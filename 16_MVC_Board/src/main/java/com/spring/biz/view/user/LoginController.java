package com.spring.biz.view.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;
import com.spring.biz.view.controller.Controller;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(">>> 로그인 처리");
		//1. 사용자가 전달한 데이터(정보) 확인(추출)
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		//2. DB연동작업 (id, password 유무 확인)
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);

		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);

		//3. 화면 네이게이션(화면전환, 화면이동)
		//로그인 성공 : 게시글 목록 보여주기
		//로그인 실패 : 로그인 화면으로 이동

		String returnStr = "";
		if (user != null) {
			System.out.println(">> 로그인 성공!!!");
			//response.sendRedirect("getBoardList.do"); 
			returnStr = "getBoardList.do";
		} else {
			System.out.println(">> 로그인 실패!!!");
			//response.sendRedirect("login.jsp");
			returnStr = "login"; 
			//.jsp 붙이면 DispatcherServlet에서 로그인 실패 처리하다가 login.jsp.jsp로 오류남
		}
		return returnStr;

	}

	
}
