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
body>header {
	width: 90%;
	grid-column: 1/ -1;
	padding: 0px;
}

h2 {
	margin-bottom: 1%;
}

body {
	display: grid;
	grid-template-columns: 1fr 1fr 1fr;
}

small {
	font-size: 0.6em;
}

aside li {
	padding: 0px;
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
	
	grid-column: 1 / -1;
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
	width:88%;
}


ul {
	padding-left: 25%;
	
}

body aside {
	
	padding-left: 1rem;

}

.caloryBlock {
	margin-top: 10%;
	

}

table thead tr th {
	font-size: 0.6em;
}

.blockH2 {
	text-align: center;
	

}

.blockSmall {
	padding-left: 8%;
}


</style>
</head>
<body>
	<header>
		<h1>${ userName } Body Report</h1>		
	</header>

	<c:if test="${ bodyReport != null }">

		<aside id="personalBlock">
			<ul>
				<li>Name: &nbsp;&nbsp;${ userName}</li>
				<li>Age: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ userAge }</li>
				<li>Height: ${ userHeight } cm</li>
				<li>Weight: ${ userWeight } kg</li>
				<li>BMI: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatNumber type="number"
						maxFractionDigits="2" value="${ userBMI }" /></li>
				<li>BMR: &nbsp;&nbsp;&nbsp;&nbsp;${ userBMR }</li>
				<li id="smallList"><small>BMR: Basal Metabolic Rate <br>
						BMI: Body Mass Index</small></li>
			</ul>
		</aside>
		<aside id="D_WCaloriesBlock">
			<div class="caloryBlock">
				<h2>${ CaloriesPerDay }</h2>
				<b>Calories per Day</b>
			</div>
			<div class="caloryBlock">
				<h2>${ CaloriesPerWeek }</h2>
				<b>Calories per Week</b>
			</div>
		</aside>
		<aside id="BMIBlock">
			<div>
				<br><br>Dear ${ userName }, your BMI is <cite><b>
				<fmt:formatNumber type="number" maxFractionDigits="2"
					value="${ userBMI }" /> </b></cite>
				.<br>It's
				<c:if test="${ userBMI <= 18.5 }"> <cite><b>Underweight level</b></cite>.<br>
					Please consider the <cite><b>Bulking plan</b></cite>.
				</c:if>
				<c:if test="${ userBMI > 18.5 && userBMI < 25 }"> <cite><b>Normal Weight level</b></cite>.<br>
					Please consider the <cite><b>Maintenance plan</b></cite>.
				</c:if>
				<c:if test="${ userBMI >= 25 && userBMI < 30 }"> <cite><b>Overweight Weight level</b></cite>.<br>
					Please consider the <cite><b>Cutting plan</b></cite>.
				</c:if>
				<c:if test="${ userBMI >= 30 }"> <cite><b>Overweight Weight level</b></cite>.<br>
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
						<td><h2 class="blockH2">${ moderateCarbonProtein }g</h2> <small class="blockSmall">protein</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ moderateCarbonFat }g</h2> <small class="blockSmall">fat</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ moderateCarbonCarb }g</h2> <small class="blockSmall">carb</small></td>
					</tr>
				</table>
				<table class="caloryPlanBlock">
					<thead>
						<tr>
							<th>Lower Carbon(40/40/20)</th>
						<tr>
					</thead>
					<tr>
						<td><h2 class="blockH2">${ lowerCarbonProtein }g</h2> <small class="blockSmall">protein</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ lowerCarbonFat }g</h2> <small class="blockSmall">fat</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ lowerCarbonCarb }g</h2> <small class="blockSmall">carb</small></td>
					</tr>
				</table>
				<table class="caloryPlanBlock">
					<thead>
						<tr>
							<th>Higher Carbon(30/20/50)</th>
						<tr>
					</thead>
					<tr>
						<td><h2 class="blockH2">${ higherCarbonProtein }g</h2> <small class="blockSmall">protein</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ higherCarbonFat }g</h2> <small class="blockSmall">fat</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ higherCarbonCarb }g</h2> <small class="blockSmall">carb</small></td>
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
						<td><h2 class="blockH2">${ moderateCarbonProtein }g</h2> <small class="blockSmall">protein</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ moderateCarbonFat }g</h2> <small class="blockSmall">fat</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ moderateCarbonCarb }g</h2> <small class="blockSmall">carb</small></td>
					</tr>
				</table>
				<table class="caloryPlanBlock">
					<thead>
						<tr>
							<th>Lower Carbon(40/40/20)</th>
						<tr>
					</thead>
					<tr>
						<td><h2 class="blockH2">${ lowerCarbonProtein }g</h2> <small class="blockSmall">protein</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ lowerCarbonFat }g</h2> <small class="blockSmall">fat</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ lowerCarbonCarb }g</h2> <small class="blockSmall">carb</small></td>
					</tr>
				</table>
				<table class="caloryPlanBlock">
					<thead>
						<tr>
							<th>Higher Carbon(30/20/50)</th>
						<tr>
					</thead>
					<tr>
						<td><h2 class="blockH2">${ higherCarbonProtein }g</h2> <small class="blockSmall">protein</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ higherCarbonFat }g</h2> <small class="blockSmall">fat</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ higherCarbonCarb }g</h2> <small class="blockSmall">carb</small></td>
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
						<td><h2 class="blockH2">${ moderateCarbonProtein }g</h2> <small class="blockSmall">protein</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ moderateCarbonFat }g</h2> <small class="blockSmall">fat</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ moderateCarbonCarb }g</h2> <small class="blockSmall">carb</small></td>
					</tr>
				</table>
				<table class="caloryPlanBlock">
					<thead>
						<tr>
							<th>Lower Carbon(40/40/20)</th>
						<tr>
					</thead>
					<tr>
						<td><h2 class="blockH2">${ lowerCarbonProtein }g</h2> <small class="blockSmall">protein</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ lowerCarbonFat }g</h2> <small class="blockSmall">fat</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ lowerCarbonCarb }g</h2> <small class="blockSmall">carb</small></td>
					</tr>
				</table>
				<table class="caloryPlanBlock">
					<thead>
						<tr>
							<th>Higher Carbon(30/20/50)</th>
						<tr>
					</thead>
					<tr>
						<td><h2 class="blockH2">${ higherCarbonProtein }g</h2> <small class="blockSmall">protein</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ higherCarbonFat }g</h2> <small class="blockSmall">fat</small></td>
					</tr>
					<tr>
						<td><h2 class="blockH2">${ higherCarbonCarb }g</h2> <small class="blockSmall">carb</small></td>
					</tr>
				</table>
			</c:if>
		</aside>

	</c:if>
</body>
</html>