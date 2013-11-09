<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<content tag="title"><spring:message code="update.reservation" text="Update Reservation" /></content>

<content tag="breadcrumbs">
    <a href="${pageContext.request.contextPath}/admin/hotel/list-of-hotels"><spring:message code="list.of.hotels" text="List of Hotels" /></a>
    <span class="divider">/</span>
    <a href="${pageContext.request.contextPath}/admin/hotel/${hotelId}/update-hotel"><spring:message code="update.hotel" text="Update Hotel" /></a>
    <span class="divider">/</span>
    <a href="${pageContext.request.contextPath}/admin/hotel/room/${hotelId}/${roomId}/update-room"><spring:message code="update.room" text="Update Room" /></a>
    <span class="divider">/</span>
    <spring:message code="update.reservation" text="Update Reservation" />
</content>

<body>
    update-reservation.jsp
</body>