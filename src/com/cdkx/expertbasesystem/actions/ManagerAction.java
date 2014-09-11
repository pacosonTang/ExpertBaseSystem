package com.cdkx.expertbasesystem.actions;

import java.util.List;

import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �ṩ��������Ϣ�Ĺ��������Ի�Ա���г���������Ա���쵼��Ϣ�Ĺ������ݿ�ı�����ָ��Ĺ����ҵ���߼�
 * @author Guojun
 *
 */
public class ManagerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private List<User> leaders;
	
	private List<User> members;
	
	private List<User> servers;
	
	private String selectIds;
	
	private UserService userService;
	
	/**
	 * ��ʾ����˵Ļ�Ա
	 * @return
	 */
	public String showUncheckedUsers(){
		members = userService.findUncheckedUsers();
		return SUCCESS;
	}
	
	/**
	 * ���û���Ϣ�������,ͬ���û���ע��
	 * @return ��ת���û����ҳ��
	 */
	public String passUser(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++){
			user = userService.findUser(Integer.parseInt(ids[i]));
			if(user != null){
				user.setChecked(1);
				userService.modifyUser(user);
			} else
				throw new AppException("���û������ڣ�");
		}
		return SUCCESS;
	}
	
	/**
	 * �ܾ��û���ע��
	 * @return ��ת�����ҳ��
	 */
	public String refuseUser(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++){
			userService.deleteUser(Integer.parseInt(ids[i]));
		}
		return SUCCESS;
	}
	
	/**
	 * �쵼ͳһ��Ϊû��������Ϣ��ֻ�б�Ҫ��Ϣ
	 * �쵼��Ϣ�ɹ���Ա���
	 * @return
	 */
	public String addLeader(){
		user.setLevel(1);
		userService.addUser(user);
		return SUCCESS;
	}
	
	/**
	 * ����г���������Ա
	 * @return
	 */
	public String addServer(){
		user.setLevel(2);
		userService.addUser(user);
		return SUCCESS;
	}
	
	/**
	 * ��ӻ�Ա
	 * @return
	 */
	public String addMember(){
		user.setLevel(3);
		userService.addUser(user);
		return SUCCESS;
	}
	
	/**
	 * ɾ���г���������Ա<br>
	 * �����Ҫɾ�������г�������Ա����ôֻ��Ҫ����Ҫɾ���ı�ű�����selectIds������̨����<br>
	 * ���Ҫɾ������г���������Ա����ô�轫ѡ���idȫ���ռ�������Ȼ���á�,����������selectIds��<br>
	 * �����ֱ�ӽ���ѡ��ȡ��ͬ���ִ��䣬��ô���䵽��̨��������Ҫ�޸�Ϊint�͵����飬�Ի�Ա���쵼�Ĳ�����Ȼ
	 * @return
	 */
	public String deleteServers(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			userService.deleteUser(Integer.parseInt(ids[i]));
		return SUCCESS;
	}
	
	/**
	 * ɾ����Ա��Ϣ
	 * @return
	 */
	public String deleteMembers(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			userService.deleteUser(Integer.parseInt(ids[i]));
		return SUCCESS;
	}
	
	/**
	 * ����ɾ���쵼��Ϣ
	 * @return
	 */
	public String deleteLeaders(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			userService.deleteUser(Integer.parseInt(ids[i]));
		return SUCCESS;
	}
	
	/**
	 * ��ʾ���е��쵼��Ϣ
	 * @return
	 */
	public String showLeaders(){
		leaders = userService.findLeaders();
		return SUCCESS;
	}
	
	/**
	 * ��ʾ���еĻ�Ա��Ϣ
	 * @return
	 */
	public String showMembers(){
		members = userService.findMembers();
		return SUCCESS;
	}
	
	public String showServers(){
		servers = userService.findServers();
		return SUCCESS;
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

	public List<User> getLeaders() {
		return leaders;
	}

	public List<User> getMembers() {
		return members;
	}

	public List<User> getServers() {
		return servers;
	}

}
