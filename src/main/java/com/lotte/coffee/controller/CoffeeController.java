package com.lotte.coffee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lotte.coffee.dto.CoffeeDTO;
import com.lotte.coffee.dto.NoticeBoardDTO;
import com.lotte.coffee.dto.QuizDTO;
import com.lotte.coffee.service.CoffeeService;

@Controller
public class CoffeeController {
	@Autowired
	CoffeeService service;
	
	@ResponseBody
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public ModelAndView main(@RequestParam Map<String, String> param) {
		ModelAndView mav = new ModelAndView();
		List<CoffeeDTO> goodsList = service.selectGoods();
		mav.setViewName("hello");
		mav.addObject(goodsList);
		mav.addAllObjects(param);
		return mav;
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public ModelAndView join() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("join");
		return mav;
	}
	@RequestMapping(value="/logintest", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> loginTest(@RequestBody HashMap<String, String> param) {
		Map<String, String> member = service.selectMember(param);
		return member;
	}
	@RequestMapping(value="/insertMember", method=RequestMethod.POST)
	public ModelAndView insertMember(@RequestBody HashMap<String, String> param) {
 		ModelAndView mav = new ModelAndView();
		int insertYn = service.insertMember(param);
		mav.setViewName("hello");
		return mav;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/checkMemId", method=RequestMethod.POST)
	public int checkMemId(@RequestBody String mem_id) {
		ModelAndView mav = new ModelAndView();
		int existYn = service.checkExistMember(mem_id);
		mav.addObject("existYn",existYn);
		mav.setViewName("join");
		return existYn;
	}
	@RequestMapping(value="/master", method=RequestMethod.GET)
	public ModelAndView master() {
		ModelAndView mav = new ModelAndView();
		List<CoffeeDTO> goodsList = service.selectGoods();
		List<Map<String, String>> sales = service.selectSales();
		mav.addObject(goodsList);
		mav.addObject(sales);
		mav.setViewName("master");
		return mav;
	}
	
	@RequestMapping(value="/insertMenu", method=RequestMethod.POST)
	public ModelAndView insertMenu(@RequestBody HashMap<String, String> param) {
 		ModelAndView mav = new ModelAndView();
		int insertYn = service.insertMenu(param);
		mav.setViewName("master");
		return mav;
	}
	
	@RequestMapping(value="/shortManage", method=RequestMethod.GET)
	public ModelAndView shortManage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shortManage");
		return mav;
	}
	
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public ModelAndView info() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("info");
		return mav;
	}
	@ResponseBody
	@RequestMapping(value="/board/{menuGroupId}", method=RequestMethod.GET)
	public ModelAndView board(@PathVariable("menuGroupId") String menuGroupId){
		ModelAndView mav = new ModelAndView();
		List<NoticeBoardDTO> boardList = service.selectBoard(menuGroupId);
		mav.addObject(boardList);
		mav.setViewName("board");
		return mav;
	}
	@ResponseBody
	@RequestMapping(value = "/boardWrite", method=RequestMethod.GET)
	public ModelAndView boardWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardWrite");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/quiz", method=RequestMethod.GET)
	public ModelAndView quiz() {
		ModelAndView mav = new ModelAndView();
		List<QuizDTO> quizList = service.selectQuiz();
		mav.addObject(quizList);
		mav.setViewName("quiz");
		return mav;
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public ModelAndView insertBoard(@RequestBody HashMap<String, String> param) {
 		ModelAndView mav = new ModelAndView();
		int insertYn = service.insertBoard(param);
		mav.setViewName("master");
		return mav;
	}	
}
