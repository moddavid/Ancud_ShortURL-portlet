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

package de.ancud.shorturl.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShortUrlLocalService}.
 *
 * @author David
 * @see ShortUrlLocalService
 * @generated
 */
public class ShortUrlLocalServiceWrapper implements ShortUrlLocalService,
	ServiceWrapper<ShortUrlLocalService> {
	public ShortUrlLocalServiceWrapper(
		ShortUrlLocalService shortUrlLocalService) {
		_shortUrlLocalService = shortUrlLocalService;
	}

	/**
	* Adds the short url to the database. Also notifies the appropriate model listeners.
	*
	* @param shortUrl the short url
	* @return the short url that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.ancud.shorturl.model.ShortUrl addShortUrl(
		de.ancud.shorturl.model.ShortUrl shortUrl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.addShortUrl(shortUrl);
	}

	/**
	* Creates a new short url with the primary key. Does not add the short url to the database.
	*
	* @param shortUrlId the primary key for the new short url
	* @return the new short url
	*/
	@Override
	public de.ancud.shorturl.model.ShortUrl createShortUrl(long shortUrlId) {
		return _shortUrlLocalService.createShortUrl(shortUrlId);
	}

	/**
	* Deletes the short url with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shortUrlId the primary key of the short url
	* @return the short url that was removed
	* @throws PortalException if a short url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.ancud.shorturl.model.ShortUrl deleteShortUrl(long shortUrlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.deleteShortUrl(shortUrlId);
	}

	/**
	* Deletes the short url from the database. Also notifies the appropriate model listeners.
	*
	* @param shortUrl the short url
	* @return the short url that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.ancud.shorturl.model.ShortUrl deleteShortUrl(
		de.ancud.shorturl.model.ShortUrl shortUrl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.deleteShortUrl(shortUrl);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _shortUrlLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ancud.shorturl.model.impl.ShortUrlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ancud.shorturl.model.impl.ShortUrlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public de.ancud.shorturl.model.ShortUrl fetchShortUrl(long shortUrlId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.fetchShortUrl(shortUrlId);
	}

	/**
	* Returns the short url with the primary key.
	*
	* @param shortUrlId the primary key of the short url
	* @return the short url
	* @throws PortalException if a short url with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.ancud.shorturl.model.ShortUrl getShortUrl(long shortUrlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.getShortUrl(shortUrlId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<de.ancud.shorturl.model.ShortUrl> getShortUrls(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.getShortUrls(start, end);
	}

	/**
	* Returns the number of short urls.
	*
	* @return the number of short urls
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getShortUrlsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.getShortUrlsCount();
	}

	/**
	* Updates the short url in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shortUrl the short url
	* @return the short url that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.ancud.shorturl.model.ShortUrl updateShortUrl(
		de.ancud.shorturl.model.ShortUrl shortUrl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.updateShortUrl(shortUrl);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _shortUrlLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_shortUrlLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _shortUrlLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public de.ancud.shorturl.model.ShortUrl getOriginalUrlByIndentifier(
		java.lang.String identifier)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.getOriginalUrlByIndentifier(identifier);
	}

	@Override
	public java.util.List<de.ancud.shorturl.model.ShortUrl> getFilteredShortUrlsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shortUrlLocalService.getFilteredShortUrlsByGroupId(groupId,
			start, end);
	}

	@Override
	public java.lang.String getRandomIdentifier() {
		return _shortUrlLocalService.getRandomIdentifier();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ShortUrlLocalService getWrappedShortUrlLocalService() {
		return _shortUrlLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedShortUrlLocalService(
		ShortUrlLocalService shortUrlLocalService) {
		_shortUrlLocalService = shortUrlLocalService;
	}

	@Override
	public ShortUrlLocalService getWrappedService() {
		return _shortUrlLocalService;
	}

	@Override
	public void setWrappedService(ShortUrlLocalService shortUrlLocalService) {
		_shortUrlLocalService = shortUrlLocalService;
	}

	private ShortUrlLocalService _shortUrlLocalService;
}