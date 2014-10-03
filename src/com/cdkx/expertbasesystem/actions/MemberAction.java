package com.cdkx.expertbasesystem.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.cdkx.expertbasesystem.service.AwardService;
import com.cdkx.expertbasesystem.service.PatentService;
import com.cdkx.expertbasesystem.service.ProjectService;
import com.cdkx.expertbasesystem.service.ThesisService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �ṩ��Ա���Լ����ġ�������Ŀ�����гɹ�������ר����Ϣ����ɾ��<br>
 * 1.�û���ע��ʱ���Բ���д��Щ��Ϣ�������ͨ���ˣ���¼ϵͳ����д<br>
 * 2.�����Ŀ�����Ŀ���гɹ�����ר����Ϣ�Ȳ��ṩ�޸Ĳ���������û���д������ɾ������<br>
 * @author Guojun
 * 2014-8-25
 */
public class MemberAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private String selectIds;
	
	private AwardService awardService;
	
	private ThesisService thesisService;
	
	private PatentService patentService;
	
	private ProjectService projectService;
	
	private String jsonString;
	
	private Map<String, Object> session;

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
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
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
}
