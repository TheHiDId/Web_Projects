package com.kh.mcdonalds.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.mcdonalds.model.dto.UserDTO;

public class UserDAO {
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<UserDTO> selectAllUsers(Connection conn) {
		
		String sql = """
				SELECT
					USER_NO,
					USER_ID,
					USER_PW,
					USER_NAME,
					ENROLL_DATE
				FROM
					TB_USER
				""";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UserDTO user = new UserDTO();
				
				user.setUserNo(rset.getInt("USER_NO"));
				user.setUserId(rset.getString("USER_ID"));
				user.setUserPw(rset.getString("USER_PW"));
				user.setUserName(rset.getString("USER_NAME"));
				user.setEnrollDate(rset.getDate("ENROLL_DATE"));
				
				list.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rset != null && !rset.isClosed()) rset.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(pstmt != null && !pstmt.isClosed()) pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return list;
	}
}
