<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<content tag="title"><spring:message code="add.hotel" text="Add hotel" /></content>

<content tag="breadcrumbs"><spring:message code="add.hotel" text="Add Hotel" /></content>

<body>
    <div class="widget-box">
        <div class="widget-title"><h5><span class="icon"><i class="icon-align-justify"></i></span> <spring:message code="add.hotel" text="Add Hotel" /></h5></div>
            <div class="widget-content nopadding">
                <form:form modelAttribute="hotelForm" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/hotel/create-hotel">
                    <div class="control-group">
                        <form:label class="control-label" path="name"><spring:message code="name" text="Name" /> <span class="required">*</span></form:label>
                        <div class="controls">
                            <form:input path="name" cssClass="width-250" />
                            <form:errors cssClass="error-message" path="name" />
                        </div>
                    </div>

                    <div class="form-actions">
                        <input type="submit" value="<spring:message code="save" text="Save" />" class="btn btn-primary" />
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>