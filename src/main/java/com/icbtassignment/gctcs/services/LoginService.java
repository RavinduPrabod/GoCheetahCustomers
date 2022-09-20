package com.icbtassignment.gctcs.services;

import javax.sql.DataSource;

import com.icbtassignment.gctcs.dao.LoginDao;
import com.icbtassignment.gctcs.entities.CustomerMaster;

public class LoginService {
	
	public static CustomerMaster get(DataSource dataSource,String UserName){	
		return LoginDao.get(dataSource,UserName);
	}
	
	public static Boolean checkAuthentication(DataSource dataSource,String UserName){	
		return LoginDao.checkAuthentication(dataSource,UserName);
	}

}
