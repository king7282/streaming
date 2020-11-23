package com.jyj.streaming.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jyj.streaming.dto.BroadcastDto;

import io.humble.video.Codec;
import io.humble.video.Demuxer;
import io.humble.video.DemuxerFormat;
import io.humble.video.Encoder;
import io.humble.video.MediaPacket;
import io.humble.video.MediaPicture;
import io.humble.video.Muxer;
import io.humble.video.MuxerFormat;
import io.humble.video.PixelFormat;
import io.humble.video.Rational;
import io.humble.video.awt.MediaPictureConverter;
import io.humble.video.awt.MediaPictureConverterFactory;

@Service
public class BroadcastService {
	private HashMap<String, BroadcastDto> map = new HashMap<>();
	private int broadcastCount = 0;
	private final String fileLocation = "C:/tmp/";
	private final String blackPicture = "data:image/gif;base64,R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs=";
	
	public String generateBroadcast() {
		broadcastCount++;
		String ID = Integer.toString(broadcastCount);
		BroadcastDto broadcast = new BroadcastDto(ID, ID);
		map.put(ID, broadcast);
		return ID;
	}
	
	public void setDelay(String ID, int delay) {
		map.get(ID).setDelay(delay);
	}
	
	public void setScreen(String ID, String base64Image) throws IOException {
		File file = new File(fileLocation, map.get(ID).getFileName() + "_" + map.get(ID).increment());
		FileOutputStream fos = new FileOutputStream(file);
		
		fos.write(base64Image.getBytes());
		fos.flush();
		fos.getFD().sync();
		fos.close();
	}
	
	public String getScreen(String ID, int time) throws IOException {
		if(map.get(ID) == null) {
			return blackPicture;
		}
		
		String fileName = fileLocation + ID + "_" + map.get(ID).getSpecificTime(time + 10);
		File file = new File(fileName);
		if(!file.exists())
			return blackPicture;
		
		FileReader reader = new FileReader(file);
		int cur;
		StringBuilder content = new StringBuilder();
		
		while((cur = reader.read()) != -1) {
			content.append((char)cur);
		}
		reader.close();
		return content.toString();
	}
}
