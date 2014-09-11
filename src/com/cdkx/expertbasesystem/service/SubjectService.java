package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Subject;

/**
 * 对学科专业实体提供服务
 * @author Guojun
 * 2014-8-23
 */
public interface SubjectService {

	/**
	 * 添加学科专业信息
	 * @param subject 待添加的学科专业实体
	 */
	public void addSubject(Subject subject);
	
	/**
	 * 删除指定的学科专业实体
	 * @param subject 待删除的学科专业实体
	 */
	public void deleteSubject(Subject subject);
	
	/**
	 * 删除由编号指定的学科专业实体
	 * @param id 待删除的学科专业实体的编号
	 */
	public void deleteSubjectById(int id);
	
	/**
	 * 修改学科专业
	 * @param subject 已修改的学科专业实体
	 */
	public void modifySubject(Subject subject);
	
	/**
	 * 查找指定的学科专业实体
	 * @param id 待查找的学科专业编号
	 * @return Subject 对应的学科专业实体
	 */
	public Subject findSubject(int id);
	
	/**
	 * 找到所有的学科专业实体
	 * @return List 包含所有的学科专业实体
	 */
	public List<Subject> findSubjects();
	
	/**
	 * 查找一级学科实体
	 * @return List 所有一级学科实体
	 */
	public List<Subject> findFirstSubjects();
}
