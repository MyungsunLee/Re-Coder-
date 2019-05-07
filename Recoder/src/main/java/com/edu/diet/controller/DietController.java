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
		int tdeeFat = 0;
		
		int carbKcal = 0;		// 탄수화물 식품 1개 칼로리
		int sumCarbKcal = 0;	// 탄수화물 식품 칼로리 총합
		
		int proteinKcal = 0;	// 단백질 식품 1개 칼로리
		int sumProKcal = 0;		// 단백질 식품 칼로리 총함
		
		int fatKcal = 0;
		int sumFatKcal = 0;
		int memberNo = memberInfoVo1.getMemberNo();
		
		
		MemberInfoVo memberInfoVo = memberInfoService.memberInfoSelectOne(memberNo);
		
		  
//		tdeeCarbohydrate = (int)((memberInfoVo.getMemberInfoCal() - 500) * 0.5); // 탄수화물 = (유지칼로리-500) * 0.5
//		tdeeProtein = (int)((memberInfoVo.getMemberInfoCal() - 500) * 0.3);		 //	단백질 = (유지칼로리 - 500) *0.3
		
		log.debug("memberInfoVo1.getMemberInfoActivity()-{}", memberInfoVo.getMemberInfoActivity());
		switch (memberInfoVo.getMemberInfoActivity()) {										// 유지칼로리 계산
		case 1:  
			tdeeCarbohydrate = (int)(((memberInfoVo.getMemberInfoCal()*1.2) - 500) * 0.5); // 탄수화물 = (유지칼로리-500) * 0.5
			tdeeProtein = (int)(((memberInfoVo.getMemberInfoCal()*1.2) - 500) * 0.3);		 //	단백질 = (유지칼로리 - 500) *0.3
			tdeeFat = (int)(((memberInfoVo.getMemberInfoCal()*1.2) - 500) * 0.2);		 //	지방 = (유지칼로리 - 500) *0.2
			
			break;
		case 2:  
			tdeeCarbohydrate = (int)(((memberInfoVo.getMemberInfoCal()*1.375) - 500) * 0.5); // 탄수화물 = (유지칼로리-500) * 0.5
			tdeeProtein = (int)(((memberInfoVo.getMemberInfoCal()*1.375) - 500) * 0.3);		 //	단백질 = (유지칼로리 - 500) *0.3
			tdeeFat = (int)(((memberInfoVo.getMemberInfoCal()*1.375) - 500) * 0.2);		 //	지방 = (유지칼로리 - 500) *0.2
			break;
		case 3:  
			tdeeCarbohydrate = (int)(((memberInfoVo.getMemberInfoCal()*1.55) - 500) * 0.5); // 탄수화물 = (유지칼로리-500) * 0.5
			tdeeProtein = (int)(((memberInfoVo.getMemberInfoCal()*1.55) - 500) * 0.3);		 //	단백질 = (유지칼로리 - 500) *0.3
			tdeeFat = (int)(((memberInfoVo.getMemberInfoCal()*1.55) - 500) * 0.2);		 //	지방 = (유지칼로리 - 500) *0.2
			
			break;
		case 4:  
			tdeeCarbohydrate = (int)(((memberInfoVo.getMemberInfoCal()*1.725) - 500) * 0.5); // 탄수화물 = (유지칼로리-500) * 0.5
			tdeeProtein = (int)(((memberInfoVo.getMemberInfoCal()*1.725) - 500) * 0.3);		 //	단백질 = (유지칼로리 - 500) *0.3
			tdeeFat = (int)(((memberInfoVo.getMemberInfoCal()*1.725) - 500) * 0.2);		 //	지방 = (유지칼로리 - 500) *0.2
			break;
		case 5:  
			tdeeCarbohydrate = (int)(((memberInfoVo.getMemberInfoCal()*1.9) - 500) * 0.5); // 탄수화물 = (유지칼로리-500) * 0.5
			tdeeProtein = (int)(((memberInfoVo.getMemberInfoCal()*1.9) - 500) * 0.3);		 //	단백질 = (유지칼로리 - 500) *0.3
			tdeeFat = (int)(((memberInfoVo.getMemberInfoCal()*1.9) - 500) * 0.2);		 //	지방 = (유지칼로리 - 500) *0.2
			break;
			
		default:
			break;
		}
		
		
		
		List<Map<String, Object>> carbCollection = new ArrayList<Map<String,Object>>();
			
		while(true) { //다이어트 셀렉트원 만들자
			DietVo dietVoC = dietService.selectCarbohydrate();
			Map<String, Object> dietVoCMap = new HashMap<String, Object>();
			if(tdeeCarbohydrate > sumCarbKcal) {				// 탄수총합 < TDEE-500 이면
				carbKcal = dietVoC.getDietCal();				// carbKcal에 랜덤 선택하여 담는다.'
				dietVoCMap.put("dietVoC", dietVoC);
				log.debug("map---------------------------------------------------------------------: {}", dietVoCMap.get("dietVoC"));
				carbCollection.add((Map<String, Object>) dietVoCMap);
				sumCarbKcal = sumCarbKcal + carbKcal;			// 탄수총합 = 탄수총합(이전) + carbKcal
			}else if(tdeeCarbohydrate == sumCarbKcal) {			// 탄총 == T-5
										
				break;
			}else {
				if((tdeeCarbohydrate - sumCarbKcal) <= 100) {	// (TDEE-500) - 탄수총합 의 칼로리가 100 이하면 그대로 내보낸다  
					break;
				}else {							
					sumCarbKcal = sumCarbKcal - carbKcal;		// 아니면 
					break;
				}
			}
			
			model.addAttribute("dietVoCMap", dietVoCMap);
			
		}
		
		// DB에서 식단목록 가져오기
		List<DietVo> dietVoList =  dietService.dietSelectList();
		
		
		Map<String, Integer> carbDietVoCntMap = new HashMap();
		Map<String, Integer> carbDietVoCalMap = new HashMap();
		for (DietVo dietVo2 : dietVoList) {
			int dietNameCnt = 0;	//음식의 갯수를 저장할 변수 생성
			int dietNameCal = 0;
			
			DietVo tempDietVo = null;
			for (int i = 0; i < carbCollection.size(); i++) { //가챠 스타트
				Map<String, Object> map = (Map<String, Object>)carbCollection.get(i);
								
				tempDietVo = (DietVo)map.get("dietVoC");
				if(dietVo2.getDietName().equals(tempDietVo.getDietName())) { // 
					dietNameCnt = dietNameCnt + 1;
					dietNameCal = dietVo2.getDietCal() + dietNameCal;
				}
				
			}
			
			if(dietNameCnt != 0) {
				carbDietVoCntMap.put(dietVo2.getDietName(), dietNameCnt); // vo형식으로 ||
				carbDietVoCalMap.put(dietVo2.getDietName(), dietNameCal); // vo형식으로 ||
		
			}
			
//			dietNameCntInfoList.add(newDietVoCMap);
		}
		model.addAttribute("carbDietVoCntMap", carbDietVoCntMap);
		model.addAttribute("carbDietVoCalMap", carbDietVoCalMap);
		
		log.debug("sumCarbKcal ================================================================={}", sumCarbKcal);
		model.addAttribute("carbCollection", carbCollection);
		
		
		// 단백질
		List<Map<String, Object>> proCollection = new ArrayList<Map<String,Object>>();
		
		
		while(true) { //다이어트 셀렉트원 만들자
			DietVo dietVoF = dietService.selectProtein();
			Map<String, Object> dietVoFMap = new HashMap<String, Object>();
			if(sumProKcal < tdeeProtein) {							// 단백총합 < TDEE-500 이면
				proteinKcal = dietVoF.getDietCal();	// proteinKcal에 랜덤 선택하여 담는다.
				dietVoFMap.put("dietVoF", dietVoF);
				proCollection.add((Map<String, Object>) dietVoFMap);
				sumProKcal = sumProKcal + proteinKcal;						// 단백총합 = 단백총합(이전) + proteinKcal
			}else if(sumProKcal == tdeeProtein) {						// 단백총 == T-5
				
				break;
			}else {
				if((tdeeProtein - sumProKcal) <= 100) {	// (TDEE-500) - 단백총합 의 칼로리가 100 이하면 그대로 내보낸다  
					break;
				}else {							
					sumProKcal = sumProKcal - proteinKcal;		// 아니면 
					break;
				}
			}
			
			model.addAttribute("dietVoFMap", dietVoFMap);
		}
			
		log.debug("sumProKcal ================================================================={}", sumProKcal);
		
		
		Map<String, Integer> proDietVoCntMap = new HashMap();
		Map<String, Integer> proDietVoCalMap = new HashMap();
		
		for (DietVo dietVo2 : dietVoList) {
			int dietNameCnt = 0;	//음식의 갯수를 저장할 변수 생성
			int dietNameCal = 0;
			
			DietVo tempDietVo = null;
			for (int i = 0; i < proCollection.size(); i++) { //가챠 스타트
				Map<String, Object> map = (Map<String, Object>)proCollection.get(i);
								
				tempDietVo = (DietVo)map.get("dietVoF");
				if(dietVo2.getDietName().equals(tempDietVo.getDietName())) { // 
					dietNameCnt = dietNameCnt + 1;
					dietNameCal = dietVo2.getDietCal() + dietNameCal;
				}
				
			}
			
			if(dietNameCnt != 0) {
				proDietVoCntMap.put(dietVo2.getDietName(), dietNameCnt); // vo형식으로 ||
				proDietVoCalMap.put(dietVo2.getDietName(), dietNameCal); // vo형식으로 ||
		
			}
			
//			dietNameCntInfoList.add(newDietVoCMap);
		}
		model.addAttribute("proDietVoCntMap", proDietVoCntMap);
		model.addAttribute("proDietVoCalMap", proDietVoCalMap);
		
		model.addAttribute("proCollection", proCollection);

		
		// 지방
		List<Map<String, Object>> fatCollection = new ArrayList<Map<String,Object>>();
		
		
		while(true) { //다이어트 셀렉트원 만들자
			DietVo dietVoF = dietService.selectProtein();
			Map<String, Object> dietVoFMap = new HashMap<String, Object>();
			if(sumFatKcal < tdeeFat) {							// 단백총합 < TDEE-500 이면
				fatKcal = dietVoF.getDietCal();	// fatKcal에 랜덤 선택하여 담는다.
				dietVoFMap.put("dietVoF", dietVoF);
				fatCollection.add((Map<String, Object>) dietVoFMap);
				sumFatKcal = sumFatKcal + fatKcal;						// 단백총합 = 단백총합(이전) + fatKcal
			}else if(sumFatKcal == tdeeFat) {						// 단백총 == T-5
				
				break;
			}else {
				if((tdeeFat - sumFatKcal) <= 100) {	// (TDEE-500) - 단백총합 의 칼로리가 100 이하면 그대로 내보낸다  
					break;
				}else {							
					sumFatKcal = sumFatKcal - fatKcal;		// 아니면 
					break;
				}
			}
			
			model.addAttribute("dietVoFMap", dietVoFMap);
		}
		
		log.debug("sumFatKcal ================================================================={}", sumFatKcal);
		
		
		Map<String, Integer> fatDietVoCntMap = new HashMap();
		Map<String, Integer> fatDietVoCalMap = new HashMap();
		
		for (DietVo dietVo2 : dietVoList) {
			int dietNameCnt = 0;	//음식의 갯수를 저장할 변수 생성
			int dietNameCal = 0;
			
			DietVo tempDietVo = null;
			for (int i = 0; i < fatCollection.size(); i++) { //가챠 스타트
				Map<String, Object> map = (Map<String, Object>)fatCollection.get(i);
				
				tempDietVo = (DietVo)map.get("dietVoF");
				if(dietVo2.getDietName().equals(tempDietVo.getDietName())) { // 
					dietNameCnt = dietNameCnt + 1;
					dietNameCal = dietVo2.getDietCal() + dietNameCal;
				}
				
			}
			
			if(dietNameCnt != 0) {
				fatDietVoCntMap.put(dietVo2.getDietName(), dietNameCnt); // vo형식으로 ||
				fatDietVoCalMap.put(dietVo2.getDietName(), dietNameCal); // vo형식으로 ||
				
			}
			
//			dietNameCntInfoList.add(newDietVoCMap);
		}
		model.addAttribute("fatDietVoCntMap", fatDietVoCntMap);
		model.addAttribute("fatDietVoCalMap", fatDietVoCalMap);
		
		model.addAttribute("fatCollection", fatCollection);
		
		return viewUrl;
	}

}
