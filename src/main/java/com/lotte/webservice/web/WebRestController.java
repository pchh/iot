package com.lotte.webservice.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lotte.webservice.web.vo.AnalysisImageVO;

@RestController
public class WebRestController {
	
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
	public List<AnalysisImageVO> hello(@RequestPart MultipartFile sourceFile, HttpServletRequest request) throws IOException {
		System.out.println("ㅇㅇ?");
		String sourceFileName = sourceFile.getOriginalFilename(); 
		String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase(); 
		File destinationFile; 
		String destinationFileName;
		String path;
		do { 
			destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension; 
			path = request.getSession().getServletContext().getRealPath("/");
			destinationFile = new File("c:/attach/" + destinationFileName);
		} while (destinationFile.exists()); 
		System.out.println("dd : " + path);
		destinationFile.getParentFile().mkdirs();
		sourceFile.transferTo(destinationFile);
		
		ArrayList<AnalysisImageVO> resultParam = new ArrayList<AnalysisImageVO>();
		AnalysisImageVO result = new AnalysisImageVO().setTop1(1)
													  .setTop1Pr(0.8);
		System.out.println(result.toString());
		resultParam.add(result);
		return resultParam;
	}
}
