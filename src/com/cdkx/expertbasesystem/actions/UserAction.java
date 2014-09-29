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
	
	private String jsonString;
	
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

	public String getJsonString() {
		return jsonString;
	}

}
