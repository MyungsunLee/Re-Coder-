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

/**
 * @author TJ
 *
 */
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
	@RequestMapping(value = "/member/listOne.do")
	public String memberListOne(int no, Model model) {
		log.debug("Welcome memberListOne enter! - {}", no);

		Map<String, Object> map = memberService.memberSelectOne(no);
		MemberVo memberVo = (MemberVo) map.get("memberVo");

		model.addAttribute("memberVo", memberVo);

		return "member/memberListOneView";
	}

	@RequestMapping(value = "/common/index.do", method = RequestMethod.GET)
	public String index(Model model) {
		log.debug("Welcome IndexController 페이지 이동! ");

		return "common/index";
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
		if (memberVo != null && memberVo.getMemberAuth() == 'U') {

			// 회원이 존재한다면 세션에 담고
			// 회원 전체 조회 페이지로 이동
			session.setAttribute("login_memberVo", memberVo);

			viewUrl = "redirect:/common/index.do";
		} else if (memberVo != null && memberVo.getMemberAuth() == 'A') {

			// 회원이 존재한다면 세션에 담고 // 회원 전체 조회 페이지로 이동
			session.setAttribute("login_memberVo", memberVo);

			viewUrl = "redirect:/diet/list.do";
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

		return "redirect:/common/index.do";
	}

	// 회원가입 페이지로
	@RequestMapping(value = "/member/add.do", method = RequestMethod.GET)
	public String memberAdd(Model model) {
		log.debug("Welcome MemberController memberAdd 페이지 이동! ");

		return "member/regiform";
	}

	// 회원가입
	@RequestMapping(value = "/member/add.do", method = RequestMethod.POST)
	public String memberAdd(String memberPasswordConfirm, MemberVo memberVo, Model model) {
		log.trace("Welcome MemberController memberAdd 신규등록 처리! " + memberVo);

		if (memberVo.getMemberPassword().equals(memberPasswordConfirm)) {

			try {
				memberService.memberInsertOne(memberVo);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "/member/regifail";
			}

		} else {
			// 회원가입 실패시 처리할 페이지 추가하기
			return "/member/regifail";
		}

		return "redirect:/common/index.do";
	}

	// 마이페이지
	@RequestMapping(value = "/member/info.do", method = RequestMethod.GET)
	public String memberSelectOne(Model model) {
		log.debug("Welcome infoPage enter!");

		return "member/info";
	}

	// 회원정보 수정 페이지
	@RequestMapping(value = "/member/info.do", method = RequestMethod.POST)
	public String memberUpdate(@RequestParam(value = "memberNo") int no, Model model) {
		log.debug("Welcome memberUpdate enter! - {}", no);

		Map<String, Object> map = memberService.memberSelectOne(no);

		MemberVo memberVo = (MemberVo) map.get("memberVo");

		model.addAttribute("memberVo", memberVo);

		return "redirect:/member/update.do";
	}

	// 수정페이지
	@RequestMapping(value = "/member/update.do", method = RequestMethod.GET)
	public String memberUpdate(Model model) {
		log.debug("Welcome infoPage enter!");

		return "member/infoupdate";
	}

	@RequestMapping(value = "/member/updateCtr.do", method = RequestMethod.POST)
	public String memberUpdateCtr(HttpSession session, MemberVo memberVo, Model model) {
		log.debug("Welcome MemberController memberUpdateCtr {} :: {}", memberVo);

//		int resultNum = 0;

		try {
//			resultNum = memberService.memberUpdateOne(memberVo);
			memberService.memberUpdateOne(memberVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		session.setAttribute("login_memberVo", memberVo);

//		MemberVo sessionMemberVo = (MemberVo) session.getAttribute("login_memberVo");
//		if (resultNum != 0 && sessionMemberVo != null && sessionMemberVo.getMemberNo() == memberVo.getMemberNo()) {
//			session.setAttribute("login_memberVo", memberVo);
//		}

//		MemberVo sessionMemberVo = (MemberVo) session.getAttribute("login_memberVo");
//		// 데이터베이스에서 회원정보가 수정이 됬는지 여부
//		if (resultNum > 0 && sessionMemberVo != null && sessionMemberVo.getMemberNo() == memberVo.getMemberNo()) {
////				  MemberVo newMemberVo = new MemberVo();
//
//		  
//		  newMemberVo.setMemberNo(memberVo.getMemberNo());
//		  newMemberVo.setMemberEmail(memberVo.getMemberEmail());
//		  newMemberVo.setMemberName(memberVo.getMemberName());
//		  
//		  session.removeAttribute("login_memberVo");
//		  
//		  session.setAttribute("login_memberVo", newMemberVo); } 
//		}

		return "redirect:/member/info.do";
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

	/*
	 * 관리자 컨트롤러
	 * *****************************************************************************
	 * ***
	 */

	// 로그인페이지로 이동

	/*
	 * @RequestMapping(value = "/admin/login.do", method = RequestMethod.GET) public
	 * String adminLogin(Model model) {
	 * log.debug("Welcome MemberController adminLogin 페이지 이동! ");
	 * 
	 * return "/admin/adminloginform"; }
	 */

	/*
	 * // 로그인
	 * 
	 * @RequestMapping(value = "/admin/login.do", method = RequestMethod.POST)
	 * public String adminLogin(MemberVo memberVo1, HttpSession session, Model
	 * model) {
	 * 
	 * log.debug("Welcome MemberController adminLogin! " +
	 * memberVo1.getMemberEmail() + ", " + memberVo1.getMemberPassword());
	 * 
	 * MemberVo memberVo = memberService.memberExist(memberVo1);
	 * 
	 * String viewUrl = ""; if (memberVo != null && memberVo.getMemberAuth() == 'A')
	 * {
	 * 
	 * // 회원이 존재한다면 세션에 담고 // 회원 전체 조회 페이지로 이동
	 * session.setAttribute("login_memberVo", memberVo);
	 * 
	 * viewUrl = "redirect:/diet/list.do"; } else { viewUrl =
	 * "redirect:/admin/login.do"; }
	 * 
	 * return viewUrl; }
	 */

	// 로그아웃

	/*
	 * @RequestMapping(value = "/admin/logout.do", method = RequestMethod.GET)
	 * public String adminLogout(HttpSession session, Model model) {
	 * log.debug("Welcome MemberController logout 페이지 이동! ");
	 * 
	 * session.invalidate();
	 * 
	 * return "redirect:/admin/login.do"; }
	 */

}