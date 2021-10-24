<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<title>Sign Up</title>
<style type="text/css">
body {
	background-color: lavender;
}

/* CSS style for header beginning*/
.myHeader {
	display: grid;
	grid-template-columns: 25% 55% 20%;
	grid-template-rows: 50% 50%;
	padding: 0%;
	height: 5%;
	--block-spacing-vertical: 0px;
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

main {
	height: 42rem;
}

.error {
	color: red;
	font-style: italic;
}

#workoutimg {
	width: 90%;
	height: auto;
}

#signupBtn {
	width: 250px;
	margin: 0 auto;
}
.alert {
	color: red;
	font-style: italic;
	font-size: 110%;
	text-align: center;
	padding-top: 4%;
}
</style>
</head>
<body>
<div class="myHeader">
		
		<form action="/" method="POST" name="morphHome"></form>
		<h1 id='headerLetter'>
		
			<input type="hidden" name="morphHome" value="/" >
			<a href="javascript:document.morphHome.submit()">
			<img src="/resources/Group_Logo.png" class="logo" alt="Morph Icon" />
			</a>
			MORPH
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
					<form action="/" method="POST" name="">
					<a href="javascript:document.@name.submit()">Workout Plans</a>
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
				<a href="" id="userAccount">${ loggedIn }, Log Out</a>
			</aside>
		</c:if>

	</div>
	<hr id="headerHr">
	
	<main class="container">
		<div class="grid">
			<div>
				<h1>Create a New Account</h1>
				<h4>Easier than workout!</h4>
				<img src="/resources/workoutimg.png" id="workoutimg">

			</div>

			<div>


				<!-- Grid -->
				<div class="flex">
					<form:form method="POST" action="/newUser" modelAttribute="newUser">

						<!-- Markup example 1: input is inside label -->
						<label for="username"> User name <input type="text"
							id="username" name="username" placeholder="User name" required>
						</label>
						<form:errors path="username" cssClass="error" />

						<label for="email">Email address<input type="email"
							id="email" name="email" placeholder="Email address" required>
						</label>
						<form:errors path="email" cssClass="error" />

						<label for="birthdate">Date of birth</label>
						<input type="date" id="birthdate" name="birthdate"
							placeholder="Date of Birth" required>
						<form:errors path="birthdate" cssClass="error" />

						<label for="password">Password</label>
						<input type="password" id="password" name="password"
							placeholder="Your password" required>
						<form:errors path="password" cssClass="error" />

						<label for="confirmPw">Confirm your password</label>
						<input type="password" id="confirmPw" name="confirmPw"
							placeholder="Confirm your password" required>
						<form:errors path="confirmPw" cssClass="error" />

						<input type="submit" value="Sign Up" id="signupBtn">
						
						<c:if test="${ wrong !=null }">
							<div class="alert alert-success" role="alert">${wrong}</div>
						</c:if>

					</form:form>
				</div>
			</div>
		</div>

	</main>
	
		<footer>
		<small>&copy; 2021 by Group Morph. All rights reserved.</small>
	</footer>
</body>
</html>