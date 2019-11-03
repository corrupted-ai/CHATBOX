<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Start</title>
<jsp:include page="common/head.jsp"></jsp:include>
<link rel="stylesheet" href="common/styling.css">
<link rel="stylesheet" href="common/lumen.css">
</head>
<meta charset="ISO-8859-1">
<title>Login/SignUp</title>
</head>
<body>

	<div class="container">
		<div style="text-align: center; margin-top: 20PX; font-weight: bold;">WELCOME
			TO CHATBOX</div>
		<c:if test="${notvalid}">
			<div style="text-align: center; margin-top: 20PX; color: red;">
				User doesnot exist Sign Up? Or Enter valid details.</div>
		</c:if>
		<c:if test="${loggedout}">
			<div style="text-align: center; margin-top: 20PX; color: green;">
				Successfully Logged out</div>
		</c:if>
		<c:if test="${exist}">
			<div style="text-align: center; margin-top: 20PX; color: blue">
				This email address already exists Login Instead.</div>
		</c:if>
		<div class="row" style="margin: 5%">
			<div class="col-md-4 offset-1 cardbox">
				<div
					style="text-align: center; font-weight: bold; color: green; font-size: 25px">Login</div>

				<form class="loginform" action="login" method="post"
					novalidate="novalidate">

					<div class="form-group">
						<label>Email address</label> <input type="email"
							class="form-control validate" name="loginemail"
							placeholder="Enter email">
					</div>

					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control validate" name="loginpassword"
							placeholder="Password">
					</div>
					<div align="center" style="padding-top: 30px">
						<button type="submit" class="btn btn-outline-success">Login</button>
					</div>
					<div style="text-align: center; margin-top: 20PX;">New User?
						Sign Up</div>
				</form>

			</div>


			<div class="col-md-4 offset-2 cardbox">

				<form class="signupform" action="signup" method="post"
					novalidate="novalidate">
					<div
						style="text-align: center; font-weight: bold; color: green; font-size: 25px">Sign
						Up</div>

					<div class="form-group">
						<label>Name</label> <input type="text"
							class="form-control validate" name="name"
							placeholder="Enter Full Name">
					</div>

					<div class="form-group">
						<label>Email Address</label> <input type="email"
							class="form-control validate" name="email"
							placeholder="Enter email">
					</div>

					<div class="form-group">
						<label>Phone Number</label> <input type="text"
							class="form-control validate" name="phone"
							placeholder="Enter phone number">
					</div>

					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control validate" name="password" id="idpassword"
							placeholder="Password">
					</div>

					<div class="form-group">
						<label>Confirm Password</label> <input type="password"
							class="form-control validate" name="confirmpassword"
							placeholder="Confirm Password">
					</div>

					<div align="center" style="padding-top: 30px">
						<button type="submit" class="btn btn-outline-success">Sign
							Up and Login</button>
					</div>
				</form>

			</div>

		</div>
	</div>
	<script src="common/validate.js"></script>
</body>
</html>