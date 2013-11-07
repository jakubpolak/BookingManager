<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
    <!-- Listing hotels -->
	<h3>Hotels</h3>
	<c:forEach items="${hotels}" var="hotel">
		<a href="/bm-web/hotel/<c:out value="${hotel.id}" />"><c:out value="${hotel.name}" /></a>
		<i>$<c:out value="${hotel.id}" /></i>
		<br>
		<br>
	</c:forEach>
</body>