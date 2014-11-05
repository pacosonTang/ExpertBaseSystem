package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.domain.Patent;

/**
 * �Ի�Աר������в���
 * @author Guojun
 * 2014-8-21
 */
public interface PatentDao {

	/**
	 * ���ר������
	 * @param patent ��Ҫ��ӵ�ר������
	 */
	public void addPatent(Patent patent);
	
	/**
	 * ɾ��ר������
	 * @param patent ��Ҫɾ����ר������
	 */
	public void deletePatent(Patent patent);
	
	/**
	 * ���ݱ�Ų���ר������
	 * @param id
	 * @return Patent ��Ӧ��ŵ�ר������
	 */
	public Patent findPatent(int id);
	
	/**
	 * ���ݻ�Ա�ı�Ų��ҳ��û�Ա��ӵ�е�����ר������
	 * @param userId ��Ա�ı��
	 * @return List ������Ӧ��Ա������ר������
	 */
	public List<Patent> findPatentByUser(int userId);
	
	public List findkey(String sql);
	
	/**
	 * ��ҳ��ѯ����Ŀ
	 * @param t_sql , �����sql��䣬
	 * @param pageindex�� ��ǰҳ��
	 * @return
	 */
	public List<Patent> loaditempage(String t_sql, int pageindex);
}
