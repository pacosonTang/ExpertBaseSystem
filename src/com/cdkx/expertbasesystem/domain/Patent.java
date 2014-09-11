package com.cdkx.expertbasesystem.domain;

/**
 * 专利
 * @author Guojun
 *
 */
public class Patent {

	//专利编号
	private int id;
	
	//专利名称
	private String name;
	
	//专利授权日期
	private String authorityTime;
	
	//专利号
	private String patentNo;
	
	//专利所属的用户
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

	public String getAuthorityTime() {
		return authorityTime;
	}

	public void setAuthorityTime(String authorityTime) {
		this.authorityTime = authorityTime;
	}

	public String getPatentNo() {
		return patentNo;
	}

	public void setPatentNo(String patentNo) {
		this.patentNo = patentNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
