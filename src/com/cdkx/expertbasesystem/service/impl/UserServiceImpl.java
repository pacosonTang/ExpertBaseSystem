package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.UserDao;
import com.cdkx.expertbasesystem.domain.ConditionDTO;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.UserService;

/**
 * ���û�����ӿڵ�ʵ�֣��ṩ���û�ʵ�����ɾ�Ĳ�
 * @author Guojun
 * 2014-8-23
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Override
	public List<User> login(User user) {
		try {
			return userDao.login(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ�û���Ϊ��" + user.getUsername() +"��ʧ�ܣ�");
		}
	}

	@Override
	public User findUser(int id) {
		try {
			return userDao.findUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException();
		}
	}

	@Override
	public void addUser(User user) {
		try {
			userDao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException();
		}
	}

	@Override
	public void modifyUser(User user) {
		try {
			userDao.modifyUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException();
		}
	}

	@Override
	public void deleteUser(User user) {
		try {
			userDao.deleteUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException();
		}
	}

	@Override
	public void deleteUser(int id) {
		try {
			User user = userDao.findUserById(id);
			if(user != null)
				userDao.deleteUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException();
		}
	}

	public void setUserDao(UserDao userDao) {
		try {
			this.userDao = userDao;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException();
		}
	}

	@Override
	public List<User> findMembers() {
		try {
			return userDao.findMembers();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("�������л�Ա��Ϣʧ�ܣ�");
		}
	}

	@Override
	public List<User> findLeaders() {
		try {
			return userDao.findLeaders();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("���������쵼��Ϣʧ�ܣ�");
		}
	}

	@Override
	public List<User> findServers() {
		try {
			return userDao.findServers();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("���������г���������Ա��Ϣʧ�ܣ�");
		}
	}

	@Override
	public List<Object[]> statisticMembers(String countCondition) {
		//if(countCondition.equals(""))
		try {
			return userDao.statisticMembers(countCondition);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ͳ���û�ʧ�ܣ�");
		}
	}

	@Override
	public List<User> findUsersByUsername(String username) {
		try {
			return userDao.findUsersByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ�û���=��" + username + "�����û�ʧ�ܣ�");
		}
	}

	@Override
	public List<User> searchMember(ConditionDTO conditionDTO) {
		String hql = "from User u left join fetch u.institution left join fetch u.degree left join fetch u.education where u.level=3";
		if(conditionDTO.getDegree() != 0){
			hql += "and u.degree.id=" + conditionDTO.getDegree();
		}
		if(conditionDTO.getEducation() != 0){
			hql += "and u.education.id=" + conditionDTO.getEducation();
		}
		if(conditionDTO.getInstitution() != 0){
			hql += "and u.institution.id=" + conditionDTO.getInstitution();
		}
		if(conditionDTO.getCurrentMajor() !=null && !"".equals(conditionDTO.getCurrentMajor())){
			hql += "and u.currentMajor like '%" + conditionDTO.getCurrentMajor() + "%'";
		}
		if(conditionDTO.getAdept() != null && !"".equals(conditionDTO.getAdept())){
			hql += "and u.adept like '%" + conditionDTO.getAdept() + "%'";
		}
		if(conditionDTO.getTitle() != null && !"".equals(conditionDTO.getTitle())){
			hql += "and u.title like '%" + conditionDTO.getTitle() + "%'";
		}
		return userDao.searchMember(hql);
	}

}
