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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import de.ancud.shorturl.service.ClpSerializer;
import de.ancud.shorturl.service.ShortUrlLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author David
 */
public class ShortUrlClp extends BaseModelImpl<ShortUrl> implements ShortUrl {
	public ShortUrlClp() {
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
	public long getPrimaryKey() {
		return _shortUrlId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setShortUrlId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _shortUrlId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getShortUrlId() {
		return _shortUrlId;
	}

	@Override
	public void setShortUrlId(long shortUrlId) {
		_shortUrlId = shortUrlId;

		if (_shortUrlRemoteModel != null) {
			try {
				Class<?> clazz = _shortUrlRemoteModel.getClass();

				Method method = clazz.getMethod("setShortUrlId", long.class);

				method.invoke(_shortUrlRemoteModel, shortUrlId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdentifier() {
		return _identifier;
	}

	@Override
	public void setIdentifier(String identifier) {
		_identifier = identifier;

		if (_shortUrlRemoteModel != null) {
			try {
				Class<?> clazz = _shortUrlRemoteModel.getClass();

				Method method = clazz.getMethod("setIdentifier", String.class);

				method.invoke(_shortUrlRemoteModel, identifier);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOriginalUrl() {
		return _originalUrl;
	}

	@Override
	public void setOriginalUrl(String originalUrl) {
		_originalUrl = originalUrl;

		if (_shortUrlRemoteModel != null) {
			try {
				Class<?> clazz = _shortUrlRemoteModel.getClass();

				Method method = clazz.getMethod("setOriginalUrl", String.class);

				method.invoke(_shortUrlRemoteModel, originalUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_shortUrlRemoteModel != null) {
			try {
				Class<?> clazz = _shortUrlRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_shortUrlRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_shortUrlRemoteModel != null) {
			try {
				Class<?> clazz = _shortUrlRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_shortUrlRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_shortUrlRemoteModel != null) {
			try {
				Class<?> clazz = _shortUrlRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_shortUrlRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_shortUrlRemoteModel != null) {
			try {
				Class<?> clazz = _shortUrlRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_shortUrlRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_shortUrlRemoteModel != null) {
			try {
				Class<?> clazz = _shortUrlRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_shortUrlRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getShortUrlRemoteModel() {
		return _shortUrlRemoteModel;
	}

	public void setShortUrlRemoteModel(BaseModel<?> shortUrlRemoteModel) {
		_shortUrlRemoteModel = shortUrlRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _shortUrlRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_shortUrlRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ShortUrlLocalServiceUtil.addShortUrl(this);
		}
		else {
			ShortUrlLocalServiceUtil.updateShortUrl(this);
		}
	}

	@Override
	public ShortUrl toEscapedModel() {
		return (ShortUrl)ProxyUtil.newProxyInstance(ShortUrl.class.getClassLoader(),
			new Class[] { ShortUrl.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ShortUrlClp clone = new ShortUrlClp();

		clone.setShortUrlId(getShortUrlId());
		clone.setIdentifier(getIdentifier());
		clone.setOriginalUrl(getOriginalUrl());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(ShortUrl shortUrl) {
		int value = 0;

		if (getShortUrlId() < shortUrl.getShortUrlId()) {
			value = -1;
		}
		else if (getShortUrlId() > shortUrl.getShortUrlId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShortUrlClp)) {
			return false;
		}

		ShortUrlClp shortUrl = (ShortUrlClp)obj;

		long primaryKey = shortUrl.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{shortUrlId=");
		sb.append(getShortUrlId());
		sb.append(", identifier=");
		sb.append(getIdentifier());
		sb.append(", originalUrl=");
		sb.append(getOriginalUrl());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("de.ancud.shorturl.model.ShortUrl");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>shortUrlId</column-name><column-value><![CDATA[");
		sb.append(getShortUrlId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>identifier</column-name><column-value><![CDATA[");
		sb.append(getIdentifier());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>originalUrl</column-name><column-value><![CDATA[");
		sb.append(getOriginalUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _shortUrlId;
	private String _identifier;
	private String _originalUrl;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _shortUrlRemoteModel;
}