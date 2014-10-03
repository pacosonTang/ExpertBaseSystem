package com.cdkx.expertbasesystem.domain;

/**
 * ������Ŀ
 * @author Guojun
 *
 */
public class Project {

	//��Ŀ���
	private int id;
	
	//��Ŀ����
	private String name;
	
	//��������
	private String projectTime;
	
	//��������
	private String selfFunc;
	
	//ί�е�λ
	private String delegationUnit;
	
	//��Ŀ����
	private int projectLevel;
	
	//��Ŀ״̬
	private int completeStatus;
	
	//��������
	private float allocation;
	
	//�Գ����
	private float selffinance;
	
	//��Ŀ�����Ļ�Ա
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
