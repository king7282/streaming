package com.jyj.streaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jyj.streaming.service.BroadcastService;

@Controller
@RequestMapping(value="/Broadcast")
public class BroadcastController {
	@Autowired
	private BroadcastService broadcastService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String broadcast(Model model) {
		String ID = broadcastService.generateBroadcast();
		model.addAttribute("ID", ID);
		return "broadcast";
	}
	
	@RequestMapping(value="/{ID}", method=RequestMethod.GET)
	public String watchBroadcast(Model model, @PathVariable String ID) {
		model.addAttribute("ID", ID);
		return "watch_broadcast";
	}
	
}
