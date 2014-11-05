package com.cdkx.expertbasesystem.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cdkx.expertbasesystem.dao.AwardDao;
import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.domain.Userfour;

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
	
	@Override
	public List<Award> loaditempage(String t_sql, int pageindex) {
		
		List list = new ArrayList<Award>();
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
