package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.PatentDao;
import com.cdkx.expertbasesystem.domain.Patent;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.PatentService;

/**
 * ��ר��ʵ������ʵ�֣���ר��ʵ���ṩ��ɾ��ȷ���
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
			throw new AppException("���ר����Ϣʧ�ܣ�");
		}
	}

	@Override
	public void deletePatent(Patent patent) {
		try {
			patentDao.deletePatent(patent);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ɾ��ID=��" + patent.getId() + "����ר����Ϣʧ�ܣ�");
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
			throw new AppException("ɾ��ID=��" + id + "����ר����Ϣʧ�ܣ�");
		}
	}

	@Override
	public Patent findPatent(int id) {
		try {
			return patentDao.findPatent(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("����ID=��" + id + "����ר����Ϣʧ�ܣ�");
		}
	}

	@Override
	public List<Patent> findPatentByUser(int userId) {
		try {
			return patentDao.findPatentByUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("�����û�ID=��" + userId + "���û���õ�ר����Ϣʧ�ܣ�");
		}
	}

	public void setPatentDao(PatentDao patentDao) {
		this.patentDao = patentDao;
	}

	//������ͳ�Ʒ�������
	
	@Override
	public int findPatentNum(String userId) {
		
		String sql = "select count(*) from Patent p where p.user.realname = '" + userId + "'";
		try {
			List list = patentDao.findkey(sql); 
			
			return Integer.parseInt(list.get(0).toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ͳ�Ƹ��û��� ר��  ����ʧ��");
		}
	}

	@Override
	public List<Patent> countPatentNum(String sub, int pageindex) {

		String sql = "from Patent p where p.user.major.name = '" + sub + "'";
		return this.patentDao.loaditempage(sql, pageindex);
	}

}
