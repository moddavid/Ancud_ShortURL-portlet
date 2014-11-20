<%@ include file="init.jsp" %>

<liferay-ui:error key="identifier-required" message="identifier-required" />
<liferay-ui:error key="identifier-already-exists" message="identifier-already-exists" />
<liferay-ui:error key="identifier-wrong-letters" message="identifier-wrong-letters" />
<liferay-ui:error key="url-required" message="url-required" />
<liferay-ui:error key="url-invalid" message="url-invalid" />

<%
ShortUrl shortUrl = null;
long shortUrlId = ParamUtil.getLong(request, "shortUrlId", -1);
if (shortUrlId != -1) {
	shortUrl = ShortUrlLocalServiceUtil.getShortUrl(shortUrlId);
}

String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header backURL="<%= redirect %>" title='<%= (shortUrl != null) ? "edit-entry" : "new-entry" %>' />

<aui:model-context bean="<%= shortUrl %>" model="<%= ShortUrl.class %>" />

<portlet:actionURL name='<%= shortUrl == null ? "addEntry" : "editEntry" %>' var="editEntryURL" />

<aui:fieldset>
	<aui:form action="<%= editEntryURL %>" method="POST" name="fm">
		<aui:input name="shortUrlId" type="hidden" />
		<aui:input name="identifier" value="<%= shortUrl == null ? ShortUrlLocalServiceUtil.getRandomIdentifier() : shortUrl.getIdentifier() %>" required="<%= true %>" />
		<aui:input name="originalUrl" required="<%= true %>" />
		
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button value="cancel" onClick="<%= redirect %>" />
		</aui:button-row>
	</aui:form>
</aui:fieldset>