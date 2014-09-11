package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.UserDetailDao;
import com.cdkx.expertbasesystem.domain.UserDetail;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.UserDetailService;

/**
 * 对用户详情实体服务的实现，对用户详情实体提供增删改查等服务
 * @author Guojun
 * 2014-8-24
 */
public class UserDetailServiceImpl implements UserDetailService {

	private UserDetailDao userDetailDao;
	
	@Override
	public void addUserDetail(UserDetail userDetail) {
		try {
			userDetailDao.addUserDetail(userDetail);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("添加用户详情信息失败！");
		}
	}

	@Override
	public void deleteUserDetail(UserDetail userDetail) {
		try {
			userDetailDao.deleteUserDetail(userDetail);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("删除用户详情失败！");
		}
	}

	@Override
	public void modifyUserDetail(UserDetail userDetail) {
		try {
			userDetailDao.modifyUserDetail(userDetail);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("修改用户详情失败！");
		}
	}

	@Override
	public void deleteUserDetailById(int id) {
		try {
			UserDetail userDetail = userDetailDao.findUserDetail(id);
			if(userDetail != null)
				this.deleteUserDetail(userDetail);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("删除ID=【" + id + "】的用户详情失败！");
		}
	}

	@Override
	public UserDetail findUserDetail(int id) {
		try {
			return userDetailDao.findUserDetail(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找ID=【" + id + "】的用户详情失败！");
		}
	}

	@Override
	public List<UserDetail> findUserDetails() {
		try {
			return userDetailDao.findUserDetails();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找所有用户的详情失败！");
		}
	}

	public void setUserDetailDao(UserDetailDao userDetailDao) {
		this.userDetailDao = userDetailDao;
	}

}
