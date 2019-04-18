package com.edu.board.service;

import java.util.List;
import java.util.Map;

import com.edu.board.vo.BoardVo;

public interface BoardService {

	
	
	public List<BoardVo> boardSelectList(
			String searchOption, String keyword, int start, int end);
	public BoardVo boardSelectOne(int no);
	public int boardInsertOne(BoardVo boardVo);
	public int boardUpdateOne(BoardVo boardVo);
	public int boardDeleteOne(BoardVo boardVo);
	public int boardCountTotal(String searchOption, String keyword);
}
