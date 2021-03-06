package com.my.begin.controller;

import java.util.ArrayList;
import java.util.HashMap;
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

import com.my.begin.dao.board.BoardDAOMapper;
import com.my.begin.model.Board;

@Controller
public class BoardListController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardListController.class);
	
	//datasource이용 connection을 직접 잡는 방식
	/*@Autowired
    private BoardDAO boardDAO;*/
	
	//mybatis이용 하는 방식
	@Autowired
    private BoardDAOMapper boardDAO;
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String boardList(Model model) {
		logger.info("/list in");
		
		List<Board> boardList = boardDAO.findAll();
		model.addAttribute("boardList", boardList);
		
		return "board/board_list";
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String boardWrite(Model model) {
		logger.info("/write in");
			
		return "board/board_write";
	}
	
	@RequestMapping(value = "/board/save", method = RequestMethod.GET)
	public String boardWrite(HttpServletRequest request, ModelMap modelMap) {
		logger.info("/save in");
		
		String boardTitle = request.getParameter("input_title");
		String boardContent = request.getParameter("input_content");
		
	    HashMap<String, String> boardSaveMap = new HashMap();
	    boardSaveMap.put("boardTitle", boardTitle);
	    boardSaveMap.put("boardContent", boardContent);
	    
	    boardDAO.insertByBoardIndex(boardSaveMap);
	    List<Board> boardList = boardDAO.findAll();

	    modelMap.put("boardList", boardList);
		
		return "board/board_list";
	}
	
	@RequestMapping(value = "/board/view", method = RequestMethod.GET)
	public String boardView(HttpServletRequest request, Model model) {
		logger.info("/view in");
		
		Integer boardIndex = Integer.parseInt(request.getParameter("boardIndex"));
		
		ArrayList<Board> boardList = boardDAO.selectByBoardIndex(boardIndex);
		
		model.addAttribute("boardList", boardList);
		
		return "board/board_view";
	}
	
	@RequestMapping(value = "/board/edit", method = RequestMethod.GET)
	public String boardEdit(HttpServletRequest request, Model model) {
		logger.info("/edit in");
		
		Integer boardIndex = Integer.parseInt(request.getParameter("boardIndex"));
		
		ArrayList<Board> boardList = boardDAO.selectByBoardIndex(boardIndex);
		
		model.addAttribute("boardList", boardList);
		
		return "board/board_edit";
	}
	
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String boardUpdate(HttpServletRequest request, ModelMap modelMap) {
		logger.info("/update in");
		
		String boardIndex = request.getParameter("input_index");
		String boardTitle = request.getParameter("input_title");
		String boardContent = request.getParameter("input_content");
		
	    HashMap<String, String> boardUpdateMap = new HashMap();
	    boardUpdateMap.put("boardIndex", boardIndex);
	    boardUpdateMap.put("boardTitle", boardTitle);
	    boardUpdateMap.put("boardContent", boardContent);
	    
	    boardDAO.updateByBoardIndex(boardUpdateMap);
	    List<Board> boardList = boardDAO.findAll();

	    modelMap.put("boardList", boardList);
		
		return "board/board_list";
	}
	
	/*
	 @RequestMapping(value = "/listMapper", method = RequestMethod.GET)
	    @ResponseBody//이건 리턴으로 리스트 자체를 반환
	    public List<Customer> getCustomerListMapper() {//json으로 가져가기위해 list로 생성
	        return customerDAOMapper.findAllMapper();
	    }

	    @RequestMapping(value = "/insertlistMapper", method = RequestMethod.POST)
	    @ResponseBody
	    public List<Customer> insertListMapper(@RequestParam String name, @RequestParam int age, ModelMap modelMap) {

	        System.out.println("name: " + name);
	        System.out.println("age: " + age);
	        
	        customerDAOMapper.insertByCustomerIdMapper(name, age);
	        List<Customer> customerList = customerDAOMapper.findAllMapper();

	        return customerList;
	    }*/

}
