<%@ include file="init.jsp" %>

<liferay-ui:success key="entry-added" message='<%= LanguageUtil.format(pageContext, "entry-added", renderRequest.getAttribute("url")) %>' />
<liferay-ui:success key="entry-updated" message='<%= LanguageUtil.format(pageContext, "entry-updated", renderRequest.getAttribute("url")) %>' />
<liferay-ui:success key="entry-deleted" message="entry-deleted" />
<liferay-ui:error key="error-deleting" message="error-deleting" />

<%
boolean hasAddPermission = permissionChecker.hasPermission(scopeGroupId, "de.ancud.shorturl.model", scopeGroupId, "ADD_SHORTURL");
boolean hasConfigurePermission = permissionChecker.hasPermission(scopeGroupId, Group.class.getName(), scopeGroupId, ActionKeys.PERMISSIONS);
%>

<aui:button-row>
	<c:if test='<%= hasAddPermission %>'>
		<portlet:renderURL var="addEntryURL">
			<portlet:param name="jspPage" value="/html/shorturl/editEntry.jsp" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</portlet:renderURL>
	
		<aui:button value="add-entry" onClick="<%= addEntryURL.toString() %>" />
	</c:if>
	
	<c:if test='<%= hasConfigurePermission %>'>
		<liferay-security:permissionsURL
		  modelResource="de.ancud.shorturl.model"
		  modelResourceDescription="actions"
		  resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
		  var="permissionsURL"
		/>

		<aui:button value="permissions" onClick="<%= permissionsURL %>"/>
	</c:if>
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="no-entries-were-found" >
	<liferay-ui:search-container-results results="<%= ShortUrlLocalServiceUtil.getFilteredShortUrlsByGroupId(scopeGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS) %>" />
	
	<liferay-ui:search-container-row className="de.ancud.shorturl.model.ShortUrl" escapedModel="<%= true %>" keyProperty="shortUrlId" modelVar="currEntry" rowIdProperty="shortUrlId">
		<liferay-ui:search-container-column-text name="identifier" orderable="<%= true %>" value='<%= themeDisplay.getPortalURL() + "/" + currEntry.getIdentifier() %>' href='<%= "/" + currEntry.getIdentifier() %>' />
		<liferay-ui:search-container-column-text name="original-url" orderable="<%= true %>" property="originalUrl" href='<%= currEntry.getOriginalUrl() %>' />
		<liferay-ui:search-container-column-jsp path="/html/shorturl/entryActions.jsp" valign="middle" align="right" />
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator paginate="<%= false %>" />
</liferay-ui:search-container>
