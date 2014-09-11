package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.ProjectDao;
import com.cdkx.expertbasesystem.domain.Project;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.ProjectService;

/**
 * 对科研项目实体服务的实现，提供对科研项目实体的增删查等服务
 * @author Guojun
 * 2014-8-24
 */
public class ProjectServiceImpl implements ProjectService {

	private ProjectDao projectDao;
	
	@Override
	public void addProject(Project project) {
		try {
			projectDao.addProject(project);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("添加科研项目信息失败！");
		}
	}

	@Override
	public void deleteProject(Project project) {
		try {
			projectDao.deleteProject(project);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("删除ID=【" + project.getId() + "】的科研项目失败！");
		}
	}

	@Override
	public void deleteProjectById(int id) {
		try {
			Project project = projectDao.findProject(id);
			if(project != null)
				projectDao.deleteProject(project);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("删除ID=【" + id + "】的科研项目信息失败！");
		}
	}

	@Override
	public Project findProject(int id) {
		try {
			return projectDao.findProject(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找ID=【" + id + "】的科研项目信息失败");
		}
	}

	@Override
	public List<Project> findProjectByUser(int userId) {
		try {
			return projectDao.findProjectByUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找用户ID=【" + userId + "】用户参与的科研项目信息失败！");
		}
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

}
