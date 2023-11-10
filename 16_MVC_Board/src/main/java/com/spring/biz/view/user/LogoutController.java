package com.spring.biz.view.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.view.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">>> 로그아웃 처리");
		//1. 세션 초기화(세션 객체 무효화)
		request.getSession().invalidate();
		
		//2. 화면 네비게이션(화면이동)
		//response.sendRedirect("login.jsp");
		
		return "login";
	}

}
