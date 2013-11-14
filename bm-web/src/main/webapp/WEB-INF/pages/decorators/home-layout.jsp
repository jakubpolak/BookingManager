<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="decorator" content="home-layout">
    <title>Default</title>
    
    <!-- jQuery -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/home/jquery-ui-1.10.3.custom.min.css" />
    <script src="${pageContext.request.contextPath}/public/lib/jquery-1.8.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/public/lib/jquery-ui-1.10.3.custom.min.js"></script>
    
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/lib/bootstrap/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/public/lib/bootstrap/js/bootstrap.min.js"></script>
    
    <!--  Custom theme -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/home/theme.css" />
    
    <script type="text/javascript">
	$(function() {
	    $('.date-picker').datepicker( {
	        changeMonth: true,
	        changeYear: true,
	        showButtonPanel: true,
	        //dateFormat: 'MM yy',
	        
	    });
	});
	</script>
</head>
<body>
  <div class="container">
  <div class="row">
    <div class="navbar">
	    <div class="navbar-inner">
	    	<a class="brand" href="#">Reservation System</a>
	    </div>
    </div>
    <decorator:body />
  </div>
  </div>
</body>
</html>