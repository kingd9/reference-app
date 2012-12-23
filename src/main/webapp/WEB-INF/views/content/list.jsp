<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<ol>
	<c:forEach items="${personList}" var="person">
		<li>
			<div>Id: ${person.id}</div>
			<div>Name: ${person.firstName} ${person.lastName}</div>
		</li>
	</c:forEach>
	</ol>
</div>
