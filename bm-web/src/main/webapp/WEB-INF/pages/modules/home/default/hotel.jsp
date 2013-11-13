<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<body>
	<h1>${hotel.name}</h1>
  
    <h4 class="table-headline">Available rooms</h4>
    
    <form method="get" action="/bm-web/hotel/${hotel.id}" class="form-inline filter">
		<div class="controls">
	   		<input type="text" name="from" class="date-picker input-big span2" value="${from}" placeholder="Reservation from" />
	        <input type="text" name="to" class="date-picker input-big span2" value="${to}" placeholder="Reservation to" />
	        <button type="submit" class="btn">Show available</button>
        </div>
    </form>
    
    <!-- Listing hotel rooms -->
    <table class="table table-striped table-bordered">
        <thead>
			<tr>
				<th>Room NO.</th>
				<th>Price</th>
				<th></th>
			</tr>
		</thead>
		<c:forEach items="${hotel.roomsById}" var="room">
		   <tr>
		   		<td>
					${room.number}
				</td>
				<td>
					${room.price}
				</td>
				<td>
					<a href="/bm-web/book/${room.id}?from=${from}&to=${to}">Book now</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>