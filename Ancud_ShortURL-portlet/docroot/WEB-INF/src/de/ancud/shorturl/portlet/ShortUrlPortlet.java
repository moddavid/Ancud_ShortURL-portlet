package de.ancud.shorturl.portlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.ancud.shorturl.model.ShortUrl;
import de.ancud.shorturl.model.impl.ShortUrlImpl;
import de.ancud.shorturl.service.ShortUrlLocalServiceUtil;


public class ShortUrlPortlet extends MVCPortlet {
	public void addEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, SystemException {
		ShortUrl shortUrl = entryFromRequest(actionRequest);
		
		ArrayList<String> errors = new ArrayList<String>();
		if (ShortUrlValidator.validateEntry(shortUrl, errors)) {
			ShortUrlLocalServiceUtil.addShortUrl(shortUrl);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String url = themeDisplay.getPortalURL() + "/" + shortUrl.getIdentifier();
			
			actionRequest.setAttribute("url", "<a href=\"" + url + "\">" + url + "</a>");
			SessionMessages.add(actionRequest, "entry-added");
			sendRedirect(actionRequest, actionResponse);
		} else {
			for (String error : errors) {
				SessionErrors.add(actionRequest, error);
			}
			
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			actionResponse.setRenderParameter("redirect", ParamUtil.getString(actionRequest, "redirect"));
			actionResponse.setRenderParameter("jspPage", "/html/shorturl/editEntry.jsp");
		}
	}
	
	public void editEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, SystemException {
		ShortUrl shortUrl = entryFromRequest(actionRequest);
		
		ArrayList<String> errors = new ArrayList<String>();
		
		if (ShortUrlValidator.validateEntry(shortUrl, errors)) {
			ShortUrlLocalServiceUtil.updateShortUrl(shortUrl);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String url = themeDisplay.getPortalURL() + "/" + shortUrl.getIdentifier();
			
			actionRequest.setAttribute("url", "<a href=\"" + url + "\">" + url + "</a>");
			SessionMessages.add(actionRequest, "entry-updated");
			
			sendRedirect(actionRequest, actionResponse);
		} else {
			for (String error : errors) {
				SessionErrors.add(actionRequest, error);
			}
			
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			actionResponse.setRenderParameter("redirect", ParamUtil.getString(actionRequest, "redirect"));
			actionResponse.setRenderParameter("jspPage", "/html/shorturl/editEntry.jsp");
		}
	}
	
	public void deleteEntry(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortalException, SystemException {
		long shortUrlId = ParamUtil.getLong(actionRequest, "shortUrlId");
		
		if (Validator.isNotNull(shortUrlId)) {
			ShortUrlLocalServiceUtil.deleteShortUrl(shortUrlId);
			
			SessionMessages.add(actionRequest, "entry-deleted");
			
			sendRedirect(actionRequest, actionResponse);
		} else {
			SessionErrors.add(actionRequest, "error-deleting");
			
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			actionResponse.setRenderParameter("jspPage", "/html/shorturl/view.jsp");
		}
	}
	
	private ShortUrl entryFromRequest(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		ShortUrlImpl shortUrl = new ShortUrlImpl();

		shortUrl.setShortUrlId(ParamUtil.getLong(request, "shortUrlId"));
		shortUrl.setIdentifier(ParamUtil.getString(request, "identifier"));
		shortUrl.setOriginalUrl(ParamUtil.getString(request, "originalUrl"));
		shortUrl.setCompanyId(themeDisplay.getCompanyId());
		shortUrl.setGroupId(themeDisplay.getScopeGroupId());
		shortUrl.setUserId(themeDisplay.getUserId());

		return shortUrl;
	}
}
