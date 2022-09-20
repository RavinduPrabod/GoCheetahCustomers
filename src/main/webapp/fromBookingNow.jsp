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
						<div class="card-header"
							style="background-color: yellow; font-weight: bold; font-style: italic; font-family: cursive;">
							GO<img alt="" src="assets/chee.png"> Online booking <img
								alt="" src="assets/taxib.png">Service..............................Booking
							your partner. <img alt="" src="assets/taxi.png"> <a
								type="submit" class="btn btn-outline-success btn-lg"
								href="BookingNowServlet?command=SHOWLIST">Back</a>
						</div>
						<div class="card-body">
							<form action="BookingNowServlet" method="get"
								class="form-horizontal" id="frmBooking">
								<div class="row form-group">
									<div class="col col-md-2">
										<label class=" form-control-label"></label>
									</div>
									<div class="col col-md-4">
										<label class=" form-control-label">Passenger Name</label>
									</div>
									<div class="col col-md-1">
										<label class=" form-control-label"></label>
									</div>
									<div class="col col-md-4">
										<label class=" form-control-label">Mobile No</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-2">
										<label class=" form-control-label"></label>
									</div>
									<div class="col col-md-4">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-male"></i>
											</div>
											<input class="form-control" type="text" name="PassengerName"
												value="${CustomerName}">
										</div>
									</div>
									<div class="col col-md-1">
										<label for="text-input" class="form-control-label"
											style="text-align: right;"></label>
									</div>
									<div class="col col-md-4">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-phone"></i>
											</div>
											<input class="form-control" type="text" name="ContactNo"
												value="${MobileNo}">
										</div>
									</div>
								</div>
								<div class="row form-group"></div>
								<div class="row form-group">
									<div class="col col-md-2">
										<label class=" form-control-label"></label>
									</div>
									<div class="col col-md-4">
										<label class=" form-control-label">City (from)</label>
									</div>
									<div class="col col-md-1">
										<label class=" form-control-label"></label>
									</div>
									<div class="col col-md-4">
										<label class=" form-control-label">Street (To)</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-2">
										<label class=" form-control-label"></label>
									</div>
									<div class="col col-md-4">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-building"></i>
											</div>
											<select name="CityID" id="drpCity" required="required"
												class="form-control">
												<c:forEach items="${cityDrp}" var="city">
													<option value="${city.cityID}">${city.cityName}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col col-md-1">
										<label for="text-input" class=" form-control-label"
											style="text-align: right;"></label>
									</div>
									<div class="col col-md-4">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-road"></i>
											</div>
											<select name="StreetID" id="drpStreet" required="required"
												class="form-control">
												
													<option>Select Vehicle</option>
											
											</select>
										</div>
									</div>
								</div>
								<div class="row form-group"></div>
								<div class="row form-group"></div>
								<div class="row form-group">
									<div class="col col-md-2"></div>
									<div class="col col-md-8">
										<label class=" form-control-label">Vehicle Type</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-2"></div>
									<div class="col col-md-4">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-car"></i>
											</div>
											<select class="form-control-lg form-control"
												id="txtVehicleType" style="background-color: silver;"
												name="VehicleType">
												<option value="1">Tuk-tuk</option>
												<option value="2">Car</option>
												<option value="3">Van</option>
												<option value="4">Lorry (Max weight 2000KG)</option>
											</select>
										</div>
										<small>choose vehicle type</small>
									</div>
									<div class="col col-md-1 ">
										<a  href="javascript:void(0);" class="btn btn-primary d-none" onclick="getVehicleCharges();"> <i
											class="fa fa-rate"></i>&nbsp; Check rate
										</a>
									</div>
									<div class="col-lg-2 col-md-4">
										<label>Km per charges:</label> <label id="lblCost">0</label>/-LKR
										<input class="form-control" id="txtCost" type="hidden" name="Cost"
											value="${Cost}" disabled="disabled">
									</div>
								</div>
								<div class="row form-group"></div>
								<div class="row form-group"></div>
								<div id="showPickup">
								<div class="row form-group">
									<div class="col col-md-4">
										<label class=" form-control-label">Pick Location</label>
									</div>
									<div class="col col-md-4">
										<label class=" form-control-label">Pick Date</label>
									</div>
									<div class="col col-md-4">
										<label class=" form-control-label">Pick Time</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-4">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-map"></i>
											</div>
											<input class="form-control" type="text" name="PickupLoc">
										</div>
									</div>
									<div class="col col-md-4">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-calendar"></i>
											</div>
											<input class="form-control" type="date" name="PickupDate">
										</div>
									</div>
									<div class="col col-md-4">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-flash"></i>
											</div>
											<input class="form-control" type="time" name="PickupTime">
										</div>
									</div>
								</div>
								<div class="row form-group"></div>
								<div class="row form-group">
									<div class="col col-md-4">
										<button  class="btn btn-primary" onclick="formSubmit();" name="btnSubmit">
											<i class="fa fa-rss"></i>&nbsp; Book Now
										</button>
									</div>
								</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="assets/Scripts.html"></jsp:include>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#btnSubmit').prop('disabled', true)
			$('#PickupLoc').hide();
			$('#PickupTime').hide();
			$('#PickupDate').hide();
			$('#showPickup').hide();
		});

		 $("#txtVehicleType").change(function(event) {
			getVehicleCharges();
		}); 	
		
		function formSubmit(){
			$('#frmBooking').submit();
		}
		function getVehicleCharges() {
			$('#showPickup').hide();
			var VehicleType = $("#txtVehicleType").val();
			
			$.ajax({
	            url: "BookingNowServlet",
	            method: "GET",
	            data: {command: 'CHECKRATE',VehicleType: VehicleType},
	            success: function (result) {
	            	
	            	$("#txtCost").val(result.AmountperKM);
	            	$("#lblCost").html(result.AmountperKM);	
	            	$('#showPickup').show();
	                
	            },
	            error: function (result) {
	           	 console.log(result);
	            },
	            cache: false
	        });

		}
		
		
		 $("#drpCity").change(function(event) {
			 getStreet();
			});
		
		function getStreet(){
			var cityId= $("#drpCity").val();
				$.ajax({
		            url: "BookingControllerServlet",
		            method: "GET",
		            data: {command: 'GETSTREET',cityId: cityId},
		            success: function (result) {
		                console.log(result);
		                console.log(result);
		             
		                $.each(result, function (key, value) {
		                	
		                    $('#drpStreet').append('<option value="' + value.street_Id + '">' + value.street_Name + '</option>')
		                    
		                });
		                
		                
		            },
		            error: function (result) {
		           	 console.log(result);
		            },
		            cache: false
		        });
				bookingbtn();
			}
		
		
		
		
	</script>
</body>
</html>
