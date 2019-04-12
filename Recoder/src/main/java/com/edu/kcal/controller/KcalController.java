package com.edu.kcal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.edu.kcal.service.KcalService;


@Controller
public class KcalController {

	
	private final Logger log = LoggerFactory.getLogger(KcalController.class);
	
	@Autowired
	private KcalService kcalService;
}
