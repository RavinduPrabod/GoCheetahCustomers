<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="assets/Head.html"></jsp:include>
</head>
<body>
	<header id="header" class="header"> </header>
	<div class="content">
		<div class="animated fadeIn">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="row form-group">
							<div class="col col-md-11"></div>
							<div class="col col-md-1">
								<a type="submit" class="btn btn-outline-danger btn-lg"
									href="LoginServlet">Log out</a>
							</div>
						</div>
						<div class="card-header"
							style="background-color: yellow; font-weight: bold; font-style: italic; font-family: cursive;">
							GO<img alt="" src="assets/chee.png"> Online booking <img
								alt="" src="assets/taxib.png">Service..............................Booking
							your partner. <img alt="" src="assets/taxi.png"> <a
								type="submit" class="btn btn-outline-success btn-lg"
								href="BookingNowServlet?command=NOW">Booking Now here!</a>
						</div>
						<div class="card-body">
							<form action="BookingNowServlet" method="get"
								enctype="multipart/form-data" class="form-horizontal">
								<div class="row form-group">
									<div class="col col-md-9"></div>
									<div class="col col-md-3">
										<a type="submit" class="btn btn-outline-warning" 
										href="BookingNowServlet?command=PENDING">Pending</a>
										<a type="submit" class="btn btn-outline-info" 
										href="BookingNowServlet?command=SHOWLIST">Active</a>
										<a type="submit" class="btn btn-outline-success" 
										href="BookingNowServlet?command=COMPLETE">Complete</a>
									</div>
								</div>
								<div class="table-stats order-table ov-h">
									<table class="table ">
										<thead>
											<tr>
												<th>Booking ID</th>
												<th>Driver Name</th>
												<th>Contact No</th>
												<th>Destination</th>
												<th>Pickup Location</th>
												<th>Date</th>
												<th>Time</th>
												<th>Vehicle No</th>
												<th>Vehicle Type</th>
												<th>Status</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${Blist}" var="Blist">
												<tr>
													<td>${Blist.bookingID}</td>
													<td>${Blist.driverName}</td>
													<td>${Blist.contactNo}</td>
													<td>${Blist.streetName}</td>
													<td>${Blist.pickUpLocation}</td>
													<td>${Blist.pickUpdate}</td>
													<td>${Blist.pickUptime}</td>
													<td>${Blist.vehicleNo}</td>
													<td class="text-primary"><c:choose>
															<c:when test="${Blist.vehicleType == 1}">Tuk-tuk</c:when>
															<c:when test="${Blist.vehicleType == 2}">Car</c:when>
															<c:when test="${Blist.vehicleType == 3}">Van</c:when>
															<c:when test="${Blist.vehicleType == 4}">Lorry</c:when>
															<c:otherwise>None</c:otherwise>
														</c:choose></td>
													<td><c:choose>
															<c:when test="${Blist.status == 1}">
																<span class="badge badge-warning">Pending</span>
															</c:when>
															<c:when test="${Blist.status == 2}">
																<span class="badge badge-dark">Confirm</span>
															</c:when>
															<c:when test="${Blist.status == 3}">
																<span class="badge badge-info">OnWay</span>
															</c:when>
															<c:when test="${Blist.status == 4}">
																<span class="badge badge-primary">Pick</span>
															</c:when>
															<c:when test="${Blist.status == 5}">
																<span class="badge badge-green">Complete</span>
															</c:when>
															<c:otherwise></c:otherwise>
														</c:choose></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- .animated -->
	</div>
	<jsp:include page="assets/Scripts.html"></jsp:include>
	<!-- Scripts -->
	<script>
		
	</script>
</body>
</html>
