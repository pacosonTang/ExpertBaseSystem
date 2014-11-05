package com.cdkx.expertbasesystem.domain;

import java.util.Set;

/**
 * ѧ��רҵ
 * @author Guojun
 *
 */
public class Subject {

	//ѧ�Ʊ��
	private Integer id;
	
	//ѧ������
	private String name;
	
	//��ѧ�Ƶĸ�ѧ��
	private Subject parent;
	
	//��Ա����
	private Integer mSum;
	
	//��Ŀ����
	private Integer proSum;
	
	//��������
	private Integer aSum;
	
	//��������
	private Integer tSum;
	
	//ר������
	private Integer patSum;
	
	//��ѧ�Ƶ���ѧ��
	private Set<Subject> children;
	
	//��ѧרҵ��ͬ�Ļ�Ա
	private Set<User> users;
	
	public Subject(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject getParent() {
		return parent;
	}

	public void setParent(Subject parent) {
		this.parent = parent;
	}

	public Integer getmSum() {
		return mSum;
	}

	public void setmSum(Integer mSum) {
		this.mSum = mSum;
	}

	public Integer getProSum() {
		return proSum;
	}

	public void setProSum(Integer proSum) {
		this.proSum = proSum;
	}

	public Integer getaSum() {
		return aSum;
	}

	public void setaSum(Integer aSum) {
		this.aSum = aSum;
	}

	public Integer gettSum() {
		return tSum;
	}

	public void settSum(Integer tSum) {
		this.tSum = tSum;
	}

	public Integer getPatSum() {
		return patSum;
	}

	public void setPatSum(Integer patSum) {
		this.patSum = patSum;
	}

	public Set<Subject> getChildren() {
		return children;
	}

	public void setChildren(Set<Subject> children) {
		this.children = children;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
