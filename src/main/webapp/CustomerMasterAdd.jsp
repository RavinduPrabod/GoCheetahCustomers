<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<jsp:include page="assets/Head.html"></jsp:include>
<title>Insert title here</title>
</head>
<body>
	<div class="card" style="width: align-self:;" align="left">
		<div class="card-body">
			<div class="row g-3">
				<div class="col-11">
					<h1 class="card-title">Customer Sign up</h1>
				</div>
				<div class="col-1">
					<a class="btn btn-outline-warning btn-lg" href="CustomerLogin.jsp">Back</a>
				</div>
			</div>
			<form class="row g-3" style="margin-left: 2in;"
				action="CustomerMasterServlet" method="post">
				<div class="col-md-4">
					<label for="inputNIC" class="form-label">NIC</label> <input
						type="text" name="CustomerID" class="form-control"
						aria-label="NIC">
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<label for="inputFirstname" class="form-label">First Name</label> <input
						type="text" name="FirstName" class="form-control"
						aria-label="First name">
				</div>
				<div class="col-md-4">
					<label for="inputLastname" class="form-label">Last Name</label> <input
						type="text" name="LastName" class="form-control"
						aria-label="Last name">
				</div>
				<div class="col-12"></div>
				<div class="col-3">
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">Mobile</div>
							<input type="text" name="MobileNo" maxlength="10"
								class="form-control">
							<div class="input-group-addon">
								<i class="fa fa-phone"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="input-group">
						<div class="input-group-addon">City</div>
						<input type="text" name="City" class="form-control">
						<div class="input-group-addon">
							<i class="fa fa-building"></i>
						</div>
					</div>
				</div>
				<div class="col-12"></div>
				<div class="col-4">
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">Email</div>
							<input type="email" name="Email" class="form-control">
							<div class="input-group-addon">
								<i class="fa fa-envelope"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="col-12"></div>
				<div class="col-4">
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">Username</div>
							<input type="text" name="UserName" class="form-control">
							<div class="input-group-addon">
								<i class="fa fa-user"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="col-8"></div>
				<div class="col-4">
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">Password</div>
							<input type="password" name="Password" class="form-control">
							<div class="input-group-addon">
								<i class="fa fa-asterisk"></i>
							</div>
						</div>
					</div>
				</div>
				<div class="col-8"></div>
				<div class="col-12">
					<button type="submit" class="btn btn-primary btn-lg">SignIn</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>