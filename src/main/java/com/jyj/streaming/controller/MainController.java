package com.jyj.streaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/Main")
	public String main(Model model) {
		return "main";
	}
}
