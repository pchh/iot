package com.lotte.ai.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lotte.ai.dto.AnalysisDTO;
import com.lotte.ai.service.AiService;

@RestController
public class AiController {
	
	@Autowired
	AiService service;
	
	@GetMapping("/test")
	public String test() {
		return "hello";
	}
	
	@PostMapping("/test2")
	public String test2() {
		return "hello";
	}
	
	@PostMapping("/analysisshoes")
	public AnalysisDTO hello(MultipartHttpServletRequest sourceFile, HttpServletRequest request) throws IOException {
		String fileName = service.uploadFile(sourceFile);
		AnalysisDTO resultParam = service.fileRecognize(fileName);
		
		System.out.println(resultParam.toString());
		return resultParam;
	}
}
