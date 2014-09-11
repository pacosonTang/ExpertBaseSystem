package com.cdkx.expertbasesystem.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cdkx.expertbasesystem.dao.PatentDao;
import com.cdkx.expertbasesystem.domain.Patent;

/**
 * 对专利操作借口的实现
 * @author Guojun
 * 2014-8-22
 */
public class PatentDaoImpl extends HibernateDaoSupport implements PatentDao {

	@Override
	public void addPatent(Patent patent) {
		getHibernateTemplate().save(patent);
	}

	@Override
	public void deletePatent(Patent patent) {
		getHibernateTemplate().delete(patent);
	}

	@Override
	public Patent findPatent(int id) {
		return (Patent) getHibernateTemplate().load(Patent.class, id);
	}

	@Override
	public List<Patent> findPatentByUser(int userId) {
		return getHibernateTemplate().find("from Patent p where p.user.id=" + userId);
	}

}
