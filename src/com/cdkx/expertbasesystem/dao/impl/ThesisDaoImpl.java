package com.cdkx.expertbasesystem.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cdkx.expertbasesystem.dao.ThesisDao;
import com.cdkx.expertbasesystem.domain.Thesis;

public class ThesisDaoImpl extends HibernateDaoSupport implements ThesisDao {

	@Override
	public void addThesis(Thesis thesis) {
		getHibernateTemplate().save(thesis);
	}

	@Override
	public void deleteThesis(Thesis thesis) {
		getHibernateTemplate().delete(thesis);
	}

	@Override
	public void modifyThesis(Thesis thesis) {
		getHibernateTemplate().update(thesis);
	}

	@Override
	public List<Thesis> findThesisByUser(int userid) {
		return getHibernateTemplate().find("from Thesis t where t.user.id=" + userid);
	}

	@Override
	public Thesis findThesis(int id) {
		return (Thesis) getHibernateTemplate().load(Thesis.class, id);
	}
	
	@Override
	public List findKeyword(String sql) {
		return this.getHibernateTemplate().find(sql);
	}
}
