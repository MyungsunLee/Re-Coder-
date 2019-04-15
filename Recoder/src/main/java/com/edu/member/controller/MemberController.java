package com.edu.member.controller;

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
	
	@RequestMapping(value = "/common/index.do", method = RequestMethod.GET)
	public String index(Model model) {
		log.debug("Welcome IndexController 페이지 이동! ");

		return "/common/index";
	}
	
	

	// 로그인페이지로 이동
	@RequestMapping(value = "/auth/login.do", method = RequestMethod.GET)
	public String login(Model model) {
		log.debug("Welcome MemberController login 페이지 이동! ");

		return "/auth/loginform";
	}

	// 로그인
	@RequestMapping(value = "/auth/login.do", method = RequestMethod.POST)
	public String longinCtr(MemberVo memberVo1, HttpSession session, Model model) {

//		log.debug("Welcome MemberController loginCtr! " + memberVo1.getMemberEmail() + ", " + memberVo1.getMemberPassword());


		MemberVo memberVo = memberService.memberExist(memberVo1);

		String viewUrl = "";
		if (memberVo != null) {
			
			// 회원이 존재한다면 세션에 담고
			// 회원 전체 조회 페이지로 이동
			session.setAttribute("login_memberVo", memberVo);

			viewUrl = "/common/index";
		} else {
			viewUrl = "/auth/loginfail";
		}

		return viewUrl;
	}

	// 로그아웃
	@RequestMapping(value = "auth/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		log.debug("Welcome MemberController logout 페이지 이동! ");

		// 세션의 객체들 파기
		session.invalidate();

		return "/common/index";
	}

	// 회원가입 페이지로
	@RequestMapping(value = "/member/add.do", method = RequestMethod.GET)
	public String memberAdd(Model model) {
		log.debug("Welcome MemberController memberAdd 페이지 이동! ");

		return "member/regiform";
	}

	// 회원가입
	@RequestMapping(value = "/member/add.do", method = RequestMethod.POST)
	public String memberAdd(String memberPasswordConfirm, MemberVo memberVo,
							Model model) {
		log.trace("Welcome MemberController memberAdd 신규등록 처리! " + memberVo);
		
		if (memberVo.getMemberPassword().equals(memberPasswordConfirm)) {
			memberService.memberInsertOne(memberVo);
		}else {
			//회원가입 실패시 처리할 페이지 추가하기
			return "/member/regifail";
		}
		
		return "/common/index";
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
