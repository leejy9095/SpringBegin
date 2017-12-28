package com.my.begin.controller;

import java.util.List;

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
		model.addAttribute("value", boardList);
		
		return "board/board_list";
	}
	//datasource이용 connection을 직접 잡는 방식(insert)
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String boardWrite(@RequestParam String name, @RequestParam int age, ModelMap modelMap) {
		
		/*HttpServletRequest request)
	{
		String a = request.getParameter("a");
		String b = request.getParameter("b");*/
		/*logger.info("/write in");
		
		 System.out.println("name: " + name);
	        System.out.println("age: " + age);

	        customerDAO.insertByCustomerId(name,age);
	        List<Customer> customerList = customerDAO.findAll();

	        modelMap.put("value", customerList);*/
		
		
		return "board/board_write";
	}
	
	

}
