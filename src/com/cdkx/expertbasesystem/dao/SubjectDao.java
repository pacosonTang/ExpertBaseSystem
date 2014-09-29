package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Subject;

/**
 * 对学科专业的操作
 * @author Guojun
 * 2014-8-21
 */
public interface SubjectDao {

	/**
	 * 添加一个学科专业
	 * @param subject 要添加的学科分类
	 */
	public void addSubject(Subject subject);
	
	/**
	 * 删除一个学科分类
	 * @param subject 要删除的学科分类
	 */
	public void deleteSubject(Subject subject);
	
	/**
	 * 修改一个学科分类
	 * @param subject 已修改的学科分类信息
	 */
	public void modifySubject(Subject subject);
	
	/**
	 * 找到id专业下所有子专业
	 * @return List 该专业的所有子专业
	 */
	public List<Subject> findSubjectsByParent(int id);
	
	/**
	 * 查找指定学科分类
	 * @param id 学科分类的编号
	 * @return Suject 对应的学科分类
	 */
	public Subject findSubject(int id);
	
	/**
	 * 查找所有的一级学科分类
	 * @return List 所有的一级学科
	 */
	public List<Subject> findFirstSubjects();
}
