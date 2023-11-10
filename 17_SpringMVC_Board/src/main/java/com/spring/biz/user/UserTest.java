package com.spring.biz.user;

import com.spring.biz.user.impl.UserDAO;

public class UserTest {

	public static void main(String[] args) {
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
//		vo.setName("관리자");
//		vo.setRole("Admin");
		
		UserDAO dao = new UserDAO();
		UserVO vo2 = dao.getUser(vo);
		System.out.println(vo2);
		
	}

}
