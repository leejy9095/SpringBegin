package com.my.begin.dao.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.my.begin.model.Board;

public interface BoardDAOMapper {
	List<Board> findAll();

	//void insertByBoardIndex(@Param("boardTitle") String boardTitle, @Param("boardContent") String boardContent);

	ArrayList<Board> selectByBoardIndex(@Param("boardIndex") Integer boardIndex);

	void insertByBoardIndex(@Param("boardMap") HashMap<String, String> boardSaveMap);
	
	void updateByBoardIndex(@Param("boardMap") HashMap<String, String> boardUpdateMap);
	
}