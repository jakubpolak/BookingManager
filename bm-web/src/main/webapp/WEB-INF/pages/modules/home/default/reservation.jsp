<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
  <spring:message code="booking.reservation.number" text="Email" />: ${reservationId}<br>
  <spring:message code="booking.reservation.onname" text="On Name" />: ${customerName}<br>
  <spring:message code="booking.reservation.email" text="Email" /> ${customerEmail}<br>
  <spring:message code="booking.reservation.phone" text="Phone" /> ${customerPhone}<br>
  <spring:message code="booking.reservation.from" text="From" />: ${reservationFrom}<br>
  <spring:message code="booking.reservation.to" text="To" />: ${reservationTo}<br>
</body>