<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<content tag="title"><spring:message code="update.room" text="Update Room" /></content>

<content tag="breadcrumbs">
    <a href="${pageContext.request.contextPath}/admin/hotel/list-of-hotels"><spring:message code="list.of.hotels" text="List of Hotels" /></a>
    <span class="divider">/</span>
    <a href="${pageContext.request.contextPath}/admin/hotel/${hotelId}/update-hotel"><spring:message code="update.hotel" text="Update Hotel" /></a>
    <span class="divider">/</span>
    <spring:message code="update.room" text="Update Room" />
</content>

<body>
    <div class="widget-box">
        <div class="widget-title"><h5><span class="icon"><i class="icon-align-justify"></i></span> <spring:message code="list.of.rooms" text="List of Rooms" /></h5></div>
        <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th><spring:message code="from" text="From" /></th>
                    <th><spring:message code="to" text="To" /></th>
                    <th><spring:message code="name" text="Name" /></th>
                    <th><spring:message code="email" text="Email" /></th>
                    <th><spring:message code="phone" text="Phone" /></th>
                    <th>&nbsp;</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${reservationDtos}" var="reservationDto" varStatus="status">
                        <tr>
                            <td class="width-20">${status.count}</td>
                            <td>${reservationDto.reservationFrom}</td>
                            <td>${reservationDto.reservationTo}</td>
                            <td>${reservationDto.customerName}</td>
                            <td>${reservationDto.customerPhone}</td>
                            <td>${reservationDto.customerPhone}</td>
                            <td class="center width-100">
                                <a href="${pageContext.servletContext.contextPath}/admin/hotel/room/reservation/${hotelId}/${roomId}/${reservationDto.id}/update-reservation">
                                    <i class="icon-pencil"></i> <spring:message code="update" text="Update" />
                                </a>
                            </td>
                            <td class="center width-100">
                                <a href="${pageContext.servletContext.contextPath}/admin/hotel/room/reservation/${hotelId}/${roomId}/${reservationDto.id}/delete-reservation">
                                    <i class="icon-trash"></i> <spring:message code="delete" text="Delete" />
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>