package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Degree;

/**
 * 对学历学位实体提供服务
 * @author Guojun
 * 2014-8-23
 */
public interface DegreeService {

	/**
	 * 查找所有的学位实体
	 * @return List 所有的学位实体
	 */
	public List<Degree> findDegrees();
	
	/**
	 * 查找所有学历实体
	 * @return List 所有的学历实体
	 */
	public List<Degree> findEducations();
}
