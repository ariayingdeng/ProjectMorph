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
	margin-left: 5%;
	background-color: lavender;
	font-family: calibri;

	width: 90%;
	color: rgb(139, 69, 19);
	width: 90%;
}

#myHeader {
	display: grid;
	grid-template-columns: 25% 55% 20%;
	grid-template-rows: 50% 50%;
	padding: 0%;
	height: 9%;
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
	grid-row: 1/-1;
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
	margin-top: 5%;
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

hr {
	heigth: 2px;
	width: 95%;
	border: 2px double rgb(139, 69, 19);
}


footer small{
	margin-left: 2%;
}










h2 {
	color: black;
}

#bodyContainer img {
	width: 50%;
	
}

#bodyContainer p {
	color: #404040;
}


</style>

</head>
<body>
	<header id="myHeader">
		<h1 id='headerLetter'>
			<img src="/resources/Group_Logo.png" class="logo" alt="Morph Icon" />MORPH


		</h1>

		<div id='navContainer'>
			<nav>
				<aside id="firstAside">
					<form action="/" method="POST" name="">
					<a href="javascript:document.@name.submit()">Body Information</a>
					</form>
					<form action="/bodyAnalysisReport" method="POST" name="analysisReportForm">
					<input type="hidden" name="analysisReport" value="analysisReport" />
					<a href="javascript:document.analysisReportForm.submit()">Analysis Report</a> 
					</form>
					<form action="/" method="POST" name="">
					<a href="javascript:document.@name.submit()">Workout Plansn</a>
					</form>
					<form action="/" method="POST" name="">
					<a href="javascript:document.@name.submit()">Meal Plans</a>
					</form>
					<form action="/" method="POST" name="">
					<a href="javascript:document.@name.submit()">Check-In</a>
					</form>
					<form action="/" method="POST" name="">
					<a href="javascript:document.@name.submit()">Community</a>
					</form>
					
				</aside>
			</nav>

		</div>
		<c:if test="${ login == null }">
			<aside id="secondAside">
				<a href="" id='login'>Login</a> <a href="" id='createAccount'>Sign
					Up</a>
			</aside>

		</c:if>
		<c:if test="${ login != null }">
			<aside id="secondAside">
				<a href="" id="userAccount">Welcome, ${ userName }</a>
			</aside>
		</c:if>

	</header>
	<hr>
	<div id='bodyContainer'>

		<img src="/resources/workoutandeat.jpg" alt="picture" >
		
		<h2>
		<br>
		About Project</h2>
		<p>We create a easier way to bring you healthier life, input your information and we will create a customized plan for you.<br>
			Don't hesitate, sign up and join us, then start to reach a bight future.
		</p>


	</div>


	<footer>
		<small>&copy; 2021 by Group Morph. All rights reserved.</small>
	</footer>




</body>
</html>