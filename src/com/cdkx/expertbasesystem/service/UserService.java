package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.User;

/**
 * 提供基于User对象的服务
 * @author Guojun
 *
 */
public interface UserService {

	/**
	 * 用户登录，查询该用户是否存在于数据库中
	 * @param user 当前登录的用户信息
	 * @return List 数据库中匹配的用户
	 */
	public List<User> login(User user);
	
	/**
	 * 查找所有会员
	 * @return List 所有会员信息的集合
	 */
	public List<User> findMembers();
	
	/**
	 * 查找所有领导信息
	 * @return List 所有领导信息的集合
	 */
	public List<User> findLeaders();
	
	/**
	 * 查找所有市场化服务人员信息
	 * @return 所有市场化服务人员信息的集合
	 */
	public List<User> findServers();
	
	/**
	 * 通过id查找该用户的所有信息
	 * @param id 待查找的用户的编号
	 * @return User 对应的用户实体
	 */
	public User findUser(int id);
	
	/**
	 * 增加一个用户的信息
	 * @param user 待添加的用户
	 */
	public void addUser(User user);
	
	/**
	 * 修改用户信息
	 * @param user 已修改的用户信息
	 */
	public void modifyUser(User user);
	
	/**
	 * 通过User对象删除该用户
	 * @param user 待删除用户
	 */
	public void deleteUser(User user);
	
	/**
	 * 通过用户id删除用户
	 * @param id 待删除用户的编号
	 */
	public void deleteUser(int id);
	
	/**
	 * 根据用户给出的条件查询相应的用户
	 * @param searchCondition 查询条件
	 * @param searchValue 需要查询的值
	 * @return List 满足条件的所有用户的集合
	 */
	public List<User> searchMembers(String searchCondition, String searchValue);
	
	/**
	 * 查找所有未审核的会员
	 * @return List 所有未审核的用户信息
	 */
	public List<User> findUncheckedUsers();
	
	/**
	 * 对会员进行统计
	 * @return
	 */
	public List<Object[]> statisticMembers(String countCondition);
	
	/**
	 * 通过用户名来查找用户
	 * @param username 需要查找的用户名
	 * @return 使用该用户名的所有用户
	 */
	public List<User> findUsersByUsername(String username);
}
