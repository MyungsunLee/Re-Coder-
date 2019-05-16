package com.recoder.fatda.diet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recoder.fatda.diet.dao.DietDao;
import com.recoder.fatda.diet.vo.DietVo;

@Service
public class DietServiceImpl implements DietService {

	@Autowired
	public DietDao dietDao;
	
	
	@Override
	public List<DietVo> dietSelectList(int start, int end) {
		// TODO Auto-generated method stub
		return dietDao.dietSelectList(start, end);
	}

	@Override
	public List<DietVo> dietSelectListAll() {
		// TODO Auto-generated method stub
		return dietDao.dietSelectListAll();
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
	public DietVo selectFat() {
		// TODO Auto-generated method stub
		return dietDao.selectFat();
	}

	@Override
	public List<DietVo> selectFatList() {
		// TODO Auto-generated method stub
		return dietDao.selectFatList();
	}

	@Override
	public int dietCountTotal() {
		// TODO Auto-generated method stub
		return dietDao.dietCountTotal();
	}

	
}
