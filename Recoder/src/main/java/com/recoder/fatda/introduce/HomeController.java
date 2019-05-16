package com.recoder.fatda.introduce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping(value="/introduce/home.do")
	public String introduce() {
		
		return "/common/introduce";
	}
}
