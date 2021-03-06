package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.domain.Userfour;

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
	
	/**
	 * 通过指定hql语句查询会员
	 * @param hql
	 * @return List 符合hql条件的所有会员集合
	 */
	public List<User> searchMember(String hql);
	
	//【以下方法用于统计】
	
	/**
	 * 主要用户和数据库进行交互，service 直接传递sql就可以访问数据库了。
	 * @param sql
	 * @return
	 */
	
	public List findKeyword(String sql);
	
	/**
	 * @param sql， 要查询的slq
	 * @param pageindex，当前页面
	 * @return 集合 List<Userfour> 
	 */
	public List<Userfour> loaditempage(String sql,int pageindex);
	
	 
}
