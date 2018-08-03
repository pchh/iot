package com.lotte.coffee.dto;

public class NoticeBoardDTO {
	private int Num;              // Index
	private String Title;         // 제목
	private String Contents;      // 내용
	private String Menu_Group_ID; // 장기,단기
	private String Name;          // 이름
	private String Work_Date;     // 등록일자
	private String Login_PW;    // 전화번호
	private String Login_ID;     // 생년월일
	private String User_Group_ID; // 기수

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
	public String getWork_Date() {
		return Work_Date;
	}
	public void setWork_Date(String work_Date) {
		Work_Date = work_Date;
	}
	public String getLogin_PW() {
		return Login_PW;
	}
	public void setLogin_PW(String login_PW) {
		Login_PW = login_PW;
	}
	public String getLogin_ID() {
		return Login_ID;
	}
	public void setLogin_ID(String login_ID) {
		Login_ID = login_ID;
	}
	public String getUser_Group_ID() {
		return User_Group_ID;
	}
	public void setUser_Group_ID(String user_Group_ID) {
		User_Group_ID = user_Group_ID;
	}
	
		
}
