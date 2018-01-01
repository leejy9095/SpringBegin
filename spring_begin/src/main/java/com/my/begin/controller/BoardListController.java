package com.my.begin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.begin.dao.board.BoardDAO;
import com.my.begin.model.Board;

@Controller
public class BoardListController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardListController.class);
	
	@Autowired
    private BoardDAO boardDAO;
	
	//datasource이용 connection을 직접 잡는 방식(select)
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String boardList(Model model) {
		logger.info("/list in");
		
		List<Board> boardList = boardDAO.findAll();
		model.addAttribute("boardList", boardList);
		
		return "board/board_list";
	}
	
	//datasource이용 connection을 직접 잡는 방식(write)
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String boardWrite(Model model) {
		logger.info("/write in");
			
		return "board/board_write";
	}
	
	//datasource이용 connection을 직접 잡는 방식(Save)
	@RequestMapping(value = "/board/save", method = RequestMethod.GET)
	public String boardWrite(HttpServletRequest request, ModelMap modelMap) {
		logger.info("/save in");
		
		String inputTitle = request.getParameter("input_title");
		String inputContent = request.getParameter("input_content");
		
		System.out.println("inputTitle: " + inputTitle);
	    System.out.println("inputContent: " + inputContent);

	    boardDAO.insertByBoardIndex(inputTitle,inputContent);
	    List<Board> boardList = boardDAO.findAll();

	    modelMap.put("boardList", boardList);
		
		return "board/board_list";
	}
	
	

}
