package com.cdkx.expertbasesystem.domain;

import java.util.Set;

/**
 * Э��
 * @author Guojun
 *
 */
public class Institution {

	//Э����
	private int id;
	
	//Э������
	private String name;
	
	//��ͬЭ��Ļ�Ա
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
