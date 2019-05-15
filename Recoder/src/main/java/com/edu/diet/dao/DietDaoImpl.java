package com.edu.diet.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.diet.vo.DietVo;

@Repository
public class DietDaoImpl implements DietDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String namespace = "com.edu.diet.";
	
	@Override
	public List<DietVo> dietSelectList(int start, int end) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectList(namespace + "dietSelectList", map);
	}
	
	@Override
	public List<DietVo> dietSelectListAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "dietSelectListAll");
	}
	
	@Override
	public int dietInsertOne(DietVo dietVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "dietInsertOne", dietVo);
	}
	
	@Override
	public int dietUpdateOne(DietVo dietVo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "dietUpdateOne", dietVo);
	}

	@Override
	public int dietDelete(int dietNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + "dietDelete" , dietNo);
	}

	@Override
	public DietVo selectCarbohydrate() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "selectCarbohydrate");
	}

	@Override
	public DietVo selectProtein() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "selectProtein");
	}

	@Override
	public List<DietVo> selectCarbohydrateList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"selectCarbohydrateList");
	}

	@Override
	public List<DietVo> selectProteinList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"selectProteinList");
	}

	public DietVo selectFat() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "selectFat");
	}

	@Override
	public List<DietVo> selectFatList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"selectFatList");
	}

	@Override
	public int dietCountTotal() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"dietSelectTotalCount");
	}

	
}
