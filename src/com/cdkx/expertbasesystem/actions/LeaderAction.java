package com.cdkx.expertbasesystem.actions;

import java.util.List;

import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 为领导提供会员统计，会员查询等业务逻辑
 * @author Guojun
 *
 */
public class LeaderAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private List<User> members;
	
	private UserService userService;
	
	private String countCondition;
	
	private List<Object[]> count;
	
	/**
	 * 显示所有的会员信息
	 * @return
	 */
	public String showMembers(){
		members = userService.findMembers();
		return SUCCESS;
	}
	
	/**
	 * 对会员信息进行统计<br>
	 * 返回的是一个Object对象数组的list集合，在jsp中进行访问的时候需要利用iterator标签进行循环<br>
	 * 并且其中的Object数组需要用id来进行访问，用#{id}[0]来获取<br>
	 * json表示暂时没有测试<br>
	 * 需要用户选择搜索条件，例如按学位搜索、按学历搜索、按职称搜索等，传回来的是这些条件的英文表示
	 * degree-学位
	 * education-学历
	 * title-职称（需要讨论）
	 * institution-协会（需讨论）
	 * @return
	 */
	public String countMember(){
		count = (List<Object[]>) userService.statisticMembers(countCondition);
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

	public Object getCount() {
		return count;
	}

}
