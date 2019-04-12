package com.edu.kcal.dao;

import java.util.List;

import com.edu.kcal.vo.KcalVo;

public interface KcalDao {

	
	
	public List<KcalVo> kcalSelectList(String searchOption, String keyword, int start, int end);
}
