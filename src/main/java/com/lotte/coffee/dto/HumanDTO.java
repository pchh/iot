package com.lotte.coffee.dto;

import java.util.Date;

public class HumanDTO {
	private String Name;          // 이름
	private String Hand_Phone;    // 전화번호
	private String Resigt_ID;     // 생년월일
	private String User_Group_ID; // 기수
	private String Company;       // 계열사
	
	
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
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

}
