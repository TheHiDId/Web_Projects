package com.kh.burgerking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.burgerking.model.dto.UserDTO;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/sign-up.do")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post에서 Get도 호출하는지 확인");
		
		/* Controller의 역할
		 * 
		 * 1. request 객체로부터 값을 뽑아서 DTO로 가공
		 * 2. 요청 처리 -> 이건 일단 패스
		 * 3. View 처리
		 */
		
		// Post 방식일 경우 인코딩 설정이 ISO-8859-1 으로 바뀌기 때문에 값을 추출하기 전에 UTF-8 로 변경해줘야 함
		request.setCharacterEncoding("UTF-8");
		
		// 1) 값 뽑아담기
		// request.getParameter("input 태그의 name 속성값");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		
		System.out.println(userId);
		System.out.println(userPw);
		System.out.println(userName);
		
		UserDTO user = new UserDTO(userId, userPw, userName);
		
		// int result =  service.insertUser(user);
		
		// 2) View 처리
		// JSP 이용해서 응답데이터 만들기
		// JSP: Java 기반의 서버 사이드 스크립트 언어
		
		// 응답화면(JSP)에서 필요할 데이터를 넘겨줄 것 -> request에 담아서
		// 속성 >> 키 : 밸류 세트로 묶어서 값을 담을 수 있음
		request.setAttribute("user", user);
		request.setAttribute("message", "요청 처리에 성공했습니다!");
		
		// 응답페이지를 JSP에게 위임(배정)
		
		// RequestDispatcher
		RequestDispatcher view = request.getRequestDispatcher("/views/response_page.jsp");
		
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("진짜로 호출되는지 확인");
		
		doGet(request, response);
	}

}
