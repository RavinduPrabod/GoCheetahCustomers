package com.icbtassignment.gctcs.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.joda.time.DateTime;

import com.google.gson.Gson;
import com.icbtassignment.gct.utils.EntityValidator;
import com.icbtassignment.gctcs.entities.BookingDetails;
import com.icbtassignment.gctcs.entities.BookingListDto;
import com.icbtassignment.gctcs.entities.CityMaster;
import com.icbtassignment.gctcs.entities.StreetMaster;
import com.icbtassignment.gctcs.services.BookingNowService;

@WebServlet("/BookingNowServlet")
public class BookingNowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/gocheetha_application")
	private DataSource dataSource;

	public BookingNowServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String command = request.getParameter("command");
		if(command.equals("SHOWLIST"))
		{	
			mainList(request,response);		
		}
		if(command.equals("PENDING"))
		{	
			PENDINGList(request, response);		
		}
		if(command.equals("COMPLETE"))
		{	
			COMPLETEist(request, response);		
		}
		else if(command.equals("CHECKRATE") ) {
			getVehicleCharges(request,response);		
		}
		else if(command.equals("NOW") )
		{
			HttpSession session = request.getSession();
					
			String CustomerName =(String)session.getAttribute("CustomerName"); 
			String MobileNo =(String)session.getAttribute("MobileNo"); 	
			
			request.setAttribute("CustomerName", CustomerName);
			request.setAttribute("MobileNo", MobileNo);
			
			List<CityMaster> cityDrp = BookingNowService.getCityList(dataSource);
			request.setAttribute("cityDrp", cityDrp);
			List<StreetMaster> StreetList = BookingNowService.getStreetList(dataSource);
			request.setAttribute("streetDrp", StreetList);
			request.getRequestDispatcher("fromBookingNow.jsp").forward(request, response);	
			
			command = null;		
		}			
	}
 
	protected void getVehicleCharges(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
			int VehicleType = Integer.parseInt(request.getParameter("VehicleType"));
			BookingDetails Cost =  BookingNowService.get(dataSource,VehicleType);
			
			  Gson json = new Gson(); 
			  String vehicleList = json.toJson(Cost);
			  response.setContentType("application/json");
			  response.setCharacterEncoding("UTF-8");
			  response.getWriter().write(vehicleList);
			 
			
		}
	
	private void getStreetDrp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		 * String cityId =null; cityId = request.getParameter("cityId"); List<Street>
		 * streetDrp = StreetService.getStreetByCity(dataSource,cityId); Gson json = new
		 * Gson(); String countryList = json.toJson(streetDrp);
		 * response.setContentType("application/json");
		 * response.setCharacterEncoding("UTF-8");
		 * response.getWriter().write(countryList);
		 */
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		add(request, response);					
	}
	protected void mainList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String CustomerID =(String)session.getAttribute("CustomerID"); 
		
		List<BookingListDto> oMaster = BookingNowService.getList(dataSource, CustomerID);
		request.setAttribute("Blist", oMaster);
		request.getRequestDispatcher("/frmBookingList.jsp").forward(request, response);

	}
	protected void PENDINGList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String CustomerID =(String)session.getAttribute("CustomerID"); 
		
		List<BookingListDto> oMaster = BookingNowService.getPENDINGList(dataSource, CustomerID);
		request.setAttribute("Blist", oMaster);
		request.getRequestDispatcher("/frmBookingList.jsp").forward(request, response);

	}
	protected void COMPLETEist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String CustomerID =(String)session.getAttribute("CustomerID"); 
		
		List<BookingListDto> oMaster = BookingNowService.getCOMPLETEList(dataSource, CustomerID);
		request.setAttribute("Blist", oMaster);
		request.getRequestDispatcher("/frmBookingList.jsp").forward(request, response);

	}
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();	
		String CID =(String)session.getAttribute("CustomerID"); 
		
		String CustomerID = CID.toString();
		int CityID = Integer.parseInt(request.getParameter("CityID"));
		int StreetID = Integer.parseInt(request.getParameter("StreetID"));
		String PassengerName = request.getParameter("PassengerName").toString();
		String ContactNo = request.getParameter("ContactNo").toString();
		int VehicleType = Integer.parseInt(request.getParameter("VehicleType"));
		String PickUpLocation = request.getParameter("PickupLoc").toString();
		Date PickUpdate = Date.valueOf(request.getParameter("PickupDate"));
		String PickUptime = request.getParameter("PickupTime").toString();
		int Status = 1;
		DateTime CreateDatetime = null;
		DateTime ModifiedDateTime = null;
		
		BookingDetails oMaster = new BookingDetails(0,CustomerID,CityID,StreetID,PassengerName,ContactNo,VehicleType,PickUpLocation,PickUpdate,PickUptime,Status,CreateDatetime,ModifiedDateTime);
		
		EntityValidator<BookingDetails> validator = new EntityValidator<BookingDetails>();
		String errors = validator.validate(oMaster);

		if (!errors.isEmpty()) {
			request.setAttribute("BookList", oMaster);
			request.setAttribute("error", errors);
			request.getRequestDispatcher("BookingNow.jsp").forward(request, response);
		} else {
			BookingNowService.CreateBook(dataSource, oMaster);
			request.getRequestDispatcher("BookingNowServlet?command=SHOWLIST").forward(request, response);
		}
	}

	protected void getAmount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		JCheckBox j1 = new JCheckBox("cb1");
//		j1.isSelected()
//		{
//			
//		}
//		int id1= Integer.parseInt(request.getParameter("DriverID"));	
//		int id2= Integer.parseInt(request.getParameter("DriverID"));	
//		int vehicletype= Integer.parseInt(request.getParameter("DriverID"));	
//		DistanceList oDriverMaster = BookingNowService.get(dataSource,id1, id2, vehicletype);
//		
//		request.setAttribute("DriversList", oDriverMaster);
//		request.getRequestDispatcher("/DriverMasterUpdate.jsp").forward(request, response);

//		List<BranchMaster> oBranchMaster =  BranchMasterService.getList(dataSource);
//		request.setAttribute("BranchList", oBranchMaster);
//		request.getRequestDispatcher("/DriverMasterUpdate.jsp").forward(request, response);

	}

}
