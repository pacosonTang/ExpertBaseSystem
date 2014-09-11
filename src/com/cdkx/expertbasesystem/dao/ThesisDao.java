package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Thesis;

/**
 * ���û���������Ľ��в���
 * @author Guojun
 * 2014-8-21
 */
public interface ThesisDao {

	/**
	 * ���һ��������
	 * @param thesis ��Ҫ��ӵ�������
	 */
	public void addThesis(Thesis thesis);
	
	/**
	 * ɾ��һ��������
	 * @param thesis ��Ҫɾ����������
	 */
	public void deleteThesis(Thesis thesis);
	
	/**
	 * �޸�������Ϣ
	 * @param thesis ���޸ĵ�������
	 */
	public void modifyThesis(Thesis thesis);
	
	/**
	 * ���ݻ�Ա�ı�Ų��Ҹû�Ա��ӵ�е�����
	 * @param userid ��Ա���
	 * @return List ������Ӧ��Ա���е�����
	 */
	public List<Thesis> findThesisByUser(int userid);
	
	/**
	 * ���Ҷ�Ӧ��ŵ�����
	 * @param id
	 * @return Thesis ��Ӧ��ŵ�����
	 */
	public Thesis findThesis(int id);
}
