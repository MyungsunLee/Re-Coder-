package com.edu.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edu.board.vo.BoardVo;

public interface BoardService {

   
   
   public List<BoardVo> boardSelectList(
         String searchOption, String keyword, int start, int end);
   public Map<String, Object> boardSelectOne(int no);
//   public int boardInsertOne(BoardVo boardVo);
   
   public void boardInsertOne(BoardVo boardVo, 
		   					   MultipartHttpServletRequest multipartHttpServletRequest) 
		   throws Exception;
//   public int boardUpdateOne(BoardVo boardVo);
   public int boardUpdateOne(BoardVo boardVo, 
		   					 MultipartHttpServletRequest multipartHttpServletRequest,
		   					 int fileIdx) throws Exception;
   
//   public int boardDeleteOne(int boardNo);
   public int boardDeleteOne(int no) throws Exception;
   public int boardCountTotal(String searchOption, String keyword);
   public BoardVo boardSelectOneSub(int rNum);
   
   //파일?
//   public void insertFile(Map<String, Object> map);
//   public List<Map<String, Object>> fileSelectList(int no);
//   public int fileDelete(int no);
//   public Map<String, Object> fileSelectStoredFileName(int no);
   
   
}