<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<content tag="title"><spring:message code="list.of.hotels" text="List of hotels" /></content>

<content tag="breadcrumbs"><spring:message code="list.of.hotels" text="List of hotels" /></content>

<body>
    <div class="widget-box">
        <div class="widget-title"><h5><span class="icon"><i class="icon-align-justify"></i></span> <spring:message code="list.of.hotels" text="List of Hotels" /></h5></div>
        <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Názov</th>
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
                                <a href="${pageContext.servletContext.contextPath}/admin/hotel/${hotelDto.id}/update-hotel">
                                    <i class="icon-pencil"></i> Upraviť
                                </a>
                            </td>
                            <td class="center width-100">
                                <a href="${pageContext.servletContext.contextPath}/admin/hotel/${hotelDto.id}/delete-hotel">
                                    <i class="icon-trash"></i> Zmazať
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>