package com.lotte.ai.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmotionMapper {
	int userRegist(HashMap<String, String> param);

	List<HashMap<String, Object>> emotionList(HashMap<String, String> param);

	int faceEmotionRegist(HashMap<String, String> param);
	
	int faceFileReigst(HashMap<String, String> param);
}
