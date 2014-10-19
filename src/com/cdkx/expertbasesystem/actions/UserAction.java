package com.cdkx.expertbasesystem.actions;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cdkx.expertbasesystem.domain.Patent;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.domain.UserDTO;
import com.cdkx.expertbasesystem.dto.UserTotalDTO;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.UserService;
import com.cdkx.expertbasesystem.utils.BaseAction;
import com.cdkx.expertbasesystem.utils.JsonUtil;
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

public class UserAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> request;
	private Map<String, Object> session;
	
	//ǰ����Ҫ����User��UserDetail����Ϣ��ʹ�÷����ǣ������User�����ԣ�
	//��ֱ��user.xxxx�������UserDetail�����ԣ�����Ҫʹ��user.userDetail.xxxx
	private User user;
	
	private List<User> users;
	
	private UserDTO userDTO;
	
	private File img;
	
	private String imgFileName;
	
	private UserService userService;
	
	private String jsonString;
	
	private String keyword;
	
	private List<UserTotalDTO> list_total; 
	
	/**
	 * �޸��û���Ϣ
	 * @return �����û�����ת����Ӧ�û���ҳ��
	 */
	public String modifyUser(){
		if(user.getMajor() != null && user.getMajor().getName() != null){
			user.getMajor().setId(Integer.parseInt(user.getMajor().getName().substring(0, user.getMajor().getName().indexOf("-"))));
		}
		userService.modifyUser(user);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String modifyCount(){
		int userId = Integer.parseInt(session.get("userId").toString());
		user = userService.findUser(userId);
		userDTO.setPassword(MD5Util.encode(userDTO.getPassword()));
		if(userDTO.getPassword().equals(user.getPassword())){
			users = userService.findUsersByUsername(userDTO.getUsername());
			users.remove(user);
			if(users != null && users.size() > 0)
				jsonString = "{success:false, errorMessage:'���û����ѱ������û�ռ��'}";
			else{
				user.setUsername(userDTO.getUsername());
				user.setPassword(MD5Util.encode(userDTO.getNewpass()));
				userService.modifyUser(user);
				jsonString = "{success:true}";
			}
		}else{
			jsonString = "{success:false, errorMessage:'���벻��ȷ������������'}";
		}
		return SUCCESS;
	}
	
	public String showUser(){
		if(session.get("userId") != null){
			int id = Integer.parseInt(session.get("userId").toString());
			user = userService.findUser(id);
			jsonString = JsonUtil.jsonForSingle(user);
			return SUCCESS;
		} else 
			throw new AppException("�û�û�е�¼");
	}
	
	public String upload(){
		String realPath = ServletActionContext.getServletContext().getRealPath("/uploads");
		if(img != null && !"".equals(imgFileName)){
			if(img.length() < 204800){
				String imgName = UUID.randomUUID().toString() + imgFileName.substring(imgFileName.indexOf("."));
				File imgDist = new File(new File(realPath), imgName);
				if(!imgDist.getParentFile().exists()){
					imgDist.getParentFile().mkdirs();
				}
				try {
					FileUtils.copyFile(img, imgDist);
					File oldImg = new File(new File(realPath), user.getAvatar());
					oldImg.delete();
					user.setAvatar(imgName);
					userService.modifyUser(user);
					jsonString = "{success:true, imgName:'" + imgName + "'}";
				} catch (IOException e) {
					e.printStackTrace();
					jsonString = "{success:false,errorMessage:'ͼƬ�ϴ�ʧ�ܣ�'}";
					throw new AppException("ͼƬ�ϴ�ʧ�ܣ�");
				}
			} else {
				jsonString = "{success : false, errorMessage:'ͼƬ���ֻ��Ϊ200K��������ѡ��...'}";
			}
		}else{
			jsonString = "{success:false, errorMessage:'ͼƬ�ϴ�ʧ�ܣ�'}";
		}
		return SUCCESS;
	}

	//����Ϊͳ������ķ�����
	/**
	 * ͳ�ƻ�Ա���ۺ���Ϣ��: ��Ŀ, ����, ����,and ר�� ���� 
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String total_member() throws UnsupportedEncodingException{
		
		String str = new String(this.getKeyword().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("�ؼ��� :  " + str);
		try {
			list_total = userService.countnum(str);
			this.getRequest().put("list_total", list_total);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ�û��ۺ���Ϣʧ��");
		}
		return "success";
	}
	
	/**
	 * ȫ����Ա����
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String total_someone() throws UnsupportedEncodingException{
		
		String str = new String(this.getKeyword().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("�ؼ��� :  " + str);
		try {
			List temp = userService.findUserBySub_count(str);
			this.getRequest().put("list_total", temp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ  ��Ա����  ��Ϣʧ��");
		}
		return "success";
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

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
