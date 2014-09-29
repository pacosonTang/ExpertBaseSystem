package com.cdkx.expertbasesystem.actions;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Degree;
import com.cdkx.expertbasesystem.service.DegreeService;
import com.cdkx.expertbasesystem.utils.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 提供对学历学位的业务逻辑
 * @author Guojun
 *
 */
public class DegreeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private List<Degree> educations;
	
	private List<Degree> degrees;
	
	private DegreeService degreeService;
	
	private String jsonString;
	
	/**
	 * 显示所有学位信息<br>
	 * 使用这个函数的地方可能有两个，一个是管理员添加会员的时候，另一个是会员修改自己信息或者管理员修改会员信息的时候<br>
	 * 方法必须以Ajax的方法进行调用，调用之后需要能回到当前页面局部刷新下拉列表，后期估计要用json来封装数据<br>
	 * 使用方法，在前台调用showDegrees.action即可，不需要传入参数
	 * @return
	 */
	public String showDegrees(){
		degrees = degreeService.findDegrees();
		jsonString = JsonUtil.jsonForList(degrees);
		return SUCCESS;
	}
	
	/**
	 * 显示所有学历信息<br>
	 * 使用这个函数的地方可能有两个，一个是管理员添加会员的时候，另一个是会员修改自己信息或者管理员修改会员信息的时候<br>
	 * 方法必须以Ajax的方法进行调用，调用之后需要能回到当前页面局部刷新下拉列表，后期估计要用json来封装数据<br>
	 * 使用方法，在前台调用showDegrees.action即可，不需要传入参数
	 * @return
	 */
	public String showEducations(){
		educations = degreeService.findEducations();
		jsonString = JsonUtil.jsonForList(educations);
		return SUCCESS;
	}

	public void setDegreeService(DegreeService degreeService) {
		this.degreeService = degreeService;
	}

	public String getJsonString() {
		return jsonString;
	}

}
