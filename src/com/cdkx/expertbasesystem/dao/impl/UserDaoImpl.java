package com.cdkx.expertbasesystem.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cdkx.expertbasesystem.dao.UserDao;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.domain.Userfour;
import com.cdkx.expertbasesystem.dto.UserTotalDTO;

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

	@Override
	public List findKeyword(String sql) {
		return this.getHibernateTemplate().find(sql);
	}

	@Override
	public List<Userfour> loaditempage(String t_sql, int pageindex) {
		
		List list = new ArrayList<Userfour>();
	    final int pageSize = 10;
		final int items = (pageindex-1) * pageSize; 
		final String sql = t_sql;
		try {
	    	list = getHibernateTemplate().executeFind(new HibernateCallback() {  
	             public Object doInHibernate(Session session)  
	             throws HibernateException, SQLException {  
	             org.hibernate.Query query = (org.hibernate.Query) session.createQuery(sql); 
	        	 query.setFirstResult(items);   
	        	 query.setMaxResults(pageSize);
	             List listInner = query.list();  
	             return listInner;  
	             }  
	           });  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return list;
	}
}
