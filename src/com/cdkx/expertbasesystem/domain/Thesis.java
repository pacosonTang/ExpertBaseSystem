package com.cdkx.expertbasesystem.domain;

/**
 * �Ƽ�����
 * @author Guojun
 *
 */
public class Thesis {

	//���ı��
	private int id;
	
	//��������
	private String name;
	
	//��¼���
	private String pubTime;
	
	//���������Ļ�Ա
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

	public String getPubTime() {
		return pubTime;
	}

	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
