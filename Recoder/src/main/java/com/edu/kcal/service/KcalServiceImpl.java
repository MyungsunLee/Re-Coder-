package com.edu.kcal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.kcal.dao.KcalDao;
import com.edu.kcal.vo.KcalVo;

@Service
public class KcalServiceImpl implements KcalService {

	@Autowired
	public KcalDao kcalDao;

	@Override
	public List<KcalVo> kcalSelectList(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}
}
