<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<content tag="title"><spring:message code="update.hotel" text="Update Hotel" /></content>

<content tag="breadcrumbs">
    <a href="${pageContext.request.contextPath}/admin/hotel/list-of-hotels"><spring:message code="list.of.hotels" text="List of Hotels" /></a> <span class="divider">/</span> <spring:message code="update.hotel" text="Update Hotel" />
</content>

<body>
    <div class="widget-box">
        <div class="widget-title"><h5><span class="icon"><i class="icon-align-justify"></i></span> <spring:message code="list.of.rooms" text="List of Rooms" /></h5></div>
        <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Číslo</th>
                    <th>&nbsp;</th>
                    <th>&nbsp;</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${roomDtos}" var="roomDto" varStatus="status">
                        <tr>
                            <td class="width-20">${status.count}</td>
                            <td>${roomDto.number}</td>
                            <td class="center width-100">
                                <a href="${pageContext.servletContext.contextPath}/admin/hotel/room/${hotelId}/${roomDto.id}/update-room">
                                    <i class="icon-pencil"></i> <spring:message code="update" text="Update"/>
                                </a>
                            </td>
                            <td class="center width-100">
                                <a href="${pageContext.servletContext.contextPath}/admin/hotel/room/${hotelId}/${roomDto.id}/delete-room">
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