package com.jyj.streaming.dto;

public class BroadcastDto {
	private String ID;
	private String fileName;
	private int delay;
	private Integer curTime;
	private final int mod = 60000;
	
	public BroadcastDto(String ID, String fileName) {
		this.ID = ID;
		this.fileName = fileName;
		this.delay = 0;
		this.curTime = 0;
	}
	
	public void setDelay(int delay) {
		this.delay = delay;
	}
	
	public int getDelay() {
		return this.delay;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public int increment() {
		int cur = 0;
		synchronized(this.curTime) {
			cur = this.curTime;
			this.curTime = (this.curTime + 1) % mod;
		}
		return cur;
	}
	
	public int getSpecificTime(int time) {
		int result = 0;
		synchronized(this.curTime) {
			result = (this.curTime - time - delay + mod) % mod;
		}
		return result;
	}
}
