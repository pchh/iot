package com.lotte.coffee.dto;

import java.util.Date;

public class QuizDTO {
	private int ID;               // 문제번호
	private String Contents;      // 문제
	private String Correct;       // 정답
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getContents() {
		return Contents;
	}
	public void setContents(String contents) {
		Contents = contents;
	}
	public String getCorrect() {
		return Correct;
	}
	public void setCorrect(String correct) {
		Correct = correct;
	}	
}
