package com.lotte.ai.dto;

public class AddIndexDTO {
	private  AnalysisDTO data;
	private int index;
	public AnalysisDTO getData() {
		return data;
	}
	
	public AddIndexDTO setData(AnalysisDTO data) {
		this.data = data;
		return this;
	}
	
	public int getIndex() {
		return index;
	}
	
	public AddIndexDTO setIndex(int index) {
		this.index = index;
		return this;
	}
	
}
