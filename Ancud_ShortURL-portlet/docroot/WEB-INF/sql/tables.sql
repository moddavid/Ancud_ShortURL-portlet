create table shorturl_ShortUrl (
	shortUrlId LONG not null primary key,
	identifier VARCHAR(75) null,
	originalUrl STRING null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);