package com.cdkx.expertbasesystem.domain;

/**
 * ר��
 * @author Guojun
 *
 */
public class Patent {

	//ר�����
	private int id;
	
	//ר������
	private String name;
	
	//ר����Ȩ����
	private String authorityTime;
	
	//ר����
	private String patentNo;
	
	//ר���������û�
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
