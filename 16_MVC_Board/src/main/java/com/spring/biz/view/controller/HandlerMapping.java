package com.spring.biz.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.spring.biz.view.board.DeleteBoardController;
import com.spring.biz.view.board.GetBoardController;
import com.spring.biz.view.board.GetBoardListController;
import com.spring.biz.view.board.InsertBoardController;
import com.spring.biz.view.board.UpdateBoardController;
import com.spring.biz.view.user.LoginController;
import com.spring.biz.view.user.LogoutController;

// HandlerMapping : 요청정보와 처리할 컨트롤러를 연결하는 정보를 저장, 관리
public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController()); // login.do 요청이 들어오면 LoginController가 작업한다
		mappings.put("/logout.do", new LogoutController()); 
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
	}
	
	
	public Controller getController(String path) {
		
		
		return mappings.get(path); 
	}
}
