package com.edu.memberInfo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.memberInfo.service.MemberInfoService;
import com.edu.memberInfo.vo.MemberInfoVo;


@Controller
public class MemberInfoController {

	
	private final Logger log = LoggerFactory.getLogger(MemberInfoController.class);
	
	@Autowired
	private MemberInfoService memberInfoService;
	
	
	// 칼로리 처방 페이지로 이동
	@RequestMapping(value = "/memberInfo/memberInfoView.do", method = RequestMethod.GET)
	public String memberInfoView(Model model) {
		log.debug("Welcome kcalController memberInfoView 페이지 이동! ");
		
		return "/memberInfo/memberInfoView";
	}
	
	// 칼로리 처방전 페이지로 이동
	@RequestMapping(value = "/memberInfo/memberInfoKcalView.do", method = RequestMethod.POST)
	public String memberInfoKcalView(@RequestParam(value = "memberNo") String no, MemberInfoVo memberInfoVo1, Model model) {
		log.debug("Welcome kcalController memberinfoKcalView 페이지 이동! ");
		
		memberInfoVo1.setMemberNo(Integer.parseInt(no));
		
		boolean memberInfoVo = memberInfoService.memberInfoExist(memberInfoVo1);
		
		System.out.println("꾸우?");
		
		String viewUrl = "";
		if (memberInfoVo == false) {
			// 칼로리 처방 정보가 존재한다면 세션에 담고
			// 칼로리 처방전 페이지로 이동
//			session.setAttribute("login_memberInfoVo", memberInfoVo);
			
			System.out.println("까");
			memberInfoService.memberInfoInsertOne(memberInfoVo1);


			System.out.println("뀨");
			
			viewUrl = "redirect:/memberInfo/memberInfoKcalView.do";
		} else {
			viewUrl = "/memberInfo/memberInfoView";
		}

//		MemberInfoVo memberInfoVo = (memberInfoVo) map.get("memberInfoVo");
		return viewUrl;
	}
}
