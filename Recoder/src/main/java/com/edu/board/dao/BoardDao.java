package com.edu.board.dao;

import java.util.List;
import java.util.Map;

import com.edu.board.vo.BoardVo;


public interface BoardDao {

	
	public List<BoardVo> boardSelectList(
			String searchOption, String keyword, int start, int end);
	public BoardVo boardSelectOne(int no);
	public int boardInsertOne(BoardVo boardVo);
	public int boardUpdateOne(BoardVo boardVo);
	public int boardDeleteOne(int boardNo);
	public int boardCountTotal(Map<String, String> map);
	
}
