package com.edu.kcal.service;

import java.util.List;

import com.edu.kcal.vo.KcalVo;

public interface KcalService {

	
	public List<KcalVo> kcalSelectList(String searchOption, String keyword, int start, int end);
}
