package com.cdkx.expertbasesystem.domain;

import java.util.Set;

/**
 * ѧ��ѧλ
 * @author Guojun
 *
 */
public class Degree {

	//ѧ��ѧλ���
	private int id;
	
	//ѧ��ѧλ����
	private String name;
	
	//�Ƿ�Ϊѧλ
	private int isDegree;
	
	//��ǰѧλ�µ����л�Ա
	private Set<UserDetail> userDetailsForDegree;
	
	//��ǰѧ���µ����л�Ա
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
