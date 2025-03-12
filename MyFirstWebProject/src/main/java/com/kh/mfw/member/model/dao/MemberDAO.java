package com.kh.mfw.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberDAO {

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
			System.err.println("OJDBC 라이브러리가 존재하지 않습니다.");
		}
	}

	public MemberDTO signIn(Connection conn, MemberDTO member) {
		
		String sql = """
				SELECT
					MEMBER_ID,
					MEMBER_PW,
					MEMBER_NAME,
					EMAIL,
					ENROLL_DATE
				FROM
					KH_MEMBER
				WHERE
					MEMBER_ID = ?
				AND
					MEMBER_PW = ?
				""";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		MemberDTO signInMember = new MemberDTO();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				signInMember.setMemberId(rset.getString("MEMBER_ID"));
				signInMember.setMemberPw(rset.getString("MEMBER_PW"));
				signInMember.setMemberName(rset.getString("MEMBER_NAME"));
				signInMember.setEmail(rset.getString("EMAIL"));
				signInMember.setEnrollDate(rset.getDate("ENROLL_DATE"));
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
		
		return signInMember;
	}
}
