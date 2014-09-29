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
	
	//��ͬѧλ�Ļ�Ա����
	private Set<User> usersForDegree;
	
	//��ͬѧ���Ļ�Ա����
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
