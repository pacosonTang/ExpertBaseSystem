package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Project;

/**
 * 对会员参与的项目进行操作
 * @author Guojun
 * 2014-8-21
 */
public interface ProjectDao {

	/**
	 * 添加科研项目类
	 * @param project 要添加的科研项目类
	 */
	public void addProject(Project project);
	
	/**
	 * 删除科研项目类
	 * @param project 需要删除的科研项目类
	 */
	public void deleteProject(Project project);
	
	/**
	 * 修改科研项目类
	 * @param project 已经修改好的科研项目信息类
	 */
	public void modifyProject(Project project);
	
	/**
	 * 查找到指定会员所有的科研项目
	 * @param userid 会员的编号
	 * @return List 包含该会员所有的科研项目
	 */
	public List<Project> findProjectByUser(int userId);
	
	/**
	 * 找到指定的科研项目
	 * @param id 要查询的科研项目的编号
	 * @return Project 要查找的科研项目
	 */
	public Project findProject(int id);
	
	public List findkey(String sql);
}
