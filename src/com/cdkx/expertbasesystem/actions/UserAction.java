package com.cdkx.expertbasesystem.actions;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.interceptor.SessionAware;

import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.UserService;
import com.cdkx.expertbasesystem.utils.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 关于用户信息的所有操作都在此进行响应和分发<br>
 * 1.会员对自己信息执行的操作，包括注册、查询修改自己的信息<br>
 * 2.领导对自己信息的修改，查询<br>
 * 3.市场化服务人员对自己信息的修改查询<br>
 * 4.管理员对自己信息的查询修改<br>
 * @author Guojun
 *
 */
public class UserAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	
	//前端需要传入User和UserDetail的信息，使用方法是：如果是User的属性，
	//则直接user.xxxx，如果是UserDetail的属性，则需要使用user.userDetail.xxxx
	private User user;
	
	private List<User> users;
	
	private UserService userService;
	
	private String jsonString;
	
	/**
	 * 修改用户信息
	 * @return 根据用户类型转向相应用户的页面
	 */
	public String modifyUser(){
		userService.modifyUser(user);
		return SUCCESS;
	}
	
	public String showUser(){
		if(session.get("userId") != null){
			int id = Integer.parseInt(session.get("userId").toString());
			
			user = userService.findUser(id);
			//jsonString = JsonUtil.jsonForSingle(user);
			JsonConfig cfg = new JsonConfig();
			cfg.setExcludes(new String[]{"handler", "hibernateLazyInitializer"});
			cfg.setJsonPropertyFilter(new PropertyFilter(){

				@Override
				public boolean apply(Object source, String name, Object value) {
					if(name.equals("projects") || name.equals("awards") || name.equals("thesises") || name.equals("children")
							|| name.equals("patents") || name.equals("parent")|| name.equals("usersForMajor") || name.equals("users")
							|| name.equals("usersForCurrentMajor") || name.equals("usersForDegree") || name.equals("usersForEducation"))
						return true;
					else
						return false;
				}
				
			});
			JSONArray jsonData = JSONArray.fromObject(user, cfg);
			jsonString = "{success:true,totalCount:1,list:" + jsonData.toString() + "}";
			return SUCCESS;
		} else 
			throw new AppException("用户没有登录");
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

	public String getJsonString() {
		return jsonString;
	}

}
