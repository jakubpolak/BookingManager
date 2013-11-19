<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<content tag="title"><spring:message code="add.reservation" text="Add reservation" /></content>

<content tag="breadcrumbs">
    <a href="${pageContext.request.contextPath}/admin/hotel/list-of-hotels"><spring:message code="list.of.hotels" text="List of hotels" /></a>
    <span class="divider">/</span>
    <a href="${pageContext.request.contextPath}/admin/hotel/${hotelId}/update-hotel"><spring:message code="update.hotel" text="Update hotel" /></a>
    <span class="divider">/</span>
    <a href="${pageContext.request.contextPath}/admin/hotel/room/${hotelId}/${roomId}/update-room"><spring:message code="update.room" text="Update room" /></a>
    <span class="divider">/</span>
    <spring:message code="add.reservation" text="Add reservation" />
</content>

<body>
    <div class="widget-box">
        <div class="widget-title"><h5><span class="icon"><i class="icon-align-justify"></i></span> <spring:message code="add.reservation" text="Add reservation" /></h5></div>
        <div class="widget-content nopadding">
            <form:form modelAttribute="reservationForm" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/hotel/room/reservation/${hotelId}/${roomId}/create-reservation">
                <div class="control-group">
                    <form:label class="control-label" path="reservationFrom"><spring:message code="reservation.from" text="From" /> <span class="required">*</span></form:label>
                    <div class="controls">
                        <form:input path="reservationFrom" cssClass="width-250 date-picker" />
                        <form:errors cssClass="error-message" path="reservationFrom" />
                    </div>
                </div>

                <div class="control-group">
                    <form:label class="control-label" path="reservationTo"><spring:message code="reservation.to" text="To" /> <span class="required">*</span></form:label>
                    <div class="controls">
                        <form:input path="reservationTo" cssClass="width-250 date-picker" />
                        <form:errors cssClass="error-message" path="reservationTo" />
                    </div>
                </div>

                <div class="control-group">
                    <form:label class="control-label" path="customerName"><spring:message code="customer.name" text="Customer name" /> <span class="required">*</span></form:label>
                    <div class="controls">
                        <form:input path="customerName" cssClass="width-250" />
                        <form:errors cssClass="error-message" path="customerName" />
                    </div>
                </div>

                <div class="control-group">
                    <form:label class="control-label" path="customerEmail"><spring:message code="customer.email" text="Customer email" /> <span class="required">*</span></form:label>
                    <div class="controls">
                        <form:input path="customerEmail" cssClass="width-250" />
                        <form:errors cssClass="error-message" path="customerEmail" />
                    </div>
                </div>

                <div class="control-group">
                    <form:label class="control-label" path="customerPhone"><spring:message code="customer.phone" text="Customer phone" /> <span class="required">*</span></form:label>
                    <div class="controls">
                        <form:input path="customerPhone" cssClass="width-250" />
                        <form:errors cssClass="error-message" path="customerPhone" />
                    </div>
                </div>

                <div class="form-actions">
                    <input type="submit" value="<spring:message code="save" text="Save" />" class="btn btn-primary" />
                </div>
            </form:form>
        </div>
    </div>
</body>