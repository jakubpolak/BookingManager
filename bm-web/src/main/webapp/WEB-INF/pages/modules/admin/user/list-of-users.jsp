<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<content tag="title"><spring:message code="list.of.users" text="List of Users" /></content>

<content tag="breadcrumbs"><spring:message code="list.of.users" text="List of Users" /></content>

<body>
    <div class="widget-box">
        <div class="widget-title"><h5><span class="icon"><i class="icon-align-justify"></i></span> <spring:message code="list.of.users" text="List of Users" /></h5></div>
        <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>
                        <spring:message code="email" text="Email" />
                    </th>
                    <th>
                        <spring:message code="role.name" text="Role name" />
                    </th>
                    <th>&nbsp;</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${userDtos}" var="userDto" varStatus="status">
                        <tr>
                            <td class="width-20">${status.count}</td>
                            <td>${userDto.email}</td>
                            <td>${userDto.roleByRoleId.name}</td>
                            <td class="center width-100">
                                <a href="${pageContext.servletContext.contextPath}/admin/user/${userDto.id}/update-user">
                                    <i class="icon-pencil"></i> Upraviť
                                </a>
                            </td>
                            <td class="center width-100">
                                <a href="${pageContext.servletContext.contextPath}/admin/user/${userDto.id}/delete-user">
                                    <i class="icon-trash"></i> Zmazať
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>