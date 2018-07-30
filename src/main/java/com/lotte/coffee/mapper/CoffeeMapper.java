package com.lotte.coffee.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.lotte.coffee.dto.CoffeeDTO;

@Mapper
public interface CoffeeMapper {
	Map<String, String> selectMember(HashMap<String, String> param);
	int insertMember(HashMap<String, String> param);
	int checkExistMember(String mem_id);
	List<CoffeeDTO> selectGoods();
	int insertMenu(HashMap<String, String> param);
	List<Map<String, String>> selectSales();
	List<Map<String, String>> selectSales2();
}
