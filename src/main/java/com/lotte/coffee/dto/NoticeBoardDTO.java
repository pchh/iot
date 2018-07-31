package com.lotte.coffee.dto;

import java.util.Date;

public class NoticeBoardDTO {
	private int Num;              // Index
	private String Title;         // 제목
	private String Contents;      // 내용
	private String Menu_Group_ID; // 장기,단기
	private String Name;          // 이름
	private String Work_Data;     // 등록일자
	private String Hand_Phone;    // 전화번호
	private String Resigt_ID;     // 생년월일
	private String User_Group_ID; // 기수
		
	public String getHand_Phone() {
		return Hand_Phone;
	}
	public void setHand_Phone(String hand_Phone) {
		Hand_Phone = hand_Phone;
	}
	public String getResigt_ID() {
		return Resigt_ID;
	}
	public void setResigt_ID(String resigt_ID) {
		Resigt_ID = resigt_ID;
	}
	public String getUser_Group_ID() {
		return User_Group_ID;
	}
	public void setUser_Group_ID(String user_Group_ID) {
		User_Group_ID = user_Group_ID;
	}		
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContents() {
		return Contents;
	}
	public void setContents(String contents) {
		Contents = contents;
	}
	public String getMenu_Group_ID() {
		return Menu_Group_ID;
	}
	public void setMenu_Group_ID(String menu_Group_ID) {
		Menu_Group_ID = menu_Group_ID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getWork_Data() {
		return Work_Data;
	}
	public void setWork_Data(String work_Data) {
		Work_Data = work_Data;
	}
	
}
