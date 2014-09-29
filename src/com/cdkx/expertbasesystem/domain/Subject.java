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
	private Set<Subject> children;
	
	//所学专业相同的会员
	private Set<User> usersForMajor;
	
	//现从事专业相同的会员
	private Set<User> usersForCurrentMajor;

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

	public Set<User> getUsersForMajor() {
		return usersForMajor;
	}

	public void setUsersForMajor(Set<User> usersForMajor) {
		this.usersForMajor = usersForMajor;
	}

	public Set<User> getUsersForCurrentMajor() {
		return usersForCurrentMajor;
	}

	public void setUsersForCurrentMajor(Set<User> usersForCurrentMajor) {
		this.usersForCurrentMajor = usersForCurrentMajor;
	}

	public Set<Subject> getChildren() {
		return children;
	}

	public void setChildren(Set<Subject> children) {
		this.children = children;
	}
}
