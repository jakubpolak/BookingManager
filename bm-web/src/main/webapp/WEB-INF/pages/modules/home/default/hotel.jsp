<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
    <!-- Listing hotels -->
	<h3>Hotel ${hotel.name}</h3>
	<c:forEach items="${hotel.roomsById}" var="room">
		${room.id}
	</c:forEach>
</body>