package com.cdkx.expertbasesystem.domain;

import java.util.Set;

/**
 * 学科专业
 * @author Guojun
 *
 */
public class Subject {

	//学科编号
	private int id;
	
	//学科名称
	private String name;
	
	//该学科的父学科
	private Subject parent;
	
	//该学科的子学科
	private Set<Subject> subjects;
	
	//同一个用户所学专业包含的用户
	private Set<UserDetail> userDetailsForMajor;
	
	//同一个当前研究专业包含的用户
	private Set<UserDetail> userDetailsForCurrentMajor;

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

	public Subject getParent() {
		return parent;
	}

	public void setParent(Subject parent) {
		this.parent = parent;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<UserDetail> getUserDetailsForMajor() {
		return userDetailsForMajor;
	}

	public void setUserDetailsForMajor(Set<UserDetail> userDetailsForMajor) {
		this.userDetailsForMajor = userDetailsForMajor;
	}

	public Set<UserDetail> getUserDetailsForCurrentMajor() {
		return userDetailsForCurrentMajor;
	}

	public void setUserDetailsForCurrentMajor(
			Set<UserDetail> userDetailsForCurrentMajor) {
		this.userDetailsForCurrentMajor = userDetailsForCurrentMajor;
	}
}
