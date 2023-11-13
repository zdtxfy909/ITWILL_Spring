package com.spring.biz.view.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

@Controller
public class UserController {
	/* @RequestMapping
	@RequestMapping : 요청과 처리(Controller) 연결(HandlerMapping 역할 대체)
	Command 객체 사용 : 파라미터로 전달되는 값을 Command 객체에 설정
	
	*스프링 프레임워크에서 하는 일
	1. UserVO 타입 객체 생성
	2. UserVO 타입 객체에 전달받은 파라미터 값을 설정 (이름이 일치하는 경우 - 파라미터값과 속성이 일치하는 경우)
	3. UserVO 타입 객체를 메소드에 파라미터 값으로 전달
	*/
	
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO)
			throws ServletException, IOException {
		System.out.println(">>> 로그인 처리");
		System.out.println("vo : " + vo);

		UserVO user = userDAO.getUser(vo);
		System.out.println("user : " + user);

		if (user != null) {
			System.out.println(">> 로그인 성공!!!");
			return "getBoardList.do";
		} else {
			System.out.println(">> 로그인 실패!!!");
			return "login.jsp";
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println(">>> 로그아웃 처리");
		session.invalidate(); //스프링에게 전달받은 세션 무효화시키기
		
		return "login.jsp";
	}
	
	
}
