package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Award;

/**
 * �Ի�Ա�Ƽ��ɹ�������Ĳ���
 * @author Guojun
 * 2014-8-21
 */
public interface AwardDao {

	/**
	 * �����û�id��ѯ���û��Ľ���
	 * @param userid
	 * @return List
	 */
	public List<Award> findAwardByUser(int userid);
	
	/**
	 * ����id��ѯ������Ϣ
	 * @param id
	 * @return Award
	 */
	public Award findAward(int awardid);
	
	/**
	 * ��ӽ�����Ϣ
	 * @param award
	 */
	public void addAward(Award award);
	
	/**
	 * ɾ����Ա�Ľ�����Ϣ
	 * @param award Award���󣬱�ʾ��Ա��һ���Ƽ��ɹ�����
	 */
	public void deleteAward(Award award);
	
	/**
	 * �޸Ŀ��н�����Ϣ
	 * @param award �޸ĺõĽ�����Ϣ
	 */
	public void modifyAward(Award award);
	
	public List findkey(String sql);
	
	/**
	 * ��ҳ��ѯ����Ŀ
	 * @param t_sql , �����sql��䣬
	 * @param pageindex�� ��ǰҳ��
	 * @return
	 */
	public List<Award> loaditempage(String t_sql, int pageindex);
	
}
