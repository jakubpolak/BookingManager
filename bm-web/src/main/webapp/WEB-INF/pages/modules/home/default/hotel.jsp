<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<body>
	<h1>${hotel.name}</h1>
  
    <h4 class="table-headline"><spring:message code="booking.header.availablerooms" text="Available rooms" /></h4>
    
    <form method="get" action="${pageContext.request.contextPath}/hotel/${hotel.id}" class="form-inline filter">
		<div class="controls">
	   		<input type="text" name="from" class="date-picker input-big span2" value="${from}" placeholder="<spring:message code="booking.reservation.reservationfrom" text="Reservation from" />" />
	        <input type="text" name="to" class="date-picker input-big span2" value="${to}" placeholder="<spring:message code="booking.reservation.reservationto" text="Reservation to" />" />
	        <button type="submit" class="btn"><spring:message code="booking.buttons.showavailable" text="Show available" /></button>
        </div>
    </form>
    
    <!-- Listing hotel rooms -->
    <table class="table table-striped table-bordered">
        <thead>
			<tr>
				<th><spring:message code="booking.hotel.roomnumber" text="Room No." /></th>
				<th><spring:message code="booking.hotel.price" text="Price" /></th>
				<th></th>
			</tr>
		</thead>
		<c:forEach items="${hotel.roomsById}" var="room">
		   <tr>
		   		<td>
					${room.number}
				</td>
				<td>
					&euro; ${room.price}
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/book/${room.id}?from=${from}&to=${to}"><spring:message code="booking.buttons.booknow" text="Book now" /></a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>