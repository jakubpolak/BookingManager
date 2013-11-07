<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<body>

<!-- Reservation form to book a room in a hotel -->

<form:form method="post" action="/bm-web/processBooking" modelAttribute="reservationForm">
      <table>
          <tr>
            <td><form:label path="reservationFrom">From</form:label> <form:errors path="reservationFrom"></form:errors></td>
          	<td><form:input path="reservationFrom" cssClass="date-picker" /></td>
          </tr>
          <tr>
            <td><form:label path="reservationTo">To</form:label> <form:errors path="reservationTo"></form:errors></td>
          	<td><form:input path="reservationTo" cssClass="date-picker" /></td>
          </tr>
          <tr>
            <td><form:label path="customerName">Name and surname</form:label> <form:errors path="customerName"></form:errors></td>
          	<td><form:input path="customerName" /></td>
          </tr>
          <tr>
            <td><form:label path="customerEmail">Email</form:label> <form:errors path="customerEmail"></form:errors></td>
          	<td><form:input path="customerEmail" /></td>
          </tr>
          <tr>
            <td><form:label path="customerPhone">Phone</form:label> <form:errors path="customerPhone"></form:errors></td>
          	<td><form:input path="customerPhone" /></td>
          </tr>
          <tr>
            <!-- Will be hidden -->
          	<td>Room ID: <form:input path="roomByRoomId" /></td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="submit" value="Book" />
              </td>
          </tr>
      </table>
</form:form>
</body>