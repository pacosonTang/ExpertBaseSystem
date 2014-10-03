package com.cdkx.expertbasesystem.domain;

/**
 * 科研项目
 * @author Guojun
 *
 */
public class Project {

	//项目编号
	private int id;
	
	//项目名称
	private String name;
	
	//立项日期
	private String projectTime;
	
	//本人作用
	private String selfFunc;
	
	//委托单位
	private String delegationUnit;
	
	//项目级别
	private int projectLevel;
	
	//项目状态
	private int completeStatus;
	
	//财政拨款
	private float allocation;
	
	//自筹款项
	private float selffinance;
	
	//项目所属的会员
	private User user;

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

	public String getProjectTime() {
		return projectTime;
	}

	public void setProjectTime(String projectTime) {
		this.projectTime = projectTime;
	}

	public String getSelfFunc() {
		return selfFunc;
	}

	public void setSelfFunc(String selfFunc) {
		this.selfFunc = selfFunc;
	}

	public String getDelegationUnit() {
		return delegationUnit;
	}

	public void setDelegationUnit(String delegationUnit) {
		this.delegationUnit = delegationUnit;
	}

	public int getProjectLevel() {
		return projectLevel;
	}

	public void setProjectLevel(int projectLevel) {
		this.projectLevel = projectLevel;
	}

	public int getCompleteStatus() {
		return completeStatus;
	}

	public void setCompleteStatus(int completeStatus) {
		this.completeStatus = completeStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public float getAllocation() {
		return allocation;
	}

	public void setAllocation(float allocation) {
		this.allocation = allocation;
	}

	public float getSelffinance() {
		return selffinance;
	}

	public void setSelffinance(float selffinance) {
		this.selffinance = selffinance;
	}
}
