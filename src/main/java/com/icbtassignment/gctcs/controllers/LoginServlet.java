package com.icbtassignment.gctcs.controllers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.servlet.http.HttpSession;

import com.icbtassignment.gctcs.entities.CustomerMaster;
import com.icbtassignment.gctcs.services.LoginService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/gocheetha_application")
	private DataSource dataSource;
	
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("CustomerLogin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckCardential(request, response);
	}
	
	private void CheckCardential(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		try {
			HttpSession session = request.getSession();		
			String UserName = request.getParameter("UserName").toString();
			
			if(LoginService.checkAuthentication(dataSource,UserName)) {
				
				CustomerMaster UserList = LoginService.get(dataSource, UserName);
				session.setAttribute("CustomerID", UserList.getCustomerID());
				session.setAttribute("CustomerName", UserList.getFirstName() + " " +  UserList.getLastName());
				session.setAttribute("City", UserList.getCity());
				session.setAttribute("MobileNo", UserList.getMobileNo());
				session.setAttribute("Password", UserList.getPassword());
				response.sendRedirect("BookingNowServlet?command=SHOWLIST");
			}
			else {
				request.setAttribute("exceptionerror","User Credinatial incorrect");
				request.setAttribute("exceptionerrorshow", "");
				request.getRequestDispatcher("CustomerLogin.jsp").forward(request, response);
			}
			
			
		} catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("CustomerLogin.jsp").forward(request, response);
		}	
	}
}
