package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.UserDetail;

/**
 * 对用户详细信息的操作，用户详细信息应该是同用户基本信息进行级联操作，当统计协会学历学位等信息时
 * 会同时涉及到基本信息和详细信息，故仍然建立对用户详细信息的操作
 * @author Guojun
 * 2014-8-21
 */
public interface UserDetailDao {

	/**
	 * 添加一个用户详情，用户详情是同用户的基本信息一并存入的，这里留有一个接口供后期开发使用
	 * @param userDetail 需要添加的用户详细信息
	 */
	public void addUserDetail(UserDetail userDetail);
	
	/**
	 * 删除一个用户的详情，用户详情是同用户基本信息共存亡，一个用户可以没有详情信息，但如果存在用户详情，那么用户也是存在的
	 * @param userDetail 需要删除的用户详情
	 */
	public void deleteUserDetail(UserDetail userDetail);
	
	/**
	 * 修改用户的详情信息
	 * @param userDetail 已修改的用户详情信息
	 */
	public void modifyUserDetail(UserDetail userDetail);
	
	/**
	 * 根据编号找到用户详情信息
	 * @param id 用户编号
	 * @return UserDetail 用户的详细信息
	 */
	public UserDetail findUserDetail(int id);
	
	/**
	 * 找到所有用户详细信息
	 * @return List 所有用户的详细信息
	 */
	public List<UserDetail> findUserDetails();
}
