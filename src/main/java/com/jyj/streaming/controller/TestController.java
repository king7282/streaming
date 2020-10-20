package com.jyj.streaming.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	
	@RequestMapping(value="/{ID}/setScreen", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> setScreen(@PathVariable String ID, String image) throws IOException {
		HashMap<String, Object> result = new HashMap<>();
		
		broadcastService.setImageToVideo(ID, image);
		
		result.put("data", "HI");
		return result;
	}
	
}
