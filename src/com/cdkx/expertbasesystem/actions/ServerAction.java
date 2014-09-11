package com.cdkx.expertbasesystem.actions;

import java.util.List;

import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class ServerAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private List<User> members;
	
	private String searchCondition;
	
	private String searchValue;
	
	private UserService userService;
	
	/**
	 * 显示所有的会员信息
	 * @return
	 */
	public String showMembers(){
		members = userService.findMembers();
		return SUCCESS;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

}
