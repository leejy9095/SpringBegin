package com.my.begin.model;

//객체를 만들때 생성자 getter와setter와 tostring 정도는 만들도록 신경쓰기

public class Board {
    private int boardIndex;
    private String boardTitle;
    private String boardContent;
    private String boardDate;

    public Board() {

    }

    public Board(int boardIndex, String boardTitle, String boardContent, String boardDate) {
		super();
		this.boardIndex = boardIndex;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
	}

    public int getBoardIndex() {
		return boardIndex;
	}

	public void setBoardIndex(int boardIndex) {
		this.boardIndex = boardIndex;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	@Override
    public String toString() { //tostring는 객체는 object를 상속하는데 거기에 tostring가 있다 그래서 가져다 쓴것이다 tostring는 객체를 불르면 자동으로 실행된다
        return "Board{" +
                "boardIndex=" + boardIndex +
                ", boardTitle='" + boardTitle + '\'' +
                ", boardContent=" + boardContent +
                ", boardDate=" + boardDate +
                '}';
    }
}