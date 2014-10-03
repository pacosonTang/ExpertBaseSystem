package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.User;

/**
 * 负责对user表进行操作
 * @author Guojun
 * 2014-8-21
 */
public interface UserDao {

	/**
	 * 用于用户登录使使用
	 * @param user
	 * @return List
	 */
	public List<User> login(User user);
	
	/**
	 * 查找全部用户信息
	 * @return List 所有会员信息的集合
	 */
	public List<User> findMembers();
	
	/**
	 * 查找所有的领导信息
	 * @return List 所有领导信息的集合
	 */
	public List<User> findLeaders();
	
	/**
	 * 查找所有的市场化服务人员信息
	 * @return List 所有市场化服务人员信息的集合
	 */
	public List<User> findServers();
	
	/**
	 * 通过使用一个用户的id来查找这个User的全部信息
	 * @param id
	 * @return User
	 */
	public User findUserById(int id);
	
	/**
	 * 添加一个用户的信息
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 修改一个用户的信息
	 * @param user
	 */
	public void modifyUser(User user);
	
	/**
	 * 通过直接删除用户对象删除一个用户的信息
	 * @param user
	 */
	public void deleteUser(User user);
	
	/**
	 * 按用户给出的条件查询满足条件的会员
	 * @param searchCondition 查询条件
	 * @param searchValue 查询会员要满足相应条件的值
	 * @return List 所有满足条件的会员的集合
	 */
	public List<User> searchUsers(String searchCondition, String searchValue);
	
	/**
	 * 查找还没有审核的会员
	 * @return List 所有未审核的会员的信息
	 */
	public List<User> findUncheckedUsers();
	
	/**
	 * 对会员信息进行统计
	 * @return Obeject
	 */
	public List<Object[]> statisticMembers(String countCondition);
	
	/**
	 * 查找具有相同用户名的用户，以判断当前用户修改的帐号是唯一的
	 * @param username 用户新的帐号
	 * @return 使用该用户名的所有用户
	 */
	public List<User> findUsersByUsername(String username);
}
