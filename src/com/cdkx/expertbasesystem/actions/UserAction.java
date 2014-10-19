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
 * 关于用户信息的所有操作都在此进行响应和分发<br>
 * 1.会员对自己信息执行的操作，包括注册、查询修改自己的信息<br>
 * 2.领导对自己信息的修改，查询<br>
 * 3.市场化服务人员对自己信息的修改查询<br>
 * 4.管理员对自己信息的查询修改<br>
 * @author Guojun
 *
 */

public class UserAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> request;
	private Map<String, Object> session;
	
	//前端需要传入User和UserDetail的信息，使用方法是：如果是User的属性，
	//则直接user.xxxx，如果是UserDetail的属性，则需要使用user.userDetail.xxxx
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
	 * 修改用户信息
	 * @return 根据用户类型转向相应用户的页面
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
				jsonString = "{success:false, errorMessage:'该用户名已被其它用户占用'}";
			else{
				user.setUsername(userDTO.getUsername());
				user.setPassword(MD5Util.encode(userDTO.getNewpass()));
				userService.modifyUser(user);
				jsonString = "{success:true}";
			}
		}else{
			jsonString = "{success:false, errorMessage:'密码不正确，请重新输入'}";
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
			throw new AppException("用户没有登录");
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
					jsonString = "{success:false,errorMessage:'图片上传失败！'}";
					throw new AppException("图片上传失败！");
				}
			} else {
				jsonString = "{success : false, errorMessage:'图片最大只能为200K，请重新选择...'}";
			}
		}else{
			jsonString = "{success:false, errorMessage:'图片上传失败！'}";
		}
		return SUCCESS;
	}

	//以下为统计所需的方法啦
	/**
	 * 统计会员的综合信息如: 项目, 奖励, 论文,and 专利 数量 
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String total_member() throws UnsupportedEncodingException{
		
		String str = new String(this.getKeyword().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("关键字 :  " + str);
		try {
			list_total = userService.countnum(str);
			this.getRequest().put("list_total", list_total);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询用户综合信息失败");
		}
		return "success";
	}
	
	/**
	 * 全部会员姓名
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String total_someone() throws UnsupportedEncodingException{
		
		String str = new String(this.getKeyword().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("关键字 :  " + str);
		try {
			List temp = userService.findUserBySub_count(str);
			this.getRequest().put("list_total", temp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询  会员姓名  信息失败");
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
