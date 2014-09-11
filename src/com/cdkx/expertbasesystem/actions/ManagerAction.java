package com.cdkx.expertbasesystem.actions;

import java.util.List;

import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 提供对所有信息的管理，包括对会员、市场化服务人员、领导信息的管理，数据库的备份与恢复的管理等业务逻辑
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
	 * 显示待审核的会员
	 * @return
	 */
	public String showUncheckedUsers(){
		members = userService.findUncheckedUsers();
		return SUCCESS;
	}
	
	/**
	 * 对用户信息进行审核,同意用户的注册
	 * @return 回转到用户审核页面
	 */
	public String passUser(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++){
			user = userService.findUser(Integer.parseInt(ids[i]));
			if(user != null){
				user.setChecked(1);
				userService.modifyUser(user);
			} else
				throw new AppException("该用户不存在！");
		}
		return SUCCESS;
	}
	
	/**
	 * 拒绝用户的注册
	 * @return 回转到审核页面
	 */
	public String refuseUser(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++){
			userService.deleteUser(Integer.parseInt(ids[i]));
		}
		return SUCCESS;
	}
	
	/**
	 * 领导统一视为没有详情信息，只有必要信息
	 * 领导信息由管理员添加
	 * @return
	 */
	public String addLeader(){
		user.setLevel(1);
		userService.addUser(user);
		return SUCCESS;
	}
	
	/**
	 * 添加市场化服务人员
	 * @return
	 */
	public String addServer(){
		user.setLevel(2);
		userService.addUser(user);
		return SUCCESS;
	}
	
	/**
	 * 添加会员
	 * @return
	 */
	public String addMember(){
		user.setLevel(3);
		userService.addUser(user);
		return SUCCESS;
	}
	
	/**
	 * 删除市场化服务人员<br>
	 * 如果需要删除单个市场服务人员，那么只需要将需要删除的编号保存在selectIds传到后台即可<br>
	 * 如果要删除多个市场化服务人员，那么需将选择的id全部收集起来，然后用“,”隔开存入selectIds中<br>
	 * 如果是直接将复选框取相同名字传输，那么传输到后台的数据需要修改为int型的数组，对会员、领导的操作亦然
	 * @return
	 */
	public String deleteServers(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			userService.deleteUser(Integer.parseInt(ids[i]));
		return SUCCESS;
	}
	
	/**
	 * 删除会员信息
	 * @return
	 */
	public String deleteMembers(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			userService.deleteUser(Integer.parseInt(ids[i]));
		return SUCCESS;
	}
	
	/**
	 * 批量删除领导信息
	 * @return
	 */
	public String deleteLeaders(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			userService.deleteUser(Integer.parseInt(ids[i]));
		return SUCCESS;
	}
	
	/**
	 * 显示所有的领导信息
	 * @return
	 */
	public String showLeaders(){
		leaders = userService.findLeaders();
		return SUCCESS;
	}
	
	/**
	 * 显示所有的会员信息
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
