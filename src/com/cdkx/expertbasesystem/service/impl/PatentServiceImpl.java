package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.PatentDao;
import com.cdkx.expertbasesystem.domain.Patent;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.PatentService;

/**
 * 对专利实体服务的实现，对专利实体提供增删查等服务
 * @author Guojun
 * 2014-8-24
 */
public class PatentServiceImpl implements PatentService {

	private PatentDao patentDao;
	
	@Override
	public void addPatent(Patent patent) {
		try {
			patentDao.addPatent(patent);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("添加专利信息失败！");
		}
	}

	@Override
	public void deletePatent(Patent patent) {
		try {
			patentDao.deletePatent(patent);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("删除ID=【" + patent.getId() + "】的专利信息失败！");
		}
	}

	@Override
	public void deletePatentById(int id) {
		try {
			Patent patent = patentDao.findPatent(id);
			if(patent != null)
				patentDao.deletePatent(patent);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("删除ID=【" + id + "】的专利信息失败！");
		}
	}

	@Override
	public Patent findPatent(int id) {
		try {
			return patentDao.findPatent(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找ID=【" + id + "】的专利信息失败！");
		}
	}

	@Override
	public List<Patent> findPatentByUser(int userId) {
		try {
			return patentDao.findPatentByUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找用户ID=【" + userId + "】用户获得的专利信息失败！");
		}
	}

	public void setPatentDao(PatentDao patentDao) {
		this.patentDao = patentDao;
	}

}
