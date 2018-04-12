package com.lotte.ai.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface EmotionService {
	int userRegist(HashMap<String, String> param);

	List<HashMap<String, Object>> emotionList(HashMap<String, String> param);

	int faceEmotionRegist(HashMap<String, String> param);
	
	String uploadFile(MultipartHttpServletRequest sourceFile, HashMap<String, String> param);
}
