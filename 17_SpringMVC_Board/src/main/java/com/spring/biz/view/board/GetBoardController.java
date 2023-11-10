package com.spring.biz.view.board;

import java.io.IOException;

import javax.crypto.Mac;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">>> 게시글 상세 보여주기");
		//1. 전달받은 데이터 확인(추출) - 입력
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//2-1. DB연동작업(게시물 1개 조회) - 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);

		BoardDAO boardDAO = new BoardDAO(); //객체생성
		BoardVO board = boardDAO.getBoard(vo);
		
		//2-2. 검색결과를 세션에 저장(뷰에서 사용 가능하게)
		//request.getSession().setAttribute("board", board);
		//HttpSession session = request.getSession();
		//session.setAttribute("board", board); //리턴받은 데이터를 세션에 저장
		
		//3. 화면전환(상세페이지로 이동) - 아웃풋
		//response.sendRedirect("getBoard.jsp");
		
		//return "getBoard";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}

}
