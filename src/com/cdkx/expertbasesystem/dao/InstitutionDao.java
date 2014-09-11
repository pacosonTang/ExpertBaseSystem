package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Institution;

/**
 * 对协会信息进行操作
 * @author Guojun
 * 2014-8-21
 */
public interface InstitutionDao {
	
	/**
	 * 添加一个协会
	 * @param institution
	 */
	public void addInstitution(Institution institution);
	
	/**
	 * 根据协会的对象删除一个协会
	 * @param institution
	 */
	public void deleteInstitution(Institution institution);
	
	/**
	 * 查找所有的协会信息
	 * @return List 包含所有协会信息
	 */
	public List<Institution> findInstitutions();
	
	/**
	 * 
	 * @param id 要查找协会的ID
	 * @return Institution 根据ID查找到的协会对象
	 */
	public Institution findInstitutionId(int id);
}
