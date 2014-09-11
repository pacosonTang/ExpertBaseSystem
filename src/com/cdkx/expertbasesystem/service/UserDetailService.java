package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.UserDetail;

/**
 * 对用户详情实体类的服务
 * @author Guojun
 * 2014-8-23
 */
public interface UserDetailService {

	/**
	 * 添加用户详情实体
	 * @param userDetail 用户详情实体
	 */
	public void addUserDetail(UserDetail userDetail);
	
	/**
	 * 删除用户详情实体
	 * @param userDetail 需删除的用户实体
	 */
	public void deleteUserDetail(UserDetail userDetail);
	
	/**
	 * 修改用户详情实体
	 * @param userDetail 已修改的用户详情实体
	 */
	public void modifyUserDetail(UserDetail userDetail);
	
	/**
	 * 根据用户详情实体的的编号删除用户详情实体
	 * @param id 用户编号或者用户详情编号
	 */
	public void deleteUserDetailById(int id);
	
	/**
	 * 通过用户编号或者用户详情编号找到用户详情实体（用户编号和用户详情编号是一对一主键关联）
	 * @param id 用户编号或者用户详情编号
	 * @return UserDetail 对应的用户详情实体
	 */
	public UserDetail findUserDetail(int id);
	
	/**
	 * 找到所有的用户详情实体
	 * @return List 所有用户详情实体的集合
	 */
	public List<UserDetail> findUserDetails();
}
