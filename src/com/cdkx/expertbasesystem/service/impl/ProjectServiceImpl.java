package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.ProjectDao;
import com.cdkx.expertbasesystem.domain.Project;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.ProjectService;

/**
 * �Կ�����Ŀʵ������ʵ�֣��ṩ�Կ�����Ŀʵ�����ɾ��ȷ���
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
			throw new AppException("��ӿ�����Ŀ��Ϣʧ�ܣ�");
		}
	}

	@Override
	public void deleteProject(Project project) {
		try {
			projectDao.deleteProject(project);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ɾ��ID=��" + project.getId() + "���Ŀ�����Ŀʧ�ܣ�");
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
			throw new AppException("ɾ��ID=��" + id + "���Ŀ�����Ŀ��Ϣʧ�ܣ�");
		}
	}

	@Override
	public Project findProject(int id) {
		try {
			return projectDao.findProject(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("����ID=��" + id + "���Ŀ�����Ŀ��Ϣʧ��");
		}
	}

	@Override
	public List<Project> findProjectByUser(int userId) {
		try {
			return projectDao.findProjectByUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("�����û�ID=��" + userId + "���û�����Ŀ�����Ŀ��Ϣʧ�ܣ�");
		}
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

}
