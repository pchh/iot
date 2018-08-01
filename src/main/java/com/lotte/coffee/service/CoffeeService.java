package com.lotte.coffee.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lotte.coffee.dto.CoffeeDTO;
import com.lotte.coffee.dto.NoticeBoardDTO;
import com.lotte.coffee.dto.QuizDTO;

public interface CoffeeService {
	Map<String, String> selectMember(HashMap<String, String> param);
	int insertMember(HashMap<String, String> param);
	int checkExistMember(String mem_id);
	List<CoffeeDTO> selectGoods();
	int insertMenu(HashMap<String, String> param);
	List<Map<String, String>> selectSales();
	List<QuizDTO> selectQuiz();
	List<NoticeBoardDTO> selectBoard(String menuGroupId);
}
