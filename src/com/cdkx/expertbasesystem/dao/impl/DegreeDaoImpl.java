package com.cdkx.expertbasesystem.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cdkx.expertbasesystem.dao.DegreeDao;
import com.cdkx.expertbasesystem.domain.Degree;

public class DegreeDaoImpl extends HibernateDaoSupport implements DegreeDao {

	@Override
	public List<Degree> findDegrees() {
		return getHibernateTemplate().find("from Degree d where d.isDegree=1");
	}

	@Override
	public List<Degree> findEducations() {
		return getHibernateTemplate().find("from Degree d where d.isDegree=0");
	}

}
