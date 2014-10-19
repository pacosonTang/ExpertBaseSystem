package com.cdkx.expertbasesystem.dto;

import java.io.Serializable;

public class UserTotalDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6449340695293120042L;
	private String username;
	private String project;
	private String award;
	private String patent;
	private String thesis;

	public UserTotalDTO() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public String getPatent() {
		return patent;
	}

	public void setPatent(String patent) {
		this.patent = patent;
	}

	public String getThesis() {
		return thesis;
	}

	public void setThesis(String thesis) {
		this.thesis = thesis;
	}
}
