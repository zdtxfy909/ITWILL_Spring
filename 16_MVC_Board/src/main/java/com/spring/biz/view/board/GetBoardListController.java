package com.spring.biz.view.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.view.controller.Controller;

public class GetBoardListController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">>> 게시글 전체 목록 보여주기");
		//1. 게시글 목록 조회(SELECT)
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList();
		
		//2. 검색 결과를 세션에 저장하고
		request.getSession().setAttribute("boardList", boardList); //request에서 session 얻기
		
		//3. 목록 화면으로 이동
		//response.sendRedirect("getBoardList.jsp");
		
		return "getBoardList"; //viewResolver 태울거니까 .jsp 붙이면 안됨
	}
	
}
