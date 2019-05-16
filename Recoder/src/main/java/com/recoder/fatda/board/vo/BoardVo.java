package com.recoder.fatda.board.vo;

import java.util.Date;

public class BoardVo {

   private int boardNo;
   private String boardTitle;
   private String name;
   private int memberNo;
   private String boardContent;
   private Date boardCreDate;
   private Date boardModDate;
   private int rowNum;
   private String updl;
   private int commentTotCount = 0;
   


public BoardVo() {
      super();
   }

  



   public BoardVo(int boardNo, String boardTitle, String name, int memberNo, String boardContent, Date boardCreDate,
		Date boardModDate, int rowNum, String updl, int commentTotCount) {
	super();
	this.boardNo = boardNo;
	this.boardTitle = boardTitle;
	this.name = name;
	this.memberNo = memberNo;
	this.boardContent = boardContent;
	this.boardCreDate = boardCreDate;
	this.boardModDate = boardModDate;
	this.rowNum = rowNum;
	this.updl = updl;
	this.commentTotCount = commentTotCount;
}





public int getMemberNo() {
      return memberNo;
   }

   public void setMemberNo(int memberNo) {
      this.memberNo = memberNo;
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
   
   public int getRowNum() {
      return rowNum;
   }
   
   
   public void setRowNum(int rowNum) {
      this.rowNum = rowNum;
      
   }
   public String getUpdl() {
	return updl;
}

   public void setUpdl(String updl) {
	this.updl = updl;
}


public int getCommentTotCount() {
	return commentTotCount;
}


public void setCommentTotCount(int commentTotCount) {
	this.commentTotCount = commentTotCount;
}
   
   
}