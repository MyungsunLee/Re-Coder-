package com.edu.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.board.dao.BoardDao;
import com.edu.board.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Autowired
	public BoardDao boardDao;

	@Override
	public List<BoardVo> boardSelectList(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
		return boardDao.boardSelectList(searchOption, keyword, start, end);
	}

	@Override
	public BoardVo boardSelectOne(int no) {
		// TODO Auto-generated method stub
		return boardDao.boardSelectOne(no);
	}

	@Override
	public int boardInsertOne(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return boardDao.boardInsertOne(boardVo);
	}

	@Override
	public int boardUpdateOne(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return boardDao.boardUpdateOne(boardVo);
	}

	@Override
	public int boardCountTotal(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		
		return boardDao.boardCountTotal(map);
	}

	@Override
	public int boardDeleteOne(int boardNo) {
		// TODO Auto-generated method stub
		return boardDao.boardDeleteOne(boardNo);
	}
}
