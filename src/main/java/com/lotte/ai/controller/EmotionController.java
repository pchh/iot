package com.lotte.ai.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/")
	public int faceEmotionRegist(@RequestBody HashMap<String, String> param) {
		return service.faceEmotionRegist(param);
	}
}
