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

package de.ancud.shorturl.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ShortUrl}.
 * </p>
 *
 * @author David
 * @see ShortUrl
 * @generated
 */
public class ShortUrlWrapper implements ShortUrl, ModelWrapper<ShortUrl> {
	public ShortUrlWrapper(ShortUrl shortUrl) {
		_shortUrl = shortUrl;
	}

	@Override
	public Class<?> getModelClass() {
		return ShortUrl.class;
	}

	@Override
	public String getModelClassName() {
		return ShortUrl.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("shortUrlId", getShortUrlId());
		attributes.put("identifier", getIdentifier());
		attributes.put("originalUrl", getOriginalUrl());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long shortUrlId = (Long)attributes.get("shortUrlId");

		if (shortUrlId != null) {
			setShortUrlId(shortUrlId);
		}

		String identifier = (String)attributes.get("identifier");

		if (identifier != null) {
			setIdentifier(identifier);
		}

		String originalUrl = (String)attributes.get("originalUrl");

		if (originalUrl != null) {
			setOriginalUrl(originalUrl);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this short url.
	*
	* @return the primary key of this short url
	*/
	@Override
	public long getPrimaryKey() {
		return _shortUrl.getPrimaryKey();
	}

	/**
	* Sets the primary key of this short url.
	*
	* @param primaryKey the primary key of this short url
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_shortUrl.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the short url ID of this short url.
	*
	* @return the short url ID of this short url
	*/
	@Override
	public long getShortUrlId() {
		return _shortUrl.getShortUrlId();
	}

	/**
	* Sets the short url ID of this short url.
	*
	* @param shortUrlId the short url ID of this short url
	*/
	@Override
	public void setShortUrlId(long shortUrlId) {
		_shortUrl.setShortUrlId(shortUrlId);
	}

	/**
	* Returns the identifier of this short url.
	*
	* @return the identifier of this short url
	*/
	@Override
	public java.lang.String getIdentifier() {
		return _shortUrl.getIdentifier();
	}

	/**
	* Sets the identifier of this short url.
	*
	* @param identifier the identifier of this short url
	*/
	@Override
	public void setIdentifier(java.lang.String identifier) {
		_shortUrl.setIdentifier(identifier);
	}

	/**
	* Returns the original url of this short url.
	*
	* @return the original url of this short url
	*/
	@Override
	public java.lang.String getOriginalUrl() {
		return _shortUrl.getOriginalUrl();
	}

	/**
	* Sets the original url of this short url.
	*
	* @param originalUrl the original url of this short url
	*/
	@Override
	public void setOriginalUrl(java.lang.String originalUrl) {
		_shortUrl.setOriginalUrl(originalUrl);
	}

	/**
	* Returns the company ID of this short url.
	*
	* @return the company ID of this short url
	*/
	@Override
	public long getCompanyId() {
		return _shortUrl.getCompanyId();
	}

	/**
	* Sets the company ID of this short url.
	*
	* @param companyId the company ID of this short url
	*/
	@Override
	public void setCompanyId(long companyId) {
		_shortUrl.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this short url.
	*
	* @return the group ID of this short url
	*/
	@Override
	public long getGroupId() {
		return _shortUrl.getGroupId();
	}

	/**
	* Sets the group ID of this short url.
	*
	* @param groupId the group ID of this short url
	*/
	@Override
	public void setGroupId(long groupId) {
		_shortUrl.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this short url.
	*
	* @return the user ID of this short url
	*/
	@Override
	public long getUserId() {
		return _shortUrl.getUserId();
	}

	/**
	* Sets the user ID of this short url.
	*
	* @param userId the user ID of this short url
	*/
	@Override
	public void setUserId(long userId) {
		_shortUrl.setUserId(userId);
	}

	/**
	* Returns the user uuid of this short url.
	*
	* @return the user uuid of this short url
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shortUrl.getUserUuid();
	}

	/**
	* Sets the user uuid of this short url.
	*
	* @param userUuid the user uuid of this short url
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_shortUrl.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this short url.
	*
	* @return the create date of this short url
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _shortUrl.getCreateDate();
	}

	/**
	* Sets the create date of this short url.
	*
	* @param createDate the create date of this short url
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_shortUrl.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this short url.
	*
	* @return the modified date of this short url
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _shortUrl.getModifiedDate();
	}

	/**
	* Sets the modified date of this short url.
	*
	* @param modifiedDate the modified date of this short url
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_shortUrl.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _shortUrl.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_shortUrl.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _shortUrl.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_shortUrl.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _shortUrl.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _shortUrl.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_shortUrl.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shortUrl.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_shortUrl.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_shortUrl.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shortUrl.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ShortUrlWrapper((ShortUrl)_shortUrl.clone());
	}

	@Override
	public int compareTo(de.ancud.shorturl.model.ShortUrl shortUrl) {
		return _shortUrl.compareTo(shortUrl);
	}

	@Override
	public int hashCode() {
		return _shortUrl.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.ancud.shorturl.model.ShortUrl> toCacheModel() {
		return _shortUrl.toCacheModel();
	}

	@Override
	public de.ancud.shorturl.model.ShortUrl toEscapedModel() {
		return new ShortUrlWrapper(_shortUrl.toEscapedModel());
	}

	@Override
	public de.ancud.shorturl.model.ShortUrl toUnescapedModel() {
		return new ShortUrlWrapper(_shortUrl.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _shortUrl.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _shortUrl.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_shortUrl.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShortUrlWrapper)) {
			return false;
		}

		ShortUrlWrapper shortUrlWrapper = (ShortUrlWrapper)obj;

		if (Validator.equals(_shortUrl, shortUrlWrapper._shortUrl)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ShortUrl getWrappedShortUrl() {
		return _shortUrl;
	}

	@Override
	public ShortUrl getWrappedModel() {
		return _shortUrl;
	}

	@Override
	public void resetOriginalValues() {
		_shortUrl.resetOriginalValues();
	}

	private ShortUrl _shortUrl;
}