package com.lotte.ai.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lotte.ai.service.EmotionService;

@RestController
public class EmotionController {
	@Autowired
	EmotionService service;
	
	@PostMapping("/userregist")
	public int userRegist(@RequestBody HashMap<String, String> param) {
		return service.userRegist(param);
	}
	
	@PostMapping("/emotionlist")
	public List<HashMap<String, Object>> emotionList(@RequestBody HashMap<String, String> param) {
		return service.emotionList(param);
	}
	
	@PostMapping("/facefileregist")
	public int faceEmotionRegist(MultipartHttpServletRequest sourceFile, 
								 @RequestPart("userName") String userName,
								 @RequestPart("userBirthday") String userBirthday,
								 @RequestPart("userSex") String userSex,
								 @RequestPart("emotion") String emotion) {

		HashMap<String, String> param = new HashMap<String, String>();
		param.put("userName", userName);
		param.put("userBirthday", userBirthday);
		param.put("userSex", userSex);
		param.put("emotion", emotion);
		String fileName = service.uploadFile(sourceFile, param);
		param.put("fileName", fileName);
		return service.faceEmotionRegist(param);
	}
}
