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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.ancud.shorturl.NoSuchShortUrlException;
import de.ancud.shorturl.model.ShortUrl;
import de.ancud.shorturl.model.impl.ShortUrlImpl;
import de.ancud.shorturl.model.impl.ShortUrlModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the short url service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author David
 * @see ShortUrlPersistence
 * @see ShortUrlUtil
 * @generated
 */
public class ShortUrlPersistenceImpl extends BasePersistenceImpl<ShortUrl>
	implements ShortUrlPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ShortUrlUtil} to access the short url persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ShortUrlImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
			ShortUrlModelImpl.FINDER_CACHE_ENABLED, ShortUrlImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
			ShortUrlModelImpl.FINDER_CACHE_ENABLED, ShortUrlImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
			ShortUrlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_IDENTIFIER = new FinderPath(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
			ShortUrlModelImpl.FINDER_CACHE_ENABLED, ShortUrlImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByIdentifier",
			new String[] { String.class.getName() },
			ShortUrlModelImpl.IDENTIFIER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDENTIFIER = new FinderPath(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
			ShortUrlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdentifier",
			new String[] { String.class.getName() });

	/**
	 * Returns the short url where identifier = &#63; or throws a {@link de.ancud.shorturl.NoSuchShortUrlException} if it could not be found.
	 *
	 * @param identifier the identifier
	 * @return the matching short url
	 * @throws de.ancud.shorturl.NoSuchShortUrlException if a matching short url could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl findByIdentifier(String identifier)
		throws NoSuchShortUrlException, SystemException {
		ShortUrl shortUrl = fetchByIdentifier(identifier);

		if (shortUrl == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("identifier=");
			msg.append(identifier);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchShortUrlException(msg.toString());
		}

		return shortUrl;
	}

	/**
	 * Returns the short url where identifier = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param identifier the identifier
	 * @return the matching short url, or <code>null</code> if a matching short url could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl fetchByIdentifier(String identifier)
		throws SystemException {
		return fetchByIdentifier(identifier, true);
	}

	/**
	 * Returns the short url where identifier = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param identifier the identifier
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching short url, or <code>null</code> if a matching short url could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl fetchByIdentifier(String identifier,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { identifier };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_IDENTIFIER,
					finderArgs, this);
		}

		if (result instanceof ShortUrl) {
			ShortUrl shortUrl = (ShortUrl)result;

			if (!Validator.equals(identifier, shortUrl.getIdentifier())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SHORTURL_WHERE);

			boolean bindIdentifier = false;

			if (identifier == null) {
				query.append(_FINDER_COLUMN_IDENTIFIER_IDENTIFIER_1);
			}
			else if (identifier.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IDENTIFIER_IDENTIFIER_3);
			}
			else {
				bindIdentifier = true;

				query.append(_FINDER_COLUMN_IDENTIFIER_IDENTIFIER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdentifier) {
					qPos.add(identifier);
				}

				List<ShortUrl> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDENTIFIER,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ShortUrlPersistenceImpl.fetchByIdentifier(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ShortUrl shortUrl = list.get(0);

					result = shortUrl;

					cacheResult(shortUrl);

					if ((shortUrl.getIdentifier() == null) ||
							!shortUrl.getIdentifier().equals(identifier)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDENTIFIER,
							finderArgs, shortUrl);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDENTIFIER,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ShortUrl)result;
		}
	}

	/**
	 * Removes the short url where identifier = &#63; from the database.
	 *
	 * @param identifier the identifier
	 * @return the short url that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl removeByIdentifier(String identifier)
		throws NoSuchShortUrlException, SystemException {
		ShortUrl shortUrl = findByIdentifier(identifier);

		return remove(shortUrl);
	}

	/**
	 * Returns the number of short urls where identifier = &#63;.
	 *
	 * @param identifier the identifier
	 * @return the number of matching short urls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIdentifier(String identifier) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDENTIFIER;

		Object[] finderArgs = new Object[] { identifier };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHORTURL_WHERE);

			boolean bindIdentifier = false;

			if (identifier == null) {
				query.append(_FINDER_COLUMN_IDENTIFIER_IDENTIFIER_1);
			}
			else if (identifier.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IDENTIFIER_IDENTIFIER_3);
			}
			else {
				bindIdentifier = true;

				query.append(_FINDER_COLUMN_IDENTIFIER_IDENTIFIER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdentifier) {
					qPos.add(identifier);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_IDENTIFIER_IDENTIFIER_1 = "shortUrl.identifier IS NULL";
	private static final String _FINDER_COLUMN_IDENTIFIER_IDENTIFIER_2 = "shortUrl.identifier = ?";
	private static final String _FINDER_COLUMN_IDENTIFIER_IDENTIFIER_3 = "(shortUrl.identifier IS NULL OR shortUrl.identifier = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_ORIGINALURL = new FinderPath(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
			ShortUrlModelImpl.FINDER_CACHE_ENABLED, ShortUrlImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByOriginalUrl",
			new String[] { String.class.getName() },
			ShortUrlModelImpl.ORIGINALURL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORIGINALURL = new FinderPath(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
			ShortUrlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOriginalUrl",
			new String[] { String.class.getName() });

	/**
	 * Returns the short url where originalUrl = &#63; or throws a {@link de.ancud.shorturl.NoSuchShortUrlException} if it could not be found.
	 *
	 * @param originalUrl the original url
	 * @return the matching short url
	 * @throws de.ancud.shorturl.NoSuchShortUrlException if a matching short url could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl findByOriginalUrl(String originalUrl)
		throws NoSuchShortUrlException, SystemException {
		ShortUrl shortUrl = fetchByOriginalUrl(originalUrl);

		if (shortUrl == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("originalUrl=");
			msg.append(originalUrl);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchShortUrlException(msg.toString());
		}

		return shortUrl;
	}

	/**
	 * Returns the short url where originalUrl = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param originalUrl the original url
	 * @return the matching short url, or <code>null</code> if a matching short url could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl fetchByOriginalUrl(String originalUrl)
		throws SystemException {
		return fetchByOriginalUrl(originalUrl, true);
	}

	/**
	 * Returns the short url where originalUrl = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param originalUrl the original url
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching short url, or <code>null</code> if a matching short url could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl fetchByOriginalUrl(String originalUrl,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { originalUrl };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ORIGINALURL,
					finderArgs, this);
		}

		if (result instanceof ShortUrl) {
			ShortUrl shortUrl = (ShortUrl)result;

			if (!Validator.equals(originalUrl, shortUrl.getOriginalUrl())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SHORTURL_WHERE);

			boolean bindOriginalUrl = false;

			if (originalUrl == null) {
				query.append(_FINDER_COLUMN_ORIGINALURL_ORIGINALURL_1);
			}
			else if (originalUrl.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORIGINALURL_ORIGINALURL_3);
			}
			else {
				bindOriginalUrl = true;

				query.append(_FINDER_COLUMN_ORIGINALURL_ORIGINALURL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOriginalUrl) {
					qPos.add(originalUrl);
				}

				List<ShortUrl> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORIGINALURL,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ShortUrlPersistenceImpl.fetchByOriginalUrl(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ShortUrl shortUrl = list.get(0);

					result = shortUrl;

					cacheResult(shortUrl);

					if ((shortUrl.getOriginalUrl() == null) ||
							!shortUrl.getOriginalUrl().equals(originalUrl)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORIGINALURL,
							finderArgs, shortUrl);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORIGINALURL,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ShortUrl)result;
		}
	}

	/**
	 * Removes the short url where originalUrl = &#63; from the database.
	 *
	 * @param originalUrl the original url
	 * @return the short url that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl removeByOriginalUrl(String originalUrl)
		throws NoSuchShortUrlException, SystemException {
		ShortUrl shortUrl = findByOriginalUrl(originalUrl);

		return remove(shortUrl);
	}

	/**
	 * Returns the number of short urls where originalUrl = &#63;.
	 *
	 * @param originalUrl the original url
	 * @return the number of matching short urls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOriginalUrl(String originalUrl) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORIGINALURL;

		Object[] finderArgs = new Object[] { originalUrl };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHORTURL_WHERE);

			boolean bindOriginalUrl = false;

			if (originalUrl == null) {
				query.append(_FINDER_COLUMN_ORIGINALURL_ORIGINALURL_1);
			}
			else if (originalUrl.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORIGINALURL_ORIGINALURL_3);
			}
			else {
				bindOriginalUrl = true;

				query.append(_FINDER_COLUMN_ORIGINALURL_ORIGINALURL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOriginalUrl) {
					qPos.add(originalUrl);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORIGINALURL_ORIGINALURL_1 = "shortUrl.originalUrl IS NULL";
	private static final String _FINDER_COLUMN_ORIGINALURL_ORIGINALURL_2 = "shortUrl.originalUrl = ?";
	private static final String _FINDER_COLUMN_ORIGINALURL_ORIGINALURL_3 = "(shortUrl.originalUrl IS NULL OR shortUrl.originalUrl = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
			ShortUrlModelImpl.FINDER_CACHE_ENABLED, ShortUrlImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
			ShortUrlModelImpl.FINDER_CACHE_ENABLED, ShortUrlImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ShortUrlModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
			ShortUrlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the short urls where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching short urls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShortUrl> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ShortUrl> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<ShortUrl> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ShortUrl> list = (List<ShortUrl>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ShortUrl shortUrl : list) {
				if ((groupId != shortUrl.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SHORTURL_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShortUrlModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ShortUrl>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ShortUrl>(list);
				}
				else {
					list = (List<ShortUrl>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public ShortUrl findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchShortUrlException, SystemException {
		ShortUrl shortUrl = fetchByGroupId_First(groupId, orderByComparator);

		if (shortUrl != null) {
			return shortUrl;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShortUrlException(msg.toString());
	}

	/**
	 * Returns the first short url in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching short url, or <code>null</code> if a matching short url could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ShortUrl> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ShortUrl findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchShortUrlException, SystemException {
		ShortUrl shortUrl = fetchByGroupId_Last(groupId, orderByComparator);

		if (shortUrl != null) {
			return shortUrl;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShortUrlException(msg.toString());
	}

	/**
	 * Returns the last short url in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching short url, or <code>null</code> if a matching short url could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ShortUrl> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ShortUrl[] findByGroupId_PrevAndNext(long shortUrlId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchShortUrlException, SystemException {
		ShortUrl shortUrl = findByPrimaryKey(shortUrlId);

		Session session = null;

		try {
			session = openSession();

			ShortUrl[] array = new ShortUrlImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, shortUrl, groupId,
					orderByComparator, true);

			array[1] = shortUrl;

			array[2] = getByGroupId_PrevAndNext(session, shortUrl, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShortUrl getByGroupId_PrevAndNext(Session session,
		ShortUrl shortUrl, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHORTURL_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ShortUrlModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shortUrl);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShortUrl> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the short urls that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching short urls that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShortUrl> filterFindByGroupId(long groupId)
		throws SystemException {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<ShortUrl> filterFindByGroupId(long groupId, int start, int end)
		throws SystemException {
		return filterFindByGroupId(groupId, start, end, null);
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
	@Override
	public List<ShortUrl> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SHORTURL_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SHORTURL_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SHORTURL_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ShortUrlModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ShortUrlModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ShortUrl.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ShortUrlImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ShortUrlImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ShortUrl>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public ShortUrl[] filterFindByGroupId_PrevAndNext(long shortUrlId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchShortUrlException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(shortUrlId, groupId,
				orderByComparator);
		}

		ShortUrl shortUrl = findByPrimaryKey(shortUrlId);

		Session session = null;

		try {
			session = openSession();

			ShortUrl[] array = new ShortUrlImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, shortUrl,
					groupId, orderByComparator, true);

			array[1] = shortUrl;

			array[2] = filterGetByGroupId_PrevAndNext(session, shortUrl,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ShortUrl filterGetByGroupId_PrevAndNext(Session session,
		ShortUrl shortUrl, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SHORTURL_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SHORTURL_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SHORTURL_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(ShortUrlModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ShortUrlModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ShortUrl.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ShortUrlImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ShortUrlImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shortUrl);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ShortUrl> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the short urls where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ShortUrl shortUrl : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(shortUrl);
		}
	}

	/**
	 * Returns the number of short urls where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching short urls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHORTURL_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of short urls that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching short urls that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountByGroupId(long groupId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_SHORTURL_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ShortUrl.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "shortUrl.groupId = ?";

	public ShortUrlPersistenceImpl() {
		setModelClass(ShortUrl.class);
	}

	/**
	 * Caches the short url in the entity cache if it is enabled.
	 *
	 * @param shortUrl the short url
	 */
	@Override
	public void cacheResult(ShortUrl shortUrl) {
		EntityCacheUtil.putResult(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
			ShortUrlImpl.class, shortUrl.getPrimaryKey(), shortUrl);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDENTIFIER,
			new Object[] { shortUrl.getIdentifier() }, shortUrl);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORIGINALURL,
			new Object[] { shortUrl.getOriginalUrl() }, shortUrl);

		shortUrl.resetOriginalValues();
	}

	/**
	 * Caches the short urls in the entity cache if it is enabled.
	 *
	 * @param shortUrls the short urls
	 */
	@Override
	public void cacheResult(List<ShortUrl> shortUrls) {
		for (ShortUrl shortUrl : shortUrls) {
			if (EntityCacheUtil.getResult(
						ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
						ShortUrlImpl.class, shortUrl.getPrimaryKey()) == null) {
				cacheResult(shortUrl);
			}
			else {
				shortUrl.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all short urls.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ShortUrlImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ShortUrlImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the short url.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ShortUrl shortUrl) {
		EntityCacheUtil.removeResult(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
			ShortUrlImpl.class, shortUrl.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(shortUrl);
	}

	@Override
	public void clearCache(List<ShortUrl> shortUrls) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ShortUrl shortUrl : shortUrls) {
			EntityCacheUtil.removeResult(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
				ShortUrlImpl.class, shortUrl.getPrimaryKey());

			clearUniqueFindersCache(shortUrl);
		}
	}

	protected void cacheUniqueFindersCache(ShortUrl shortUrl) {
		if (shortUrl.isNew()) {
			Object[] args = new Object[] { shortUrl.getIdentifier() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDENTIFIER, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDENTIFIER, args,
				shortUrl);

			args = new Object[] { shortUrl.getOriginalUrl() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORIGINALURL, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORIGINALURL, args,
				shortUrl);
		}
		else {
			ShortUrlModelImpl shortUrlModelImpl = (ShortUrlModelImpl)shortUrl;

			if ((shortUrlModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_IDENTIFIER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { shortUrl.getIdentifier() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDENTIFIER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDENTIFIER,
					args, shortUrl);
			}

			if ((shortUrlModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ORIGINALURL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { shortUrl.getOriginalUrl() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORIGINALURL,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORIGINALURL,
					args, shortUrl);
			}
		}
	}

	protected void clearUniqueFindersCache(ShortUrl shortUrl) {
		ShortUrlModelImpl shortUrlModelImpl = (ShortUrlModelImpl)shortUrl;

		Object[] args = new Object[] { shortUrl.getIdentifier() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDENTIFIER, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDENTIFIER, args);

		if ((shortUrlModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_IDENTIFIER.getColumnBitmask()) != 0) {
			args = new Object[] { shortUrlModelImpl.getOriginalIdentifier() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDENTIFIER, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDENTIFIER, args);
		}

		args = new Object[] { shortUrl.getOriginalUrl() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORIGINALURL, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORIGINALURL, args);

		if ((shortUrlModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ORIGINALURL.getColumnBitmask()) != 0) {
			args = new Object[] { shortUrlModelImpl.getOriginalOriginalUrl() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORIGINALURL, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORIGINALURL, args);
		}
	}

	/**
	 * Creates a new short url with the primary key. Does not add the short url to the database.
	 *
	 * @param shortUrlId the primary key for the new short url
	 * @return the new short url
	 */
	@Override
	public ShortUrl create(long shortUrlId) {
		ShortUrl shortUrl = new ShortUrlImpl();

		shortUrl.setNew(true);
		shortUrl.setPrimaryKey(shortUrlId);

		return shortUrl;
	}

	/**
	 * Removes the short url with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shortUrlId the primary key of the short url
	 * @return the short url that was removed
	 * @throws de.ancud.shorturl.NoSuchShortUrlException if a short url with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl remove(long shortUrlId)
		throws NoSuchShortUrlException, SystemException {
		return remove((Serializable)shortUrlId);
	}

	/**
	 * Removes the short url with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the short url
	 * @return the short url that was removed
	 * @throws de.ancud.shorturl.NoSuchShortUrlException if a short url with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl remove(Serializable primaryKey)
		throws NoSuchShortUrlException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ShortUrl shortUrl = (ShortUrl)session.get(ShortUrlImpl.class,
					primaryKey);

			if (shortUrl == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShortUrlException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(shortUrl);
		}
		catch (NoSuchShortUrlException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ShortUrl removeImpl(ShortUrl shortUrl) throws SystemException {
		shortUrl = toUnwrappedModel(shortUrl);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(shortUrl)) {
				shortUrl = (ShortUrl)session.get(ShortUrlImpl.class,
						shortUrl.getPrimaryKeyObj());
			}

			if (shortUrl != null) {
				session.delete(shortUrl);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (shortUrl != null) {
			clearCache(shortUrl);
		}

		return shortUrl;
	}

	@Override
	public ShortUrl updateImpl(de.ancud.shorturl.model.ShortUrl shortUrl)
		throws SystemException {
		shortUrl = toUnwrappedModel(shortUrl);

		boolean isNew = shortUrl.isNew();

		ShortUrlModelImpl shortUrlModelImpl = (ShortUrlModelImpl)shortUrl;

		Session session = null;

		try {
			session = openSession();

			if (shortUrl.isNew()) {
				session.save(shortUrl);

				shortUrl.setNew(false);
			}
			else {
				session.merge(shortUrl);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ShortUrlModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((shortUrlModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shortUrlModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { shortUrlModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
			ShortUrlImpl.class, shortUrl.getPrimaryKey(), shortUrl);

		clearUniqueFindersCache(shortUrl);
		cacheUniqueFindersCache(shortUrl);

		return shortUrl;
	}

	protected ShortUrl toUnwrappedModel(ShortUrl shortUrl) {
		if (shortUrl instanceof ShortUrlImpl) {
			return shortUrl;
		}

		ShortUrlImpl shortUrlImpl = new ShortUrlImpl();

		shortUrlImpl.setNew(shortUrl.isNew());
		shortUrlImpl.setPrimaryKey(shortUrl.getPrimaryKey());

		shortUrlImpl.setShortUrlId(shortUrl.getShortUrlId());
		shortUrlImpl.setIdentifier(shortUrl.getIdentifier());
		shortUrlImpl.setOriginalUrl(shortUrl.getOriginalUrl());
		shortUrlImpl.setCompanyId(shortUrl.getCompanyId());
		shortUrlImpl.setGroupId(shortUrl.getGroupId());
		shortUrlImpl.setUserId(shortUrl.getUserId());
		shortUrlImpl.setCreateDate(shortUrl.getCreateDate());
		shortUrlImpl.setModifiedDate(shortUrl.getModifiedDate());

		return shortUrlImpl;
	}

	/**
	 * Returns the short url with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the short url
	 * @return the short url
	 * @throws de.ancud.shorturl.NoSuchShortUrlException if a short url with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl findByPrimaryKey(Serializable primaryKey)
		throws NoSuchShortUrlException, SystemException {
		ShortUrl shortUrl = fetchByPrimaryKey(primaryKey);

		if (shortUrl == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchShortUrlException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return shortUrl;
	}

	/**
	 * Returns the short url with the primary key or throws a {@link de.ancud.shorturl.NoSuchShortUrlException} if it could not be found.
	 *
	 * @param shortUrlId the primary key of the short url
	 * @return the short url
	 * @throws de.ancud.shorturl.NoSuchShortUrlException if a short url with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl findByPrimaryKey(long shortUrlId)
		throws NoSuchShortUrlException, SystemException {
		return findByPrimaryKey((Serializable)shortUrlId);
	}

	/**
	 * Returns the short url with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the short url
	 * @return the short url, or <code>null</code> if a short url with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ShortUrl shortUrl = (ShortUrl)EntityCacheUtil.getResult(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
				ShortUrlImpl.class, primaryKey);

		if (shortUrl == _nullShortUrl) {
			return null;
		}

		if (shortUrl == null) {
			Session session = null;

			try {
				session = openSession();

				shortUrl = (ShortUrl)session.get(ShortUrlImpl.class, primaryKey);

				if (shortUrl != null) {
					cacheResult(shortUrl);
				}
				else {
					EntityCacheUtil.putResult(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
						ShortUrlImpl.class, primaryKey, _nullShortUrl);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ShortUrlModelImpl.ENTITY_CACHE_ENABLED,
					ShortUrlImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return shortUrl;
	}

	/**
	 * Returns the short url with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param shortUrlId the primary key of the short url
	 * @return the short url, or <code>null</code> if a short url with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ShortUrl fetchByPrimaryKey(long shortUrlId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)shortUrlId);
	}

	/**
	 * Returns all the short urls.
	 *
	 * @return the short urls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ShortUrl> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ShortUrl> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<ShortUrl> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ShortUrl> list = (List<ShortUrl>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SHORTURL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHORTURL;

				if (pagination) {
					sql = sql.concat(ShortUrlModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ShortUrl>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ShortUrl>(list);
				}
				else {
					list = (List<ShortUrl>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the short urls from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ShortUrl shortUrl : findAll()) {
			remove(shortUrl);
		}
	}

	/**
	 * Returns the number of short urls.
	 *
	 * @return the number of short urls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SHORTURL);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the short url persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.ancud.shorturl.model.ShortUrl")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ShortUrl>> listenersList = new ArrayList<ModelListener<ShortUrl>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ShortUrl>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ShortUrlImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SHORTURL = "SELECT shortUrl FROM ShortUrl shortUrl";
	private static final String _SQL_SELECT_SHORTURL_WHERE = "SELECT shortUrl FROM ShortUrl shortUrl WHERE ";
	private static final String _SQL_COUNT_SHORTURL = "SELECT COUNT(shortUrl) FROM ShortUrl shortUrl";
	private static final String _SQL_COUNT_SHORTURL_WHERE = "SELECT COUNT(shortUrl) FROM ShortUrl shortUrl WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "shortUrl.shortUrlId";
	private static final String _FILTER_SQL_SELECT_SHORTURL_WHERE = "SELECT DISTINCT {shortUrl.*} FROM shorturl_ShortUrl shortUrl WHERE ";
	private static final String _FILTER_SQL_SELECT_SHORTURL_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {shorturl_ShortUrl.*} FROM (SELECT DISTINCT shortUrl.shortUrlId FROM shorturl_ShortUrl shortUrl WHERE ";
	private static final String _FILTER_SQL_SELECT_SHORTURL_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN shorturl_ShortUrl ON TEMP_TABLE.shortUrlId = shorturl_ShortUrl.shortUrlId";
	private static final String _FILTER_SQL_COUNT_SHORTURL_WHERE = "SELECT COUNT(DISTINCT shortUrl.shortUrlId) AS COUNT_VALUE FROM shorturl_ShortUrl shortUrl WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "shortUrl";
	private static final String _FILTER_ENTITY_TABLE = "shorturl_ShortUrl";
	private static final String _ORDER_BY_ENTITY_ALIAS = "shortUrl.";
	private static final String _ORDER_BY_ENTITY_TABLE = "shorturl_ShortUrl.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShortUrl exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShortUrl exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ShortUrlPersistenceImpl.class);
	private static ShortUrl _nullShortUrl = new ShortUrlImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ShortUrl> toCacheModel() {
				return _nullShortUrlCacheModel;
			}
		};

	private static CacheModel<ShortUrl> _nullShortUrlCacheModel = new CacheModel<ShortUrl>() {
			@Override
			public ShortUrl toEntityModel() {
				return _nullShortUrl;
			}
		};
}