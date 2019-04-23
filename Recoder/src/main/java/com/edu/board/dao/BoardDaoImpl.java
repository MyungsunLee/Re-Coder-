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

	@Override
	public BoardVo boardSelectOne(int boardNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+"boardSelectOne", boardNo);
	}

	@Override
	public int boardInsertOne(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + "boardInsertOne", boardVo);
	}

	@Override
	public int boardUpdateOne(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace+"boardUpdateOne", boardVo);
	}


	@Override
	public int boardCountTotal(Map<String, String> map) {
		// TODO Auto-generated method stub
		
//		org.slf4j.Logger log = LoggerFactory.getLogger(BoardDaoImpl.class);
		
//		log.debug(sqlSession.selectOne(nameSpace+"boardSelectTotalCount", map));
		return sqlSession.selectOne(nameSpace+"boardSelectTotalCount", map);
	}


	@Override
	public int boardDeleteOne(int boardNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete(nameSpace + "boardDeleteOne", boardNo);

	}


	@Override
	public BoardVo boardSelectOneSub(int rNum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+"boardSelectOneRestTwo",rNum);
	}

	@Override
	public void insertFile(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		sqlSession.insert(nameSpace + "insertFile", map);
	}

	@Override
	public List<Map<String, Object>> fileSelectList(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + "fileSelectList", no);
	}

	@Override
	public int fileDelete(int no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(nameSpace + "fileDelete", no);
	}

	@Override
	public Map<String, Object> fileSelectStoredFileName(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + "fileSelectStoredFileName", no);
	}

	
	
	
	
}
