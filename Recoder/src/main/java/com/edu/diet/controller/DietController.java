package com.edu.diet.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.diet.service.DietService;
import com.edu.diet.vo.DietVo;

@Controller
public class DietController {

	private final Logger log = LoggerFactory.getLogger(DietController.class);

	@Autowired
	private DietService dietService;

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

}
