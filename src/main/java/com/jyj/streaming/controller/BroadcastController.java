package com.jyj.streaming.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyj.streaming.service.BroadcastService;

@Controller
@RequestMapping(value="/Broadcast")
public class BroadcastController {
	@Autowired
	private BroadcastService broadcastService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String broadcast(Model model) {
		model.addAttribute("ID", broadcastService.generateBroadcast());
		return "broadcast";
	}
	
	@RequestMapping(value="/{ID}", method=RequestMethod.GET)
	public String watchBroadcast(Model model, @PathVariable String ID) {
		model.addAttribute("ID", ID);
		return "watch_broadcast";
	}
	
	@RequestMapping(value="/{ID}/setScreen", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> setScreen(@PathVariable String ID, @RequestParam String image) throws IOException, InterruptedException {
		HashMap<String, Object> result = new HashMap<>();
		
		broadcastService.setScreen(ID, image);
		
		result.put("result", "Success");
		return result;
	}
	
	@RequestMapping(value="/{ID}/getScreen", method=RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> getScreen(@PathVariable String ID, String time) throws IOException {
		HashMap<String, Object> result = new HashMap<>();
		String image = broadcastService.getScreen(ID, new Integer(time));
		
		result.put("image", image);
		result.put("result", "Success");
		return result;
	}
	
	@RequestMapping(value="/{ID}/config", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> setConfig(@PathVariable String ID, int delay) {
		HashMap<String, Object> result = new HashMap<>();
		
		broadcastService.setDelay(ID, delay);
		
		result.put("result", "Success");
		return result;
	}
	
}
