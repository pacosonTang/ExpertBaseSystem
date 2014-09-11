package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.InstitutionDao;
import com.cdkx.expertbasesystem.domain.Institution;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.InstitutionService;

/**
 * ��Э��ʵ������ʵ�֣��ṩ��ѧ��רҵʵ�����ɾ��ȷ���
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
			throw new AppException("���Э����Ϣʧ�ܣ�");
		}
	}

	@Override
	public void deleteInstitution(Institution institution) {
		try {
			institutionDao.deleteInstitution(institution);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ɾ��ID=��" + institution.getId() + "����Э����Ϣʧ�ܣ�");
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
			throw new AppException("ɾ��ID=��" + id + "����Э����Ϣʧ�ܣ�");
		}
	}

	@Override
	public Institution findInstitutions(int id) {
		try {
			return institutionDao.findInstitutionId(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("����ID=��" + id + "����Э����Ϣʧ�ܣ�");
		}
	}

	@Override
	public List<Institution> findInstitutions() {
		try {
			return institutionDao.findInstitutions();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��������Э����Ϣʧ�ܣ�");
		}
	}

	public void setInstitutionDao(InstitutionDao institutionDao) {
		this.institutionDao = institutionDao;
	}

}
