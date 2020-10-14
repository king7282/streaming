package com.jyj.streaming.service;

import org.springframework.stereotype.Service;

@Service
public class BroadcastService {
	
	private int broadcastCount = 0;
	
	public String generateBroadcastID() {
		broadcastCount++;
		return Integer.toString(broadcastCount);
	}
}
