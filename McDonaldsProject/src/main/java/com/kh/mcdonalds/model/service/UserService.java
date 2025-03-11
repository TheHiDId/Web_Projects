package com.kh.mcdonalds.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.kh.mcdonalds.model.dao.UserDAO;
import com.kh.mcdonalds.model.dto.UserDTO;

public class UserService {
	
	public List<UserDTO> selectAllUsers() {
		final String URL = "jdbc:oracle:thin:@112.221.156.34:12345:XE";
		final String USERNAME = "KH13_BJY";
		final String PASSWORD = "KH1234";
		
		Connection conn = null;
		
		List<UserDTO> list = null;
		
		UserDAO userDao = new UserDAO();
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			list =  userDao.selectAllUsers(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(conn != null && !conn.isClosed()) conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
