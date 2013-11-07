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
<body class="">
<!--<![endif]-->
<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav pull-right">
            <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">Settings</a></li>
            <li id="fat-menu" class="dropdown">
                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="icon-user"></i> Administrator
                    <i class="icon-caret-down"></i>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">My Account</a></li>
                    <li class="divider"></li>
                    <li><a class="visible-phone" href="#">Settings</a></li>
                    <li class="divider visible-phone"></li>
                    <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
                </ul>
            </li>
        </ul>
        <a class="brand" href="#">Administration</a>
    </div>
</div>
<div class="sidebar-nav">
    <a href="#" class="nav-header" ><i class="icon-table"></i>Dashboard</a>

    <a href="#articles-menu" class="nav-header" data-toggle="collapse"><i class="icon-file"></i>Hotel<span class="label label-info">+2</span></a>
    <ul id="articles-menu" class="nav nav-list collapse  in">
        <li class="active">
            <a href="#"><spring:message code="list.of.hotels" text="default text" /></a>
        </li>
        <li>
            <a href="#"><spring:message code="add.hotel" text="default text" /></a>
        </li>
    </ul>
</div>
<div class="content">
    <div class="header">
        <h1 class="page-title">
            <decorator:getProperty property="page.page-title" default="&nbsp;" />
        </h1>
    </div>

    <ul class="breadcrumb">
        <c:choose>
            <c:when test="${origPage.isPropertySet('page.breadcrumbs')}">
                <li><a href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a> <span class="divider">/</span></li>
                <decorator:getProperty property="page.breadcrumbs" />
            </c:when>
            <c:otherwise>
                <li class="active">Dashboard</li>
            </c:otherwise>
        </c:choose>
    </ul>

    <div class="container-fluid">
        <div class="row-fluid">
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
