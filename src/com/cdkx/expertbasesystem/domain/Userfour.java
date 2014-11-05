package com.cdkx.expertbasesystem.domain;

import java.util.Set;

/**
 * 会员 成就数量统计表， 包括 论文， 奖励， 项目， 专利数量
 * @author Guojun
 *
 */
public class Userfour {
	
	
	//用户编号
	private int id;
	
//	真实姓名
	private String realname;
	
//	所属学科名称
	private String subname;
	
//	项目数量
	private int proNum;
	
//	专利数量
	private int patNum;

//	专利数量
	private int aNum;
	
//	论文数量
	private int tNum;
	
	public Userfour(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getProNum() {
		return proNum;
	}
	public void setProNum(int proNum) {
		this.proNum = proNum;
	}
	public int getPatNum() {
		return patNum;
	}
	public void setPatNum(int patNum) {
		this.patNum = patNum;
	}
	public int getaNum() {
		return aNum;
	}
	public void setaNum(int aNum) {
		this.aNum = aNum;
	}
	public int gettNum() {
		return tNum;
	}
	public void settNum(int tNum) {
		this.tNum = tNum;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}
	  
}
