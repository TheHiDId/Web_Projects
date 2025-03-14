package com.kh.mfw.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberDAO {
	public MemberDTO signIn(SqlSession sqlSession, MemberDTO member) {
		return sqlSession.selectOne("memberMapper.signIn", member); // 조회 결과가 없으면 null 반환
	}
	
	public boolean checkId(SqlSession sqlSession, String memberId) {
		return (Integer)sqlSession.selectOne("memberMapper.checkId", memberId) > 0 ? true : false;
	}
	
	public boolean checkEmail(SqlSession sqlSession, String email) {
		return (Integer)sqlSession.selectOne("memberMapper.checkId", email) > 0 ? true : false;
	}
	
	public int signUp(SqlSession sqlSession, MemberDTO member) {
		return sqlSession.insert("memberMapper.signUp", member);
	}
}
