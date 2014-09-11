package com.cdkx.expertbasesystem.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �ṩ�Ի�Ա��������ҵ���߼�
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
	 * �ṩ���û��ĸ����������û����Ը���ҳ�����ʾ����ѡ��Ȼ�������Ӧ��ֵ�������û�ѡ���Ĳ�ѯ���Ͳ�ѯֵ�������������Ļ�Ա��Ϣ
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
			throw new AppException("��û�е�¼�����¼��ִ�д˲�����");
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
