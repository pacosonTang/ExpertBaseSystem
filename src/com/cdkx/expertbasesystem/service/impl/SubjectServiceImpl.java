package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.SubjectDao;
import com.cdkx.expertbasesystem.domain.Subject;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.SubjectService;

/**
 * ��ѧ��רҵʵ������ʵ�֣��ṩ��ѧ��רҵʵ�����ɾ�Ĳ�����Լ��ҵ����ڶ��˵�һ��ѧ��ʵ��Ĳ�ѯ
 * @author Guojun
 * 2014-8-24
 */
public class SubjectServiceImpl implements SubjectService {

	private SubjectDao subjectDao;
	
	@Override
	public void addSubject(Subject subject) {
		try {
			subjectDao.addSubject(subject);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("���ѧ��רҵ��Ϣʧ�ܣ�");
		}
	}

	@Override
	public void deleteSubject(Subject subject) {
		try {
			subjectDao.deleteSubject(subject);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ɾ��ID=��" + subject.getId() + "����ѧ��רҵ��Ϣʧ�ܣ�");
		}
	}

	@Override
	public void deleteSubjectById(int id) {
		try {
			Subject subject = subjectDao.findSubject(id);
			if(subject != null)
				subjectDao.deleteSubject(subject);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ɾ��ID=��" + id + "����ѧ��רҵ��Ϣʧ�ܣ�");
		}
	}

	@Override
	public void modifySubject(Subject subject) {
		try {
			subjectDao.modifySubject(subject);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("�޸�ID=��" + subject.getId() + "��ѧ��רҵ��Ϣʧ��");
		}
	}

	@Override
	public Subject findSubject(int id) {
		try {
			return subjectDao.findSubject(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("����ID=��" + id + "����ѧ��רҵ��Ϣʧ�ܣ�");
		}
	}

	@Override
	public List<Subject> findSubjectsByParent(int id) {
		try {
			return subjectDao.findSubjectsByParent(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��������ѧ��רҵ��Ϣʧ�ܣ�");
		}
	}

	@Override
	public List<Subject> findFirstSubjects() {
		try {
			return subjectDao.findFirstSubjects();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("����һ��ѧ��ʧ�ܣ�");
		}
	}

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	@Override
	public List<Subject> findAllSubjects() {
		try {
			return subjectDao.findAllSubjects();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��������ѧ��רҵʧ�ܣ�");
		}
	}

	@Override
	public List<Subject> subjectByParent(String name) {

		String sql = "from Subject s where s.parent.name = '" + name + "'";
		try {
			return subjectDao.subjectByParent(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("�鿴��Ŀ¼ʧ��");
		}
	}

}
