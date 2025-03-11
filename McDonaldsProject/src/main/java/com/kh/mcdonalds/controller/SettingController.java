package com.kh.mcdonalds.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mcdonalds.model.dto.Burger;

@WebServlet("/sc")
public class SettingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SettingController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doGet 요청 잘 오는지 확인");
		
		/* Servlet에서 응답데이터가 있는데? JSP에게 보내줘야함! -> request에 담아서
		 * 
		 * Servlet 내장 객체 / Scope 객체
		 * Application / Session / Request / Page
		 * 간단히 얘기해서 request처럼 데이터를 저장하기 위해 쓰이는 객체들
		 * 
		 * 1. ServletContext (Application Scope)
		 * 		하나의 애플리케이션 당, 딱 한 개 존재하는 객체
		 * 		이 영역에 데이터를 담으면 애플리케이션 전역에서 사용 가능
		 * 
		 * 2. HttpSession (Session Scope)
		 * 		하나의 브라우저 당, 하나 존재하는 객체
		 * 		이 영역에 데이터를 담으면 JSP / Servlet 단에서 사용 가능
		 * 		값이 한 번 담기면 브라우저가 닫히거나, 세션을 비우거나(로그아웃), 서버를 중지하기 전까지는 계속해서 사용 가능
		 * 
		 * 3. HttpServletRequest (Request Scope)
		 * 		요청 시 매번 생성되는 객체이긴 하나
		 * 		이 영역에 데이터를 담으면 request 객체를 포워딩 받는 응답 JSP에서만 사용 가능, 즉 1회용
		 * 
		 * 4. PageContext (Page Scope)
		 * 		JSP 페이지 내에서만 사용 가능
		 * 
		 * => 위 객체들에 값을 담을 때는 .setAttribute("키", "밸류")
		 * 															 .getAttribute("키")
		 * 															 .removeAttribute("키")
		 */
		
		// requestScope
		request.setAttribute("brand", "KFC");
		request.setAttribute("bestSeller", new Burger("KFC", "징거버거", 6200));
		
		// sessionScope
		HttpSession session = request.getSession();
		
		session.setAttribute("brand", "McDonald");
		session.setAttribute("bestSeller", new Burger("McDonald", "빅맥", 6800));
		
		// 숫자
		request.setAttribute("bigNumber", 10);
		request.setAttribute("smallNumber", 3);

		// 문자
		request.setAttribute("str", "집에 가고 싶다");
		
		// 리스트
		request.setAttribute("list", new ArrayList());
		
		// 응답 view 위임 -> 포워딩
		request.getRequestDispatcher("/WEB-INF/views/print.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
