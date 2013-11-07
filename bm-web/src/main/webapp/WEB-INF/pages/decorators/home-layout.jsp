<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<html>
<head>
    <meta name="decorator" content="home-layout">
    <title>Default</title>
    <link rel="stylesheet" href="/bm-web/public/css/home/jquery-ui-1.10.3.custom.min.css" />
    <script src="/bm-web/public/lib/jquery-1.8.1.min.js"></script>
    <script src="/bm-web/public/lib/jquery-ui-1.10.3.custom.min.js"></script>
    
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
    <decorator:body />
</body>
</html>