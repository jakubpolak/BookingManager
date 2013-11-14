<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<body>
	<h1>${hotel.name}</h1>
	<h4><spring:message code="booking.header.bookroom" text="Book room" /> ${room.number} <spring:message code="booking.header.bookroom.for" text="for" /> &euro; ${room.price}</h4>

	<!-- Reservation form to book a room in a hotel -->

	<spring:message code="booking.reservation.reservationfrom" text="Reservation from" var="reservationFrom" />
	<spring:message code="booking.reservation.reservationto" text="Reservation to" var="reservationTo" />
    <spring:message code="booking.reservation.yournameandsurname" text="Your name" var="yournameandsurname" />
    <spring:message code="booking.reservation.youremail" text="Your email" var="youremail" />
    <spring:message code="booking.reservation.yourphone" text="Your phone number" var="yourphonenumber" />

	<form:form method="post" action="${pageContext.request.contextPath}/processBooking"
		modelAttribute="reservationForm">
		<table>
			<tr>
				<td><form:label path="reservationFrom"><spring:message code="booking.reservation.from" text="From" /></form:label> <form:errors
						path="reservationFrom"></form:errors></td>
				<td><form:input path="reservationFrom" cssClass="date-picker" placeholder="${reservationFrom}" /></td>
			</tr>
			<tr>
				<td><form:label path="reservationTo"><spring:message code="booking.reservation.to" text="To" /></form:label> <form:errors
						path="reservationTo"></form:errors></td>
				<td><form:input path="reservationTo" cssClass="date-picker" placeholder="${reservationTo}"  /></td>
			</tr>
			<tr>
				<td><form:label path="customerName"><spring:message code="booking.reservation.nameandsurname" text="Name and surname" /></form:label>
					<form:errors path="customerName"></form:errors></td>
				<td><form:input path="customerName" placeholder="${yournameandsurname}"  /></td>
			</tr>
			<tr>
				<td><form:label path="customerEmail"><spring:message code="booking.reservation.email" text="Email" /></form:label> <form:errors
						path="customerEmail"></form:errors></td>
				<td><form:input path="customerEmail" placeholder="${youremail}"  /></td>
			</tr>
			<tr>
				<td><form:label path="customerPhone"><spring:message code="booking.reservation.phone" text="Phone" /></form:label> <form:errors
						path="customerPhone"></form:errors></td>
				<td><form:input path="customerPhone" placeholder="${yourphonenumber}"  /></td>
			</tr>
		</table>
		<form:input type="hidden" path="roomByRoomId" />
		<input type="submit" class="btn" value="<spring:message code="booking.buttons.book" text="Book" />" />
	</form:form>
</body>