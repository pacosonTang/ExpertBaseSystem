package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.User;

/**
 * �����user����в���
 * @author Guojun
 * 2014-8-21
 */
public interface UserDao {

	/**
	 * �����û���¼ʹʹ��
	 * @param user
	 * @return List
	 */
	public List<User> login(User user);
	
	/**
	 * ����ȫ���û���Ϣ
	 * @return List ���л�Ա��Ϣ�ļ���
	 */
	public List<User> findMembers();
	
	/**
	 * �������е��쵼��Ϣ
	 * @return List �����쵼��Ϣ�ļ���
	 */
	public List<User> findLeaders();
	
	/**
	 * �������е��г���������Ա��Ϣ
	 * @return List �����г���������Ա��Ϣ�ļ���
	 */
	public List<User> findServers();
	
	/**
	 * ͨ��ʹ��һ���û���id���������User��ȫ����Ϣ
	 * @param id
	 * @return User
	 */
	public User findUserById(int id);
	
	/**
	 * ���һ���û�����Ϣ
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * �޸�һ���û�����Ϣ
	 * @param user
	 */
	public void modifyUser(User user);
	
	/**
	 * ͨ��ֱ��ɾ���û�����ɾ��һ���û�����Ϣ
	 * @param user
	 */
	public void deleteUser(User user);
	
	/**
	 * ���û�������������ѯ���������Ļ�Ա
	 * @param searchCondition ��ѯ����
	 * @param searchValue ��ѯ��ԱҪ������Ӧ������ֵ
	 * @return List �������������Ļ�Ա�ļ���
	 */
	public List<User> searchUsers(String searchCondition, String searchValue);
	
	/**
	 * ���һ�û����˵Ļ�Ա
	 * @return List ����δ��˵Ļ�Ա����Ϣ
	 */
	public List<User> findUncheckedUsers();
	
	/**
	 * �Ի�Ա��Ϣ����ͳ��
	 * @return Obeject
	 */
	public List<Object[]> statisticMembers(String countCondition);
	
	/**
	 * ���Ҿ�����ͬ�û������û������жϵ�ǰ�û��޸ĵ��ʺ���Ψһ��
	 * @param username �û��µ��ʺ�
	 * @return ʹ�ø��û����������û�
	 */
	public List<User> findUsersByUsername(String username);
}
