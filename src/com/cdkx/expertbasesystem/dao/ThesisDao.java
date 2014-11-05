package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Award;
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
	
	//�����·�������ͳ�ơ�
	/**
	 * ���Ҷ�Ӧ��ŵ�����list
	 * @param id
	 * @return List<Thesis> ��Ӧ��ŵ������б�
	 */
	public List findKeyword(String sql);
	
	/**
	 * ��ҳ��ѯ����Ŀ
	 * @param t_sql , �����sql��䣬
	 * @param pageindex�� ��ǰҳ��
	 * @return
	 */
	public List<Thesis> loaditempage(String t_sql, int pageindex);
}
