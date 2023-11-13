package com.spring.biz.view.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

@Controller
public class UserController {
	
	//POST 방식에 대한 login.do
	//@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	@PostMapping("/login.do") //4.3 버전부터 사용가능
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
	
	/* @ModelAttribute : 모델(Model)의 속성값으로 저장(속성명 별도 지정)
	 * 별도 명칭 부여 안하면 <데이터타입>의 첫글자 소문자로 작성된 명칭 사용
	 * @ModelAttribute UserVO ----> 속성명 userVO 명칭 사용
	 * @ModelAttribute("user") UserVO ----> 속성명 user 사용
	 */
	
	//GET 방식에 대한 login.do
	//@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	@GetMapping("/login.do")
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println(">>> 로그인 화면 이동 - loginView()");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println(">>> 로그아웃 처리");
		session.invalidate(); //스프링에게 전달받은 세션 무효화시키기
		
		return "login.jsp";
	}
	
	
}
