package com.edu.diet.controller;

import java.util.ArrayList;
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

import com.edu.diet.service.DietService;
import com.edu.diet.vo.DietVo;
import com.edu.memberInfo.service.MemberInfoService;
import com.edu.memberInfo.vo.MemberInfoVo;

@Controller
public class DietController {

	private final Logger log = LoggerFactory.getLogger(DietController.class);

	@Autowired
	private DietService dietService;
	@Autowired
	private MemberInfoService memberInfoService;
	
	
	@RequestMapping(value = "/diet/list.do", method = RequestMethod.GET)
	public String dietList(Model model) {
		log.debug("Welcome DietController dietList 페이지 이동! ");

		List<DietVo> dietList = dietService.dietSelectList();

		model.addAttribute("dietList", dietList);

		String viewUrl = "diet/dietlist";

		return viewUrl;
	}

	@RequestMapping(value = "/diet/add.do", method = RequestMethod.POST)
	public String dietAdd(DietVo dietVo, Model model) {
		log.trace("Welcome DietController dietAdd 식단등록 처리! ");

		try {
			dietService.dietInsertOne(dietVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String viewUrl = "redirect:/diet/list.do";

		return viewUrl;
	}

	@RequestMapping(value = "/diet/update.do", method = RequestMethod.GET)
	public String dietUpdate(int dietNo, Model model) {
		log.debug("Welcome DietController dietUpdate 페이지 - {}");
		
		model.addAttribute("dietNo", dietNo);
		
		String viewUrl = "diet/dietupdateform";
		return viewUrl;
	}

	@RequestMapping(value = "/diet/update.do", method = RequestMethod.POST)
	public String dietUpdate(DietVo dietVo, Model model) {
		log.debug("Welcome DietController dietUpdate 수행 - {}");

		try {
			dietService.dietUpdateOne(dietVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String viewUrl = "redirect:/diet/list.do";

		return viewUrl;
	}

	@RequestMapping(value = "/diet/delete.do", method = RequestMethod.GET)
	public String dietDelete(int dietNo, Model model) {
		log.debug("Welcome DietController dietDelete 수행! ");

		try {
			dietService.dietDelete(dietNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String viewUrl = "redirect:/diet/list.do";

		return viewUrl;
	}
	
	// 일반 사용자 식단처방페이지 이동 
	@RequestMapping(value = "/diet/dietPrescription.do", method = RequestMethod.GET)
	public String dietPrescription(HttpSession session, Model model) {
		log.debug("Welcome DietController dietPrescription 페이지 이동! ");
		
		String viewUrl = "diet/dietPrescription";
		
		List<DietVo> dietList = dietService.dietSelectList();

		model.addAttribute("dietList", dietList);
		
		return viewUrl;
	}
	
	// 식단처방페이지에서 직접 선택을 했을 경우 
	@RequestMapping(value = "/diet/selfChoice.do", method = RequestMethod.GET)
	public String dietSelfChoice(HttpSession session, Model model) {
		log.debug("Welcome DietController dietselfChoice 페이지 이동! ");
		
		String viewUrl = "diet/selfChoice";
		
		List<DietVo> dietList = dietService.dietSelectList();
		
		model.addAttribute("dietList", dietList);
		
		return viewUrl;
	}

	// 식단처방페이지에서 랜덤 선택을 했을 경우 
	@RequestMapping(value = "/diet/randomChoice.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String randomChoice(DietVo dietVo, HttpSession session, MemberInfoVo memberInfoVo1, Model model) {
		log.debug("Welcome DietController dietRandomChoice 페이지 이동! {}", memberInfoVo1.getMemberNo());
		
		String viewUrl = "/diet/randomChoice";
		int tdeeCarbohydrate = 0; 	// 하루 유지 칼로리 中 탄수화물 칼로리
		int tdeeProtein = 0;
		
		int carbKcal = 0;		// 탄수화물 식품 1개 칼로리
		int sumCarbKcal = 0;	// 탄수화물 식품 칼로리 총합
		
		int proteinKcal = 0;	// 단백질 식품 1개 칼로리
		int sumProKcal = 0;		// 단백질 식품 칼로리 총함
//		int cnt = 0;
		int memberNo = memberInfoVo1.getMemberNo();
		
		
		MemberInfoVo memberInfoVo = memberInfoService.memberInfoSelectOne(memberNo);
		
		  
//		tdeeCarbohydrate = (int)((memberInfoVo.getMemberInfoCal() - 500) * 0.5); // 탄수화물 = (유지칼로리-500) * 0.5
//		tdeeProtein = (int)((memberInfoVo.getMemberInfoCal() - 500) * 0.2);		 //	단백질 = (유지칼로리 - 500) *0.2
		
		log.debug("memberInfoVo1.getMemberInfoActivity()-{}", memberInfoVo.getMemberInfoActivity());
		switch (memberInfoVo.getMemberInfoActivity()) {
		case 1:  
			tdeeCarbohydrate = (int)(((memberInfoVo.getMemberInfoCal()*1.2) - 500) * 0.5); // 탄수화물 = (유지칼로리-500) * 0.5
			tdeeProtein = (int)(((memberInfoVo.getMemberInfoCal()*1.2) - 500) * 0.2);		 //	단백질 = (유지칼로리 - 500) *0.2
			
			break;
		case 2:  
			tdeeCarbohydrate = (int)(((memberInfoVo.getMemberInfoCal()*1.375) - 500) * 0.5); // 탄수화물 = (유지칼로리-500) * 0.5
			tdeeProtein = (int)(((memberInfoVo.getMemberInfoCal()*1.375) - 500) * 0.2);		 //	단백질 = (유지칼로리 - 500) *0.2
			break;
		case 3:  
			tdeeCarbohydrate = (int)(((memberInfoVo.getMemberInfoCal()*1.55) - 500) * 0.5); // 탄수화물 = (유지칼로리-500) * 0.5
			tdeeProtein = (int)(((memberInfoVo.getMemberInfoCal()*1.55) - 500) * 0.2);		 //	단백질 = (유지칼로리 - 500) *0.2
			
			break;
		case 4:  
			tdeeCarbohydrate = (int)(((memberInfoVo.getMemberInfoCal()*1.725) - 500) * 0.5); // 탄수화물 = (유지칼로리-500) * 0.5
			tdeeProtein = (int)(((memberInfoVo.getMemberInfoCal()*1.725) - 500) * 0.2);		 //	단백질 = (유지칼로리 - 500) *0.2
			break;
		case 5:  
			tdeeCarbohydrate = (int)(((memberInfoVo.getMemberInfoCal()*1.9) - 500) * 0.5); // 탄수화물 = (유지칼로리-500) * 0.5
			tdeeProtein = (int)(((memberInfoVo.getMemberInfoCal()*1.9) - 500) * 0.2);		 //	단백질 = (유지칼로리 - 500) *0.2
			break;
			
		default:
			break;
		}
		
		
		
		List<Map<String, Object>> carbCollection = new ArrayList<Map<String,Object>>();
			
		while(true) { //다이어트 셀렉트원 만들자
			DietVo dietVoC = dietService.selectCarbohydrate();
			Map<String, Object> dietVoCMap = new HashMap<String, Object>();
			if(sumCarbKcal < tdeeCarbohydrate) {				// 탄수총합 < TDEE-500 이면
				carbKcal = dietVoC.getDietCal();				// carbKcal에 랜덤 선택하여 담는다.'
				dietVoCMap.put("dietVoC", dietVoC);
				log.debug("map---------------------------------------------------------------------: {}", dietVoCMap.get("dietVoC"));
				carbCollection.add((Map<String, Object>) dietVoCMap);
				sumCarbKcal = sumCarbKcal + carbKcal;			// 탄수총합 = 탄수총합(이전) + carbKcal
			}else if(sumCarbKcal == tdeeCarbohydrate) {			// 탄총 == T-5
										
				break;
			}else {
				sumCarbKcal = sumCarbKcal - carbKcal;
				break;
			}
			
			model.addAttribute("dietVoCMap", dietVoCMap);
			
		}
		log.debug("sumCarbKcal ================================================================={}", sumCarbKcal);
		
		model.addAttribute("carbCollection", carbCollection);
		
		// 단백질
		List<Map<String, Object>> proCollection = new ArrayList<Map<String,Object>>();
		
		
		while(true) { //다이어트 셀렉트원 만들자
			DietVo dietVoP = dietService.selectProtein();
			Map<String, Object> dietVoPMap = new HashMap<String, Object>();
			if(sumProKcal < tdeeProtein) {							// 단백총합 < TDEE-500 이면
				proteinKcal = dietVoP.getDietCal();	// proteinKcal에 랜덤 선택하여 담는다.
				dietVoPMap.put("dietVoP", dietVoP);
				proCollection.add((Map<String, Object>) dietVoPMap);
				sumProKcal = sumProKcal + proteinKcal;						// 단백총합 = 단백총합(이전) + proteinKcal
			}else if(sumProKcal == tdeeProtein) {						// 단백총 == T-5
				
				break;
			}else {
				sumProKcal = sumProKcal - proteinKcal;
				break;
			}
			
			model.addAttribute("dietVoPMap", dietVoPMap);
		}
			
		log.debug("sumProKcal ================================================================={}", sumProKcal);
		model.addAttribute("proCollection", proCollection);
		
		return viewUrl;
	}

}
