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
	display: block;
	margin: 0 auto;
	width: 35%;
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
					<form action="/bodyAnalysisReport" method="POST"
						name="analysisReportForm">
						<input type="hidden" name="analysisReport" value="analysisReport" />
						<a href="javascript:document.analysisReportForm.submit()">Analysis</a>
					</form>
					<form action="/workoutplan" method="POST" name="workoutPlan">
						<a href="javascript:document.workoutPlan.submit()">Workout Plans</a>
					</form>
					<form action="/GenerateMealPlan" method="POST" name="GenerateMealPlan">
					<a href="javascript:document.GenerateMealPlan.submit()">Meal Plans</a>
					</form>
					<form action="/estimationInfoInput" method="POST" name="goalEstimation">
						<a href="javascript:document.goalEstimation.submit()">Goal-Estimation</a>
					</form>
					<form action="/" method="POST" name="">
						<a href="javascript:document.@name.submit()">Check-In</a>
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

	<div class="gd">
		<div class="left"></div>

		<div class="flex">


			<h1>Hello ${userName}</h1>

			<h6>We will generate a body analysis report for you. Please
				input your information below.</h6>

			<form:form action="/bodyAnalysis" method="POST"
				modelAttribute="analysis">

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
					<form:option value="3" label="Moderate Exercise (3-5 days/week)" />
					<form:option value="4" label="Heavy Exercise (6-7 days/week)" />
					<form:option value="5" label="Athlete (2x per day)" />
				</form:select>

				<input type="submit" value="Generate Report" id="btn">

			</form:form>

		</div>
		<div class="right"></div>
	</div>


	<footer>
		<small>&copy; 2021 by Group Morph. All rights reserved.</small>
	</footer>
</body>
</html>