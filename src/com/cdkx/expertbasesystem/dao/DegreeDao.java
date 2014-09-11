package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Degree;

/**
 * 对学位学历表进行操作
 * 学历学位一般是不会改变的
 * @author Guojun
 * 2014-8-21
 */
public interface DegreeDao {

	/**
	 * 查找所有的学位类型
	 * @return List 包含所有的学位
	 */
	public List<Degree> findDegrees();
	
	/**
	 * 查找所有的学历类型
	 * @return List 包含所有的学历
	 */
	public List<Degree> findEducations();
}
