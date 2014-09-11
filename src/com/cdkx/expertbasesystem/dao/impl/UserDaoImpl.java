package com.cdkx.expertbasesystem.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cdkx.expertbasesystem.dao.UserDao;
import com.cdkx.expertbasesystem.domain.User;

/**
 * 提供对User表的操作
 * @author Guojun
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User findUserById(int id) {
		return (User) getHibernateTemplate().load(User.class, id);
	}

	@Override
	public void addUser(User user) {
		getHibernateTemplate().save(user);
	}

	@Override
	public void modifyUser(User user) {
		getHibernateTemplate().update(user);
	}

	@Override
	public void deleteUser(User user) {
		getHibernateTemplate().delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> login(User user) {
		return getHibernateTemplate().find("from User user where user.username='" + user.getUsername() + "' and user.password='" + user.getPassword() + "'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findMembers() {
		return getHibernateTemplate().find("from User u where user.level=3");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findLeaders() {
		return getHibernateTemplate().find("from User u where user.level=1");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findServers() {
		return getHibernateTemplate().find("from User u where user.level=2");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchUsers(String searchCondition, String searchValue) {
		return getHibernateTemplate().find("from User u left join fetch u.userDetail where u.userDetail." + searchCondition + " like '%" + searchValue + "%'");
	}

	@Override
	public List<User> findUncheckedUsers() {
		return getHibernateTemplate().find("from User u left join fetch u.userDetail where u.checked=0");
	}
}
