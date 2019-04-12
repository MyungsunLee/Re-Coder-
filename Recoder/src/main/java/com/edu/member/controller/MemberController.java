package com.edu.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.edu.member.service.MemberService;


@Controller
public class MemberController {

	
	private final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	
	@Autowired
	private MemberService memberService;
}
