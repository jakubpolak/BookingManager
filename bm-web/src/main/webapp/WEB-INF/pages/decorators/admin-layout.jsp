<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:useBean id="now" class="java.util.Date" scope="application" />
<decorator:usePage id="origPage" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file="../modules/admin/partials/head.jsp" %>
    </head>
    <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
    <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
    <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
    <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
    <!--[if (gt IE 9)|!(IE)]><!-->
    <body>
        <!--<![endif]-->
        <div class="navbar">
            <div class="navbar-inner">
                <ul class="nav pull-right">
                    <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button"><spring:message code="settings" text="Settings" /></a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> Administrator
                            <i class="icon-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><spring:message code="my.account" text="My account" /></a></li>
                            <li class="divider"></li>
                            <li><a class="visible-phone" href="#"><spring:message code="settings" text="Settings" /></a></li>
                            <li class="divider visible-phone"></li>
                            <li><a href="<c:url value="/j_spring_security_logout" />"><spring:message code="logout" text="Logout" /></a></li>
                        </ul>
                    </li>
                </ul>
                <a class="brand" href="${pageContext.request.contextPath}/admin"><spring:message code="administration" text="Administration" /></a>
            </div>
        </div>
        <div class="sidebar-nav">
            <a href="${pageContext.request.contextPath}/admin" class="nav-header" ><i class="icon-table"></i><spring:message code="dashboard" text="Nástenka" /></a>
            <a href="#hotels-menu" class="nav-header" data-toggle="collapse">
                <i class="icon-home"></i><spring:message code="hotel" text="Hotel" />
                <span class="label label-info">+2</span>
            </a>
            <ul id="hotels-menu" class="nav nav-list collapse <c:if test="${pageContext.request.servletPath.contains('/admin/hotel')}">in</c:if>">
                <li <c:if test="${pageContext.request.servletPath.contains('/admin/hotel') and pageContext.request.servletPath != '/admin/hotel/create-hotel'}">class="active"</c:if>>
                    <a href="${pageContext.request.contextPath}/admin/hotel/list-of-hotels">
                        <spring:message code="list.of.hotels" text="List of hotels" />
                    </a>
                </li>
                <li <c:if test="${pageContext.request.servletPath == '/admin/hotel/create-hotel'}">class="active"</c:if>>
                    <a href="${pageContext.request.contextPath}/admin/hotel/create-hotel">
                        <spring:message code="add.hotel" text="Add hotel" />
                    </a>
                </li>
            </ul>

            <a href="#users-menu" class="nav-header" data-toggle="collapse">
                <i class="icon-user"></i><spring:message code="user" text="User" />
                <span class="label label-info">+2</span>
            </a>
            <ul id="users-menu" class="nav nav-list collapse <c:if test="${pageContext.request.servletPath.contains('/admin/user')}">in</c:if>">
                <li <c:if test="${pageContext.request.servletPath.contains('/admin/user') and pageContext.request.servletPath != '/admin/user/create-user'}">class="active"</c:if>>
                    <a href="${pageContext.request.contextPath}/admin/user/list-of-users">
                        <spring:message code="list.of.users" text="List of users" />
                    </a>
                </li>
                <li <c:if test="${pageContext.request.servletPath == '/admin/user/create-user'}">class="active"</c:if>>
                    <a href="${pageContext.request.contextPath}/admin/user/create-user">
                        <spring:message code="add.user" text="Add user" />
                    </a>
                </li>
            </ul>
        </div>
        <div class="content">
            <div class="header">
                <h1 class="page-title">
                    <decorator:getProperty property="page.title" default="&nbsp;" />
                </h1>
            </div>

            <ul class="breadcrumb">
                <c:choose>
                    <c:when test="${origPage.isPropertySet('page.breadcrumbs')}">
                        <li><a href="${pageContext.request.contextPath}/admin/dashboard"><spring:message code="dashboard" text="Dashboard" /></a> <span class="divider">/</span></li>
                        <decorator:getProperty property="page.breadcrumbs" />
                    </c:when>
                    <c:otherwise>
                        <li class="active">
                            <spring:message code="dashboard" text="Dashboard" />
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>

            <div class="container-fluid">
                <div class="row-fluid">
                    <c:if test="${flashMessage != null}">
                        <div class="alert alert-${flashMessageType}">
                            <button class="close" data-dismiss="alert">×</button>
                            <spring:message code="${flashMessage}" />
                        </div>
                    </c:if>
                    <decorator:body />
                    <footer>
                        <hr>
                        <p class="pull-right">A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
                    </footer>
                </div>
            </div>
        </div>

        <script src="${pageContext.request.contextPath}/public/lib/bootstrap/js/bootstrap.js"></script>
        <script type="text/javascript">
            $("[rel=tooltip]").tooltip();
            $(function() {
                $('.demo-cancel-click').click(function(){return false;});
            });
        </script>
    </body>
</html>
