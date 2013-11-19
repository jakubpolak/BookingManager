<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<content tag="title"><spring:message code="add.user" text="Add user" /></content>

<content tag="breadcrumbs">
    <a href="${pageContext.request.contextPath}/admin/user/list-of-users"><spring:message code="list.of.users" text="List of users" /></a>
    <span class="divider">/</span>
    <spring:message code="add.user" text="Add user" />
</content>

<body>
    <div class="widget-box">
        <div class="widget-title"><h5><span class="icon"><i class="icon-align-justify"></i></span> <spring:message code="add.user" text="Add user" /></h5></div>
        <div class="widget-content nopadding">
            <form:form modelAttribute="userCreateFormType" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/user/create-user">
                <div class="control-group">
                    <form:label class="control-label" path="email"><spring:message code="email" text="Email" /> <span class="required">*</span></form:label>
                    <div class="controls">
                        <form:input path="email" cssClass="width-250" />
                        <form:errors cssClass="error-message" path="email" />
                    </div>
                </div>

                <div class="control-group">
                    <form:label class="control-label" path="password"><spring:message code="password" text="Password" /> <span class="required">*</span></form:label>
                    <div class="controls">
                        <form:password path="password" cssClass="width-250" />
                        <form:errors cssClass="error-message" path="password" />
                    </div>
                </div>

                <div class="control-group">
                    <form:label class="control-label" path="roleByRoleId"><spring:message code="role" text="Role" /> <span class="required">*</span></form:label>
                    <div class="controls">
                        <form:select path="roleByRoleId">
                            <form:options items="${roleDtos}" itemValue="id" itemLabel="name" />
                        </form:select>
                    </div>
                </div>

                <div class="form-actions">
                    <input type="submit" value="<spring:message code="save" text="Save" />" class="btn btn-primary" />
                </div>
            </form:form>
        </div>
    </div>
</body>