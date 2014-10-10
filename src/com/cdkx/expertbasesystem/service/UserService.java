package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.ConditionDTO;
import com.cdkx.expertbasesystem.domain.User;

/**
 * �ṩ����User����ķ���
 * @author Guojun
 *
 */
public interface UserService {

	/**
	 * �û���¼����ѯ���û��Ƿ���������ݿ���
	 * @param user ��ǰ��¼���û���Ϣ
	 * @return List ���ݿ���ƥ����û�
	 */
	public List<User> login(User user);
	
	/**
	 * �������л�Ա
	 * @return List ���л�Ա��Ϣ�ļ���
	 */
	public List<User> findMembers();
	
	/**
	 * ���������쵼��Ϣ
	 * @return List �����쵼��Ϣ�ļ���
	 */
	public List<User> findLeaders();
	
	/**
	 * ���������г���������Ա��Ϣ
	 * @return �����г���������Ա��Ϣ�ļ���
	 */
	public List<User> findServers();
	
	/**
	 * ͨ��id���Ҹ��û���������Ϣ
	 * @param id �����ҵ��û��ı��
	 * @return User ��Ӧ���û�ʵ��
	 */
	public User findUser(int id);
	
	/**
	 * ����һ���û�����Ϣ
	 * @param user ����ӵ��û�
	 */
	public void addUser(User user);
	
	/**
	 * �޸��û���Ϣ
	 * @param user ���޸ĵ��û���Ϣ
	 */
	public void modifyUser(User user);
	
	/**
	 * ͨ��User����ɾ�����û�
	 * @param user ��ɾ���û�
	 */
	public void deleteUser(User user);
	
	/**
	 * ͨ���û�idɾ���û�
	 * @param id ��ɾ���û��ı��
	 */
	public void deleteUser(int id);
	
	/**
	 * ͨ��ָ����������ѯ��Ա
	 * @param conditionDTO �û������Ĳ�ѯ����
	 * @return �����û��������������л�Ա����
	 */
	public List<User> searchMember(ConditionDTO conditionDTO);
	
	/**
	 * �Ի�Ա����ͳ��
	 * @return
	 */
	public List<Object[]> statisticMembers(String countCondition);
	
	/**
	 * ͨ���û����������û�
	 * @param username ��Ҫ���ҵ��û���
	 * @return ʹ�ø��û����������û�
	 */
	public List<User> findUsersByUsername(String username);
}
