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
	
	//ͬһ��Э���µĻ�Ա
	private Set<UserDetail> userDetails;

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

	public Set<UserDetail> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Set<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}
}
