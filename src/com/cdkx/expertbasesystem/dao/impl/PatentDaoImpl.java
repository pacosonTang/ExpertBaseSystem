package com.cdkx.expertbasesystem.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cdkx.expertbasesystem.dao.PatentDao;
import com.cdkx.expertbasesystem.domain.Award;
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

	@Override
	public List findkey(String sql) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(sql);
	}
	
	@Override
	public List<Patent> loaditempage(String t_sql, int pageindex) {
		
		List list = new ArrayList<Patent>();
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
