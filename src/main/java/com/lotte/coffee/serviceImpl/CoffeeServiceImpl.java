package com.lotte.coffee.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lotte.coffee.dto.CoffeeDTO;
import com.lotte.coffee.dto.NoticeBoardDTO;
import com.lotte.coffee.dto.QuizDTO;
import com.lotte.coffee.mapper.CoffeeMapper;
import com.lotte.coffee.service.CoffeeService;

@Service
public class CoffeeServiceImpl implements CoffeeService {

	@Autowired
	CoffeeMapper mapper;
	
	@Override
	public Map<String, String> selectMember(HashMap<String, String> param) {
		return mapper.selectMember(param);
	}
	@Override
	public int insertMember(HashMap<String, String> param) {
		return mapper.insertMember(param);
	}
	@Override
	public int checkExistMember(String mem_id) {
		return mapper.checkExistMember(mem_id);
	}
	@Override
	public List<CoffeeDTO> selectGoods() {
		return mapper.selectGoods();
	}
	@Override
	public int insertMenu(HashMap<String, String> param) {
		return mapper.insertMenu(param);
	}
	@Override
	public List<Map<String, String>> selectSales() {
		return mapper.selectSales();
	}
	@Override
	public List<QuizDTO> selectQuiz() {
		return mapper.selectQuiz();
	}
	@Override
	public List<NoticeBoardDTO> selectBoard(String menuGroupId) {
		return mapper.selectBoard(menuGroupId);
	}

}
