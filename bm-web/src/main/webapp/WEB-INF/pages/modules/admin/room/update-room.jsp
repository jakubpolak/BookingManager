<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <div class="widget-title"><h5><span class="icon"><i class="icon-align-justify"></i></span> <spring:message code="update.room" text="Update Room" /></h5></div>
        <div class="widget-content nopadding">
            <form:form modelAttribute="roomForm" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/hotel/room/${hotelId}/${roomId}/update-room">
                <div class="control-group">
                    <form:label class="control-label" path="number"><spring:message code="number" text="Number" /> <span class="required">*</span></form:label>
                    <div class="controls">
                        <form:input path="number" cssClass="width-250" />
                        <form:errors cssClass="error-message" path="number" />
                    </div>
                </div>

                <div class="control-group">
                    <form:label class="control-label" path="price"><spring:message code="price" text="Price" /> <span class="required">*</span></form:label>
                    <div class="controls">
                        <form:input path="price" cssClass="width-250" />
                        <form:errors cssClass="error-message" path="price" />
                    </div>
                </div>

                <div class="form-actions">
                    <input type="submit" value="<spring:message code="save" text="Save" />" class="btn btn-primary" />
                </div>
            </form:form>
        </div>
    </div>

    <c:if test="${not empty reservationDtos}">
        <div class="widget-box">
            <div class="widget-title"><h5><span class="icon"><i class="icon-align-justify"></i></span> <spring:message code="list.of.reservations" text="List of Rooms" /></h5></div>
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
                                <td><fmt:formatDate value="${reservationDto.reservationFrom}" type="date" pattern="MM/dd/yyyy" /></td>
                                <td><fmt:formatDate value="${reservationDto.reservationTo}" type="date" pattern="MM/dd/yyyy" /></td>
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
    </c:if>

    <div class="btn-toolbar">
        <a class="btn btn-primary" href="${pageContext.servletContext.contextPath}/admin/hotel/room/reservation/${hotelId}/${roomId}/create-reservation">
            <i class="icon-plus"></i> <spring:message code="add.reservation" text="Add reservation" />
        </a>
    </div>
</body>