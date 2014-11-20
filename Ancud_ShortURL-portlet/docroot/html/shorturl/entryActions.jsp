<%@include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ShortUrl shortUrl = (ShortUrl)row.getObject();

String name = ShortUrl.class.getName();
long shortUrlId = shortUrl.getShortUrlId();

long groupId = themeDisplay.getScopeGroupId();
%>

<liferay-ui:icon-menu>
	<c:if test="<%= permissionChecker.hasPermission(groupId, name, shortUrlId, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="/html/shorturl/editEntry.jsp" />
			<portlet:param name="shortUrlId" value="<%= String.valueOf(shortUrlId) %>"/>
			<portlet:param name="redirect" value="<%= currentURL %>"/>
		</portlet:renderURL>
	
		<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />
	</c:if>

	<c:if test="<%= permissionChecker.hasPermission(groupId, name, shortUrlId, ActionKeys.DELETE) %>">
		<portlet:actionURL name="deleteEntry" var="deleteURL">
			<portlet:param name="shortUrlId" value="<%= String.valueOf(shortUrlId) %>" />
			<portlet:param name="redirect" value="<%= currentURL %>"/>
		</portlet:actionURL>
		
		<liferay-ui:icon image="delete" url="<%=deleteURL.toString() %>" />
	</c:if>
	
	<c:if test="<%= permissionChecker.hasPermission(groupId, name, shortUrlId, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= ShortUrl.class.getName() %>"
			modelResourceDescription="<%= shortUrl.getIdentifier() %>"
			resourcePrimKey="<%= String.valueOf(shortUrlId) %>"
			var="permissionsURL"
		/>
		
		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	</c:if>
</liferay-ui:icon-menu>