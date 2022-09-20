<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header id="header" class="header"> </header>
	<div class="content">
		<div class="animated fadeIn">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header"
							style="background-color: yellow; font-weight: bold; font-style: italic; font-family: cursive;">
						</div>
						<div class="card-body">
							<form action="BookingNowServlet" method="get">
								<div class="mb-3">
									<label for="exampleFormControlInput1" class="form-label">Email
										address</label> <input type="email" class="form-control"
										id="exampleFormControlInput1" placeholder="name@example.com">
								</div>
								<div class="mb-3">
									<label for="exampleFormControlTextarea1" class="form-label">Example
										textarea</label>
									<textarea class="form-control" id="exampleFormControlTextarea1"
										rows="3"></textarea>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>
