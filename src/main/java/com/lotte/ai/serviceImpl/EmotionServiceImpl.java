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
}
