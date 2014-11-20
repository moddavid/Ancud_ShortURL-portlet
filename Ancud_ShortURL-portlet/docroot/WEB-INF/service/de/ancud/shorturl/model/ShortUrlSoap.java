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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link de.ancud.shorturl.service.http.ShortUrlServiceSoap}.
 *
 * @author David
 * @see de.ancud.shorturl.service.http.ShortUrlServiceSoap
 * @generated
 */
public class ShortUrlSoap implements Serializable {
	public static ShortUrlSoap toSoapModel(ShortUrl model) {
		ShortUrlSoap soapModel = new ShortUrlSoap();

		soapModel.setShortUrlId(model.getShortUrlId());
		soapModel.setIdentifier(model.getIdentifier());
		soapModel.setOriginalUrl(model.getOriginalUrl());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ShortUrlSoap[] toSoapModels(ShortUrl[] models) {
		ShortUrlSoap[] soapModels = new ShortUrlSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ShortUrlSoap[][] toSoapModels(ShortUrl[][] models) {
		ShortUrlSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ShortUrlSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ShortUrlSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ShortUrlSoap[] toSoapModels(List<ShortUrl> models) {
		List<ShortUrlSoap> soapModels = new ArrayList<ShortUrlSoap>(models.size());

		for (ShortUrl model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ShortUrlSoap[soapModels.size()]);
	}

	public ShortUrlSoap() {
	}

	public long getPrimaryKey() {
		return _shortUrlId;
	}

	public void setPrimaryKey(long pk) {
		setShortUrlId(pk);
	}

	public long getShortUrlId() {
		return _shortUrlId;
	}

	public void setShortUrlId(long shortUrlId) {
		_shortUrlId = shortUrlId;
	}

	public String getIdentifier() {
		return _identifier;
	}

	public void setIdentifier(String identifier) {
		_identifier = identifier;
	}

	public String getOriginalUrl() {
		return _originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		_originalUrl = originalUrl;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _shortUrlId;
	private String _identifier;
	private String _originalUrl;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
}