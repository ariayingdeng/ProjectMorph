<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css"
	>
<title>Group Morph Profile</title>

</head>
<body>
	<h1>Test for generate report</h1>
	<form:form method="POST" action="/bodyReport"
		modelAttribute="bodyReport">
		<input type="submit" value="Generate" />
	</form:form>
	<c:if test="${ bodyReport != null }">
   	${ bodyReport }
   	</c:if>
</body>
</html>