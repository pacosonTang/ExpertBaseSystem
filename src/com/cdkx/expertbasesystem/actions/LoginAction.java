package com.cdkx.expertbasesystem.actions;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.UserService;
import com.cdkx.expertbasesystem.utils.BaseAction;
import com.cdkx.expertbasesystem.utils.MD5Util;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ����ר�������û����е�¼���˳�����
 * @author Guojun
 *
 */

public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	//��¼��Ϣ
	private User user;
	
	//�û�ҵ���߼�
	private UserService userService;
	
	//ȡ��Session�Ự
	private Map<String, Object> session;
	
	/**
	 * �û���¼
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
			session.put("loginError", "�û��������벻ƥ�䣡");
			return ERROR;
		}
	}
	
	/**
	 * �û�ע��
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
