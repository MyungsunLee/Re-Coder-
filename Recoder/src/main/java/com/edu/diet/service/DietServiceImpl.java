package com.edu.diet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.diet.dao.DietDao;

@Service
public class DietServiceImpl implements DietService {

	@Autowired
	public DietDao dietDao;
}
