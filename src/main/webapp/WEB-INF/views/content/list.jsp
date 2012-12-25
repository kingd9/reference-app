<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<ol>
		<c:forEach items="${personList}" var="person">
			<li>
				<h3>Name:</h3>
				<div class="vcard">
					<span class="fn n">
						<span class="given-name">${person.firstName}</span>
						<span class="family-name">${person.lastName}</span>
					</span> 
				</div>
				<div><a href="${pageContext.request.contextPath}/person/${person.id}">Details</a></div>
				<div><a href="${pageContext.request.contextPath}/person/edit/${person.id}">Edit</a></div>
				<div><a href="${pageContext.request.contextPath}/person/delete/${person.id}">Delete</a></div>
			</li>
		</c:forEach>
	</ol>
</div>
