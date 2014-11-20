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

import com.liferay.portal.service.persistence.BasePersistence;

import de.ancud.shorturl.model.ShortUrl;

/**
 * The persistence interface for the short url service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author David
 * @see ShortUrlPersistenceImpl
 * @see ShortUrlUtil
 * @generated
 */
public interface ShortUrlPersistence extends BasePersistence<ShortUrl> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ShortUrlUtil} to access the short url persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the short url where identifier = &#63; or throws a {@link de.ancud.shorturl.NoSuchShortUrlException} if it could not be found.
	*
	* @param identifier the identifier
	* @return the matching short url
	* @throws de.ancud.shorturl.NoSuchShortUrlException if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.ancud.shorturl.model.ShortUrl findByIdentifier(
		java.lang.String identifier)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException;

	/**
	* Returns the short url where identifier = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param identifier the identifier
	* @return the matching short url, or <code>null</code> if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.ancud.shorturl.model.ShortUrl fetchByIdentifier(
		java.lang.String identifier)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the short url where identifier = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param identifier the identifier
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching short url, or <code>null</code> if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.ancud.shorturl.model.ShortUrl fetchByIdentifier(
		java.lang.String identifier, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the short url where identifier = &#63; from the database.
	*
	* @param identifier the identifier
	* @return the short url that was removed
	* @throws SystemException if a system exception occurred
	*/
	public de.ancud.shorturl.model.ShortUrl removeByIdentifier(
		java.lang.String identifier)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException;

	/**
	* Returns the number of short urls where identifier = &#63;.
	*
	* @param identifier the identifier
	* @return the number of matching short urls
	* @throws SystemException if a system exception occurred
	*/
	public int countByIdentifier(java.lang.String identifier)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the short url where originalUrl = &#63; or throws a {@link de.ancud.shorturl.NoSuchShortUrlException} if it could not be found.
	*
	* @param originalUrl the original url
	* @return the matching short url
	* @throws de.ancud.shorturl.NoSuchShortUrlException if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.ancud.shorturl.model.ShortUrl findByOriginalUrl(
		java.lang.String originalUrl)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException;

	/**
	* Returns the short url where originalUrl = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param originalUrl the original url
	* @return the matching short url, or <code>null</code> if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.ancud.shorturl.model.ShortUrl fetchByOriginalUrl(
		java.lang.String originalUrl)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the short url where originalUrl = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param originalUrl the original url
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching short url, or <code>null</code> if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.ancud.shorturl.model.ShortUrl fetchByOriginalUrl(
		java.lang.String originalUrl, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the short url where originalUrl = &#63; from the database.
	*
	* @param originalUrl the original url
	* @return the short url that was removed
	* @throws SystemException if a system exception occurred
	*/
	public de.ancud.shorturl.model.ShortUrl removeByOriginalUrl(
		java.lang.String originalUrl)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException;

	/**
	* Returns the number of short urls where originalUrl = &#63;.
	*
	* @param originalUrl the original url
	* @return the number of matching short urls
	* @throws SystemException if a system exception occurred
	*/
	public int countByOriginalUrl(java.lang.String originalUrl)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the short urls where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching short urls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.ancud.shorturl.model.ShortUrl> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.ancud.shorturl.model.ShortUrl> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.ancud.shorturl.model.ShortUrl> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first short url in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching short url
	* @throws de.ancud.shorturl.NoSuchShortUrlException if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.ancud.shorturl.model.ShortUrl findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException;

	/**
	* Returns the first short url in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching short url, or <code>null</code> if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.ancud.shorturl.model.ShortUrl fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last short url in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching short url
	* @throws de.ancud.shorturl.NoSuchShortUrlException if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.ancud.shorturl.model.ShortUrl findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException;

	/**
	* Returns the last short url in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching short url, or <code>null</code> if a matching short url could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.ancud.shorturl.model.ShortUrl fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.ancud.shorturl.model.ShortUrl[] findByGroupId_PrevAndNext(
		long shortUrlId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException;

	/**
	* Returns all the short urls that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching short urls that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.ancud.shorturl.model.ShortUrl> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.ancud.shorturl.model.ShortUrl> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.ancud.shorturl.model.ShortUrl> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public de.ancud.shorturl.model.ShortUrl[] filterFindByGroupId_PrevAndNext(
		long shortUrlId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException;

	/**
	* Removes all the short urls where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of short urls where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching short urls
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of short urls that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching short urls that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the short url in the entity cache if it is enabled.
	*
	* @param shortUrl the short url
	*/
	public void cacheResult(de.ancud.shorturl.model.ShortUrl shortUrl);

	/**
	* Caches the short urls in the entity cache if it is enabled.
	*
	* @param shortUrls the short urls
	*/
	public void cacheResult(
		java.util.List<de.ancud.shorturl.model.ShortUrl> shortUrls);

	/**
	* Creates a new short url with the primary key. Does not add the short url to the database.
	*
	* @param shortUrlId the primary key for the new short url
	* @return the new short url
	*/
	public de.ancud.shorturl.model.ShortUrl create(long shortUrlId);

	/**
	* Removes the short url with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shortUrlId the primary key of the short url
	* @return the short url that was removed
	* @throws de.ancud.shorturl.NoSuchShortUrlException if a short url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.ancud.shorturl.model.ShortUrl remove(long shortUrlId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException;

	public de.ancud.shorturl.model.ShortUrl updateImpl(
		de.ancud.shorturl.model.ShortUrl shortUrl)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the short url with the primary key or throws a {@link de.ancud.shorturl.NoSuchShortUrlException} if it could not be found.
	*
	* @param shortUrlId the primary key of the short url
	* @return the short url
	* @throws de.ancud.shorturl.NoSuchShortUrlException if a short url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.ancud.shorturl.model.ShortUrl findByPrimaryKey(long shortUrlId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.ancud.shorturl.NoSuchShortUrlException;

	/**
	* Returns the short url with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param shortUrlId the primary key of the short url
	* @return the short url, or <code>null</code> if a short url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.ancud.shorturl.model.ShortUrl fetchByPrimaryKey(long shortUrlId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the short urls.
	*
	* @return the short urls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.ancud.shorturl.model.ShortUrl> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.ancud.shorturl.model.ShortUrl> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<de.ancud.shorturl.model.ShortUrl> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the short urls from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of short urls.
	*
	* @return the number of short urls
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}