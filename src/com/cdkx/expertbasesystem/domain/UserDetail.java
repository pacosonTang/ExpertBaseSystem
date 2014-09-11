package com.cdkx.expertbasesystem.domain;

/**
 * �û���ϸ��Ϣ
 * @author Guojun
 *
 */
public class UserDetail {

	//�û����
	private int id;
	
	//�û��Ա�
	private String sex;
	
	//��������
	private String birthday;
	
	//�ó�����
	private String adept;
	
	//��ҵԺУ
	private String school;
	
	//��ҵʱ��
	private String graduateTime;
	
	//ͷ�Σ�����ְ��
	private String title;
	
	//ְ��
	private String duty;
	
	//����Э��
	private Institution institution;
	
	//ѧλ
	private Degree degree;
	
	//ѧ��
	private Degree education;
	
	//��ѧרҵ
	private Subject major;
	
	//Ŀǰ�о�רҵ
	private Subject currentMajor;
	
	//�û��������ڵ��û�
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
