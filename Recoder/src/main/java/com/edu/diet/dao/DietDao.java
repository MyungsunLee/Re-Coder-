package com.edu.diet.dao;

import java.util.List;

import com.edu.diet.vo.DietVo;

public interface DietDao {
	
	public List<DietVo> dietSelectList();
	public int dietInsertOne(DietVo dietVo);
	public int dietUpdateOne(DietVo dietVo);
	public int dietDelete(int dietNo);

}
