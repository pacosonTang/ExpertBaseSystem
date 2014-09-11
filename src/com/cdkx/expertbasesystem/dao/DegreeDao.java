package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Degree;

/**
 * ��ѧλѧ������в���
 * ѧ��ѧλһ���ǲ���ı��
 * @author Guojun
 * 2014-8-21
 */
public interface DegreeDao {

	/**
	 * �������е�ѧλ����
	 * @return List �������е�ѧλ
	 */
	public List<Degree> findDegrees();
	
	/**
	 * �������е�ѧ������
	 * @return List �������е�ѧ��
	 */
	public List<Degree> findEducations();
}
