<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
    <!-- Listing hotels -->
	<h3><spring:message code="booking.header.hotels" text="Hotels" /></h3>
	<table class="table table-striped table-bordered">
	    <c:if test="${empty hotels}">
	        <div class="well">
	        	<spring:message code="booking.reservation.nohotels" text="There are currently no hotels to choose from." />
	        </div>
        </c:if>
		<c:forEach items="${hotels}" var="hotel">
			<tr>
				<td>
					<a href="${pageContext.request.contextPath}/hotel/<c:out value="${hotel.id}" />"><c:out value="${hotel.name}" /></a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>