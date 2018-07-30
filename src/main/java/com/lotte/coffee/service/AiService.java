package com.lotte.ai.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lotte.ai.dto.AnalysisDTO;

public interface AiService {
	String uploadFile(MultipartHttpServletRequest sourceFile);
	
	AnalysisDTO fileRecognize(String fileName);
}
