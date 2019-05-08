package com.edu.util;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Paging implements Serializable{


   // 페이지당 게시물수
   public static final int PAGE_SCALE = 10;
   // 화면당 페이지 수
   public static final int BLOCK_SCALE = 10;
   
   private int curPage;  // 현재 페이지
   private int prevPage; // 이전 페이지
   private int nextPage; // 다음 페이지
   private int totPage; // 전체 페이지
   private int totBlock; // 전체 페이지 블록 갯수
   private int curBlock;
   private int prevBlock;
   private int nextBlock;
   
   private int pageBegin;   // db 들고올 실제 게시물 위치 시작
   private int pageEnd;     // db 들고올 실제 게시물 위치 끝
   
   private int blockBegin;  // 블록의 시작번호
   private int blockEnd;    // 블록의 끝번호
   
   // 생성자
   public Paging(int count, int curPage) {
      this.curBlock = 1;
      this.curPage = curPage;
      setTotPage(count);
      setPageRange();
      setTotBlock();
      setBlockRange();
   }
   
   public void setPageRange(){
      pageBegin = (curPage - 1) * PAGE_SCALE + 1;
      pageEnd = pageBegin + PAGE_SCALE - 1;
   }
   
   public void setBlockRange(){
      curBlock = (int)Math.ceil((curPage - 1) / BLOCK_SCALE) + 1; //block begin/end를 이용하기 위한 임시의 수?
      //예시 화면으로 출력해서 이해하는게 빠름. 1: 1, 2~10: 2, 11~20: 3, 21~30:4, ...
      //수 묶어주기
      
      blockBegin = (curBlock - 1) * BLOCK_SCALE + 1;
      //1: 1, 2: 11, 3: 21, 4: 31, ...
   
      blockEnd = blockBegin + BLOCK_SCALE - 1;
      //1: 10, 11: 20, 21: 30, ...
      if(blockEnd > totPage) {
         blockEnd = totPage;
      }
      
      prevPage = (curPage == 1) ? 1 : (curBlock - 1) * BLOCK_SCALE;
      nextPage = curBlock > totBlock ? (curBlock * BLOCK_SCALE) 
            : (curBlock * BLOCK_SCALE) + 1;
      
      // 첫 페이지가 범위를 초과하지 않도록 처리
      if(prevPage <= 0) {
         prevPage = 1;
      }
      
      if(nextPage >= totPage) {
         nextPage = totPage;
      }
   }
   
   public int getCurPage() {
      return curPage;
   }
   public void setCurPage(int curPage) {
      this.curPage = curPage;
   }
   public int getPrevPage() {
      return prevPage;
   }
   public void setPrevPage(int prevPage) {
      this.prevPage = prevPage;
   }
   public int getNextPage() {
      return nextPage;
   }
   public void setNextPage(int nextPage) {
      this.nextPage = nextPage;
   }
   public int getTotPage() {
      return totPage;
   }
   public void setTotPage(int count) {
      this.totPage = (int)Math.ceil(count * 1.0 / PAGE_SCALE);
   }
   public int getTotBlock() {
      return totBlock;
   }
   public void setTotBlock() {
      this.totBlock = (int)Math.ceil( (double)totPage / (double)BLOCK_SCALE);
   }
   public int getCurBlock() {
      return curBlock;
   }
   public void setCurBlock(int curBlock) {
      this.curBlock = curBlock;
   }
   public int getPrevBlock() {
      return prevBlock;
   }
   public void setPrevBlock(int prevBlock) {
      this.prevBlock = prevBlock;
   }
   public int getNextBlock() {
      return nextBlock;
   }
   public void setNextBlock(int nextBlock) {
      this.nextBlock = nextBlock;
   }
   public int getPageBegin() {
      return pageBegin;
   }
   public void setPageBegin(int pageBegin) {
      this.pageBegin = pageBegin;
   }
   public int getPageEnd() {
      return pageEnd;
   }
   public void setPageEnd(int pageEnd) {
      this.pageEnd = pageEnd;
   }
   public int getBlockBegin() {
      return blockBegin;
   }
   public void setBlockBegin(int blockBegin) {
      this.blockBegin = blockBegin;
   }
   public int getBlockEnd() {
      return blockEnd;
   }
   public void setBlockEnd(int blockEnd) {
      this.blockEnd = blockEnd;
   }
   
   
   
   
   
   
   
   
}