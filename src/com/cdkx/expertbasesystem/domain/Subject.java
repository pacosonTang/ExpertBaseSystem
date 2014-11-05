package com.cdkx.expertbasesystem.domain;

import java.util.Set;

/**
 * 学科专业
 * @author Guojun
 *
 */
public class Subject {

	//学科编号
	private Integer id;
	
	//学科名称
	private String name;
	
	//该学科的父学科
	private Subject parent;
	
	//会员数量
	private Integer mSum;
	
	//项目数量
	private Integer proSum;
	
	//奖励数量
	private Integer aSum;
	
	//论文数量
	private Integer tSum;
	
	//专利数量
	private Integer patSum;
	
	//该学科的子学科
	private Set<Subject> children;
	
	//所学专业相同的会员
	private Set<User> users;
	
	public Subject(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getmSum() {
		return mSum;
	}

	public void setmSum(Integer mSum) {
		this.mSum = mSum;
	}

	public Integer getProSum() {
		return proSum;
	}

	public void setProSum(Integer proSum) {
		this.proSum = proSum;
	}

	public Integer getaSum() {
		return aSum;
	}

	public void setaSum(Integer aSum) {
		this.aSum = aSum;
	}

	public Integer gettSum() {
		return tSum;
	}

	public void settSum(Integer tSum) {
		this.tSum = tSum;
	}

	public Integer getPatSum() {
		return patSum;
	}

	public void setPatSum(Integer patSum) {
		this.patSum = patSum;
	}

	public Set<Subject> getChildren() {
		return children;
	}

	public void setChildren(Set<Subject> children) {
		this.children = children;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
