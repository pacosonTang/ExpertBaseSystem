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
	
	//���ķ�������
	private String pubTime;
	
	//�Ƿ���¼
	private int isAccept;
	
	//�Ƿ��ں����ڿ�����
	private int isCore;
	
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

	public int getIsAccept() {
		return isAccept;
	}

	public void setIsAccept(int isAccept) {
		this.isAccept = isAccept;
	}

	public int getIsCore() {
		return isCore;
	}

	public void setIsCore(int isCore) {
		this.isCore = isCore;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
