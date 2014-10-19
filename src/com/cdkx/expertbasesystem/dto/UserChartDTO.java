package com.cdkx.expertbasesystem.dto;

import java.io.Serializable;

public class UserChartDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8632671445469256522L;
	private String subject;
	private int phd;
	private int user;
	
	public UserChartDTO(){}

	
	public UserChartDTO(String subject, int phd, int user) {
		
		this.subject = subject;
		this.phd = phd;
		this.user = user;
	}


	public int getPhd() {
		return phd;
	}

	public void setPhd(int phd) {
		this.phd = phd;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
