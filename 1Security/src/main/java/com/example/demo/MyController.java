package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(value="/do", method=RequestMethod.POST)
	public String dosome() {
		return "success post";
	}

}
