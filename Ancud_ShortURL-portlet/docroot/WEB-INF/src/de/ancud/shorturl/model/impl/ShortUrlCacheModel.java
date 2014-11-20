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

package de.ancud.shorturl.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.ancud.shorturl.model.ShortUrl;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ShortUrl in entity cache.
 *
 * @author David
 * @see ShortUrl
 * @generated
 */
public class ShortUrlCacheModel implements CacheModel<ShortUrl>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{shortUrlId=");
		sb.append(shortUrlId);
		sb.append(", identifier=");
		sb.append(identifier);
		sb.append(", originalUrl=");
		sb.append(originalUrl);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ShortUrl toEntityModel() {
		ShortUrlImpl shortUrlImpl = new ShortUrlImpl();

		shortUrlImpl.setShortUrlId(shortUrlId);

		if (identifier == null) {
			shortUrlImpl.setIdentifier(StringPool.BLANK);
		}
		else {
			shortUrlImpl.setIdentifier(identifier);
		}

		if (originalUrl == null) {
			shortUrlImpl.setOriginalUrl(StringPool.BLANK);
		}
		else {
			shortUrlImpl.setOriginalUrl(originalUrl);
		}

		shortUrlImpl.setCompanyId(companyId);
		shortUrlImpl.setGroupId(groupId);
		shortUrlImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			shortUrlImpl.setCreateDate(null);
		}
		else {
			shortUrlImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			shortUrlImpl.setModifiedDate(null);
		}
		else {
			shortUrlImpl.setModifiedDate(new Date(modifiedDate));
		}

		shortUrlImpl.resetOriginalValues();

		return shortUrlImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		shortUrlId = objectInput.readLong();
		identifier = objectInput.readUTF();
		originalUrl = objectInput.readUTF();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(shortUrlId);

		if (identifier == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(identifier);
		}

		if (originalUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(originalUrl);
		}

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long shortUrlId;
	public String identifier;
	public String originalUrl;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
}