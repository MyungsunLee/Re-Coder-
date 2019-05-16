package com.recoder.fatda.board.dao;

import java.util.List;
import java.util.Map;

import com.recoder.fatda.board.vo.BoardVo;
import com.recoder.fatda.board.vo.CommentVo;


public interface BoardDao {

   //게시글 관리
   public List<BoardVo> boardSelectList(
         String searchOption, String keyword, int start, int end);
   public BoardVo boardSelectOne(int no);
   public int boardInsertOne(BoardVo boardVo);
   public int boardUpdateOne(BoardVo boardVo);
   public int boardDeleteOne(int boardNo);
   
   
   //페이징
   public int boardCountTotal(Map<String, String> map);
   public BoardVo boardSelectOneSub(int rNum);
   
   
   //파일첨부
   public void insertFile(Map<String, Object> map);
   public List<Map<String, Object>> fileSelectList(int no);
   public int fileDelete(int no);
   public Map<String, Object> fileSelectStoredFileName(int no);
   
   //덧글 관리
   public List<CommentVo> commentSelectList(int boardNo);
   public int commentInsertOne(CommentVo commentVo);
   public int commentUpdateOne(CommentVo commentVo);
   
   //덧글1개 삭제
   public int commentDeleteOne(int commentNo);
   //게시판 삭제시 관련댓글 모두 삭제
   public int commentDeleteList(int boardNo);
   
   public int commentTotalList(int boardNo);
   
   
   
   
   
   
   
   
}