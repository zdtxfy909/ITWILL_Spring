package com.spring.biz.board;

import java.util.List;

import com.spring.biz.board.impl.BoardDAO;

public class BoardTest {

	public static void main(String[] args) {
		BoardVO vo = new BoardVO(); //>> BoardVO() 객체 생성
//		vo.setTitle("제목수정");
//		vo.setContent("내용수정테스트");
//		vo.setSeq(2);
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.getBoardList();

		for (BoardVO vo2 : list) {
			System.out.println(vo2);
		}
		
		//dao.updateBoard(vo);
		//dao.deleteBoard(vo);
				
		//BoardVO board = dao.getBoard(vo); //===> JDBC로 getBoard() 실행
		//System.out.println("board : " + board);
	}

}
