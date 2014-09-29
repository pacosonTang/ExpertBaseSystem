package com.cdkx.expertbasesystem.actions;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Institution;
import com.cdkx.expertbasesystem.service.InstitutionService;
import com.cdkx.expertbasesystem.utils.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 提供对协会信息的业务逻辑
 * @author Guojun
 *
 */
public class InstitutionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Institution institution;
	
	private List<Institution> institutions;
	
	private InstitutionService institutionService;
	
	private String jsonString;
	
	/**
	 * 显示所有的协会信息<br>
	 * 使用方法：在前端直接使用showInstitutions.action即可，不需要传递参数<br>
	 * 使用该方法的地方有两个，一个是会员修改自己信息，一个是管理员添加和修改会员信息<br>
	 * 此方法返回的是所有的协会信息，供用户选择，需要Ajax的支持，一般是点击下拉列表然后将返回的institutions循环显示到下拉列表中<br>
	 * 方法最后需要返回到访问这个函数的页面去，需要局部刷新，故返回的内容可能需要用json封装
	 * @return
	 */
	public String showInstitutions(){
		institutions = institutionService.findInstitutions();
		jsonString = JsonUtil.jsonForList(institutions);
		return SUCCESS;
	}
	
	/**
	 * 添加协会信息<br>
	 * 使用方法：直接在前端form中的aciton属性addInstitution.action即可。<br>
	 * 输入：需要输入协会信息，输入框的name需要为institution.name即可，id会自动生成。<br>
	 * 输出：如果需要此功能，那么需要存在一个显示所有协会列表的页面，此方法结束后，会跳转到showInstitutions.action重新显示出所有的协会信息，
	 * 或者这里是一个ajax请求，在管理员添加会员选择协会的时候发现协会内容不足，直接有一个添加功能，
	 * 形成简单的添加，添加结束后直接把添加结果重新刷新即可，也需要跳到showInstitutions.action重新局部刷新<br>
	 * @return
	 */
	public String addInstitution(){
		institutionService.addInstitution(institution);
		return SUCCESS;
	}

	public List<Institution> getInstitutions() {
		return institutions;
	}

	public void setInstitutionService(InstitutionService institutionService) {
		this.institutionService = institutionService;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public String getJsonString() {
		return jsonString;
	}

}
