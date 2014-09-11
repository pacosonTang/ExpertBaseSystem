package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.UserDetailDao;
import com.cdkx.expertbasesystem.domain.UserDetail;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.UserDetailService;

/**
 * ���û�����ʵ������ʵ�֣����û�����ʵ���ṩ��ɾ�Ĳ�ȷ���
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
			throw new AppException("����û�������Ϣʧ�ܣ�");
		}
	}

	@Override
	public void deleteUserDetail(UserDetail userDetail) {
		try {
			userDetailDao.deleteUserDetail(userDetail);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ɾ���û�����ʧ�ܣ�");
		}
	}

	@Override
	public void modifyUserDetail(UserDetail userDetail) {
		try {
			userDetailDao.modifyUserDetail(userDetail);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("�޸��û�����ʧ�ܣ�");
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
			throw new AppException("ɾ��ID=��" + id + "�����û�����ʧ�ܣ�");
		}
	}

	@Override
	public UserDetail findUserDetail(int id) {
		try {
			return userDetailDao.findUserDetail(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("����ID=��" + id + "�����û�����ʧ�ܣ�");
		}
	}

	@Override
	public List<UserDetail> findUserDetails() {
		try {
			return userDetailDao.findUserDetails();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("���������û�������ʧ�ܣ�");
		}
	}

	public void setUserDetailDao(UserDetailDao userDetailDao) {
		this.userDetailDao = userDetailDao;
	}

}
