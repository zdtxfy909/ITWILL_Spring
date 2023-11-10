package com.spring.biz.view.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

import oracle.net.aso.r;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">>> 게시글 삭제");
		//1. 전달받은 데이터 추출
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//2. DB연동작업(수정)
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		
		//3. 페이지 전환(목록페이지로 이동)
		//response.sendRedirect("getBoardList.do");
		
		//return "getBoardList.do";
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.do");
		
		return mav;
	}

}
