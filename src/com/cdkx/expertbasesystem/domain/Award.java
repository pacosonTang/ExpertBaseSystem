package com.cdkx.expertbasesystem.domain;

/**
 * 科技成果奖励
 * @author Guojun
 *
 */
public class Award {

	//奖励编号
	private int id;
	
	//奖励名称
	private String name;
	
	//成果名称
	private String fruitName;
	
	//获奖日期
	private String awardTime;
	
	//奖励所属的会员
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
