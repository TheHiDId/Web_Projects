package com.kh.mcdonalds.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mcdonalds.model.dto.UserDTO;
import com.kh.mcdonalds.model.service.UserService;

@WebServlet("/jstl")
public class JstlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public JstlController() {
  	super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int point = 500;
		request.setAttribute("point", point);
		
		String[] colors = {"red", "orangered", "orange", "yellow", "yellowgreen", "greenyellow", "green"};
		request.setAttribute("colors", colors);
		
		// TB_USER 로 가서 다 조회해오자
		UserService userService = new UserService();
		
		List<UserDTO> list = userService.selectAllUsers();
		
		request.setAttribute("userList", list);
		
		request.setAttribute("msg", "감칠맛");
		
		request.getRequestDispatcher("\\WEB-INF\\views\\jstl\\jstl.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
