package com.cdkx.expertbasesystem.dto;

import java.io.Serializable;
import java.util.List;

public class FirstDTO implements Serializable{//一级学科dto
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6356062357220605421L;
	private String first;
	private List<SecondDTO> secondlist;
	
	public FirstDTO(String first, List<SecondDTO> second) {
		this.first = first;
		this.secondlist = second;
	}
	
	public FirstDTO() {}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public List<SecondDTO> getSecondlist() {
		return secondlist;
	}

	public void setSecondlist(List<SecondDTO> secondlist) {
		this.secondlist = secondlist;
	}
}
