package com.spring.biz.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController {
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 입력");
		System.out.println("vo : "  + vo);
		//1. 전달받은 데이터 추출(확인)
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
		//2. DB연동작업(입력)
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
////=> vo에 있으니까 할 필요 없음			
		
		boardDAO.insertBoard(vo);
		
 		return "getBoardList.do";
	}

}
