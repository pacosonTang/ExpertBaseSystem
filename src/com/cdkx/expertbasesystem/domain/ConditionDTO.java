package com.cdkx.expertbasesystem.domain;

public class ConditionDTO {

	private int degree;
	
	private int education;
	
	private int institution;
	
	private String currentMajor;
	
	private String adept;
	
	private String title;

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public int getEducation() {
		return education;
	}

	public void setEducation(int education) {
		this.education = education;
	}

	public int getInstitution() {
		return institution;
	}

	public void setInstitution(int institution) {
		this.institution = institution;
	}

	public String getAdept() {
		return adept;
	}

	public void setAdept(String adept) {
		this.adept = adept;
	}

	public String getCurrentMajor() {
		return currentMajor;
	}

	public void setCurrentMajor(String currentMajor) {
		this.currentMajor = currentMajor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
