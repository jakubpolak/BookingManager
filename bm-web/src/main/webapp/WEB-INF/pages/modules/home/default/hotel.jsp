<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<body>
    <!-- Listing hotels -->
	<h3>Hotel ${hotel.name}</h3>
	<form method="get" action="/bm-web/hotel/${hotel.id}">
	
	<table>
		<tr>
            <td><label>From</label></td>
          	<td><input type="text" name="from" class="date-picker" value="${from}" /></td>
          	<td><label>To</label></td>
          	<td><input type="text" name="to" class="date-picker" value="${to}" /></td>
          </tr>
          <input type="submit" value="Filter" />
    </table>
    </form>
  
    <h2>Available rooms</h2>
	<c:forEach items="${hotel.roomsById}" var="room">
		${room.id}
	</c:forEach>
</body>