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
	
	//相同学位的会员集合
	private Set<User> usersForDegree;
	
	//相同学历的会员集合
	private Set<User> usersForEducation;

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

	public Set<User> getUsersForDegree() {
		return usersForDegree;
	}

	public void setUsersForDegree(Set<User> usersForDegree) {
		this.usersForDegree = usersForDegree;
	}

	public Set<User> getUsersForEducation() {
		return usersForEducation;
	}

	public void setUsersForEducation(Set<User> usersForEducation) {
		this.usersForEducation = usersForEducation;
	}
}
