package com.recoder.fatda.board.vo;

import java.util.Date;

public class CommentVo {
	
	private int commentNo;
	private int boardNo;
	private int memberNo;
	private String memberName = "";
	private String comments =  "";
	private Date creDate;
	
	
	
	
	
	public CommentVo() {
		super();
	}


	public CommentVo(int commentNo, int boardNo, int memberNo, String memberName, String comments, Date creDate) {
		super();
		this.commentNo = commentNo;
		this.boardNo = boardNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.comments = comments;
		this.creDate = creDate;
	}


	public int getCommentNo() {
		return commentNo;
	}


	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public Date getCreDate() {
		return creDate;
	}


	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	
	
	
}











