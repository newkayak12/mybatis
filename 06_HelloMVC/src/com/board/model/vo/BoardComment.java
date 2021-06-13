package com.board.model.vo;

import java.util.*;

public class BoardComment {
	private int boardCommentNo, boardCommentLevel;
	private String boardCommentWriter, boardCommentContent;
	private int boardRef, boardCommentRef;
	private Date boardCommentDate;
	
	public BoardComment() {
		// TODO Auto-generated constructor stub
	}
	
	public int getBoardCommentNo() {
		return boardCommentNo;
	}
	public void setBoardCommentNo(int boardCommentNo) {
		this.boardCommentNo = boardCommentNo;
	}
	public int getBoardCommentLevel() {
		return boardCommentLevel;
	}
	public void setBoardCommentLevel(int boardCommentLevel) {
		this.boardCommentLevel = boardCommentLevel;
	}
	public String getBoardCommentWriter() {
		return boardCommentWriter;
	}
	public void setBoardCommentWriter(String boardCommentWriter) {
		this.boardCommentWriter = boardCommentWriter;
	}
	public String getBoardCommentContent() {
		return boardCommentContent;
	}
	public void setBoardCommentContent(String boardCommentContent) {
		this.boardCommentContent = boardCommentContent;
	}
	public int getBoardRef() {
		return boardRef;
	}
	public void setBoardRef(int boardRef) {
		this.boardRef = boardRef;
	}
	public int getBoardCommentRef() {
		return boardCommentRef;
	}
	public void setBoardCommentRef(int boardCommentRef) {
		this.boardCommentRef = boardCommentRef;
	}
	public Date getBoardCommentDate() {
		return boardCommentDate;
	}
	public void setBoardCommentDate(Date boardCommentDate) {
		this.boardCommentDate = boardCommentDate;
	}
	
	
	
}
