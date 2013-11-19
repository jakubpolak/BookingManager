<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
  <h1><spring:message code="booking.reservation.success" text="Book is already reserved." /></h1>
  
  <div class="alert alert-success">
  	<spring:message code="booking.reservation.notedetails" text="Note the details of your reservation:" />
  </div>
 
  <strong><spring:message code="booking.reservation.number" text="Number" />: ${reservationId}</strong><br>
  <spring:message code="booking.reservation.onname" text="On Name" />: ${customerName}<br>
  <spring:message code="booking.reservation.email" text="Email" /> ${customerEmail}<br>
  <spring:message code="booking.reservation.phone" text="Phone" /> ${customerPhone}<br>
  <spring:message code="booking.reservation.from" text="From" />: ${reservationFrom}<br>
  <spring:message code="booking.reservation.to" text="To" />: ${reservationTo}<br>
</body>