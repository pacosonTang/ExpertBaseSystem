package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.UserDetail;

/**
 * ���û���ϸ��Ϣ�Ĳ������û���ϸ��ϢӦ����ͬ�û�������Ϣ���м�����������ͳ��Э��ѧ��ѧλ����Ϣʱ
 * ��ͬʱ�漰��������Ϣ����ϸ��Ϣ������Ȼ�������û���ϸ��Ϣ�Ĳ���
 * @author Guojun
 * 2014-8-21
 */
public interface UserDetailDao {

	/**
	 * ���һ���û����飬�û�������ͬ�û��Ļ�����Ϣһ������ģ���������һ���ӿڹ����ڿ���ʹ��
	 * @param userDetail ��Ҫ��ӵ��û���ϸ��Ϣ
	 */
	public void addUserDetail(UserDetail userDetail);
	
	/**
	 * ɾ��һ���û������飬�û�������ͬ�û�������Ϣ��������һ���û�����û��������Ϣ������������û����飬��ô�û�Ҳ�Ǵ��ڵ�
	 * @param userDetail ��Ҫɾ�����û�����
	 */
	public void deleteUserDetail(UserDetail userDetail);
	
	/**
	 * �޸��û���������Ϣ
	 * @param userDetail ���޸ĵ��û�������Ϣ
	 */
	public void modifyUserDetail(UserDetail userDetail);
	
	/**
	 * ���ݱ���ҵ��û�������Ϣ
	 * @param id �û����
	 * @return UserDetail �û�����ϸ��Ϣ
	 */
	public UserDetail findUserDetail(int id);
	
	/**
	 * �ҵ������û���ϸ��Ϣ
	 * @return List �����û�����ϸ��Ϣ
	 */
	public List<UserDetail> findUserDetails();
}
