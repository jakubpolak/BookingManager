<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<content tag="title"><spring:message code="list.of.hotels" text="List of hotels" /></content>

<content tag="breadcrumbs"><spring:message code="list.of.hotels" text="List of hotels" /></content>

<body>
    <c:if test="${empty hotelDtos}">
        <div class="alert alert-info">
            <button class="close" data-dismiss="alert">×</button>
            <spring:message code="list.of.hotels.is.empty" text="List of hotels is empty." />
        </div>
    </c:if>

    <c:if test="${not empty hotelDtos}">
        <div class="widget-box">
            <div class="widget-title"><h5><span class="icon"><i class="icon-align-justify"></i></span> <spring:message code="list.of.hotels" text="List of Hotels" /></h5></div>
            <div class="widget-content nopadding">
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th><spring:message code="name" text="Name" /></th>
                            <th>&nbsp;</th>
                            <th>&nbsp;</th>
                            <th>&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${hotelDtos}" var="hotelDto" varStatus="status">
                            <tr>
                                <td class="width-20">${status.count}</td>
                                <td>${hotelDto.name}</td>
                                <td class="center width-100">
                                    <a href="${pageContext.servletContext.contextPath}/admin/hotel/room/${hotelDto.id}/create-room">
                                        <i class="icon-plus"></i> <spring:message code="add.room" text="Add room"/>
                                    </a>
                                </td>
                                <td class="center width-100">
                                    <a href="${pageContext.servletContext.contextPath}/admin/hotel/${hotelDto.id}/update-hotel">
                                        <i class="icon-pencil"></i> <spring:message code="update" text="Update"/>
                                    </a>
                                </td>
                                <td class="center width-100">
                                    <a href="${pageContext.servletContext.contextPath}/admin/hotel/${hotelDto.id}/delete-hotel">
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
</body>