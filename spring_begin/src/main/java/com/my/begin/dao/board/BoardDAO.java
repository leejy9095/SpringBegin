package com.my.begin.dao.board;

import java.util.List;

import com.my.begin.model.Board;

public interface BoardDAO {

	List<Board> findAll();

    void insertByBoardIndex(String boardTitle, String boardContent);

}