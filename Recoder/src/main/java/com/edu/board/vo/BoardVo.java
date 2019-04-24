package com.edu.board.vo;

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
   
   


public BoardVo() {
      super();
   }

   public BoardVo(String boardTitle, int memberNo,   String boardContent) {
      super();
      this.boardTitle = boardTitle;
      this.memberNo = memberNo;
      this.boardContent = boardContent;
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

}