package com.cdkx.expertbasesystem.domain;

/**
 * �Ƽ��ɹ�����
 * @author Guojun
 *
 */
public class Award {

	//�������
	private int id;
	
	//��������
	private String name;
	
	//�ɹ�����
	private String fruitName;
	
	//������
	private String awardTime;
	
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

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public String getAwardTime() {
		return awardTime;
	}

	public void setAwardTime(String awardTime) {
		this.awardTime = awardTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
