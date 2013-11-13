<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<content tag="title"><spring:message code="add.room" text="Add room" /></content>

<content tag="breadcrumbs">
    <a href="${pageContext.request.contextPath}/admin/hotel/list-of-hotels"><spring:message code="list.of.hotels" text="List of Hotels" /></a>
    <span class="divider">/</span>
    <a href="${pageContext.request.contextPath}/admin/hotel/${hotelId}/update-hotel"><spring:message code="update.hotel" text="Update Hotel" /></a>
    <span class="divider">/</span>
    <spring:message code="add.room" text="Add Room" />
</content>

<body>
    <div class="widget-box">
        <div class="widget-title"><h5><span class="icon"><i class="icon-align-justify"></i></span> <spring:message code="add.room" text="Add Room" /></h5></div>
        <div class="widget-content nopadding">
            <form:form modelAttribute="roomForm" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/hotel/room/${hotelId}/create-room">
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
</body>