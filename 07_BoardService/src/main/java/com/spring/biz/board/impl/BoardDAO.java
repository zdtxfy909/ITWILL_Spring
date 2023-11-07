package com.spring.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spring.biz.board.BoardVO;
import com.spring.biz.common.JDBCUtil;

public class BoardDAO {
	//JDBC 관련 변수(필드)
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//SQL 문장
	private final String BOARD_INSERT
		= "INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT)" 
		+ "VALUES ((SELECT NVL(MAX(SEQ),0) + 1 FROM BOARD), ?, ?, ?)";
	
	private final String BOARD_UPDATE
		= "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ?";
	
	private final String BOARD_DELETE 
		= "DELETE FROM BOARD WHERE SEQ = ?";
	
	private final String BOARD_GET 
		= "SELECT * FROM BOARD WHERE SEQ = ?";
	
	private final String BOARD_LIST
		= "SELECT * FROM BOARD ORDER BY SEQ DESC";
	
 	public BoardDAO() {
		System.out.println(">> BoardDAO() 객체 생성");
	}
	
	//글입력
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 실행");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setNString(1, vo.getTitle());
			stmt.setNString(2, vo.getWriter());
			stmt.setNString(3, vo.getContent());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
	}
	
	//글수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 실행");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
		
	}
	
	//글삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 실행");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt);
		}
		
		
	}
	
	//글 하나 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 실행");
		BoardVO board = null;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		
		return board;
	}
	
	//글 목록 조회
	public List<BoardVO> getBoardList() {
		System.out.println("===> JDBC로 getBoardList() 실행");
		List<BoardVO> list = new ArrayList<>();
		BoardVO board = null;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return list;
	}
}
