package com.spring.biz.view.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller; //스프링에서 제공하는 Controller

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
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
		ModelAndView mav = new ModelAndView();
		
		if (user != null) {
			System.out.println(">> 로그인 성공!!!");
			//response.sendRedirect("getBoardList.do"); 
			//returnStr = "getBoardList.do";
			mav.setViewName("redirect:getBoardList.do");
		} else {
			System.out.println(">> 로그인 실패!!!");
			//response.sendRedirect("login.jsp");
			//returnStr = "login";
			mav.setViewName("redirect:login.jsp"); // viewResolver 적용안함(재요청처리) 
		}
		return mav;

	}

	
}
