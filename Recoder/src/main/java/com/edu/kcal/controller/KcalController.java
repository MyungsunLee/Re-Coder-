package com.edu.kcal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.kcal.service.KcalService;


@Controller
public class KcalController {

	
	private final Logger log = LoggerFactory.getLogger(KcalController.class);
	
	@Autowired
	private KcalService kcalService;
	
	
	// 칼로리 처방 페이지로 이동
	@RequestMapping(value = "/kcal/kcalView.do", method = RequestMethod.GET)
	public String login(Model model) {
		log.debug("Welcome kcalController kcalView 페이지 이동! ");

		return "/kcal/kcalView";
	}
}
