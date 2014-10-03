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
	private Set<Subject> children;
	
	//��ѧרҵ��ͬ�Ļ�Ա
	private Set<User> users;

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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Subject> getChildren() {
		return children;
	}

	public void setChildren(Set<Subject> children) {
		this.children = children;
	}
}
