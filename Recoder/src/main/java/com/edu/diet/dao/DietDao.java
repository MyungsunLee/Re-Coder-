package com.edu.diet.dao;

import java.util.List;
import java.util.Map;

import com.edu.diet.vo.DietVo;

public interface DietDao {
	
	public List<DietVo> dietSelectList(int start, int end);
	public List<DietVo> dietSelectListAll();
	public int dietCountTotal();
	public int dietInsertOne(DietVo dietVo);
	public int dietUpdateOne(DietVo dietVo);
	public int dietDelete(int dietNo);
	public DietVo selectCarbohydrate();
	public DietVo selectProtein();
	public DietVo selectFat();
	public List<DietVo> selectCarbohydrateList();
	public List<DietVo> selectProteinList();
	public List<DietVo> selectFatList();
}
