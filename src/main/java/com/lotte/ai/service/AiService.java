package com.lotte.ai.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lotte.ai.dto.AnalysisImageDTO;

public interface AiService {
	String uploadFile(MultipartHttpServletRequest sourceFile);
	
	List<AnalysisImageDTO> fileRecognize(String fileName);
}
