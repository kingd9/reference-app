<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><tiles:insertAttribute name="title" /></title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/main.css"/>
</head>
<body>
 
<div id="header">
<tiles:insertAttribute name="header" />
</div>
<div id="title">
	<h2><tiles:insertAttribute name="title" /></h2>
</div>
<div id="content">
	<tiles:insertAttribute name="content" />
</div>
<div id="footer">
	<tiles:insertAttribute name="footer" />
</div>
</body>
</html>