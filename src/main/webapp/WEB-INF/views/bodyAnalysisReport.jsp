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
<title>Morph Body Report</title>
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

	<div id="reportContainer">
		<h1 id="reportH1">Body Report of ${ userName }</h1>

		<c:if test="${ bodyReport != null }">

			<aside id="personalBlock">
				<ul>
					<li>Name: &nbsp;&nbsp;${ userName}</li>
					<li>Age: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ userAge }</li>
					<li>Height: ${ userHeight } cm</li>
					<li>Weight: ${ userWeight } kg</li>
					<li>BMI: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatNumber
							type="number" maxFractionDigits="2" value="${ userBMI }" /></li>
					<li>BMR: &nbsp;&nbsp;&nbsp;&nbsp;${ userBMR }</li>
					<li id="smallList"><small>BMR: Basal Metabolic Rate <br>
							BMI: Body Mass Index
					</small></li>
				</ul>
			</aside>
			<aside id="D_WCaloriesBlock">
				<div class="caloryBlock">
					<h2 class="calH2">${ CaloriesPerDay }</h2>
					<b>Calories per Day</b>
				</div>
				<div class="caloryBlock">
					<h2 class="calH2">${ CaloriesPerWeek }</h2>
					<b>Calories per Week</b>
				</div>
			</aside>
			<aside id="BMIBlock">
				<div>
					<br> <br>Dear ${ userName }, your BMI is <cite><b>
							<fmt:formatNumber type="number" maxFractionDigits="2"
								value="${ userBMI }" />
					</b></cite> .<br>It's
					<c:if test="${ userBMI <= 18.5 }">
						<cite><b>Underweight level</b></cite>.<br>
					Please consider the <cite><b>Bulking plan</b></cite>.
				</c:if>
					<c:if test="${ userBMI > 18.5 && userBMI < 25 }">
						<cite><b>Normal Weight level</b></cite>.<br>
					Please consider the <cite><b>Maintenance plan</b></cite>.
				</c:if>
					<c:if test="${ userBMI >= 25 && userBMI < 30 }">
						<cite><b>Overweight Weight level</b></cite>.<br>
					Please consider the <cite><b>Cutting plan</b></cite>.
				</c:if>
					<c:if test="${ userBMI >= 30 }">
						<cite><b>Overweight Weight level</b></cite>.<br>
					Please consider the <cite><b>Cutting plan</b></cite>.
				</c:if>
				</div>
				<table>
					<tr>
						<td><c:if test="${ userBMI <= 18.5 }">
								<b>
							</c:if>18.5 or less<c:if test="${ userBMI <= 18.5}">
								</b>
							</c:if></td>
						<td><c:if test="${ userBMI <= 18.5 }">
								<b>
							</c:if>Underweight<c:if test="${ userBMI <= 18.5}">
								</b>
							</c:if></td>
					</tr>
					<tr>
						<td><c:if test="${ userBMI > 18.5 && userBMI < 25 }">
								<b>
							</c:if>18.5 ~ 25<c:if test="${ userBMI > 18.5 && userBMI < 25 }">
								</b>
							</c:if></td>
						<td><c:if test="${ userBMI > 18.5 && userBMI < 25 }">
								<b>
							</c:if>Normal Weight<c:if test="${ userBMI > 18.5 && userBMI < 25 }">
								</b>
							</c:if></td>
					<tr>
					<tr>
						<td><c:if test="${ userBMI >= 25 && userBMI < 30 }">
								<b>
							</c:if>25 ~ 30<c:if test="${ userBMI >= 25 && userBMI < 30 }">
								</b>
							</c:if></td>
						<td><c:if test="${ userBMI >= 25 && userBMI < 30 }">
								<b>
							</c:if>Overweight<c:if test="${ userBMI >= 25 && userBMI < 30 }">
								</b>
							</c:if></td>
					<tr>
					<tr>
						<td><c:if test="${ userBMI >= 30 }">
								<b>
							</c:if>30+<c:if test="${ userBMI >= 30 }">
								</b>
							</c:if></td>
						<td><c:if test="${ userBMI >= 30 }">
								<b>
							</c:if>Obese<c:if test="${ userBMI >= 30 }">
								</b>
							</c:if></td>
					<tr>
				</table>
			</aside>
			<aside id="caloryPlans">

				<c:if test="${ caloryPlan == null || caloryPlan == 0 }">

					<table class="caloryPlanBlock">
						<thead>
							<tr>
								<th>Moderate Carbon(30/35/35)</th>
							<tr>
						</thead>
						<tr>
							<td><h2 class="blockH2">${ moderateCarbonProtein }g</h2> <small
								class="blockSmall">protein</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ moderateCarbonFat }g</h2> <small
								class="blockSmall">fat</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ moderateCarbonCarb }g</h2> <small
								class="blockSmall">carb</small></td>
						</tr>
					</table>
					<table class="caloryPlanBlock">
						<thead>
							<tr>
								<th>Lower Carbon(40/40/20)</th>
							<tr>
						</thead>
						<tr>
							<td><h2 class="blockH2">${ lowerCarbonProtein }g</h2> <small
								class="blockSmall">protein</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ lowerCarbonFat }g</h2> <small
								class="blockSmall">fat</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ lowerCarbonCarb }g</h2> <small
								class="blockSmall">carb</small></td>
						</tr>
					</table>
					<table class="caloryPlanBlock">
						<thead>
							<tr>
								<th>Higher Carbon(30/20/50)</th>
							<tr>
						</thead>
						<tr>
							<td><h2 class="blockH2">${ higherCarbonProtein }g</h2> <small
								class="blockSmall">protein</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ higherCarbonFat }g</h2> <small
								class="blockSmall">fat</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ higherCarbonCarb }g</h2> <small
								class="blockSmall">carb</small></td>
						</tr>
					</table>
				</c:if>
				<c:if test="${ caloryPlan == 1 }">
					<div>These macronutrient values reflect your maintenance
						calories of ${ CaloriesPerDay - 500} calories per day, which is a
						500 calorie per day deficit from your maintenance of ${ CaloriesPerDay }
						calories per day.</div>
					<table class="caloryPlanBlock">
						<thead>
							<tr>
								<th>Moderate Carbon(30/35/35)</th>
							<tr>
						</thead>
						<tr>
							<td><h2 class="blockH2">${ moderateCarbonProtein }g</h2> <small
								class="blockSmall">protein</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ moderateCarbonFat }g</h2> <small
								class="blockSmall">fat</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ moderateCarbonCarb }g</h2> <small
								class="blockSmall">carb</small></td>
						</tr>
					</table>
					<table class="caloryPlanBlock">
						<thead>
							<tr>
								<th>Lower Carbon(40/40/20)</th>
							<tr>
						</thead>
						<tr>
							<td><h2 class="blockH2">${ lowerCarbonProtein }g</h2> <small
								class="blockSmall">protein</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ lowerCarbonFat }g</h2> <small
								class="blockSmall">fat</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ lowerCarbonCarb }g</h2> <small
								class="blockSmall">carb</small></td>
						</tr>
					</table>
					<table class="caloryPlanBlock">
						<thead>
							<tr>
								<th>Higher Carbon(30/20/50)</th>
							<tr>
						</thead>
						<tr>
							<td><h2 class="blockH2">${ higherCarbonProtein }g</h2> <small
								class="blockSmall">protein</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ higherCarbonFat }g</h2> <small
								class="blockSmall">fat</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ higherCarbonCarb }g</h2> <small
								class="blockSmall">carb</small></td>
						</tr>
					</table>
				</c:if>

				<c:if test="${ caloryPlan == 2 }">
					<div>These macronutrient values reflect your maintenance
						calories of ${ CaloriesPerDay + 500} calories per day, which is
						+500 calories per day from your maintenance of ${ CaloriesPerDay }
						calories per day.</div>
					<table class="caloryPlanBlock">
						<thead>
							<tr>
								<th>Moderate Carbon(30/35/35)</th>
							<tr>
						</thead>
						<tr>
							<td><h2 class="blockH2">${ moderateCarbonProtein }g</h2> <small
								class="blockSmall">protein</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ moderateCarbonFat }g</h2> <small
								class="blockSmall">fat</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ moderateCarbonCarb }g</h2> <small
								class="blockSmall">carb</small></td>
						</tr>
					</table>
					<table class="caloryPlanBlock">
						<thead>
							<tr>
								<th>Lower Carbon(40/40/20)</th>
							<tr>
						</thead>
						<tr>
							<td><h2 class="blockH2">${ lowerCarbonProtein }g</h2> <small
								class="blockSmall">protein</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ lowerCarbonFat }g</h2> <small
								class="blockSmall">fat</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ lowerCarbonCarb }g</h2> <small
								class="blockSmall">carb</small></td>
						</tr>
					</table>
					<table class="caloryPlanBlock">
						<thead>
							<tr>
								<th>Higher Carbon(30/20/50)</th>
							<tr>
						</thead>
						<tr>
							<td><h2 class="blockH2">${ higherCarbonProtein }g</h2> <small
								class="blockSmall">protein</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ higherCarbonFat }g</h2> <small
								class="blockSmall">fat</small></td>
						</tr>
						<tr>
							<td><h2 class="blockH2">${ higherCarbonCarb }g</h2> <small
								class="blockSmall">carb</small></td>
						</tr>
					</table>
				</c:if>
			</aside>

		</c:if>
	</div>
	<footer>
		<small>&copy; 2021 by Group Morph. All rights reserved.</small>
	</footer>
</body>
</html>