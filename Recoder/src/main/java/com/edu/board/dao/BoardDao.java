package com.edu.board.dao;

import java.util.List;

import com.edu.board.vo.BoardVo;


public interface BoardDao {

	
	public List<BoardVo> boardSelectList(
			String searchOption, String keyword, int start, int end);
}
