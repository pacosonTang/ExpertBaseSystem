package com.cdkx.expertbasesystem.domain;

import java.util.Set;

/**
 * 协会
 * @author Guojun
 *
 */
public class Institution {

	//协会编号
	private int id;
	
	//协会名称
	private String name;
	
	//同一个协会下的会员
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
