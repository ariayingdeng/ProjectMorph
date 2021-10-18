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

main {
	height: 40rem;
}

.error {
	color: red;
	font-style: italics;
}

#workoutimg {
	width: 90%;
	height: auto;
}

#signupBtn {
	width: 250px;
	margin: 0 auto;
}
</style>
</head>
<body>
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
					<form:form method="POST" action="/newUser"
						modelAttribute="newUser">

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
						<form:errors path="birthdate" cssClass="error" />

						<label for="pw">Confirm your password</label>
						<input type="password" id="pw" name="pw"
							placeholder="Confirm your password" required>
						<form:errors path="birthdate" cssClass="error" />

						<input type="submit" value="Sign Up" id="signupBtn">

					</form:form>
				</div>
			</div>
		</div>

	</main>
</body>
</html>