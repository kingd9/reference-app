<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<c:forEach items="${personList}" var="person">
		<div>
			<span>Name:</span><span>${person.firstName}</span> <span>${person.lastName}</span>
		</div>
	</c:forEach>
</div>
