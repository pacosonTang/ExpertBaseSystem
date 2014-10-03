package com.cdkx.expertbasesystem.domain;

import java.util.Set;

/**
 * �û���Ϣ���û�����������Ա���г���������Ա���쵼����Э����Ա����վά����Ա
 * @author Guojun
 *
 */
public class User {

	//�û����
	private int id;
	
	//��������
	private String realname;
	
	//�û���¼��
	private String username;
	
	//��¼����
	private String password;
	
	//������λ
	private String workUnit;
	
	//�ƶ��绰
	private String telephone;
	
	//�칫�绰
	private String officePhone;
	
	//�ʱ�
	private String postcode;
	
	//����
	private String email;
	
	//���֤��
	private String idNo;
	
	//QQ��
	private String qq;
	
	//ͨѶ��ַ
	private String address;
	
	//ͷ��
	private String avatar;
	
	//�û�����
	private int level;
	
	//�û�������Э��
	private Institution institution;
	
	//��ѧרҵ
	private Subject major;
	
	//�ִ���רҵ
	private String currentMajor;
	
	//ѧ��
	private Degree education;
	
	//ѧλ
	private Degree degree;
	
	//�Ա�
	private String sex;
	
	//��������
	private String birthday;
	
	//�ó�����
	private String adept;
	
	//��ҵԺУ
	private String school;
	
	//��ҵʱ��
	private String graduateTime;
	
	//רҵ����ְ��
	private String title;
	
	//ְ��
	private String duty;
	
	//��Ա�Ŀ�����Ŀ
	private Set<Project> projects;
	
	//��Ա���������
	private Set<Thesis> thesises;
	
	//��Ա��õ�ר��
	private Set<Patent> patents;
	
	//��Ա��õĿƼ�����
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

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Subject getMajor() {
		return major;
	}

	public void setMajor(Subject major) {
		this.major = major;
	}

	public String getCurrentMajor() {
		return currentMajor;
	}

	public void setCurrentMajor(String currentMajor) {
		this.currentMajor = currentMajor;
	}

	public Degree getEducation() {
		return education;
	}

	public void setEducation(Degree education) {
		this.education = education;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
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

	public String getAdept() {
		return adept;
	}

	public void setAdept(String adept) {
		this.adept = adept;
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
}
