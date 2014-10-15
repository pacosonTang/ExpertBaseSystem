package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Thesis;

/**
 * ������ʵ���ṩ����
 * @author Guojun
 * 2014-8-23
 */
public interface ThesisService {

	/**
	 * �������ʵ��
	 * @param thesis ����ӵ�����ʵ��
	 */
	public void addThesis(Thesis thesis);
	
	/**
	 * ɾ��ָ��������ʵ��
	 * @param thesis ��ɾ��������ʵ��
	 */
	public void deleteThesis(Thesis thesis);
	
	/**
	 * ɾ�������ı��ָ��������ʵ��
	 * @param id ���ı��
	 */
	public void deleteThesisById(int id);
	
	/**
	 * ��������
	 * @param id �����ҵ�����ʵ��ı��
	 * @return
	 */
	public Thesis findThesis(int id);
	
	/**
	 * ͨ���û���������Ҹ��û���ӵ�е�����ʵ��
	 * @param userId �û����
	 * @return List ��Ӧ�û���ӵ�е�����ʵ��
	 */
	public List<Thesis> findThesisByUser(int userId);
	
	//�����·�������ͳ�ơ�
	/**
	 * ͨ���û���������Ҹ��û���ӵ�е�����ʵ��
	 * @param userId �û����
	 * @return List ��Ӧ�û���ӵ�е�����ʵ��
	 */
	public List<Thesis> countThesis(int userId);
	
	/**
	 * �����û���(id)ͳ�� ����  ����
	 * @param userId �û����
	 * @return List ��Ӧ�û�����������
	 */
	public int findThesisNum(String userId);
	
	/**
	 * ��ѯ��������
	 * @param sub ѧ�ƿ�Ŀ
	 * @return List ��Ӧ�û�����������
	 */
	public List<Thesis> countThesisNum(String sub);
	
}
