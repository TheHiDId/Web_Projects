package com.kh.burgerking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자가 입력한 수량의 500배 작업
		// Controller: 데이터를 받아 가공해서 Service로 넘겨주는 역할 / 응답받은 데이터를 가공해서 View로 넘겨주는 역할
		
		/* 두 개의 매개변수가 존재함 (객체의 주소 값)
		 * 
		 * HttpServletRequest => 요청 시 전달된 내용들이 담김
		 * 	- 요청 전송방식(Get), 사용자의 IP 주소, 어떤 URL을 통해 왔는지, 사용자가 입력한 값 등
		 * 
		 * HttpServletResponse => 요청 처리 후, 서버에서 응답하는 내용들이 담김
		 */
		
//		String queryString = request.getQueryString();
//		System.out.println(queryString);
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		System.out.println(num);
		
		String pName = request.getParameter("pName");
		
		System.out.println(pName);
		
		/* 자주보이는 문제 상황
		 * 
		 * 404
		 * 파일이나 요청을 받아주는 서블릿을 찾지 못했을 때 발생
		 * 대부분의 경우, 단순 오타일 확률이 높음
		 * 
		 * 500
		 * 자바 소스코드 상의 오류, 즉 예외발생의 경우
		 */
		
		// DB까지 잘 갔다왔다고 치고 진행 (Insert문의 경우)
		
		/* 요청 처리(Service의 메서드를 호출해서 DB와의 상호작용이 끝난 상태)
		 */
		
		int totalPrice = num * 500;
		
		/* X(상품명)의 총 가격은 Y(총 금액)원 입니다.
		 */
		
		// 1단계 >> 응답데이터 형식 지정 -> 문서(HTML) / 인코딩(UTF-8)
		response.setContentType("text/html;charset=UTF-8");
		
		// 2단계 >> 출력 스트림 생성
		PrintWriter writer = response.getWriter();
		
		// 3단계 >> 스트림을 통해 HTML 출력
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>GET 방식 응답</title>");		
		writer.println("</head>");
		writer.println("<script>");
		writer.println("alert('배고파!!')");
		writer.println("</script>");
		writer.printf("%s의 총 가격은 %d원 입니다", pName, totalPrice);
		writer.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/bk/order doPost 메서드 호출!");
	}
	
}
