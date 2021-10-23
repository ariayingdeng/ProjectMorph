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

<link rel="stylesheet"
	href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css" />

<style>
body {
	background-color: lavender;
}

.gd {
	display: grid;
	grid-template-columns: 1fr 2fr 1fr;
	grid-template-rows: auto;
}

.left {
	grid-column: 1;
	background-image: url(/resources/analysis1.png);
	background-repeat: no-repeat;
	background-size: 120%;
	background-position-x: center;
	background-position-y: 30%;
}

.flex {
	grid-column: 2;
	margin: 0 auto;
	padding-top: 3%;
	padding-left: 2.5%;
	padding-right: 2.5%;
}

.right {
	grid-column: 3;
	background-image: url(/resources/analysis2.png);
	background-repeat: no-repeat;
	background-size: 135%;
	background-position-x: 70%;
	background-position-y: 30%;
}

#btn {
	margin: 0 auto;
	width: 20%;
}

hr {
	border-top: 2px solid grey;
}

h1, h6, #ttl, .alert {
	color: dimgrey;
}
</style>

<title>Body Analysis</title>
</head>
<body>
	<div class="gd">
		<div class="left"></div>

		<div class="flex">


			<h1>Hello ${userName}</h1>

			<h6>We will generate a body analysis report for you. Please
				input your information below.</h6>

			<form:form action="${pageContext.request.contextPath}/bodyAnalysis"
				method="POST" modelAttribute="analysis">

				<label for="age"><strong id="ttl">Age</strong><input
					type="text" id="age" name="age" placeholder=" " required></label>


				<label for="height"><strong id="ttl">Height</strong><input
					type="text" id="height" name="height" placeholder="cm" required></label>

				<label for="weight"><strong id="ttl">Weight</strong><input
					type="text" id="weight" name="weight" placeholder="kg" required></label>

				<strong id="ttl">Sex</strong> &nbsp&nbsp&nbsp&nbsp
				<form:radiobutton path="gender" value="Male" id="ttl" />  Male &nbsp&nbsp&nbsp
       			<form:radiobutton path="gender" value="Female" id="ttl" /> Female 
			
				<br>
				<br>
				<label for="bodyFat"><strong id="ttl">Body Fat</strong><input
					type="text" id="bodyFat" name="bodyFat" placeholder="20%" required>
				</label>

				<br>
				<br>
				<strong id="ttl">Activity Frequency</strong>
				<form:select path="activity">
					<form:option value="0" label="--- Select ---" />
					<form:option value="1" label="Sedentary (office job)" />
					<form:option value="2" label="Light Exercise (1-2 days/week)" />
					<form:option value="3" label="Light Exercise (3-5 days/week)" />
					<form:option value="4" label="Light Exercise (6-7 days/week)" />
					<form:option value="5" label="Light Exercise (2x per day)" />
				</form:select>

				<form:button type="submit" id="btn">Generate</form:button>

				<c:if test="${error != null}">
					<div class="alert alert-success" role="alert">${error}</div>
				</c:if>
			</form:form>
			<br> <br>
			<c:if test="${ result !=null }">

				<div class="alert alert-success" role="alert">
					<hr>
					<br> Generated Personal Information : <br> <strong
						id="ttl">${result}</strong>
				</div>
			</c:if>
		</div>
		<div class="right"></div>
	</div>

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