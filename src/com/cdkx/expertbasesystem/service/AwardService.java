package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Award;

/**
 * ���û����н���ʵ���ṩ����
 * @author Guojun
 * 2014-8-23
 */
public interface AwardService {

	/**
	 * ��ӽ���ʵ��
	 * @param award ����ӵĽ���ʵ��
	 */
	public void addAward(Award award);
	
	/**
	 * ɾ��ָ���Ŀ��н���
	 * @param award ��ɾ���Ŀ��н���ʵ�� 
	 */
	public void deleteAward(Award award);
	
	/**
	 * ͨ��ָ���Ľ������ɾ������ʵ��
	 * @param id ��ɾ���Ŀ��н���ʵ��ı��
	 */
	public void deleteAwardById(int id);
	
	/**
	 * ����ָ����ŵĿ��н���ʵ��
	 * @param id ���ҵ��Ŀ��н���ʵ��ı��
	 * @return Award ��Ӧ�Ŀ��н���ʵ��
	 */
	public Award findAward(int id);
	
	/**
	 * ͨ���û��ı���ҵ����û������н������н���ʵ��
	 * @param userId �û����
	 * @return List ���û������н���ʵ�弯��
	 */
	public List<Award> findAwardByUser(int userId);
	
	/**
	 * �����û���(id)ͳ�� ����  ����
	 * @param userId �û����
	 * @return List ��Ӧ�û��� ����  ����
	 */
	public int findAwardNum(String userId);
	
	/**
	 * ����  ѧ�ƿ�Ŀ  ͳ�� ����  
	 * @param sub ѧ�ƿ�Ŀ
	 * @return List ��Ӧ�û��� ����  ����
	 */
	public List<Award> countAwardNum(String sub,int pageindex);
	
	/**
	 * ����  ѧ�ƿ�Ŀ  ͳ�� ��Ŀ���������� five: member, award , project ,patent ,thesis.[Ϊ�˷��㣬��д����awardService ����]
	 * @param sub ѧ�ƿ�Ŀ, numtype,mNum, aNum,proNum, patNum, tNum.
	 * @return    ����
	 */
	public int countFiveNum(String sub, String datatype);
	
	
}
