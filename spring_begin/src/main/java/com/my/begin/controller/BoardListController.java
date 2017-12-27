package com.my.begin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardListController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardListController.class);
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String boardList() {
		logger.info("/list in");
		
		return "board/board_list";
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String boardWrite() {
		logger.info("/write in");
		
		return "board/board_wite";
	}
}
