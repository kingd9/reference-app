<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ attribute name="path"
	description="Path to bind to model, by convention uses path to resolve label messages"
	required="true"%>
<%@ attribute name="label"
	description="Override dynamic resolution of label" required="false"%>

<li>
	<form:label path="${path}">
		<c:choose>
			<c:when test="${empty label}">
				<c:set var="labelCode" value="${path}.label"/>
				 <sp:message code="${labelCode}" text="Code ${labelCode} not found" />
			</c:when>
			<c:otherwise>
			${label}
		</c:otherwise>
		</c:choose>
	</form:label>
</li>
<li>
	<form:input path="${path}" />
</li>
<li>
	<form:errors path="${path}" />
</li>