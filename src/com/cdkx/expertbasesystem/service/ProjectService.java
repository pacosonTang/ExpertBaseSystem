package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Project;

/**
 * 对科研项目实体提供服务
 * @author Guojun
 * 2014-8-23
 */
public interface ProjectService {

	/**
	 * 添加科研项目实体
	 * @param project 待添加的科研项目实体
	 */
	public void addProject(Project project);
	
	/**
	 * 删除指定科研项目实体
	 * @param project 待删除的科研项目实体
	 */
	public void deleteProject(Project project);
	
	/**
	 * 根据ID删除指定的科研项目实体
	 * @param id 待删除科研项目实体的编号
	 */
	public void deleteProjectById(int id);
	
	/**
	 * 查找科研项目实体
	 * @param id 待查找科研项目的编号
	 * @return Project 对应的科研项目实体
	 */
	public Project findProject(int id);
	
	/**
	 * 根据用户查找该用户的所有科研项目实体
	 * @param userId 用户编号
	 * @return List 对应用户的科研项目实体集合
	 */
	public List<Project> findProjectByUser(int userId);
	
	
	/**
	 * 根据用户名(id)统计项目数量
	 * @param userId 用户编号
	 * @return List 对应用户的科研项目数量
	 */
	public int findProNum(String userId);
	
	/**
	 * 根据科目统计项目数量
	 * @param 学科科目编号
	 * @return List 对应用户的科研项目数量
	 */
	public List<Project> countProNum(String sub);
	
	
	
}
