package com.edu.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.board.vo.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String nameSpace = "com.edu.board.";
	
	@Override
	public List<BoardVo> boardSelectList(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		
		
		return sqlSession.selectList(nameSpace+"boardSelectList", map);
	}

	
	//mapper 미구현
	@Override
	public BoardVo boardSelectOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+"boardSelectOne", no);
	}

	@Override
	public int boardInsertOne(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardUpdateOne(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDeleteOne(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int boardCountTotal(Map<String, String> map) {
		// TODO Auto-generated method stub
		
//		org.slf4j.Logger log = LoggerFactory.getLogger(BoardDaoImpl.class);
		
//		log.debug(sqlSession.selectOne(nameSpace+"boardSelectTotalCount", map));
		return sqlSession.selectOne(nameSpace+"boardSelectTotalCount", map);
	}

}
