/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.ancud.shorturl.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import sun.util.logging.resources.logging;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.ResourceConstants;

import de.ancud.shorturl.model.ShortUrl;
import de.ancud.shorturl.portlet.ShortUrlValidator;
import de.ancud.shorturl.service.base.ShortUrlLocalServiceBaseImpl;

/**
 * The implementation of the short url local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.ancud.shorturl.service.ShortUrlLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author David
 * @see de.ancud.shorturl.service.base.ShortUrlLocalServiceBaseImpl
 * @see de.ancud.shorturl.service.ShortUrlLocalServiceUtil
 */
public class ShortUrlLocalServiceImpl extends ShortUrlLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.ancud.shorturl.service.ShortUrlLocalServiceUtil} to access the short url local service.
	 */
	private static final Log log = LogFactoryUtil.getLog(ShortUrlLocalServiceImpl.class);
	
	public ShortUrl addShortUrl(ShortUrl newShortUrl) throws SystemException {
		long shortUrlId = CounterLocalServiceUtil.increment(ShortUrl.class.getName());
		
		ShortUrl shortUrl = shortUrlPersistence.create(shortUrlId);
		shortUrl.setIdentifier(newShortUrl.getIdentifier());
		shortUrl.setOriginalUrl(newShortUrl.getOriginalUrl());
		shortUrl.setCompanyId(newShortUrl.getCompanyId());
		shortUrl.setGroupId(newShortUrl.getGroupId());
		shortUrl.setUserId(newShortUrl.getUserId());
		
		Date now = new Date();
		shortUrl.setCreateDate(now);
		shortUrl.setModifiedDate(now);
	
		shortUrlPersistence.update(shortUrl);
	
		try {
			resourceLocalService.addResources(shortUrl.getCompanyId(), shortUrl.getGroupId(), shortUrl.getUserId(), ShortUrl.class.getName(), shortUrlId, false, true, true);
		} catch (PortalException e) {
			log.error(e);
		}
	
		return shortUrl;
	}
	
	public ShortUrl updateShortUrl(ShortUrl shortUrl) throws SystemException {
		try {
			ShortUrl persistedShortUrl = getShortUrl(shortUrl.getShortUrlId());
			shortUrl.setCreateDate(persistedShortUrl.getCreateDate());
		} catch (PortalException e) {
			log.error(e);
		}
		
		Date now = new Date();
		shortUrl.setModifiedDate(now);
		
		return super.updateShortUrl(shortUrl);
	}
	
	public ShortUrl deleteShortUrl(long shortUrlId) throws PortalException, SystemException {
		ShortUrl shortUrl = getShortUrl(shortUrlId);
		
		return super.deleteShortUrl(shortUrl);
	}
	
	public ShortUrl deleteShortUrl(ShortUrl shortUrl) throws SystemException {
		try {
			resourceLocalService.deleteResource(shortUrl.getCompanyId(), ShortUrl.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, shortUrl.getShortUrlId());
		} catch (PortalException e) {
			log.error(e);
		}
		
		return super.deleteShortUrl(shortUrl);
	}
	
	public ShortUrl getOriginalUrlByIndentifier(String identifier) throws SystemException {
		return shortUrlPersistence.fetchByIdentifier(identifier);
	}
	
	public List<ShortUrl> getFilteredShortUrlsByGroupId(long groupId, int start, int end) throws SystemException {
		return shortUrlPersistence.filterFindByGroupId(groupId, start, end);
	}
	
	public String getRandomIdentifier() {
		char[] chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		return sb.toString();
	}
}