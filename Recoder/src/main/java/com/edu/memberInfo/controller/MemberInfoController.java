package com.edu.memberInfo.controller;

import javax.servlet.http.HttpSession;

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
	@RequestMapping(value = "/memberInfo/memberInfoView.do", method = RequestMethod.GET)
	public String memberInfoView(HttpSession session, MemberInfoVo memberInfoVo1, Model model) {
		log.debug("Welcome kcalController memberInfoView 페이지 이동! ");

//		MemberVo memberVo = (MemberVo) session.getAttribute("login_memberVo");
		
		boolean memberExist = memberInfoService.memberInfoExist(memberInfoVo1);
		String viewUrl = "";
		
		if(memberExist != false) {	// info테이블에 값 존재
			viewUrl = "forward:/memberInfo/memberInfoShow.do";
		}else {
			
			viewUrl = "/memberInfo/memberInfoView";
		}
		
		
		return viewUrl;
//		return "/memberInfo/memberInfoView";
	}

	// 칼로리 처방전 페이지 member_info 테이블 값 확인
	@RequestMapping(value = "/memberInfo/memberInfoInsertView.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberInfoInsertView(HttpSession session, MemberInfoVo memberInfoVo1, Model model) {
		log.debug("Welcome kcalController memberinfoKcalView or memberInfoUpdateView 페이지 이동! ");

		
		boolean memberInfoVo = memberInfoService.memberInfoExist(memberInfoVo1);

		String viewUrl = "";

		if (memberInfoVo == false) { 
			// 칼로리 처방 정보가 존재하지않으면 DB에 Insert후 model에 담고 
			// 칼로리 처방전 페이지로 이동

			memberInfoService.memberInfoInsertOne(memberInfoVo1);
			memberInfoService.memberInfoUpdateOneKCal(memberInfoVo1);
			MemberInfoVo memberInfo = memberInfoService.memberInfoSelectOne(memberInfoVo1.getMemberNo());
			session.setAttribute("_memberInfoVo", memberInfo);

			log.debug("Welcome kcalController memberInfoInsertView - {}", memberInfo);

			viewUrl = "forward:/memberInfo/memberInfoKcalView.do";
		} else {// 칼로리 처방 정보가 존재하면 Update페이지로 이동
			viewUrl = "redirect:/memberInfo/memberInfoShow.do";
		}

		return viewUrl;
	}

	
	// 칼로리 처방전 페이지 member_info 값 불러와서 화면에 띄우기
	@RequestMapping(value = "/memberInfo/memberInfoShow.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberInfoShow(HttpSession session, MemberInfoVo memberInfoVo1, Model model) {
		log.debug("Welcome kcalController memberinfoShow 페이지 이동! ");
		System.out.println("하 .. .2");
		
		String viewUrl = "";
		
		MemberInfoVo memberInfo = memberInfoService.memberInfoSelectOne(memberInfoVo1.getMemberNo());
		session.setAttribute("_memberInfoVo", memberInfo);
		
		
		viewUrl = "forward:/memberInfo/memberInfoUpdateShow.do";
		
		return viewUrl;
	}

	// 칼로리 처방전 페이지 member_info 값 덮어씌우기 수정수정
	@RequestMapping(value = "/memberInfo/memberInfoUpdateView.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberInfoUpdateView(HttpSession session, MemberInfoVo memberInfoVo1, Model model) {
		log.debug("Welcome kcalController memberinfoUpdateView 페이지 이동! ");
		System.out.println("하 .. .");
		
		String viewUrl = "";
		
		MemberInfoVo memberInfo = memberInfoService.memberInfoSelectOne(memberInfoVo1.getMemberNo());
//		session.setAttribute("_memberInfoVo", memberInfo);
		
		memberInfoService.memberInfoUpdateOne(memberInfoVo1);
		memberInfoService.memberInfoUpdateOneKCal(memberInfoVo1);
		session.setAttribute("_memberInfoVo", memberInfo);
		
		viewUrl = "forward:/memberInfo/memberInfoKcalView.do";

		return viewUrl;
	}
	
	
	@RequestMapping(value = "/memberInfo/memberInfoKcalView.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberInfoKcalView(MemberInfoVo memberInfoVo1, Model model) {
		log.debug("Welcome kcalController memberinfoKcalView 페이지 이동! ");

		return "memberInfo/memberInfoKcalView";
	}
	
	@RequestMapping(value = "/memberInfo/memberInfoUpdateShow.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberInfoUpdateShow(HttpSession session, MemberInfoVo memberInfoVo1, Model model) {
		log.debug("Welcome kcalController memberinfoUpdateShow 페이지 이동! ");
		
		return "memberInfo/memberInfoUpdateShow";
	}
	
	// 칼로리 처방전 페이지 member_info 값 덮어씌우고 수정 페이지로
	@RequestMapping(value = "/memberInfo/memberInfoUpdate.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberInfoUpdate(HttpSession session, MemberInfoVo memberInfoVo1, Model model) {
		log.debug("Welcome kcalController memberinfoUpdate 페이지 이동! ");
		System.out.println("하 .. 3.");
		
		
		return "/memberInfo/memberInfoUpdateView";
	}
}
