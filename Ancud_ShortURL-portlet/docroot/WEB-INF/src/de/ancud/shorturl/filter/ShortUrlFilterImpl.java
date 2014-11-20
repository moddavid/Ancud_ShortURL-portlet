package de.ancud.shorturl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;

import de.ancud.shorturl.model.ShortUrl;
import de.ancud.shorturl.service.ShortUrlLocalServiceUtil;


public class ShortUrlFilterImpl implements Filter {
	private static final Log log = LogFactoryUtil.getLog(ShortUrlFilterImpl.class);
	
	@Override
	public void destroy() {
		log.info("Destroying ShortUrlFilter");
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		boolean doRedirect = false;
		String uri = (String)servletRequest.getAttribute(WebKeys.INVOKER_FILTER_URI);
		
		if (!uri.substring(1).contains("/")) {
			try {
				ShortUrl shortUrl = ShortUrlLocalServiceUtil.getOriginalUrlByIndentifier(uri.substring(1));
				if (shortUrl != null) {
					log.info("Redirecting from " + uri + " to " + shortUrl.getOriginalUrl());
					doRedirect = true;
					
					HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
					httpResponse.sendRedirect(shortUrl.getOriginalUrl());
				}
			} catch (SystemException e) {
				log.error(e);
			}
		}
		
		if (!doRedirect) {
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}
	
	@Override
	public void init(FilterConfig filterConfig) {
		log.info("Initializing ShortUrlFilter");
	}
}
