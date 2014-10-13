package com.cdkx.expertbasesystem.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.service.UserService;
import com.cdkx.expertbasesystem.utils.MD5Util;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 此类专门用于用户进行登录和退出操作
 * @author Guojun
 *
 */

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	//登录信息
	private User user;
	
	//用户业务逻辑
	private UserService userService;
	
	//取得Session会话
	private Map<String, Object> session;
	
	/**
	 * 用户登录
	 */
	public String login(){
		
		this.session.put("access", "member");
		user.setPassword(MD5Util.encode(user.getPassword()));
		List<User> users = userService.login(user);
		if(users != null && !users.isEmpty()){
			user = users.get(0);
			
			session.put("userId", user.getId());
			session.put("username", user.getUsername());
			session.remove("loginError");
			if(user.getLevel() == 0)
				return "manager_success";
			else if(user.getLevel() == 1){
				
				return "leader_success";
			}
			else if(user.getLevel() == 2)
				return "server_success";
			else if(user.getLevel() == 3)
				return "member_success";
			else
				return ERROR;
		} else {
			session.put("loginError", "用户名和密码不匹配！");
			return ERROR;
		}
	}
	
	/**
	 * 以下是跳转页面的访问
	 * @return success
	 */
	
	public String skip_patent(){
		
		this.session.put("access", "patent");
		return SUCCESS;
	}
	
	public String skip_award(){
		
		this.session.put("access", "award");
		return SUCCESS;
	}
	
	public String skip_project(){
		
		this.session.put("access", "project");
		return SUCCESS;
	}
	public String skip_thesis(){
		
		this.session.put("access", "thesis");
		return SUCCESS;
	}
	
	public String skip_member(){
		
		this.session.put("access", "member");
		return SUCCESS;
	}
	
	public String skip_someone(){
		
		
		this.session.put("access", "someone");
		return SUCCESS;
	}
	
	
	/**
	 * 用户注销
	 */
	public void logout(){
		session.remove("userID");
		session.remove("loginError");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
