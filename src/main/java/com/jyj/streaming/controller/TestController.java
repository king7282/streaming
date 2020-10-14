package com.jyj.streaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jyj.streaming.service.BroadcastService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private BroadcastService broadcastService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("ID", broadcastService.generateBroadcastID());
		return "test";
	}
	
	@RequestMapping(value="/{ID}/setScreen", method=RequestMethod.PUT)
	public void setScreen(@PathVariable String ID) {
		
	}
	
}
