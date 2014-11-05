package com.cdkx.expertbasesystem.actions;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.cdkx.expertbasesystem.dto.BiPropertyDTO;
import com.cdkx.expertbasesystem.dto.UserTotalDTO;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.DatacountService;
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

public class DatacountAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private DatacountService datacountService;
	private String keyword;
	private String result;
	
	/**
	 * 统计会员memberNum,项目projectNum，奖励awardNum， 论文thesisNum， 专利patentNum,占比,用ajax传输
	 * @return chart_list;
	 */
	public String member_percentage(){
		
		try {
			List<BiPropertyDTO> list = datacountService.member_ratio(keyword);
			result = JsonUtil.jsonForList(list);	
	    } catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询  会员姓名  信息失败");
		}
		System.out.println(result);
		return SUCCESS;
	}
	
	
	public String execute(){//默认访问方法
		return SUCCESS;
	}

	public DatacountService getDatacountService() {
		return datacountService;	
	}

	public void setDatacountService(DatacountService datacountService) {
		this.datacountService = datacountService;
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
	
}
