package com.cdkx.expertbasesystem.domain;

import java.util.Set;

/**
 * 学历学位
 * @author Guojun
 *
 */
public class Degree {

	//学历学位编号
	private int id;
	
	//学历学位名称
	private String name;
	
	//是否为学位
	private int isDegree;
	
	//当前学位下的所有会员
	private Set<UserDetail> userDetailsForDegree;
	
	//当前学历下的所有会员
	private Set<UserDetail> userDetailsForEducation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIsDegree() {
		return isDegree;
	}

	public void setIsDegree(int isDegree) {
		this.isDegree = isDegree;
	}

	public Set<UserDetail> getUserDetailsForDegree() {
		return userDetailsForDegree;
	}

	public void setUserDetailsForDegree(Set<UserDetail> userDetailsForDegree) {
		this.userDetailsForDegree = userDetailsForDegree;
	}

	public Set<UserDetail> getUserDetailsForEducation() {
		return userDetailsForEducation;
	}

	public void setUserDetailsForEducation(Set<UserDetail> userDetailsForEducation) {
		this.userDetailsForEducation = userDetailsForEducation;
	}
}
