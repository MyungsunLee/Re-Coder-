package com.edu.diet.service;

import java.util.List;

import com.edu.diet.vo.DietVo;

public interface DietService {
	
	public List<DietVo> dietSelectList();
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
