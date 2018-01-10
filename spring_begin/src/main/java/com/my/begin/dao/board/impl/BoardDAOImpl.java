package com.my.begin.dao.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.begin.dao.board.BoardDAO;
import com.my.begin.model.Board;

@Repository
public class BoardDAOImpl implements BoardDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Board> findAll() {
        final String sql = "SELECT board_index, board_title, board_content, board_date FROM board";

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Board> boardList = new ArrayList<Board>(); //list를 board타입으로 생성
            while (rs.next()) {	//rs가 비어있을때까지 한개한개 돌리면서 리스트에 추가
            	Board board = new Board(rs.getInt("board_index"), rs.getString("board_title"), rs.getString("board_content"), rs.getString("board_date"));
                boardList.add(board);
            }

            rs.close();
            ps.close();
            return boardList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void insertByBoardIndex(String boardTitle, String boardContent) {
        final String sql = "INSERT INTO board(board_title, board_content) VALUES(?, ?)";

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, boardTitle);
            ps.setString(2, boardContent);

            Board board = null;
            ps.execute();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}