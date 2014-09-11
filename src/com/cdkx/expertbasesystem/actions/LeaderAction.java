package com.cdkx.expertbasesystem.actions;

import java.util.List;

import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Ϊ�쵼�ṩ��Աͳ�ƣ���Ա��ѯ��ҵ���߼�
 * @author Guojun
 *
 */
public class LeaderAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private List<User> members;
	
	private UserService userService;
	
	private String countCondition;
	
	public String showMembers(){
		members = userService.findMembers();
		return SUCCESS;
	}
	
	public String countMember(){
		
		return SUCCESS;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setCountCondition(String countCondition) {
		this.countCondition = countCondition;
	}

}
