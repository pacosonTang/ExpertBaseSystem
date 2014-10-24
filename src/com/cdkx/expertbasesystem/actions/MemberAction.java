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
 * �ṩ��Ա���Լ����ġ�������Ŀ�����гɹ�������ר����Ϣ����ɾ��<br>
 * 1.�û���ע��ʱ���Բ���д��Щ��Ϣ�������ͨ���ˣ���¼ϵͳ����д<br>
 * 2.�����Ŀ�����Ŀ���гɹ�����ר����Ϣ�Ȳ��ṩ�޸Ĳ���������û���д������ɾ������<br>
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
	 * ���ݴ��ص��ض���ѡ������ı�ţ�ɾ����Ӧ������
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
	 * ���ݴ��ص��ض���ѡ���ר����ţ�ɾ����Ӧ��ר��
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
	 * ���ݴ��ص��ض���ѡ�����Ŀ��ţ�ɾ����Ӧ����Ŀ
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
	 * ���ݴ��ص��ض���ѡ��Ľ�����ţ�ɾ����Ӧ�Ľ���
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
	
	//����Ϊͳ������ķ�����
	/**
	 * ͳ�� ĳѧ���µ�  ��Ŀ ��ϸ��Ϣ  
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String total_project() throws UnsupportedEncodingException{
		
		String str = new String(this.getKeyword().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("�ؼ��� :  " + str);
		try {
			List<Project> temp = projectService.countProNum(str);
			this.getRequest().put("list_total", temp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ  ȫ����Ŀ ��Ϣʧ��");
		}
		return "success";
	}
	/**
	 * ͳ�� ĳѧ���µ� ����  ��ϸ��Ϣ  
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String total_award() throws UnsupportedEncodingException{
		
		String str = new String(this.getKeyword().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("�ؼ��� :  " + str);
		try {
			List<Award> temp = awardService.countAwardNum(str);
			this.getRequest().put("list_total", temp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ  ����  ��Ϣʧ��");
		}
		return "success";
	}
		
	/**
	 * ͳ�� ĳѧ���µ� ����  ��ϸ��Ϣ  
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String total_thesis() throws UnsupportedEncodingException{
		
		String str = new String(this.getKeyword().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("�ؼ��� :  " + str);
		try {
			List<Thesis> temp = thesisService.countThesisNum(str);
			this.getRequest().put("list_total", temp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ  ����  ��Ϣʧ��");
		}
		return "success";
	}
		
	/**
	 * ͳ�� ĳѧ���µ�  ר��  ��ϸ��Ϣ  
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String total_patent() throws UnsupportedEncodingException{
		
		String str = new String(this.getKeyword().getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("�ؼ��� :  " + str);
		try {
			List<Patent> temp = patentService.countPatentNum(str);
			this.getRequest().put("list_total", temp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ  ר��  ��Ϣʧ��");
		}
		return "success";
	}
	
//	specific
	/**
	 * ͳ�� ��Ա�� ��ϸ ��Ŀ2������3�� ����4�� ר��5 ����Ϣ  
	 * �����û��ı��id
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String specific_four(){
		 
		System.out.println("�ؼ��� :  " + keyword);
		try {
			switch(Integer.parseInt(specific_type)){
				case 2: result = JsonUtil.jsonForList(projectService.findProjectByUser(Integer.parseInt(keyword)));break;//��List����Ϊjson�ַ�������
				case 3: result = JsonUtil.jsonForList(awardService.findAwardByUser(Integer.parseInt(keyword)));break;
				case 4: result = JsonUtil.jsonForList(thesisService.findThesisByUser(Integer.parseInt(keyword)));break;
				case 5: result = JsonUtil.jsonForList(patentService.findPatentByUser(Integer.parseInt(keyword)));break;
				default:result = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ ��Ŀ  ��Ϣʧ��");
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
