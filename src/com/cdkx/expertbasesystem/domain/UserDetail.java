package com.cdkx.expertbasesystem.domain;

/**
 * 用户详细信息
 * @author Guojun
 *
 */
public class UserDetail {

	//用户编号
	private int id;
	
	//用户性别
	private String sex;
	
	//出生日期
	private String birthday;
	
	//擅长领域
	private String adept;
	
	//毕业院校
	private String school;
	
	//毕业时间
	private String graduateTime;
	
	//头衔，技术职称
	private String title;
	
	//职责
	private String duty;
	
	//所属协会
	private Institution institution;
	
	//学位
	private Degree degree;
	
	//学历
	private Degree education;
	
	//所学专业
	private Subject major;
	
	//目前研究专业
	private Subject currentMajor;
	
	//用户详情属于的用户
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getGraduateTime() {
		return graduateTime;
	}

	public void setGraduateTime(String graduateTime) {
		this.graduateTime = graduateTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public Degree getEducation() {
		return education;
	}

	public void setEducation(Degree education) {
		this.education = education;
	}

	public Subject getMajor() {
		return major;
	}

	public void setMajor(Subject major) {
		this.major = major;
	}

	public Subject getCurrentMajor() {
		return currentMajor;
	}

	public void setCurrentMajor(Subject currentMajor) {
		this.currentMajor = currentMajor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAdept() {
		return adept;
	}

	public void setAdept(String adept) {
		this.adept = adept;
	}
}
