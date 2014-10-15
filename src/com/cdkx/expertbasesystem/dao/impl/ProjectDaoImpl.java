package com.cdkx.expertbasesystem.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cdkx.expertbasesystem.dao.ProjectDao;
import com.cdkx.expertbasesystem.domain.Project;

/**
 * 对科研项目操作类的实现
 * @author Guojun
 * 2014-8-22
 */
public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao {

	@Override
	public void addProject(Project project) {
		getHibernateTemplate().save(project);
	}

	@Override
	public void deleteProject(Project project) {
		getHibernateTemplate().delete(project);
	}

	@Override
	public void modifyProject(Project project) {
		getHibernateTemplate().update(project);
	}

	@Override
	public List<Project> findProjectByUser(int userId) {
		return getHibernateTemplate().find("from Project p where p.user.id=" + userId);
	}

	@Override
	public Project findProject(int id) {
		return (Project) getHibernateTemplate().load(Project.class, id);
	}

	@Override
	public List findkey(String sql) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(sql);
	}

}
