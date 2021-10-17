<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<style>
body {
	background-color: #FFEBCD;
}

.container {
	margin-top: 0;
	margin-bottom: 0px;
	height:100vh;
	padding-top:50px;
	background-color:#696969;
	color:#FFFAFA;
}

.mb-3 {
	font-size: 20px;
	font-weight: bolder;
	font-family: calibri;
}

h1 {
	
	font-weight: bolder;
	font-family: calibri;
}

.alert{

	background-color:#696969;
	color:#FFFAFA;
	
}
</style>

<title>Body Analysis</title>
</head>
<body>
	<div class="container">
		<h1>Hello ${userName}</h1>
		<hr>
		<h4>We will generate a body analysis report for you. <br>
			Please input your information below. 
		</h4>
		
		<br>
		<form:form action="${pageContext.request.contextPath}/bodyAnalysis"
			method="POST" cssClass="form-horizontal" modelAttribute="analysis">

			<div class="mb-3">
				Height
				<form:input type="text" cssClass="form-control" path="height" />
			</div>

			<div class="mb-3">
				Weight
				<form:input type="text" cssClass="form-control" path="weight" />
			</div>

			<div class="mb-3">
				Age
				<form:input type="text" cssClass="form-control" path="age" />
			</div>

			<div class="mb-3">
				Gender
				<form:select cssClass="form-control" path="gender">
					<form:option value="NONE" label="--- Select ---" />
					<form:option value="male" label="Male" />
					<form:option value="female" label="Female" />
				</form:select>

			</div>

			<div class="mb-3">
				Body Fat (Optional)
				<form:input type="text" cssClass="form-control" path="bodyFat" />
			</div>

			<form:button type="submit" cssClass="btn btn-primary">Generate</form:button>
		</form:form>
		<br><br>
		<c:if test="${ result !=null }">
			 
			<div class="alert alert-success" role="alert">
				Generated Personal Information : <br>
				<strong>${result}</strong>
			</div>
		</c:if>
	</div>


	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
</body>
</html>