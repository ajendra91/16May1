package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/mylogin")
	public String mu(){
		return "login";
	}

	
	
	@RequestMapping("/admin")
	public String hello() {
		return "admin";
	}
	
	
	
}
