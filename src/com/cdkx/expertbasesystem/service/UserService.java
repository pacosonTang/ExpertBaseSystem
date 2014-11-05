package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.ConditionDTO;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.domain.Userfour;
import com.cdkx.expertbasesystem.dto.BiPropertyDTO;
import com.cdkx.expertbasesystem.dto.UserChartDTO;
import com.cdkx.expertbasesystem.dto.UserTotalDTO;

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
	 * 通过指定的条件查询会员
	 * @param conditionDTO 用户给定的查询条件
	 * @return 符合用户给定条件的所有会员集合
	 */
	public List<User> searchMember(ConditionDTO conditionDTO);
	
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
	
	// 以下是统计功能
	/**
	 * 通过用户名来查找用户 【统计】
	 * @param username 需要查找的用户名
	 * @return 使用该用户名的所有用户
	 */
	public List<User> findUsers(String username);
	
	/**
	 * 通过学科科目来查找用户 【统计】
	 * @param sub 需要查找的科目
	 * @return 用户名列表
	 */
	public List<String> findUserBySub(String sub);
	
	/**
	 * 通过学科科目来查找用户的统计信息， 包括 4项，专利，项目，论文，奖励数量
	 * @param sub 需要查找的科目
	 * @return Userfour 传输类的集合
	 */
	public List<Userfour> countnum(String sub,int pageindex);
	
	/**
	 * 通过  一级学科  科目来 查询专家姓名和id
	 * @param sub 需要查找的科目
	 * @return 专家姓名和编号的集合
	 */
	public List<BiPropertyDTO> findUserBySub_count(String sub);
	
	/**
	 * 通过  用户id来查询用户详细信心
	 * @param 用户编号
	 * @return 用户
	 */
	public User findUserById(String id);
	
}
