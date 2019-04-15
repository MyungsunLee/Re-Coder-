package com.edu.member.controller;

import java.util.HashMap;
import java.util.List;
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

import com.edu.member.service.MemberService;
import com.edu.member.vo.MemberVo;

@Controller
public class MemberController {

	private final Logger log = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	// 조회
//	@RequestMapping(value = "/member/list.do", method = { RequestMethod.GET, RequestMethod.POST })
//	public String memberList(Model model) {
//
//		List<MemberVo> memberList = memberService.memberList();
//
//		model.addAttribute("memberList", memberList);
//
//		return "member/memberListView";
//	}

	// 1명 조회
//	@RequestMapping(value = "/member/listOne.do")
//	public String memberListOne(int no, Model model) {
//		log.debug("Welcome memberListOne enter! - {}", no);
//
//		Map<String, Object> map = memberService.memberSelectOne(no);
//		MemberVo memberVo = (MemberVo) map.get("memberVo");
//
//		model.addAttribute("memberVo", memberVo);
//
//		return "member/memberListOneView";
//	}

	// 로그인페이지로 이동
	@RequestMapping(value = "/auth/login.do", method = RequestMethod.GET)
	public String login(HttpSession session, Model model) {
		log.debug("Welcome MemberController login 페이지 이동! ");

		return "auth/loginForm";
	}

	// 로그인
	@RequestMapping(value = "/auth/loginCtr.do", method = RequestMethod.GET)
	public String longinCtr(String email, String password, HttpSession session, Model model) {

		log.debug("Welcome MemberController loginCtr! " + email + ", " + password);

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		paramMap.put("pwd", password);

		MemberVo memberVo = memberService.memberExist(paramMap);

		String viewUrl = "";
		if (memberVo != null) {
			// 회원이 존재한다면 세션에 담고
			// 회원 전체 조회 페이지로 이동
			session.setAttribute("login_memberVo", memberVo);

			viewUrl = "redirect:/member/list.do";
		} else {
			viewUrl = "/auth/loginFail";
		}

		return viewUrl;
	}

	// 로그아웃
	@RequestMapping(value = "auth/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		log.debug("Welcome MemberController logout 페이지 이동! ");

		// 세션의 객체들 파기
		session.invalidate();

		return "redirect:/auth/login.do";
	}

	// 회원가입 페이지로
	@RequestMapping(value = "/member/add.do", method = RequestMethod.GET)
	public String memberAdd(Model model) {
		log.debug("Welcome MemberController memberAdd 페이지 이동! ");

		return "member/memberForm";
	}

	// 회원가입
	@RequestMapping(value = "/member/addCtr.do", method = RequestMethod.POST)
	public String memberAdd(MemberVo memberVo, Model model) {
		log.trace("Welcome MemberController memberAdd 신규등록 처리! " + memberVo);

		try {
			memberService.memberInsertOne(memberVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("아 오류 처리;");
			e.printStackTrace();
		}

		return "redirect:/member/list.do";
	}

	// 회원정보 수정 페이지
	@RequestMapping(value = "/member/update.do")
	public String memberUpdate(int no, Model model) {
		log.debug("Welcome memberUpdate enter! - {}", no);

		Map<String, Object> map = memberService.memberSelectOne(no);

		MemberVo memberVo = (MemberVo) map.get("memberVo");

		model.addAttribute("memberVo", memberVo);

		return "member/memberUpdateForm";
	}

	@RequestMapping(value = "/member/updateCtr.do", method = RequestMethod.POST)
	public String memberUpdateCtr(HttpSession session, MemberVo memberVo, Model model) {
		log.debug("Welcome MemberController memberUpdateCtr {} :: {}", memberVo);

		MemberVo sessionMemberVo = (MemberVo) session.getAttribute("login_memberVo");

		if (sessionMemberVo != null) {
			if (sessionMemberVo.getMemberNo() == memberVo.getMemberNo()) {
				MemberVo newMemberVo = new MemberVo();

				newMemberVo.setMemberNo(memberVo.getMemberNo());
				newMemberVo.setMemberEmail(memberVo.getMemberEmail());
				newMemberVo.setMemberName(memberVo.getMemberName());

				session.removeAttribute("login_memberVo");

				session.setAttribute("login_memberVo", newMemberVo);
			}
		}else {
			//실패시 처리 페이지로 이동
		}
		
		//페이지 미구현
		return "common/successPage";
	}

	
//	@RequestMapping(value = "/member/deleteCtr.do", method = RequestMethod.GET)
//	public String memberDelete(int no, Model model) {
//		log.debug("Welcome MemberController memberDelete" + " 회원삭제 처리! - {}", no);
//
//		try {
//			memberService.memberDelete(no);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			//실패시 처리 페이지로 이동
//		}
//		
//		//메인페이지
//		return "../Recoder/";
//	}
	
	
	
	
	
}
