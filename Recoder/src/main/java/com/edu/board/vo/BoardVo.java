package com.edu.board.vo;

import java.util.Date;

public class BoardVo {

	private int boardNo;
	private String boardTitle;
	private String name;
	private String boardContent;
	private Date boardCreDate;
	private Date boardModDate;
	
	
	public BoardVo() {
		super();
	}


	public BoardVo(int boardNo, String boardTitle, String name, String boardContent, Date boardCreDate,
			Date boardModDate) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.name = name;
		this.boardContent = boardContent;
		this.boardCreDate = boardCreDate;
		this.boardModDate = boardModDate;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getBoardTitle() {
		return boardTitle;
	}


	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBoardContent() {
		return boardContent;
	}


	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}


	public Date getBoardCreDate() {
		return boardCreDate;
	}


	public void setBoardCreDate(Date boardCreDate) {
		this.boardCreDate = boardCreDate;
	}


	public Date getBoardModDate() {
		return boardModDate;
	}


	public void setBoardModDate(Date boardModDate) {
		this.boardModDate = boardModDate;
	}


}
