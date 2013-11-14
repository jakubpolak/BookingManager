<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<body>

	<h1>${hotel.name}</h1>
	<h4>Book room ${room.number} for ${room.price}</h4>

	<!-- Reservation form to book a room in a hotel -->

	<form:form method="post" action="${pageContext.request.contextPath}/processBooking"
		modelAttribute="reservationForm">
		<table>
			<tr>
				<td><form:label path="reservationFrom">From</form:label> <form:errors
						path="reservationFrom"></form:errors></td>
				<td><form:input path="reservationFrom" cssClass="date-picker" placeholder="Reservation from" /></td>
			</tr>
			<tr>
				<td><form:label path="reservationTo">To</form:label> <form:errors
						path="reservationTo"></form:errors></td>
				<td><form:input path="reservationTo" cssClass="date-picker" placeholder="Reservation to"  /></td>
			</tr>
			<tr>
				<td><form:label path="customerName">Name and surname</form:label>
					<form:errors path="customerName"></form:errors></td>
				<td><form:input path="customerName" placeholder="Your name"  /></td>
			</tr>
			<tr>
				<td><form:label path="customerEmail">Email</form:label> <form:errors
						path="customerEmail"></form:errors></td>
				<td><form:input path="customerEmail" placeholder="Your e-mail"  /></td>
			</tr>
			<tr>
				<td><form:label path="customerPhone">Phone</form:label> <form:errors
						path="customerPhone"></form:errors></td>
				<td><form:input path="customerPhone" placeholder="Your phone number"  /></td>
			</tr>
		</table>
		<form:input type="hidden" path="roomByRoomId" />
		<input type="submit" class="btn" value="Book" />
	</form:form>
</body>