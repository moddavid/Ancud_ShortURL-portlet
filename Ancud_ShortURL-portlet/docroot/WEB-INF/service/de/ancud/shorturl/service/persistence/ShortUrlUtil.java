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

package de.ancud.shorturl.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.ancud.shorturl.model.ShortUrl;

import java.util.List;

/**
 * The persistence utility for the short url service. This utility wraps {@link ShortUrlPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author David
 * @see ShortUrlPersistence
 * @see ShortUrlPersistenceImpl
 * @generated
 */
public class ShortUrlUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ShortUrl shortUrl) {
		getPersistence().clearCache(shortUrl);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ShortUrl> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ShortUrl> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ShortUrl> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ShortUrl update(ShortUrl shortUrl) throws SystemException {
		return getPersistence().update(shortUrl);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ShortUrl update(ShortUrl shortUrl,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(shortUrl, serviceContext);
	}

	/**
	* Returns the short url where identifier = &#63; or throws a {@link de.ancud.shorturl.NoSuchShortUrlException} if it could not be found.
	*
	* @param identifier the identifier
	* @return the matching short url
	* @throws de.ancud.shorturl.NoSuchShortUrlException if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl findByIdentifier(
		java.lang.String identifier)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException {
		return getPersistence().findByIdentifier(identifier);
	}

	/**
	* Returns the short url where identifier = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param identifier the identifier
	* @return the matching short url, or <code>null</code> if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl fetchByIdentifier(
		java.lang.String identifier)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIdentifier(identifier);
	}

	/**
	* Returns the short url where identifier = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param identifier the identifier
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching short url, or <code>null</code> if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl fetchByIdentifier(
		java.lang.String identifier, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIdentifier(identifier, retrieveFromCache);
	}

	/**
	* Removes the short url where identifier = &#63; from the database.
	*
	* @param identifier the identifier
	* @return the short url that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl removeByIdentifier(
		java.lang.String identifier)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException {
		return getPersistence().removeByIdentifier(identifier);
	}

	/**
	* Returns the number of short urls where identifier = &#63;.
	*
	* @param identifier the identifier
	* @return the number of matching short urls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIdentifier(java.lang.String identifier)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIdentifier(identifier);
	}

	/**
	* Returns the short url where originalUrl = &#63; or throws a {@link de.ancud.shorturl.NoSuchShortUrlException} if it could not be found.
	*
	* @param originalUrl the original url
	* @return the matching short url
	* @throws de.ancud.shorturl.NoSuchShortUrlException if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl findByOriginalUrl(
		java.lang.String originalUrl)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException {
		return getPersistence().findByOriginalUrl(originalUrl);
	}

	/**
	* Returns the short url where originalUrl = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param originalUrl the original url
	* @return the matching short url, or <code>null</code> if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl fetchByOriginalUrl(
		java.lang.String originalUrl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByOriginalUrl(originalUrl);
	}

	/**
	* Returns the short url where originalUrl = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param originalUrl the original url
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching short url, or <code>null</code> if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl fetchByOriginalUrl(
		java.lang.String originalUrl, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOriginalUrl(originalUrl, retrieveFromCache);
	}

	/**
	* Removes the short url where originalUrl = &#63; from the database.
	*
	* @param originalUrl the original url
	* @return the short url that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl removeByOriginalUrl(
		java.lang.String originalUrl)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException {
		return getPersistence().removeByOriginalUrl(originalUrl);
	}

	/**
	* Returns the number of short urls where originalUrl = &#63;.
	*
	* @param originalUrl the original url
	* @return the number of matching short urls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOriginalUrl(java.lang.String originalUrl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOriginalUrl(originalUrl);
	}

	/**
	* Returns all the short urls where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching short urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.ancud.shorturl.model.ShortUrl> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the short urls where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ancud.shorturl.model.impl.ShortUrlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of short urls
	* @param end the upper bound of the range of short urls (not inclusive)
	* @return the range of matching short urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.ancud.shorturl.model.ShortUrl> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the short urls where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ancud.shorturl.model.impl.ShortUrlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of short urls
	* @param end the upper bound of the range of short urls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching short urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.ancud.shorturl.model.ShortUrl> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first short url in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching short url
	* @throws de.ancud.shorturl.NoSuchShortUrlException if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first short url in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching short url, or <code>null</code> if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last short url in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching short url
	* @throws de.ancud.shorturl.NoSuchShortUrlException if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last short url in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching short url, or <code>null</code> if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the short urls before and after the current short url in the ordered set where groupId = &#63;.
	*
	* @param shortUrlId the primary key of the current short url
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next short url
	* @throws de.ancud.shorturl.NoSuchShortUrlException if a short url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl[] findByGroupId_PrevAndNext(
		long shortUrlId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(shortUrlId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the short urls that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching short urls that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.ancud.shorturl.model.ShortUrl> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the short urls that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ancud.shorturl.model.impl.ShortUrlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of short urls
	* @param end the upper bound of the range of short urls (not inclusive)
	* @return the range of matching short urls that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.ancud.shorturl.model.ShortUrl> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the short urls that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ancud.shorturl.model.impl.ShortUrlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of short urls
	* @param end the upper bound of the range of short urls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching short urls that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.ancud.shorturl.model.ShortUrl> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the short urls before and after the current short url in the ordered set of short urls that the user has permission to view where groupId = &#63;.
	*
	* @param shortUrlId the primary key of the current short url
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next short url
	* @throws de.ancud.shorturl.NoSuchShortUrlException if a short url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl[] filterFindByGroupId_PrevAndNext(
		long shortUrlId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(shortUrlId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the short urls where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of short urls where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching short urls
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of short urls that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching short urls that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Caches the short url in the entity cache if it is enabled.
	*
	* @param shortUrl the short url
	*/
	public static void cacheResult(de.ancud.shorturl.model.ShortUrl shortUrl) {
		getPersistence().cacheResult(shortUrl);
	}

	/**
	* Caches the short urls in the entity cache if it is enabled.
	*
	* @param shortUrls the short urls
	*/
	public static void cacheResult(
		java.util.List<de.ancud.shorturl.model.ShortUrl> shortUrls) {
		getPersistence().cacheResult(shortUrls);
	}

	/**
	* Creates a new short url with the primary key. Does not add the short url to the database.
	*
	* @param shortUrlId the primary key for the new short url
	* @return the new short url
	*/
	public static de.ancud.shorturl.model.ShortUrl create(long shortUrlId) {
		return getPersistence().create(shortUrlId);
	}

	/**
	* Removes the short url with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shortUrlId the primary key of the short url
	* @return the short url that was removed
	* @throws de.ancud.shorturl.NoSuchShortUrlException if a short url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl remove(long shortUrlId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException {
		return getPersistence().remove(shortUrlId);
	}

	public static de.ancud.shorturl.model.ShortUrl updateImpl(
		de.ancud.shorturl.model.ShortUrl shortUrl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(shortUrl);
	}

	/**
	* Returns the short url with the primary key or throws a {@link de.ancud.shorturl.NoSuchShortUrlException} if it could not be found.
	*
	* @param shortUrlId the primary key of the short url
	* @return the short url
	* @throws de.ancud.shorturl.NoSuchShortUrlException if a short url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl findByPrimaryKey(
		long shortUrlId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException {
		return getPersistence().findByPrimaryKey(shortUrlId);
	}

	/**
	* Returns the short url with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param shortUrlId the primary key of the short url
	* @return the short url, or <code>null</code> if a short url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static de.ancud.shorturl.model.ShortUrl fetchByPrimaryKey(
		long shortUrlId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(shortUrlId);
	}

	/**
	* Returns all the short urls.
	*
	* @return the short urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.ancud.shorturl.model.ShortUrl> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the short urls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ancud.shorturl.model.impl.ShortUrlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of short urls
	* @param end the upper bound of the range of short urls (not inclusive)
	* @return the range of short urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.ancud.shorturl.model.ShortUrl> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the short urls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ancud.shorturl.model.impl.ShortUrlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of short urls
	* @param end the upper bound of the range of short urls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of short urls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<de.ancud.shorturl.model.ShortUrl> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the short urls from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of short urls.
	*
	* @return the number of short urls
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ShortUrlPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ShortUrlPersistence)PortletBeanLocatorUtil.locate(de.ancud.shorturl.service.ClpSerializer.getServletContextName(),
					ShortUrlPersistence.class.getName());

			ReferenceRegistry.registerReference(ShortUrlUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ShortUrlPersistence persistence) {
	}

	private static ShortUrlPersistence _persistence;
}