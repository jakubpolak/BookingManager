<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="decorator" content="admin-auth">
    <%@ include file="../modules/admin/partials/head.jsp" %>
</head>
<body>
<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav pull-right">

        </ul>
        <span class="brand">Authentification</span>
    </div>
</div>

<div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">Sign In</p>
            <div class="block-body">
                <form method="post" action="<c:url value="${pageContext.request.contextPath}/j_spring_security_check" />">
                    <c:if test="${error == true}">
                        <div class="alert alert-error">
                            <button type="button" class="close" data-dismiss="alert">×</button>
                            <strong>Error:</strong> Invalid email or password!
                        </div>
                    </c:if>
                    <label>Email</label>
                    <input type="text" name="j_username" id="j_username" class="span12">
                    <label>Password</label>
                    <input type="password" name="j_password" id="j_password" class="span12">
                    <button type="submit" class="btn btn-primary pull-right">Sign in</button>
                    <div class="clearfix"></div>
                </form>
            </div>
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