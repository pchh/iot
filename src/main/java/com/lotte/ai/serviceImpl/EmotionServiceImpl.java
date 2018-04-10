package com.lotte.ai.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lotte.ai.mapper.EmotionMapper;
import com.lotte.ai.service.EmotionService;

@Service
public class EmotionServiceImpl implements EmotionService {
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
		return mapper.faceEmotionRegist(param);
	}
}
