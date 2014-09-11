package com.cdkx.expertbasesystem.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 提供对会员的搜索的业务逻辑
 * @author Guojun
 *
 */
public class SearchAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private String searchValue;
	
	private String searchCondition;
	
	private List<User> members;
	
	private UserService userService;
	
	private Map<String, Object> session;
	
	/**
	 * 提供对用户的各种搜索，用户可以根据页面的提示进行选择，然后给出相应的值，根据用户选定的查询类别和查询值给出符合条件的会员信息
	 * @return
	 */
	public String searchMembers(){
		if(!(searchValue == null || searchValue.equals("")))
			members = userService.searchMembers(searchCondition, searchValue);
		User currentUser = userService.findUser(Integer.parseInt(session.get("userId").toString()));
		if(currentUser != null) {
			if(currentUser.getLevel() == 0)
				return "manager_success";
			else if(currentUser.getLevel() == 1)
				return "leader_success";
			else if(currentUser.getLevel() == 2)
				return "server_success";
			else
				return "member_success";
		} else
			throw new AppException("你没有登录，请登录后执行此操作！");
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
