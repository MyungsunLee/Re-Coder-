package com.edu.kcal.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.kcal.vo.KcalVo;


@Repository
public class KcalDaoImpl implements KcalDao {


	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<KcalVo> kcalSelectList(String searchOption, String keyword, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

}
