package com.edu.diet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.edu.diet.service.DietService;


@Controller
public class DietController {

	
	private final Logger log = LoggerFactory.getLogger(DietController.class);
	
	
	@Autowired
	private DietService dietService;
}
