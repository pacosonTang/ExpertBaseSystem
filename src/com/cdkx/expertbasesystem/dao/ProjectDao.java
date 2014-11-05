package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.domain.Project;

/**
 * �Ի�Ա�������Ŀ���в���
 * @author Guojun
 * 2014-8-21
 */
public interface ProjectDao {

	/**
	 * ��ӿ�����Ŀ��
	 * @param project Ҫ��ӵĿ�����Ŀ��
	 */
	public void addProject(Project project);
	
	/**
	 * ɾ��������Ŀ��
	 * @param project ��Ҫɾ���Ŀ�����Ŀ��
	 */
	public void deleteProject(Project project);
	
	/**
	 * �޸Ŀ�����Ŀ��
	 * @param project �Ѿ��޸ĺõĿ�����Ŀ��Ϣ��
	 */
	public void modifyProject(Project project);
	
	/**
	 * ���ҵ�ָ����Ա���еĿ�����Ŀ
	 * @param userid ��Ա�ı��
	 * @return List �����û�Ա���еĿ�����Ŀ
	 */
	public List<Project> findProjectByUser(int userId);
	
	/**
	 * �ҵ�ָ���Ŀ�����Ŀ
	 * @param id Ҫ��ѯ�Ŀ�����Ŀ�ı��
	 * @return Project Ҫ���ҵĿ�����Ŀ
	 */
	public Project findProject(int id);
	
	public List findkey(String sql);
	
	/**
	 * ��ҳ��ѯ����Ŀ
	 * @param t_sql , �����sql��䣬
	 * @param pageindex�� ��ǰҳ��
	 * @return
	 */
	public List<Project> loaditempage(String t_sql, int pageindex);
}
