<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	min-height: 70vw;
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
	margin-right: 1.5%;
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

/* CSS style for header endding */
.calH2 {
	margin-bottom: 1%;
	color: #404040;
}

#reportContainer {
	margin-left: 15%;
	width: 70%;
	display: grid;
	grid-template-columns: 1fr 1fr 1fr;
	background-color: LavenderBlush;
}

small {
	font-size: 0.6em;
}

aside li {
	padding: 0px;
	color: #404040;
}

#personalBlock {
	font-size: 1.4em;
	padding: 1rem;
}

#D_WCaloriesBlock {
	padding: 1rem;
	padding-left: 25%;
}

#BMIBlock {
	font-size: 0.7em;
}

#BMIBlock div {
	padding-left: 7%;
	white-space: nowrap;
}

#caloryPlans {
	grid-column: 1/-1;
	display: grid;
	grid-template-columns: 1fr 1fr 1fr;
	padding-left: 5%;
	padding-right: 5%;
}

.caloryPlanBlock thead tr th {
	text-align: center;
}

#BMIBlock table {
	font-size: 1.1em;
	width: 88%;
}

ul {
	padding-left: 25%;
}

#reportContainer aside {
	padding-left: 1rem;
}

.caloryBlock {
	margin-top: 10%;
}

table thead tr th {
	font-size: 0.8em;
}

.blockH2 {
	text-align: center;
	color: #404040;
}

.blockSmall {
	padding-left: 8%;
	color: #404040;
}

#reportH1 {
	grid-column: 1/-1;
	padding-left: 5%;
	color: #404040;
}

tr, td, th {
	background-color: LavenderBlush;
	color: #404040;
}

#planContainer {
	display: grid;
	grid-template-columns: 1fr 1fr 1fr;
	grid-gap: 2%;
}

.meals {
	margin: 5%;
	border: 1px solid black;
	background-color: #D3D3D3;
}

.meals h2 {
	margin-bottom: 0px;
	background-color: LavenderBlush;
	text-align: center;
	font-family: Monaco Monospace;
}

.meals h3 {
	padding: 0 5%;
	font-size: 1.2rem;
	margin-bottom: 0px;
}

.meals h4 {
	width: 95%;
	margin-left: 2.5%;
	font-size: 1rem;
}

.meals hr {
	heigth: 1px;
	width: 95%;
	border: 0.1px solid black;
}

.smallh4 {
	margin-bottom: 1%;
}

.meals .head {
	font-size: 1.1rem;
}

.meals .smallh3 {
	font-size: 1.1rem;
}

.meals .importanth3 {
	font-family: Georgia Serif;
	font-size: 1.5rem;
}

p {
	padding-left: 2%;
	color: red;
}

#newMealBtn {
	display: block;
	width: 20%;
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
					<form action="/bodyAnalysisReport" method="POST"
						name="analysisReportForm">
						<input type="hidden" name="analysisReport" value="analysisReport" />
						<a href="javascript:document.analysisReportForm.submit()">Analysis</a>
					</form>
					<form action="/workoutplan" method="POST" name="workoutPlan">
						<a href="javascript:document.workoutPlan.submit()">Workout
							Plans</a>
					</form>
					<form action="/GenerateMealPlan" method="POST"
						name="GenerateMealPlan">
						<a href="javascript:document.GenerateMealPlan.submit()">Meal
							Plans</a>
					</form>
					<form action="/estimationInfoInput" method="POST"
						name="goalEstimation">
						<a href="javascript:document.goalEstimation.submit()">Goal-Estimation</a>
					</form>
					<form action="/checkin" method="POST" name="checkin">
						<a href="javascript:document.checkin.submit()">Check-In</a>
					</form>
					<form action="/community" method="POST" name="community">
						<a href="javascript:document.community.submit()">Community</a>
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

	<div id="planContainer">

		<aside class='meals'>
			<h2>BREAKFAST</h2>
			<h3 class="importanth3">
				<br>${ breakfastName }</h3>
			<hr>
			<h3 class='smallh3'>
				Calories:<br>${ breakfastCal }</h3>
			<hr>
			<h3 class='smallh3'>
				Servings:<br>${ serveBreakfast } portion(s)
			</h3>
			<hr>

			<h4>${ breakfastWeight }gfor ${ breakfastName }</h4>
			<h4 class="smallh4 head">Nutrients:</h4>
			<h4 class="smallh4">Carbon: ${ breakfastCarbon } g</h4>
			<h4 class="smallh4">Protein: ${ breakfastProtein } g</h4>
			<h4 class="smallh4">Fat: ${ breakfastFat } g</h4>
			<!--
			<h3>Carbon: ${ breakfastCarbon }</h3>
			<h3>Protein: ${ breakfastProtein }</h3>
			<h3>Fat: ${ breakfastFat }</h3>
			  -->

		</aside>

		<aside class='meals'>
			<h2>LUNCH</h2>
			<h3 class="importanth3">
				<br>${ lunchName }</h3>
			<hr>
			<h3 class='smallh3'>
				Calories:<br>${ lunchCal } cals
			</h3>
			<hr>
			<h3 class='smallh3'>
				Servings:<br>1 portion(s)
			</h3>
			<hr>


			<h4>${ serveLunch }for${ lunchName } respectively</h4>
			<h4 class="smallh4 head">Nutrients:</h4>
			<h4 class="smallh4">Carbon: ${ lunchCarbon } g</h4>
			<h4 class="smallh4">Protein: ${ lunchProtein } g</h4>
			<h4 class="smallh4">Fat: ${ lunchFat } g</h4>


		</aside>

		<aside class='meals'>
			<h2>DINNER</h2>
			<h3 class="importanth3">
				<br>${ dinnerName }</h3>
			<hr>
			<h3 class='smallh3'>
				Calories:<br>${ dinneCal }</h3>
			<hr>
			<h3 class='smallh3'>
				Servings:<br>${ serveDinner } portion(s)
			</h3>
			<hr>

			<h4>${ dinnerWeight }gfor ${ dinnerName } respectively</h4>
			<h4 class="smallh4 head">Nutrients:</h4>
			<h4 class="smallh4">Carbon: ${ dinneCarbon } g</h4>
			<h4 class="smallh4">Protein: ${ dinneProtein } g</h4>
			<h4 class="smallh4">Fat: ${ dinneFat } g</h4>


			<!--<h3>Carbon: ${ dinneCarbon }</h3>
			<h3>Protein: ${ dinneProtein }</h3>
			<h3>Fat: ${ dinneFat }</h3>
			  -->

		</aside>


	</div>
	<form:form method="POST" action="/newMeal" modelAttribute="newMeal">
		<input type="submit" value="CHANGE MEAL PLANS" id="newMealBtn">
	</form:form>
	<p>If you want to lose weight, eat 80% of suggested portions. For
		gaining weight, eat 120% of suggested portions.</p>
	<footer>
		<small>&copy; 2021 by Group Morph. All rights reserved.</small>
	</footer>
</body>
</html>