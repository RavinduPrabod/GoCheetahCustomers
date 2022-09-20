package com.icbtassignment.gctcs.controllers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.joda.time.DateTime;

import com.icbtassignment.gct.utils.EntityValidator;
import com.icbtassignment.gctcs.entities.CustomerMaster;
import com.icbtassignment.gctcs.services.CustomerMasterService;

/**
 * Servlet implementation class CustomerMasterServlet
 */
@WebServlet("/CustomerMasterServlet")
public class CustomerMasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	@Resource(name = "jdbc/gocheetha_application")
	private DataSource dataSource;
	
    public CustomerMasterServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/CustomerMasterAdd.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		add(request,response);
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String CustomerID = request.getParameter("CustomerID").toString();
		String FirstName = request.getParameter("FirstName").toString();
		String LastName = request.getParameter("LastName").toString();
		String City = request.getParameter("City").toString();
		String MobileNo = request.getParameter("MobileNo").toString();
		String Email = request.getParameter("Email").toString();
		String UserName = request.getParameter("UserName").toString();
		String Password = request.getParameter("Password").toString();
		DateTime CreateDatetime = null;
		DateTime ModifiedDateTime = null;
		CustomerMaster oMaster = new CustomerMaster(CustomerID,FirstName,LastName,City,MobileNo,Email,UserName,Password,CreateDatetime,ModifiedDateTime);

		EntityValidator<CustomerMaster> validator = new EntityValidator<CustomerMaster>();
		String errors = validator.validate(oMaster);

		if (!errors.isEmpty()) {
			request.setAttribute("error", errors);
			request.getRequestDispatcher("/CustomerMasterAdd.jsp").forward(request, response);
		} else {
			CustomerMasterService.AddNew(dataSource, oMaster);
			request.getRequestDispatcher("LoginServlet").forward(request, response);
		}

	}

}
