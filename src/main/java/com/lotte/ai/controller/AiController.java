package com.lotte.ai.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lotte.ai.dto.AnalysisImageDTO;
import com.lotte.ai.service.AiService;
import com.lotte.ai.service.EmotionService;

import file.Client;
import file.HandlerFile;

@RestController
public class AiController {
	
	@Autowired
	AiService service;
	
	@GetMapping("/test")
	public String test() {
		System.out.println("get");
		return "hello";
	}
	
	@PostMapping("/test2")
	public String test2() {
		System.out.println("post");
		return "hello";
	}
	
	@PostMapping("/hello")
	public List<AnalysisImageDTO> hello(MultipartHttpServletRequest sourceFile, HttpServletRequest request) throws IOException {
		String fileName = service.uploadFile(sourceFile);
		List<AnalysisImageDTO> resultParam = service.fileRecognize(fileName);
		
		System.out.println(resultParam.toString());
		return resultParam;
	}
}
