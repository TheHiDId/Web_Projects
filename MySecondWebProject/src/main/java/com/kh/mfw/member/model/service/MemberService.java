package com.kh.mfw.member.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.mfw.common.Tamplate.getSqlSession;

import com.kh.mfw.member.model.dao.MemberDAO;
import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberService {

	public MemberDTO signIn(MemberDTO member) {
		SqlSession sqlSession = getSqlSession();
		
		MemberDTO signInMember = new MemberDAO().signIn(sqlSession, member);
		
		sqlSession.close();
		
		return signInMember;
	}
	
	public int signUp(MemberDTO member) {
		SqlSession sqlSession = getSqlSession();
		
		if(new MemberDAO().checkId(sqlSession, member.getMemberId())) {
			sqlSession.close();
			
			return 0;
		}
		
		if(new MemberDAO().checkEmail(sqlSession, member.getEmail())) {
			sqlSession.close();
			
			return 0;
		}
		
		int result = new MemberDAO().signUp(sqlSession, member);
		
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
}
