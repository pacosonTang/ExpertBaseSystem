package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Degree;

/**
 * ��ѧ��ѧλʵ���ṩ����
 * @author Guojun
 * 2014-8-23
 */
public interface DegreeService {

	/**
	 * �������е�ѧλʵ��
	 * @return List ���е�ѧλʵ��
	 */
	public List<Degree> findDegrees();
	
	/**
	 * ��������ѧ��ʵ��
	 * @return List ���е�ѧ��ʵ��
	 */
	public List<Degree> findEducations();
}
