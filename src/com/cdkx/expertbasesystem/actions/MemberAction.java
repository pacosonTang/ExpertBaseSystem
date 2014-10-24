package com.cdkx.expertbasesystem.actions;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.domain.Patent;
import com.cdkx.expertbasesystem.domain.Project;
import com.cdkx.expertbasesystem.domain.Thesis;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.AwardService;
import com.cdkx.expertbasesystem.service.PatentService;
import com.cdkx.expertbasesystem.service.ProjectService;
import com.cdkx.expertbasesystem.service.ThesisService;
import com.cdkx.expertbasesystem.utils.BaseAction;
import com.cdkx.expertbasesystem.utils.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 提供会员对自己论文、科研项目、科研成果奖励、专利信息的增删查<br>
 * 1.用户在注册时可以不填写这些信息，等审核通过了，登录系统再填写<br>
 * 2.对论文科研项目科研成果奖励专利信息等不提供修改操作，如果用户填写错误，需删除重填<br>
 * @author Guojun
 * 2014-8-25
 */

public class MemberAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private String selectIds;
	
	private AwardService awardService;
	
	private ThesisService thesisService;
	
	private PatentService patentService;
	
	private ProjectService projectService;
	
	private String jsonString;
	
	private Map<String, Object> session;
	
	private String keyword;
	
	private String result;
	
	private String specific_type;

	/**
	 * 根据传回的特定的选择的论文编号，删除对应的论文
	 * @return
	 */
	public String deleteThesises(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i ++){
			thesisService.deleteThesisById(Integer.parseInt(ids[i]));
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * 根据传回的特定的选择的专利编号，删除对应的专利
	 * @return
	 */
	public String deletePatents(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i ++){
			patentService.deletePatentById(Integer.parseInt(ids[i]));
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * 根据传回的特定的选择的项目编号，删除对应的项目
	 * @return
	 */
	public String deleteProjects(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i ++){
			projectService.deleteProjectById(Integer.parseInt(ids[i]));
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * 根据传回的特定的选择的奖励编号，删除对应的奖励
	 * @return
	 */
	public String deleteAwards(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i ++){
			awardService.deleteAwardById(Integer.parseInt(ids[i]));
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	//以下为统计所需的方法啦
	/**
	 * 统计 某学科下的  项目 详细信息  
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String total_project() throws UnsupportedEncodingException{
		
		String str = new String(this.getKeyword().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("关键字 :  " + str);
		try {
			List<Project> temp = projectService.countProNum(str);
			this.getRequest().put("list_total", temp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询  全部项目 信息失败");
		}
		return "success";
	}
	/**
	 * 统计 某学科下的 奖励  详细信息  
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String total_award() throws UnsupportedEncodingException{
		
		String str = new String(this.getKeyword().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("关键字 :  " + str);
		try {
			List<Award> temp = awardService.countAwardNum(str);
			this.getRequest().put("list_total", temp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询  奖励  信息失败");
		}
		return "success";
	}
		
	/**
	 * 统计 某学科下的 论文  详细信息  
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String total_thesis() throws UnsupportedEncodingException{
		
		String str = new String(this.getKeyword().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("关键字 :  " + str);
		try {
			List<Thesis> temp = thesisService.countThesisNum(str);
			this.getRequest().put("list_total", temp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询  论文  信息失败");
		}
		return "success";
	}
		
	/**
	 * 统计 某学科下的  专利  详细信息  
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String total_patent() throws UnsupportedEncodingException{
		
		String str = new String(this.getKeyword().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("关键字 :  " + str);
		try {
			List<Patent> temp = patentService.countPatentNum(str);
			this.getRequest().put("list_total", temp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询  专利  信息失败");
		}
		return "success";
	}
	
//	specific
	/**
	 * 统计 会员的 详细 项目2，奖励3， 论文4， 专利5 等信息  
	 * 输入用户的编号id
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String specific_four(){
		 
		System.out.println("关键字 :  " + keyword);
		try {
			switch(Integer.parseInt(specific_type)){
				case 2: result = JsonUtil.jsonForList(projectService.findProjectByUser(Integer.parseInt(keyword)));break;//将List解析为json字符串对象
				case 3: result = JsonUtil.jsonForList(awardService.findAwardByUser(Integer.parseInt(keyword)));break;
				case 4: result = JsonUtil.jsonForList(thesisService.findThesisByUser(Integer.parseInt(keyword)));break;
				case 5: result = JsonUtil.jsonForList(patentService.findPatentByUser(Integer.parseInt(keyword)));break;
				default:result = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询 项目  信息失败");
		}
		System.out.println(result);
		return "success";
	}
	
	
	public void setSelectIds(String selectIds) {
		this.selectIds = selectIds;
	}

	public void setAwardService(AwardService awardService) {
		this.awardService = awardService;
	}

	public void setThesisService(ThesisService thesisService) {
		this.thesisService = thesisService;
	}

	public void setPatentService(PatentService patentService) {
		this.patentService = patentService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public String getJsonString() {
		return jsonString;
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

	public String getSpecific_type() {
		return specific_type;
	}

	public void setSpecific_type(String specific_type) {
		this.specific_type = specific_type;
	}
	
}
