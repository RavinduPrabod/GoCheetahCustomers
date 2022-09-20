<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/logins.css" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<jsp:include page="assets/Head.html"></jsp:include>
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<div class="fadeIn first">
				<img src="assets/logo1.png" id="icon" alt="User Icon" />
			</div>
			<!-- Login Form -->
			<form action="LoginServlet" method="post">
				<input type="text" class="fadeIn second" name="UserName" placeholder="UserName" value=""> 
				<input type="text" class="fadeIn third" name="password" placeholder="Password" value="">
				<input type="submit" class="fadeIn fourth" value="LogIn">
				<div class="mt-2 alert alert-danger ${exceptionerrorshow}" id="divShowError" >
                    <span id="showerrormsg" class="text-danger">${exceptionerror}</span>
                	</div>
			</form>
			<div id="formFooter">
				<a class="underlineHover" href="CustomerMasterServlet">SignIn</a>
			</div>
		</div>
	</div>
<script>
	$(document).ready(function () {	
		show_Error();	
	});
	function show_Error() {
		var showerror = $("#showerrormsg").text();
		if(showerror ==""){
			$("#divShowError").hide();
		}		
	}
</script>
</body>
</html>