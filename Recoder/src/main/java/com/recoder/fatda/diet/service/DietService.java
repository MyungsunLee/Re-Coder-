package com.recoder.fatda.diet.service;

import java.util.List;

import com.recoder.fatda.diet.vo.DietVo;

public interface DietService {
	
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
