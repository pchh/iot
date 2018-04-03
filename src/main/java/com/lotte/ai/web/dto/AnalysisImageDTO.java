package com.lotte.ai.web.dto;

public class AnalysisImageDTO {
	private int top1;
	private double top1Pr;
	
	public int getTop1() {
		return top1;
	}
	public AnalysisImageDTO setTop1(int top1) {
		this.top1 = top1;
		return this;
	}
	
	public double getTop1Pr() {
		return top1Pr;
	}
	public AnalysisImageDTO setTop1Pr(double top1Pr) {
		this.top1Pr = top1Pr;
		return this;
	}
	
	@Override
	public String toString() {
		return "AnalysisImageVO [top1=" + top1 + ", top1Pr=" + top1Pr + "]";
	}
}
