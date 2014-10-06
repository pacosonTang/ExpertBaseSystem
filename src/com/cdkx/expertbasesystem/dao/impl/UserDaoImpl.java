package com.cdkx.expertbasesystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
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
		return getHibernateTemplate().find("from User u where u.level=3");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findLeaders() {
		return getHibernateTemplate().find("from User u where u.level=1");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findServers() {
		return getHibernateTemplate().find("from User u where u.level=2");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchUsers(String searchCondition, String searchValue) {
		return getHibernateTemplate().find("from User u where u.userDetail." + searchCondition + " like '%" + searchValue + "%'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> statisticMembers(String countCondition) {
		return (List<Object[]>) getHibernateTemplate().execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery("select u.userDetail.major.name as major,count(*) as amount from User u where u.level=3 group by u.userDetail.major").list();
			}
			
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUsersByUsername(String username) {
		return getHibernateTemplate().find("from User u where u.username='" + username + "'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchMember(String hql) {
		return getHibernateTemplate().find(hql);
	}
}
