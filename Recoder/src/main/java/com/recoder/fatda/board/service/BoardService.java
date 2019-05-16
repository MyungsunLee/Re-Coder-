package com.recoder.fatda.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.recoder.fatda.board.vo.BoardVo;
import com.recoder.fatda.board.vo.CommentVo;

public interface BoardService {

   
   
   public List<BoardVo> boardSelectList(
         String searchOption, String keyword, int start, int end);
   public Map<String, Object> boardSelectOne(int no);
   
   public void boardInsertOne(BoardVo boardVo, 
		   					   MultipartHttpServletRequest multipartHttpServletRequest) 
		   throws Exception;
   public int boardUpdateOne(BoardVo boardVo, 
		   					 MultipartHttpServletRequest multipartHttpServletRequest,
		   					 int fileIdx) throws Exception;
   
   public void boardDeleteOne(int no) throws Exception;
   public int boardCountTotal(String searchOption, String keyword);
   public BoardVo boardSelectOneSub(int rNum);
   

   
   public List<CommentVo> commentSelectList(int boardNo);
   public int commentInsertOne(CommentVo commentVo);
   public int commentUpdateOne(CommentVo commentVo);
   public int commentDeleteOne(int commentNo);

   public int commentTotalList(int boardNo);
   
   
   
   
   
   
   
   
   
   
}