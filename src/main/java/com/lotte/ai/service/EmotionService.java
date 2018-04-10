package com.lotte.ai.service;

import java.util.HashMap;
import java.util.List;

public interface EmotionService {
	int userRegist(HashMap<String, String> param);

	List<HashMap<String, Object>> emotionList(HashMap<String, String> param);

	int faceEmotionRegist(HashMap<String, String> param);
}
