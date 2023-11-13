package com.spring.biz.board;

import java.util.List;

//결합도 낮추기 위해 인터페이스 사용
public interface BoardService { 
	//CRUD 기능 구현 메소드 정의
	void insertBoard(BoardVO vo);
	void updateBoard(BoardVO vo);
	void deleteBoard(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	List<BoardVO> getBoardList();
	
}
