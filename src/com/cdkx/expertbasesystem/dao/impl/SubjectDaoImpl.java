package com.cdkx.expertbasesystem.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cdkx.expertbasesystem.dao.SubjectDao;
import com.cdkx.expertbasesystem.domain.Subject;

/**
 * 对学科专业操作类的实现
 * @author Guojun
 * 2014-8-22
 */
public class SubjectDaoImpl extends HibernateDaoSupport implements SubjectDao {

	@Override
	public void addSubject(Subject subject) {
		getHibernateTemplate().save(subject);
	}

	@Override
	public void deleteSubject(Subject subject) {
		getHibernateTemplate().delete(subject);
	}

	@Override
	public void modifySubject(Subject subject) {
		getHibernateTemplate().update(subject);
	}

	@Override
	public List<Subject> findSubjectsByParent(int id) {
		return getHibernateTemplate().find("from Subject s where s.parent.id=" + id);
	}

	@Override
	public Subject findSubject(int id) {
		return (Subject) getHibernateTemplate().load(Subject.class, id);
	}

	@Override
	public List<Subject> findFirstSubjects() {
		return getHibernateTemplate().find("from Subject s where s.parent=null");
	}

}
