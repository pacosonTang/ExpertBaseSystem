package com.cdkx.expertbasesystem.dto;

import java.util.List;

public class SecondDTO {//二级科目 
	
	private String secondsingle;
	private List<String> third;
	
	public SecondDTO(String second , List<String> third){
		
		this.secondsingle = second;
		this.third = third;
	}
	
	public SecondDTO(){}

	 
	public String getSecondsingle() {
		return secondsingle;
	}

	public void setSecondsingle(String secondsingle) {
		this.secondsingle = secondsingle;
	}

	public List<String> getThird() {
		return third;
	}

	public void setThird(List<String> third) {
		this.third = third;
	}
	
	
}
