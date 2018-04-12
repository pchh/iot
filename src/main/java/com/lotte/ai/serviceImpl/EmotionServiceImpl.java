package com.lotte.ai.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lotte.ai.mapper.EmotionMapper;
import com.lotte.ai.service.EmotionService;

import file.HandlerFile;

@Service
public class EmotionServiceImpl implements EmotionService {
	private static final String FILE_PATH = "c:/home/tensorflow2018/datasets/face/fromusers";
	private static final String AGE_GROUP_FILE_PATH = "c:/home/tensorflow2018/datasets/face/age_group";
	private static final String GENDER_FILE_PATH = "c:/home/tensorflow2018/datasets/face/gender";
	private static final String EMOTION_FILE_PATH = "c:/home/tensorflow2018/datasets/face/emotion";
	private static Map<String, String> gender;
	
	static {
		gender = new HashMap<String, String>();
		gender.put("10", "남자");
		gender.put("20", "여자");
	}
	
	@Autowired
	EmotionMapper mapper;
	
	@Override
	public int userRegist(HashMap<String, String> param) {
		return mapper.userRegist(param);
	}

	@Override
	public List<HashMap<String, Object>> emotionList(HashMap<String, String> param) {
		return mapper.emotionList(param);
	}

	@Override
	public int faceEmotionRegist(HashMap<String, String> param) {
		System.out.println(param);
		mapper.faceFileReigst(param);
		return mapper.faceEmotionRegist(param);
	}

	@Override
	public String uploadFile(MultipartHttpServletRequest sourceFile, HashMap<String, String> param) {
		StringBuilder sb = new StringBuilder();
		String fileName = sb.append(param.get("userBirthday").replaceAll("-", ""))
							.append("_")
							.append(param.get("userName"))
							.append("_")
							.append(gender.get(param.get("userSex")))
							.append(UUID.randomUUID().toString())
							.append(".jpg")
							.toString();
		
		HandlerFile handlerFile = new HandlerFile(sourceFile, FILE_PATH, fileName);
		String resultFileName = handlerFile.getUploadFileName(fileName);
		System.out.println(resultFileName);
		
		fileCopy(resultFileName, AGE_GROUP_FILE_PATH + "/" + fileName);
		fileCopy(resultFileName, GENDER_FILE_PATH + "/" + fileName);
		fileCopy(resultFileName, EMOTION_FILE_PATH + "/" + fileName);
		
		return fileName;
	}
	
	public static void fileCopy(String orgFilePath, String newFilePath) {
	    try{
	    	File originalFile = new File(orgFilePath);
	    	File newFile = new File(newFilePath);
	    	newFile.getParentFile().mkdirs();
	    	
	        FileInputStream inputStream = new FileInputStream(originalFile);
	        FileOutputStream outputStream = new FileOutputStream(newFile, false); 
	        
	        FileChannel fcin =  inputStream.getChannel();
	        FileChannel fcout = outputStream.getChannel(); 
	        
	        long size = fcin.size();
	        fcin.transferTo(0, size, fcout); 
	        
	        fcout.close();
	        fcin.close(); 
	        
	        outputStream.close();
	        inputStream.close();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}

}
