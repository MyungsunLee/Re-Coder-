package com.edu.board.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.edu.board.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Autowired
	public BoardDao boardDao;
}
