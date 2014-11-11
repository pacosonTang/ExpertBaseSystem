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
		
		String[] level_array = {"����Ա","�쵼","������Ա","��Ա"};
		this.session.put("access", "member");
		user.setPassword(MD5Util.encode(user.getPassword()));
		List<User> users = userService.login(user);
		if(users != null && !users.isEmpty()){
			user = users.get(0);
			session.put("userId", user.getId());
			session.put("username", user.getUsername());
			session.put("cur_realname", user.getRealname());//��ʵ����
			session.put("cur_level", user.getLevel());
			session.remove("loginError");
			if(user.getLevel() == 0){ //����Ա
				this.session.put("cur_type", "����Ա");
				return "manager_success";
			}
			else if(user.getLevel() == 1){
				this.session.put("cur_type", "��Э�쵼");
				return "leader_success"; //�쵼
			}
			else if(user.getLevel() == 2){
				this.session.put("cur_type", "������Ա");
				return "server_success"; //������Ա
			}
			else if(user.getLevel() == 3){
				this.session.put("cur_type", "��Ա");
				return "member_success"; //��Ա
			}
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
	public String logout(){
		try {
			session.remove("userId");
			session.remove("loginError"); 
			session.remove("username");
			session.remove("cur_realname");//��ʵ����
			session.remove("cur_level");
			session.remove("cur_type");
			session.remove("someone");
			session.remove("item_total");
			session.remove("cur_sub");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
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
