package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.DegreeDao;
import com.cdkx.expertbasesystem.domain.Degree;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.DegreeService;

/**
 * 对学位学历实体服务的实现，提供对学位学历的查询，因为学位学历的分级一般是不会改变的，所有没有增加删除与修改功能
 * @author Guojun
 * 2014-8-24
 */
public class DegreeServiceImpl implements DegreeService {

	private DegreeDao degreeDao;
	
	@Override
	public List<Degree> findDegrees() {
		try {
			return degreeDao.findDegrees();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找所有学位信息失败！");
		}
	}

	@Override
	public List<Degree> findEducations() {
		try {
			return degreeDao.findEducations();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找所有学位信息失败！");
		}
	}

	public void setDegreeDao(DegreeDao degreeDao) {
		this.degreeDao = degreeDao;
	}

}
