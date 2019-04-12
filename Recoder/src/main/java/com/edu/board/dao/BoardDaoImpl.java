package com.edu.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.board.vo.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Override
	public List<BoardVo> boardSelectList(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

}
