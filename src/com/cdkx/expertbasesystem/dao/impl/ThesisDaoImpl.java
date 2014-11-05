package com.cdkx.expertbasesystem.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cdkx.expertbasesystem.dao.ThesisDao;
import com.cdkx.expertbasesystem.domain.Award;
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
	@Override
	public List<Thesis> loaditempage(String t_sql, int pageindex) {
		
		List list = new ArrayList<Thesis>();
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
