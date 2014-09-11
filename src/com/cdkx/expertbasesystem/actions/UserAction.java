package com.cdkx.expertbasesystem.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.UserService;
import com.cdkx.expertbasesystem.utils.MD5Util;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 关于用户信息的所有操作都在此进行响应和分发<br>
 * 1.会员对自己信息执行的操作，包括注册、查询修改自己的信息<br>
 * 2.领导对自己信息的修改，查询<br>
 * 3.市场化服务人员对自己信息的修改查询<br>
 * 4.管理员对自己信息的查询修改<br>
 * @author Guojun
 *
 */
public class UserAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	
	//前端需要传入User和UserDetail的信息，使用方法是：如果是User的属性，
	//则直接user.xxxx，如果是UserDetail的属性，则需要使用user.userDetail.xxxx
	private User user;
	
	private List<User> users;
	
	private UserService userService;
	
	/**
	 * 用户注册<br>
	 * 将信息的可用性验证放在前端，后端只负责处理数据
	 * @return 注册成功与否的转向信息,成功转向登录页面，失败转向失败错误处理页面
	 */
	public String register(){
		user.setChecked(0);
		user.setPassword(MD5Util.encode(user.getPassword()));
		userService.addUser(user);
		return SUCCESS;
	}
	
	/**
	 * 修改用户信息
	 * @return 根据用户类型转向相应用户的页面
	 */
	public String modifyUser(){
		userService.modifyUser(user);
		return SUCCESS;
	}
	
	public String showUser(){
		if(session.get("userId") != null){
			int id = Integer.parseInt(session.get("userId").toString());
			
			user = userService.findUser(id);
			if(user.getLevel() == 0)
				return "manager_success";
			else if(user.getLevel() == 1)
				return "leader_success";
			else if(user.getLevel() == 2)
				return "server_success";
			else
				return "member_success";
		} else 
			throw new AppException("用户没有登录");
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
