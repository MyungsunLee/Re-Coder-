package com.edu.memberInfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.memberInfo.service.MemberInfoService;
import com.edu.memberInfo.vo.MemberInfoVo;


@Controller
public class MemberInfoController {

	
	private final Logger log = LoggerFactory.getLogger(MemberInfoController.class);
	
	@Autowired
	private MemberInfoService memberInfoService;
	
	
	// 칼로리 처방 페이지로 이동
	@RequestMapping(value = "/memberInfo/memberInfo.do", method = RequestMethod.GET)
	public String memberInfo(Model model) {
		log.debug("Welcome kcalController memberInfoView 페이지 이동! ");
		
		return "/memberInfo/memberInfoView";
	}
	
	// 칼로리 처방전 페이지 member_info 테이블 값 확인
	@RequestMapping(value = "/memberInfo/memberInfoInsert.do", method = {RequestMethod.POST})
	public String memberInfoInsert(MemberInfoVo memberInfoVo1, Model model) {
		log.debug("Welcome kcalController memberinfoKcalView 페이지 이동! ");
		
		boolean memberInfoVo = memberInfoService.memberInfoExist(memberInfoVo1);
		
		System.out.println("꾸우?");
		
		String viewUrl = "";
		if (memberInfoVo == false) {
			// 칼로리 처방 정보가 존재하지않으면 DB에 Insert후  model에 담고
			// 칼로리 처방전 페이지로 이동
			
			System.out.println("까");
			memberInfoService.memberInfoInsertOne(memberInfoVo1);

			model.addAttribute("memberInfoVo", memberInfoVo1);
			
			System.out.println("뀨");
			
			viewUrl = "redirect:/memberInfo/memberInfoKcalView.do";
		} else {// 칼로리 처방 정보가 존재하면 Update페이지로 이동
			viewUrl = "redirect:/memberInfo/memberInfoUpdateView.do";
		}

		return viewUrl;
	}
	// 칼로리 처방전 페이지 member_info 값 불러오기
	@RequestMapping(value = "/memberInfo/memberInfoUpdateView.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String memberInfoUpdateView(MemberInfoVo memberInfoVo1, Model model) {
		log.debug("Welcome kcalController memberinfoTakeView 페이지 이동! ");
//		@RequestParam(value = "memberNo") int no
//		@RequestParam(value = "memberNo") String no
//		memberInfoVo1.setMemberNo(Integer.parseInt(no));
		System.out.println("하 .. .");
		boolean memberInfoVo = memberInfoService.memberInfoExist(memberInfoVo1);
		
		System.out.println("꾸우R?");
		
		String viewUrl = "";
		if (memberInfoVo == true) {
			// 칼로리 처방 정보가 존재한다면 세션에 담고
			// 칼로리 처방전 페이지로 이동
			memberInfoService.memberInfoSelectOne(memberInfoVo1.getMemberNo());
			System.out.println("까R");
			memberInfoService.memberInfoUpdateOne(memberInfoVo1); //업데이트
			
			model.addAttribute("login_memberInfoVo", memberInfoVo);
			
//			session.setAttribute("login_memberInfoVo", memberInfoVo);
			
			System.out.println("R뀨");
			
//			viewUrl = "redirect:/memberInfo/memberInfoKcalView.do";
			viewUrl = "forward:/memberInfo/memberInfoKcalView";
		} else {
			viewUrl = "memberInfo/memberInfoView";
		}
		
//		MemberInfoVo memberInfoVo = (memberInfoVo) map.get("memberInfoVo");
		return viewUrl;
	}
	@RequestMapping(value = "/memberInfo/memberInfoKcalView.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String memberInfoKcalView(MemberInfoVo memberInfoVo1, Model model) {
		log.debug("Welcome kcalController memberinfoKcalView 페이지 이동! ");
		
		return "memberInfo/memberInfoKcalView";
	}
}
