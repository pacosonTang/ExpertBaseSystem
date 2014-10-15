package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Project;

/**
 * �Կ�����Ŀʵ���ṩ����
 * @author Guojun
 * 2014-8-23
 */
public interface ProjectService {

	/**
	 * ��ӿ�����Ŀʵ��
	 * @param project ����ӵĿ�����Ŀʵ��
	 */
	public void addProject(Project project);
	
	/**
	 * ɾ��ָ��������Ŀʵ��
	 * @param project ��ɾ���Ŀ�����Ŀʵ��
	 */
	public void deleteProject(Project project);
	
	/**
	 * ����IDɾ��ָ���Ŀ�����Ŀʵ��
	 * @param id ��ɾ��������Ŀʵ��ı��
	 */
	public void deleteProjectById(int id);
	
	/**
	 * ���ҿ�����Ŀʵ��
	 * @param id �����ҿ�����Ŀ�ı��
	 * @return Project ��Ӧ�Ŀ�����Ŀʵ��
	 */
	public Project findProject(int id);
	
	/**
	 * �����û����Ҹ��û������п�����Ŀʵ��
	 * @param userId �û����
	 * @return List ��Ӧ�û��Ŀ�����Ŀʵ�弯��
	 */
	public List<Project> findProjectByUser(int userId);
	
	
	/**
	 * �����û���(id)ͳ����Ŀ����
	 * @param userId �û����
	 * @return List ��Ӧ�û��Ŀ�����Ŀ����
	 */
	public int findProNum(String userId);
	
	/**
	 * ���ݿ�Ŀͳ����Ŀ����
	 * @param ѧ�ƿ�Ŀ���
	 * @return List ��Ӧ�û��Ŀ�����Ŀ����
	 */
	public List<Project> countProNum(String sub);
	
	
	
}
