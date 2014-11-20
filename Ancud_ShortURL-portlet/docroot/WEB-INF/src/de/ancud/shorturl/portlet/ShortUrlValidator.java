package de.ancud.shorturl.portlet;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import de.ancud.shorturl.model.ShortUrl;
import de.ancud.shorturl.service.ShortUrlLocalServiceUtil;


public class ShortUrlValidator {
	private static final Log log = LogFactoryUtil.getLog(ShortUrlValidator.class);
	
	public static boolean validateEntry(ShortUrl shortUrl, List<String> errors) {
		boolean valid = true;
		
		if (Validator.isNull(shortUrl.getIdentifier())) {
			errors.add("identifier-required");
			valid = false;
		} else {
			try {
				ShortUrl existingShortUrl = ShortUrlLocalServiceUtil.getOriginalUrlByIndentifier(shortUrl.getIdentifier());
				if (Validator.isNotNull(existingShortUrl) && existingShortUrl.getShortUrlId() != shortUrl.getShortUrlId()) {
					errors.add("identifier-already-exists");
					valid = false;
				}
			} catch (SystemException e) {
				log.error(e);
			}
			
			if (!shortUrl.getIdentifier().matches("[A-Za-z0-9]+")) {
				errors.add("identifier-wrong-letters");
				valid = false;
			}
		}
		
		if (Validator.isNull(shortUrl.getOriginalUrl())) {
			errors.add("url-required");
			valid = false;
		}
		
		if (!Validator.isUrl(shortUrl.getOriginalUrl())) {
			errors.add("url-invalid");
			valid = false;
		}
		
		return valid;
	}
}
