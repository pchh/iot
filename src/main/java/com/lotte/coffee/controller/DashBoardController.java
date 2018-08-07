package com.lotte.coffee.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.lotte.coffee.service.DashBoardService;


@Controller
public class DashBoardController {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@Autowired
	private DashBoardService dashboardService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainPage() {
		return "DashBoard";
	}

	@RequestMapping(value = "/dashboard/{type}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void dashboard(@RequestBody String body, @RequestHeader HttpHeaders headers, @PathVariable String type) throws Exception {
	    System.out.println(body);
		String content = dashboardService.subscriptionParser(body, type);
		if (content.equals("delete")) {
		} else {
			HttpEntity<String> entity = new HttpEntity<String>(content, headers);
			this.template.convertAndSend("/topic/subscribe", entity);
		}
		
	}

	
	@RequestMapping(value = "/sendcommand", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void sendToplug(@RequestBody String body, @RequestHeader HttpHeaders headers) throws Exception {
		dashboardService.sendCommand(body);
	}
	
	//페이지 로딩 시 데이터를 가져옴.
	@RequestMapping(value = "/initialize", method = RequestMethod.GET)
	@ResponseBody
	public String ReadInitData() throws Exception {
		String result = dashboardService.ReadinitDatas();
		return result;
	}
}