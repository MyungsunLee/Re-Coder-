package com.edu.diet.dao;

import java.util.List;

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
	public List<DietVo> dietSelectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "dietSelectList");
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

}
