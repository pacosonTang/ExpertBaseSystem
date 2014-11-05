package com.cdkx.expertbasesystem.actions;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.domain.Patent;
import com.cdkx.expertbasesystem.domain.Project;
import com.cdkx.expertbasesystem.domain.Thesis;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.domain.UserDTO;
import com.cdkx.expertbasesystem.domain.Userfour;
import com.cdkx.expertbasesystem.dto.BiPropertyDTO;
import com.cdkx.expertbasesystem.dto.UserTotalDTO;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.AwardService;
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
	
	private String result;
	
	private JSONObject jo;
	
	private String someoneKey;
	
	private String curpage;
	
	private AwardService awardService;
	
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
		int userId = Integer.parseInt(this.getSession().get("userId").toString());
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
		if(this.getSession().get("userId") != null){
			int id = Integer.parseInt(this.getSession().get("userId").toString());
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
		
		List<Userfour> list_mem; 
		String str = new String(this.getKeyword().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("关键字 :  " + str);
		if(str.equals("undefined"))
			str = String.valueOf(this.getSession().get("cur_sub"));
		keyword = str;
		try {
			list_mem = userService.countnum(str,Integer.parseInt(curpage)); //这里查询的第一页的数据
			this.getRequest().put("curpage", curpage);// 当前页面是多少
			this.getRequest().put("list_total", list_mem);
			this.getSession().put("cur_sub", str);
			this.getSession().put("item_total", this.awardService.countFiveNum(str, "mSum")); 
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询用户综合信息失败");
		}
		return "success";
	}
	
	//分页查询会员
	public String page_member() throws UnsupportedEncodingException{
		
		List<Userfour> list_mem; 
		String str = String.valueOf(this.getSession().get("cur_sub")); 
		try {
			list_mem = userService.countnum(str,Integer.parseInt(curpage)); //这里查询的第一页的数据
			this.getRequest().put("curpage", curpage);// 当前页面是多少
			this.getRequest().put("list_total", list_mem);
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
		if(str.equals("undefined"))
			str = String.valueOf(this.getSession().get("cur_sub"));
		this.setSomeoneKey(str);
		try {
			List<BiPropertyDTO> temp = userService.findUserBySub_count(str);
			this.getRequest().put("list_total", temp);
			this.getSession().put("cur_sub", str);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询  会员姓名  信息失败");
		}
		return "success";
	}
	
	
	/**
	 * 依据会员id查询会员实体对象 【ajax方法】
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String find_someone_id() throws UnsupportedEncodingException{
		
		System.out.println("关键字 :  " + keyword);
		this.getRequest().put("cur_find_id", keyword);
		try {
			user = userService.findUser(Integer.parseInt(keyword));
			/*
			JsonConfig config = new JsonConfig();
   		    config.setIgnoreDefaultExcludes(true);  //设置默认忽略
			config.setExcludes(new String[]{"patents","projects","thesises","awards","usersForDegree","usersForEducation",
					"users","children"});
			jo = JSONObject.fromObject(user,config);   //将user 封装为 JSONArray 数据*/
			result = JsonUtil.jsonForSingle(user);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询  会员姓名  信息失败");
		}
/*		System.out.println(user.getAddress());
		result = jo.toString();
*/		System.out.println(result);
		return SUCCESS;
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public UserService getUserService() {
		return userService;
	}

	public String getSomeoneKey() {
		return someoneKey;
	}

	public void setSomeoneKey(String someoneKey) {
		this.someoneKey = someoneKey;
	}

	public String getCurpage() {
		return curpage;
	}

	public void setCurpage(String curpage) {
		this.curpage = curpage;
	}

	public AwardService getAwardService() {
		return awardService;
	}

	public void setAwardService(AwardService awardService) {
		this.awardService = awardService;
	}
}
