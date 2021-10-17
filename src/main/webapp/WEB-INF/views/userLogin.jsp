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
<title>Sign In</title>
<style>
body {
	background-color: blanchedalmond;
}

main {
	height: 100vh;
}

.flex {
	padding-top: 5%;
}

.error {
	color: red;
	font-style: italics;
}

#loginBtn {
	width: 200px;
	margin: 0 auto;
}

#newBtn {
	width: 300px;
	margin: 0 auto;
}

hr {
	border-top: 5px dotted pink;
}

h5 {
	text-align: center;
}

h1 {
	margin-left: 5%;
}

h4 {
	margin-left: 5%;
}

#healthypeopleimg {
	width: 85%;
	height: auto;
}
</style>
</head>
<body>
	<main class="container">
		<div class="grid">
			<div>
				<h1>Log Into Morph</h1>
				<h4>Build a healthier lifestyle from today!</h4>
				<img src="/resources/healthypeople.png" id="healthypeopleimg">

			</div>

			<div>


				<!-- Grid -->
				<div class="flex">
					<form:form method="POST" action="/login" modelAttribute="userLogin">

						<label for="username"> User name <input type="text"
							id="username" name="username" placeholder="user name" required>
						</label>
						<form:errors path="username" cssClass="error" />

						<label for="email"> Password <input type="text" id="email"
							name="password" placeholder="password" required>
						</label>
						<form:errors path="password" cssClass="error" />

						<input type="submit" value="Log In" id="loginBtn">
						<c:if test="${ error !=null }">
							<div class="alert alert-success" role="alert">${error}</div>
						</c:if>
					</form:form>
					<hr>
					<form:form method="POST" action="/create"
						modelAttribute="newAccount">
						<h5>OR</h5>
						<input type="submit" value="Create New Account" id="newBtn">
					</form:form>


				</div>
			</div>
		</div>

	</main>
</body>
</html>