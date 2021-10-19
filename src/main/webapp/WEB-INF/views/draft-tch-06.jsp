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
<title>Group Morph Profile</title>

</head>
<body>
	<h1>Test for generate report</h1>
	<form:form method="POST" action="/bodyReport"
		modelAttribute="bodyReport">
		<input type="submit" value="Generate" />
	</form:form>
	<c:if test="${ bodyReport != null }">
		<div class="reportContainter">
			<aside id="personalBlock">
				<ul>
					<li>Name: &nbsp;&nbsp;${ userName}</li>
					<li>Age: &nbsp;&nbsp;&nbsp;${ userAge }</li>
					<li>Height: ${ userHeight } cm</li>
					<li>Weight: ${ userWeight } kg</li>
					<li>BMI: &nbsp;&nbsp;&nbsp;${ userBMI }</li>
					<li>BMR: &nbsp;&nbsp;&nbsp;${ userBMR }</li>
					<li id="smallList"><small>BMR: Basal Metabolic Rate /
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
				
					Dear ${ userName }, your BMI is ${ userBMI }. It means you are in
					the
					<c:if test="${ userBMI <= 18.5} "> Underweight level.<br>
					Please consider the Bulking plan.
				</c:if>
					<c:if test="${ userBMI > 18.5 && userBMI < 25 } "> Normal Weight level.<br>
					Please consider the Maintenance plan.
				</c:if>
					<c:if test="${ userBMI >= 25 && userBMI < 30 } "> Overweight Weight level.<br>
					Please consider the Cutting plan.
				</c:if>
					<c:if test="${ userBMI >= 30 } "> Overweight Weight level.<br>
					Please consider the Cutting plan.
				</c:if>
				<table>
					<tr>
						<td><c:if test="${ userBMI <= 18.5}">
								<b>
							</c:if>18.5 or less<c:if test="${ userBMI <= 18.5}">
								</b>
							</c:if></td>
						<td><c:if test="${ userBMI <= 18.5}">
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
		</div>
	</c:if>
</body>
</html>