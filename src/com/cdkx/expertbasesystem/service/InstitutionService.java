package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Institution;

/**
 * 对协会实体提供服务
 * @author Guojun
 * 2014-8-23
 */
public interface InstitutionService {

	/**
	 * 添加一个协会实体
	 * @param institution 待添加的协会实体
	 */
	public void addInstitution(Institution institution);
	
	/**
	 * 删除指定的协会实体
	 * @param institution 待删除的协会实体
	 */
	public void deleteInstitution(Institution institution);
	
	/**
	 * 删除指定id的协会实体
	 * @param id 待删除协会实体的编号
	 */
	public void deleteInstitutionById(int id);
	
	/**
	 * 查找协会实体
	 * @param id 待查找协会实体的编号
	 * @return Institution 对应的协会实体
	 */
	public Institution findInstitutions(int id);
	
	/**
	 * 查找所有的协会实体
	 * @return List 包含所有协会实体的集合
	 */
	public List<Institution> findInstitutions();
}
