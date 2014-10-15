package com.cdkx.expertbasesystem.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cdkx.expertbasesystem.dao.AwardDao;
import com.cdkx.expertbasesystem.domain.Award;

/**
 * 对会员奖励操作类的实现
 * @author Guojun
 * 2014-8-22
 */
public class AwardDaoImpl extends HibernateDaoSupport implements AwardDao {

	@Override
	public List<Award> findAwardByUser(int userid) {
		return getHibernateTemplate().find("from Award a where a.user.id=" + userid);
	}

	@Override
	public Award findAward(int awardid) {
		return (Award) getHibernateTemplate().load(Award.class, awardid);
	}

	@Override
	public void addAward(Award award) {
		getHibernateTemplate().save(award);
	}

	@Override
	public void deleteAward(Award award) {
		getHibernateTemplate().delete(award);
	}

	@Override
	public void modifyAward(Award award) {
		getHibernateTemplate().update(award);
	}

	@Override
	public List findkey(String sql) {

		return this.getHibernateTemplate().find(sql);
	}
}
