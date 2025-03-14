package com.kh.mfw.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mfw.member.model.dto.MemberDTO;
import com.kh.mfw.member.model.service.MemberService;

@WebServlet("/sic")
public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public SignInController() {
  	super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		MemberDTO member = new MemberDTO();
		
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPw(request.getParameter("memberPw"));
	
		MemberDTO signInMember = new MemberService().signIn(member);
		
		/* 로그인에 성공했다면 로그인한 회원의 정보를 
		 * 로그아웃 요청이 들어오거나 브라우저를 종료하기 전까지는
		 * 계속 사용할 수 있어야 하기 때문에 HttpSession이라는 저장소에 값을 담아둘 것
		 */
		request.getSession().setAttribute("signInMember", signInMember);
		
		response.sendRedirect(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
