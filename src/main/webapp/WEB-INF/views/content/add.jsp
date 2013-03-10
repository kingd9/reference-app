<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<form:form modelAttribute="person">

<%-- Need primary key to edit/create spring handles in repository  --%>

<form:hidden path="id"/>
	<fieldset>
		<ol>
			<tags:fieldInput path="firstName"></tags:fieldInput>
			<tags:fieldInput path="lastName" label="Last Name"></tags:fieldInput>
			<tags:fieldInput path="email" label="Email"></tags:fieldInput>
			<li><input type="submit" value="Save" /></li>
		</ol>
	</fieldset>
</form:form>