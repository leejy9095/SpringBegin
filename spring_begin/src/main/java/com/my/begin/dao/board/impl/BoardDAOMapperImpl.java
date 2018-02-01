package com.my.begin.dao.board.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.begin.dao.board.BoardDAOMapper;
import com.my.begin.model.Board;


@Repository
public class BoardDAOMapperImpl implements BoardDAOMapper{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<Board> findAll() {
    	List<Board> boardList = new ArrayList<>();
    	//sqlSession을 통하여 매핑한다.
    	BoardDAOMapper boardDAOMapper = sqlSession.getMapper(BoardDAOMapper.class);
    	boardList = boardDAOMapper.findAll();
    	
    	return boardList;
    }

	@Override
	public Integer selectCountAll() {
		int listCnt = 0;
		
		BoardDAOMapper boardDAOMapper = sqlSession.getMapper(BoardDAOMapper.class);
		listCnt = boardDAOMapper.selectCountAll();
		
		return listCnt;
	}
    
    @Override
	public ArrayList<Board> selectAllLimit(Integer boardStartNum, Integer boardEndNum) {
    	ArrayList<Board> boardList = new ArrayList<>();
    	
    	BoardDAOMapper boardDAOMapper = sqlSession.getMapper(BoardDAOMapper.class);
    	boardList = boardDAOMapper.selectAllLimit(boardStartNum, boardEndNum);
    	
    	return boardList;
	}
    
    @Override
    public ArrayList<Board> selectByBoardIndex(Integer boardIndex) {
    	ArrayList<Board> boardList = new ArrayList<>();
    	
    	BoardDAOMapper boardDAOMapper = sqlSession.getMapper(BoardDAOMapper.class);
    	boardList = boardDAOMapper.selectByBoardIndex(boardIndex);
    	
    	return boardList;
    }

    @Override
    public void insertByBoardIndex(HashMap<String, String> boardSaveMap){
        BoardDAOMapper boardDAOMapper = sqlSession.getMapper(BoardDAOMapper.class);
        boardDAOMapper.insertByBoardIndex(boardSaveMap);
    }

	@Override
	public void updateByBoardIndex(HashMap<String, String> boardUpdateMap) {
		 BoardDAOMapper boardDAOMapper = sqlSession.getMapper(BoardDAOMapper.class);
	     boardDAOMapper.updateByBoardIndex(boardUpdateMap);
	}


}
