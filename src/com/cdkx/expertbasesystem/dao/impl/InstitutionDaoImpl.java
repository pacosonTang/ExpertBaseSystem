package com.cdkx.expertbasesystem.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cdkx.expertbasesystem.dao.InstitutionDao;
import com.cdkx.expertbasesystem.domain.Institution;

/**
 * 对协会信息操作接口的实现
 * @author Guojun
 * 2014-8-22
 */
public class InstitutionDaoImpl extends HibernateDaoSupport implements
		InstitutionDao {

	@Override
	public void addInstitution(Institution institution) {
		getHibernateTemplate().save(institution);
	}

	@Override
	public void deleteInstitution(Institution institution) {
		getHibernateTemplate().delete(institution);
	}

	@Override
	public List<Institution> findInstitutions() {
		return getHibernateTemplate().find("from Institution i");
	}

	@Override
	public Institution findInstitutionId(int id) {
		return (Institution) getHibernateTemplate().load(Institution.class, id);
	}

}
