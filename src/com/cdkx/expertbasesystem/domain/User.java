package com.cdkx.expertbasesystem.domain;

import java.util.Set;

/**
 * 用户信息表，用户包括基本会员，市场化服务人员，领导，科协管理员，网站维护人员
 * @author Guojun
 *
 */
public class User {

	//用户编号
	private int id;
	
	//真是姓名
	private String realname;
	
	//用户登录名
	private String username;
	
	//登录密码
	private String password;
	
	//工作单位
	private String workUnit;
	
	//移动电话
	private String telephone;
	
	//办公电话
	private String officePhone;
	
	//邮编
	private String postcode;
	
	//邮箱
	private String email;
	
	//身份证号
	private String idNo;
	
	//QQ号
	private String qq;
	
	//通讯地址
	private String address;
	
	//头像
	private String avatar;
	
	//用户级别
	private int level;
	
	//会员的详细信息
	private UserDetail userDetail;
	
	//用户信息是否已经通过审核
	private int checked;
	
	//会员的科研项目
	private Set<Project> projects;
	
	//会员发表的论文
	private Set<Thesis> thesises;
	
	//会员获得的专利
	private Set<Patent> patents;
	
	//会员获得的科技奖励
	private Set<Award> awards;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Set<Thesis> getThesises() {
		return thesises;
	}

	public void setThesises(Set<Thesis> thesises) {
		this.thesises = thesises;
	}

	public Set<Patent> getPatents() {
		return patents;
	}

	public void setPatents(Set<Patent> patents) {
		this.patents = patents;
	}

	public Set<Award> getAwards() {
		return awards;
	}

	public void setAwards(Set<Award> awards) {
		this.awards = awards;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	} 
}
