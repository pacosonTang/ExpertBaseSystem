package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.InstitutionDao;
import com.cdkx.expertbasesystem.domain.Institution;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.InstitutionService;

/**
 * 对协会实体服务的实现，提供对学科专业实体的增删查等服务
 * @author Guojun
 * 2014-8-24
 */
public class InstitutionServiceImpl implements InstitutionService {

	private InstitutionDao institutionDao;
	
	@Override
	public void addInstitution(Institution institution) {
		try {
			institutionDao.addInstitution(institution);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("添加协会信息失败！");
		}
	}

	@Override
	public void deleteInstitution(Institution institution) {
		try {
			institutionDao.deleteInstitution(institution);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("删除ID=【" + institution.getId() + "】的协会信息失败！");
		}
	}

	@Override
	public void deleteInstitutionById(int id) {
		try {
			Institution institution = institutionDao.findInstitutionId(id);
			if(institution != null)
				institutionDao.deleteInstitution(institution);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("删除ID=【" + id + "】的协会信息失败！");
		}
	}

	@Override
	public Institution findInstitutions(int id) {
		try {
			return institutionDao.findInstitutionId(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找ID=【" + id + "】的协会信息失败！");
		}
	}

	@Override
	public List<Institution> findInstitutions() {
		try {
			return institutionDao.findInstitutions();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找所有协会信息失败！");
		}
	}

	public void setInstitutionDao(InstitutionDao institutionDao) {
		this.institutionDao = institutionDao;
	}

}
