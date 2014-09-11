package com.cdkx.expertbasesystem.domain;

/**
 * 科技论文
 * @author Guojun
 *
 */
public class Thesis {

	//论文编号
	private int id;
	
	//论文名称
	private String name;
	
	//论文发布日期
	private String pubTime;
	
	//是否收录
	private int isAccept;
	
	//是否在核心期刊刊登
	private int isCore;
	
	//论文所属的会员
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
