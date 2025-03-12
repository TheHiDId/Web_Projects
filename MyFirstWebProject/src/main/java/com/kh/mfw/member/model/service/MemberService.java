package com.kh.mfw.member.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.kh.mfw.member.model.dao.MemberDAO;
import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberService {
	final String URL = "jdbc:oracle:thin:@112.221.156.34:12345:XE";
	final String USERNAME = "KH13_BJY";
	final String PASSWORD = "KH1234";
	
	MemberDAO memberDao = new MemberDAO();
	
	public MemberDTO signIn(MemberDTO member) {
		MemberDTO signInMember = null;
		
		try {
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			signInMember = memberDao.signIn(conn, member);
			
			if(conn != null && !conn.isClosed()) conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return signInMember;
	}
}
