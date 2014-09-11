package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.UserDetail;

/**
 * ���û�����ʵ����ķ���
 * @author Guojun
 * 2014-8-23
 */
public interface UserDetailService {

	/**
	 * ����û�����ʵ��
	 * @param userDetail �û�����ʵ��
	 */
	public void addUserDetail(UserDetail userDetail);
	
	/**
	 * ɾ���û�����ʵ��
	 * @param userDetail ��ɾ�����û�ʵ��
	 */
	public void deleteUserDetail(UserDetail userDetail);
	
	/**
	 * �޸��û�����ʵ��
	 * @param userDetail ���޸ĵ��û�����ʵ��
	 */
	public void modifyUserDetail(UserDetail userDetail);
	
	/**
	 * �����û�����ʵ��ĵı��ɾ���û�����ʵ��
	 * @param id �û���Ż����û�������
	 */
	public void deleteUserDetailById(int id);
	
	/**
	 * ͨ���û���Ż����û��������ҵ��û�����ʵ�壨�û���ź��û���������һ��һ����������
	 * @param id �û���Ż����û�������
	 * @return UserDetail ��Ӧ���û�����ʵ��
	 */
	public UserDetail findUserDetail(int id);
	
	/**
	 * �ҵ����е��û�����ʵ��
	 * @return List �����û�����ʵ��ļ���
	 */
	public List<UserDetail> findUserDetails();
}
