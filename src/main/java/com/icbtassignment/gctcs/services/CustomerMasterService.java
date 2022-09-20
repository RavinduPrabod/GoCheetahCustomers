package com.icbtassignment.gctcs.services;

import javax.sql.DataSource;

import com.icbtassignment.gctcs.dao.CustomerMasterDao;
import com.icbtassignment.gctcs.entities.CustomerMaster;

public class CustomerMasterService {
	
	public static void AddNew(DataSource dataSource, CustomerMaster oMaster) {
		CustomerMasterDao.AddNew(dataSource,oMaster);	
	}
}
