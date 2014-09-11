package com.cdkx.expertbasesystem.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cdkx.expertbasesystem.dao.UserDetailDao;
import com.cdkx.expertbasesystem.domain.UserDetail;

/**
 * 对用户详细信息操作接口的实现
 * @author Guojun
 * 2014-8-22
 */
public class UserDetailDaoImpl extends HibernateDaoSupport implements
		UserDetailDao {

	@Override
	public void addUserDetail(UserDetail userDetail) {
		getHibernateTemplate().save(userDetail);
	}

	@Override
	public void deleteUserDetail(UserDetail userDetail) {
		getHibernateTemplate().delete(userDetail);
	}

	@Override
	public void modifyUserDetail(UserDetail userDetail) {
		getHibernateTemplate().update(userDetail);
	}

	@Override
	public UserDetail findUserDetail(int id) {
		return (UserDetail) getHibernateTemplate().load(UserDetail.class, id);
	}

	@Override
	public List<UserDetail> findUserDetails() {
		return getHibernateTemplate().find("from UserDetail u");
	}

}
