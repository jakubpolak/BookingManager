<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
    <!-- Listing hotels -->
	<h3>Hotels</h3>
	<table class="table table-striped table-bordered">
		<c:forEach items="${hotels}" var="hotel">
			<tr>
				<td>
					<a href="/bm-web/hotel/<c:out value="${hotel.id}" />"><c:out value="${hotel.name}" /></a>
					<i>$<c:out value="${hotel.id}" /></i>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>