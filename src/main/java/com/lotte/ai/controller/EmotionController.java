package com.lotte.ai.controller;

import java.util.HashMap;

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
	public int test(@RequestBody HashMap<String, String> param) {
		return service.userRegist(param);
	}
}
