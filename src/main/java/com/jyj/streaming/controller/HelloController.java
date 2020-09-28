package com.jyj.streaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.CharacterEncodingFilter;

@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String hello(Model model) {
		System.out.println(1)
		model.addAttribute("greeting", "안녕하세요");
		return "hello";
	}
}
