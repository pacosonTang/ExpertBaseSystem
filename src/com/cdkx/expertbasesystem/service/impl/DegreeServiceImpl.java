package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.DegreeDao;
import com.cdkx.expertbasesystem.domain.Degree;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.DegreeService;

/**
 * ��ѧλѧ��ʵ������ʵ�֣��ṩ��ѧλѧ���Ĳ�ѯ����Ϊѧλѧ���ķּ�һ���ǲ���ı�ģ�����û������ɾ�����޸Ĺ���
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
			throw new AppException("��������ѧλ��Ϣʧ�ܣ�");
		}
	}

	@Override
	public List<Degree> findEducations() {
		try {
			return degreeDao.findEducations();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��������ѧλ��Ϣʧ�ܣ�");
		}
	}

	public void setDegreeDao(DegreeDao degreeDao) {
		this.degreeDao = degreeDao;
	}

}
