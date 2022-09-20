package com.icbtassignment.gctcs.services;

import java.util.List;

import javax.sql.DataSource;

import com.icbtassignment.gctcs.dao.BookingNowDao;
import com.icbtassignment.gctcs.entities.BookingDetails;
import com.icbtassignment.gctcs.entities.BookingListDto;
import com.icbtassignment.gctcs.entities.CityMaster;
import com.icbtassignment.gctcs.entities.StreetMaster;


public class BookingNowService {
	
	public static List<BookingListDto> getList(DataSource dataSource, String CustomerID){	
		return BookingNowDao.getList(dataSource, CustomerID);
	}
	public static List<BookingListDto> getPENDINGList(DataSource dataSource, String CustomerID){	
		return BookingNowDao.getPENDINGList(dataSource, CustomerID);
	}
	public static List<BookingListDto> getCOMPLETEList(DataSource dataSource, String CustomerID){	
		return BookingNowDao.getCOMPLETEList(dataSource, CustomerID);
	}
	public static List<CityMaster> getCityList(DataSource dataSource){	
		return BookingNowDao.getCityList(dataSource);
	}
	
	public static List<StreetMaster> getStreetList(DataSource dataSource){	
		return BookingNowDao.getStreetList(dataSource);
	}
	
	public static float getTravelCost(DataSource dataSource,int VehicleType){	
		return BookingNowDao.getTravelCost(dataSource,VehicleType);
	}
	
	public static BookingDetails get(DataSource dataSource,int VehicleType){	
		return BookingNowDao.getVehicleList(dataSource,VehicleType);
	}
	
	public static String getRate(DataSource dataSource,int VehicleType){	
		return BookingNowDao.getRate(dataSource,VehicleType);
	}
	
	public static void CreateBook(DataSource dataSource, BookingDetails oMaster) {
		BookingNowDao.CreateBook(dataSource,oMaster);	
	}
}
