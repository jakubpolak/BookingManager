<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<content tag="title"><spring:message code="update.user" text="Update User" /></content>

<content tag="breadcrumbs">
    <a href="${pageContext.request.contextPath}/admin/user/list-of-users"><spring:message code="list.of.users" text="List of Users" /></a>
    <span class="divider">/</span>
    <spring:message code="update.user" text="Update User" />
</content>

<body>
    update-user.jsp
</body>