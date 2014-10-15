package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.ThesisDao;
import com.cdkx.expertbasesystem.domain.Thesis;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.ThesisService;

/**
 * ������ʵ������ʵ�֣��ṩ������ʵ�����ɾ��ȷ���
 * @author Guojun
 * 2014-8-24
 */
public class ThesisServiceImpl implements ThesisService {

	private ThesisDao thesisDao;
	
	@Override
	public void addThesis(Thesis thesis) {
		try {
			thesisDao.addThesis(thesis);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("���������Ϣʧ�ܣ�");
		}
	}

	@Override
	public void deleteThesis(Thesis thesis) {
		try {
			thesisDao.deleteThesis(thesis);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ɾ��ID=��" + thesis.getId() + "����������Ϣʧ�ܣ�");
		}
	}

	@Override
	public void deleteThesisById(int id) {
		try {
			Thesis thesis = thesisDao.findThesis(id);
			if(thesis != null)
				thesisDao.deleteThesis(thesis);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ɾ��ID=��" + id + "��������Ϣʧ�ܣ�");
		}
	}

	@Override
	public Thesis findThesis(int id) {
		try {
			return thesisDao.findThesis(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯID=��" + id + "���ĵ�������Ϣʧ�ܣ�");
		}
	}

	@Override
	public List<Thesis> findThesisByUser(int userId) {
		try {
			return thesisDao.findThesisByUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("�����û�ID=��" + userId + "�����û������������ʧ�ܣ�");
		}
	}

	public void setThesisDao(ThesisDao thesisDao) {
		this.thesisDao = thesisDao;
	}

	@Override
	public List<Thesis> countThesis(int userId) {
		
		String sql = "from Thesis s where s.user.id = '" + userId + "'"; 
		return thesisDao.findThesisByUser(userId);
	}
	
	@Override
	public int findThesisNum(String userId) {
		
		String sql = "select count(*) from Thesis t where t.user.realname = '" + userId + "'";
		try {
			List list = thesisDao.findKeyword(sql); 
			
			return Integer.parseInt(list.get(0).toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ͳ�Ƹ��û�����������ʧ��");
		}
	}

	@Override
	public List<Thesis> countThesisNum(String sub) {
		
		String sql = "from Thesis p where p.user.major.name = '" + sub + "'";
		try {
			return  thesisDao.findKeyword(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ͳ�Ƹ��û���  ���� ����ʧ��");
		}
	}
}
