package com.edu.diet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.diet.dao.DietDao;
import com.edu.diet.vo.DietVo;

@Service
public class DietServiceImpl implements DietService {

	@Autowired
	public DietDao dietDao;
	
	
	@Override
	public List<DietVo> dietSelectList() {
		// TODO Auto-generated method stub
		return dietDao.dietSelectList();
	}
	
	@Override
	public int dietInsertOne(DietVo dietVo) {
		// TODO Auto-generated method stub
		return dietDao.dietInsertOne(dietVo);
	}
	
	@Override
	public int dietUpdateOne(DietVo dietVo) {
		// TODO Auto-generated method stub
		return dietDao.dietUpdateOne(dietVo);
	}

	@Override
	public int dietDelete(int dietNo) {
		// TODO Auto-generated method stub
		return dietDao.dietDelete(dietNo);
	}

	@Override
	public DietVo selectCarbohydrate() {
		// TODO Auto-generated method stub
		return dietDao.selectCarbohydrate();
	}

	@Override
	public DietVo selectProtein() {
		// TODO Auto-generated method stub
		return dietDao.selectProtein();
	}

	@Override
	public List<DietVo> selectCarbohydrateList() {
		// TODO Auto-generated method stub
		return dietDao.selectCarbohydrateList();
	}

	@Override
	public List<DietVo> selectProteinList() {
		// TODO Auto-generated method stub
		return dietDao.selectProteinList();
	}

	
}
