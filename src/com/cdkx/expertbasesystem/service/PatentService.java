package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Patent;

/**
 * ��ר��ʵ���ṩ����
 * @author Guojun
 * 2014-8-23
 */
public interface PatentService {

	/**
	 * ���ר��ʵ��
	 * @param patent ����ӵ�ר��ʵ��
	 */
	public void addPatent(Patent patent);
	
	/**
	 * ɾ��ָ����ר��ʵ��
	 * @param patent ��ɾ����ר��ʵ��
	 */
	public void deletePatent(Patent patent);
	
	/**
	 * ɾ��ָ����ŵ�ר��ʵ��
	 * @param id ��ɾ��ר��ʵ��ı��
	 */
	public void deletePatentById(int id);
	
	/**
	 * ����ר��ʵ��
	 * @param id �����ҵ�ר�����
	 * @return List ��Ӧ��ר��ʵ��
	 */
	public Patent findPatent(int id);
	
	/**
	 * �����û���Ų��Ҹ��û�������ר��
	 * @param userId �û����
	 * @return List ��Ӧ�û����е�ר��
	 */
	public List<Patent> findPatentByUser(int userId);
	
	//����Ϊͳ�Ʒ���
	/**
	 * �����û���(id)ͳ�� ר��  ����
	 * @param userId �û����
	 * @return List ��Ӧ�û��� ר�� ����
	 */
	public int findPatentNum(String userId);
	
	/**
	 * ���� ѧ�ƿ�Ŀ ͳ�� ר��  ����
	 * @param sub ѧ�����ơ�
	 * @return List ��Ӧ�û��� ר�� ����
	 */
	public List<Patent> countPatentNum(String sub,int pageindex);
	
	
}
