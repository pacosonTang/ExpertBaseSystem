package com.cdkx.expertbasesystem.domain;

import java.util.Set;

/**
 * ѧ��רҵ
 * @author Guojun
 *
 */
public class Subject {

	//ѧ�Ʊ��
	private int id;
	
	//ѧ������
	private String name;
	
	//��ѧ�Ƶĸ�ѧ��
	private Subject parent;
	
	//��ѧ�Ƶ���ѧ��
	private Set<Subject> subjects;
	
	//ͬһ���û���ѧרҵ�������û�
	private Set<UserDetail> userDetailsForMajor;
	
	//ͬһ����ǰ�о�רҵ�������û�
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
