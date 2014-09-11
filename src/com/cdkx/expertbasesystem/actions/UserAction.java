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
 * �����û���Ϣ�����в������ڴ˽�����Ӧ�ͷַ�<br>
 * 1.��Ա���Լ���Ϣִ�еĲ���������ע�ᡢ��ѯ�޸��Լ�����Ϣ<br>
 * 2.�쵼���Լ���Ϣ���޸ģ���ѯ<br>
 * 3.�г���������Ա���Լ���Ϣ���޸Ĳ�ѯ<br>
 * 4.����Ա���Լ���Ϣ�Ĳ�ѯ�޸�<br>
 * @author Guojun
 *
 */
public class UserAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	
	//ǰ����Ҫ����User��UserDetail����Ϣ��ʹ�÷����ǣ������User�����ԣ�
	//��ֱ��user.xxxx�������UserDetail�����ԣ�����Ҫʹ��user.userDetail.xxxx
	private User user;
	
	private List<User> users;
	
	private UserService userService;
	
	/**
	 * �û�ע��<br>
	 * ����Ϣ�Ŀ�������֤����ǰ�ˣ����ֻ����������
	 * @return ע��ɹ�����ת����Ϣ,�ɹ�ת���¼ҳ�棬ʧ��ת��ʧ�ܴ�����ҳ��
	 */
	public String register(){
		user.setChecked(0);
		user.setPassword(MD5Util.encode(user.getPassword()));
		userService.addUser(user);
		return SUCCESS;
	}
	
	/**
	 * �޸��û���Ϣ
	 * @return �����û�����ת����Ӧ�û���ҳ��
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
			throw new AppException("�û�û�е�¼");
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
