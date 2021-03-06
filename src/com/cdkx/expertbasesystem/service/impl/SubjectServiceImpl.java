package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.SubjectDao;
import com.cdkx.expertbasesystem.domain.Subject;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.SubjectService;

/**
 * 对学科专业实体服务的实现，提供对学科专业实体的增删改查服务，以及找到处于顶端的一级学科实体的查询
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
			throw new AppException("添加学科专业信息失败！");
		}
	}

	@Override
	public void deleteSubject(Subject subject) {
		try {
			subjectDao.deleteSubject(subject);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("删除ID=【" + subject.getId() + "】的学科专业信息失败！");
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
			throw new AppException("删除ID=【" + id + "】的学科专业信息失败！");
		}
	}

	@Override
	public void modifySubject(Subject subject) {
		try {
			subjectDao.modifySubject(subject);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("修改ID=【" + subject.getId() + "】学科专业信息失败");
		}
	}

	@Override
	public Subject findSubject(int id) {
		try {
			return subjectDao.findSubject(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找ID=【" + id + "】的学科专业信息失败！");
		}
	}

	@Override
	public List<Subject> findSubjectsByParent(int id) {
		try {
			return subjectDao.findSubjectsByParent(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找所有学科专业信息失败！");
		}
	}

	@Override
	public List<Subject> findFirstSubjects() {
		try {
			return subjectDao.findFirstSubjects();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找一级学科失败！");
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
			throw new AppException("查找所有学科专业失败！");
		}
	}

	@Override
	public List<Subject> subjectByParent(String name) {

		String sql = "select s.name from Subject s where s.parent.name = '" + name + "' and s.parent <> null";
		try {
			return subjectDao.subjectByParent(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查看子目录失败");
		}
	}

	@Override
	public List findFirstSub() {
		// TODO Auto-generated method stub
		String sql = "select s.name from Subject s where s.parent=null";
		try {
			return subjectDao.subjectByParent(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查看子目录失败");
		}
	}

}
