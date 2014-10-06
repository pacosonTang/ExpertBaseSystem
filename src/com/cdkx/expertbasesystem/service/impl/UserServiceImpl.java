package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.UserDao;
import com.cdkx.expertbasesystem.domain.ConditionDTO;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.UserService;

/**
 * 对用户服务接口的实现，提供对用户实体的增删改查
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
			throw new AppException("查询用户名为【" + user.getUsername() +"】失败！");
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
			throw new AppException("查找所有会员信息失败！");
		}
	}

	@Override
	public List<User> findLeaders() {
		try {
			return userDao.findLeaders();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找所有领导信息失败！");
		}
	}

	@Override
	public List<User> findServers() {
		try {
			return userDao.findServers();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找所有市场化服务人员信息失败！");
		}
	}

	@Override
	public List<Object[]> statisticMembers(String countCondition) {
		//if(countCondition.equals(""))
		try {
			return userDao.statisticMembers(countCondition);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("统计用户失败！");
		}
	}

	@Override
	public List<User> findUsersByUsername(String username) {
		try {
			return userDao.findUsersByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询用户名=【" + username + "】的用户失败！");
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
