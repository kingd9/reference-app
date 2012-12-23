<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form modelAttribute="person">
	<fieldset>
		<ol>
			<li>
				<form:label path="firstName">First Name</form:label>
			</li>
			<li>
				<form:input path="firstName" />
			</li>
			<li>
				<form:errors path="firstName" />
			</li>

			<li>
				<form:label path="lastName">Last Name</form:label>
			</li>
			<li>
				<form:input path="lastName" />
			</li>
			<li>
				<form:errors path="lastName" />
			</li>
			<li><input type="submit" value="Save" /></li>
		</ol>
	</fieldset>
</form:form>