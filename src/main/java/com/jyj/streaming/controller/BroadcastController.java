package com.jyj.streaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/Broadcast")
public class BroadcastController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String broadcast(Model model) {
		return "broadcast";
	}
	
	@RequestMapping(value="/{ID}", method=RequestMethod.GET)
	public String watchBroadcast(Model model, @PathVariable String ID) {
		model.addAttribute("ID", ID);
		return "watch_broadcast";
	}
}
