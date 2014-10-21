package com.cdkx.expertbasesystem.dto;

public class BiPropertyDTO {
	
	private String first_p;
	private String second_p;
	
	public BiPropertyDTO(){}

	public BiPropertyDTO(String first_p, String second_p) {
		this.first_p = first_p;
		this.second_p = second_p;
	}

	public String getFirst_p() {
		return first_p;
	}

	public void setFirst_p(String first_p) {
		this.first_p = first_p;
	}

	public String getSecond_p() {
		return second_p;
	}

	public void setSecond_p(String second_p) {
		this.second_p = second_p;
	}
	
	 
	
	
}
