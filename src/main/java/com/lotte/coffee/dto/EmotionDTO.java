package com.lotte.ai.dto;

import java.util.Date;

public class EmotionDTO {
	private String codeId;
	private String codeValue;
	private String codeName;
	private String codeDesc;
	private Date registDate;
	private int registCount;
	
	public String getCodeId() {
		return codeId;
	}
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	
	public String getCodeValue() {
		return codeValue;
	}
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	
	
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	
	
	public String getCodeDesc() {
		return codeDesc;
	}
	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}
	
	
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	
	
	public int getRegistCount() {
		return registCount;
	}
	public void setRegistCount(int registCount) {
		this.registCount = registCount;
	}
}
