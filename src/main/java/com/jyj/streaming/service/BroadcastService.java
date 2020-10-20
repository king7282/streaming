package com.jyj.streaming.service;

import java.io.File;
import java.io.IOException;

import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BroadcastService {
	
	private int broadcastCount = 0;
	
	public String generateBroadcastID() {
		broadcastCount++;
		return Integer.toString(broadcastCount);
	}
	
	public void setImageToVideo(String ID, String base64Image) throws IOException {
		File file = new File("C:/tmp", "tmpImage");
		byte[] image = Base64.decode(base64Image.split(",")[1].getBytes());
		FileCopyUtils.copy(image, file);
	}
}
