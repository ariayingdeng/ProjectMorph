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
	href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Group Morph</title>
<style>
body {
	display: flex;
	flex-direction: column;
	background-color: lavender;
	font-family: calibri;
	width: 100%;
	color: rgb(139, 69, 19);
}

/* CSS style for header beginning*/
.myHeader {
	display: grid;
	grid-template-columns: 25% 55% 20%;
	grid-template-rows: 50% 50%;
	padding: 0%;
	height: 5%; -
	-block-spacing-vertical: 0px;
}

.myHeader form {
	margin: 0%;
}

#bodyContainer {
	margin: 2.5%;
	width: 95%;
}

#headerLetter {
	margin-top: 2%;
	color: rgb(139, 69, 19);
	font-family: "Gill Sans", "Gill Sans MT", Calibri, "Trebuchet MS",
		sans-serif;
	margin-bottom: 0%;
	grid-colum: 1;
	grid-row: 1/3;
	padding-top: 5%;
}

#headerLetter img {
	margin-left: 4%;
	height: 4rem;
	margin-right: 2%;
	margin-bottom: 2%;
}

#navContainer nav aside {
	justify-content: left;
	display: flex;
	width: 100%;
	position: relative; -
	-block-spacing-vertical: 0px;
}

#myHeader>#navContainer { -
	-block-spacing-vertical: 0px;
}

#firstAside form {
	font-size: 0.9em;
	white-space: nowrap;
	margin-right: 3%;
}

#navContainer nav #firstAside {
	vertical-align: bottom;
	padding-top: 3%;
}

#navContainer nav aside a {
	height: 100%;
	font-family: "Courier New", Courier, monospace;
	color: rgb(105, 105, 105);
	display: block;
	margin-right: 2.5%;
	font-size: 1em;
	font-weight: 600;
	padding-bottom: 1%;
	vertical-align: bottom;
}

#navContainer {
	grid-row: 2;
	grid-column: 2/-1;
	vertical-align: bottom;
}

#navContainer nav {
	height: 100%;
	vertical-align: bottom;
}

#secondAside {
	display: flex;
	justify-content: center;
	grid-row: 1;
	grid-column: 3;
}

#secondAside a {
	font-size: 1em;
	font-weight: 600;
	font-family: "Courier New", Courier, monospace;
	border: 2px solid rgb(139, 69, 19);
	color: rgb(105, 105, 105);
	margin: 2%;
	padding: 2%;
}

#headerHr {
	heigth: 2px;
	width: 100%;
	border: 2px double rgb(139, 69, 19);
}

body>footer {
	padding-left: 5%;
	padding-top: 0px;
	padding-bottom: 3%;
	margin: 0%;
	color: rgb(139, 69, 19);
}

/* CSS style for header ending */
span {
	font-weight: bold;
}

th {
	font-weight: bold;
	color: grey;
}

.container {
	max-width: 90%;
}

#newPlanBtn {
	display: block;
	width: 18%;
	margin: 0 auto;
}
</style>

</head>
<body>
	<div class="myHeader">

		<form action="/" method="POST" name="morphHome"></form>
		<h1 id='headerLetter'>

			<input type="hidden" name="morphHome" value="/"> <a
				href="javascript:document.morphHome.submit()"> <img
				src="/resources/Group_Logo.png" class="logo" alt="Morph Icon" />
			</a> MORPH
		</h1>



		<div id='navContainer'>
			<nav>
				<aside id="firstAside">
					<form action="/bodyInfoInput" method="POST" name="bodyInfoInput">
					<a href="javascript:document.bodyInfoInput.submit()">Body Info</a>
					</form>
					<form action="/bodyAnalysisReport" method="POST" name="analysisReportForm">
					<input type="hidden" name="analysisReport" value="analysisReport" />
					<a href="javascript:document.analysisReportForm.submit()">Analysis</a> 
					</form>
					<form action="/workoutplan" method="POST" name="workoutPlan">
					<a href="javascript:document.workoutPlan.submit()">Workout Plans</a>
					</form>
					<form action="/GenerateMealPlan" method="POST" name="GenerateMealPlan">
					<a href="javascript:document.GenerateMealPlan.submit()">Meal Plans</a>
					</form>
					<form action="/checkin" method="POST" name="checkin">
					<a href="javascript:document.checkin.submit()">Check-In</a>
					</form>
					<form action="/" method="POST" name="">
					<a href="javascript:document.@name.submit()">Community</a>
					</form>
					<form action="/userSetting" method="POST" name="userSetting">
					<a href="javascript:document.userSetting.submit()">Setting</a>
					</form>

				</aside>
			</nav>

		</div>
		<c:if test="${ loggedIn == null }">
			<aside id="secondAside">
				<form action="/loginPage" method="POST" name="loginPage"></form>
				<a href="javascript:document.loginPage.submit()">Login</a>

				<form action="/registerPage" method="POST" name="registerPage"></form>
				<a href="javascript:document.registerPage.submit()">Sign Up</a>

			</aside>

		</c:if>
		<c:if test="${ loggedIn != null }">
			<aside id="secondAside">
				<form action="/logOut" method="POST" name="logOut"></form>
				<a href="javascript:document.logOut.submit()">${ loggedIn }, Log
					Out</a>
			</aside>
		</c:if>

	</div>
	<hr id="headerHr">

	<div class="container">
		<span>Please choose your weekly work-out plan from light
			exercises to vigorous exercises by all means. </span> <br> <br>
		<div class="grid">

			<div>
				<h3>Light Exercises</h3>
				<table>
					<tr>
						<th>Day</th>
						<th>Exercise</th>
						<th>Calories/40 minutes</th>
					</tr>
					<tr>
						<td>${day1 }</td>
						<td>${exercise1 }</td>
						<td>${calories1 }</td>
					</tr>
					<tr>
						<td>${day2 }</td>
						<td>${exercise2 }</td>
						<td>${calories2 }</td>
					</tr>
					<tr>
						<td>${day3 }</td>
						<td>${exercise3 }</td>
						<td>${calories3 }</td>
					</tr>
				</table>
			</div>

			<div>
				<h3>Moderate Exercises</h3>
				<table>
					<tr>
						<th>Day</th>
						<th>Exercise</th>
						<th>Calories/40 minutes</th>
					</tr>
					<tr>
						<td>${day1 }</td>
						<td>${exercise4 }</td>
						<td>${calories4 }</td>
					</tr>
					<tr>
						<td>${day2 }</td>
						<td>${exercise5 }</td>
						<td>${calories5 }</td>
					</tr>
					<tr>
						<td>${day3 }</td>
						<td>${exercise6 }</td>
						<td>${calories6 }</td>
					</tr>
				</table>
			</div>

			<div>
				<h3>Vigorous Exercises</h3>
				<table>
					<tr>
						<th>Day</th>
						<th>Exercise</th>
						<th>Calories/40 minutes</th>
					</tr>
					<tr>
						<td>${day1 }</td>
						<td>${exercise7 }</td>
						<td>${calories7 }</td>
					</tr>
					<tr>
						<td>${day2 }</td>
						<td>${exercise8 }</td>
						<td>${calories8 }</td>
					</tr>
					<tr>
						<td>${day3 }</td>
						<td>${exercise9 }</td>
						<td>${calories9 }</td>
					</tr>
				</table>
			</div>

		</div>
		<form:form method="POST" action="/newPlan" modelAttribute="newPlan">
			<input type="submit" value="CHANGE PLAN" id="newPlanBtn">
		</form:form>

	</div>
	<footer>
		<small>&copy; 2021 by Group Morph. All rights reserved.</small>
	</footer>




</body>
</html>