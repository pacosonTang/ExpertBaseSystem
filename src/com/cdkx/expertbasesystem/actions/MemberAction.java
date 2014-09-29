package com.cdkx.expertbasesystem.actions;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.domain.Patent;
import com.cdkx.expertbasesystem.domain.Project;
import com.cdkx.expertbasesystem.domain.Thesis;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.AwardService;
import com.cdkx.expertbasesystem.service.PatentService;
import com.cdkx.expertbasesystem.service.ProjectService;
import com.cdkx.expertbasesystem.service.ThesisService;
import com.cdkx.expertbasesystem.service.UserService;
import com.cdkx.expertbasesystem.utils.JsonUtil;
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
	
	private Thesis thesis;
	
	private ThesisService thesisService;
	
	private Project project;
	
	private ProjectService projectService;
	
	private Patent patent;
	
	private PatentService patentService;
	
	private Award award;
	
	private AwardService awardService;
	
	private UserService userService;
	
	private List<Award> awards;
	
	private List<Patent> patents;
	
	private List<Project> projects;
	
	private List<Thesis> thesises;
	
	private String jsonString;
	
	private String selectIds;
	
	private Map<String, Object> session;

	/**
	 * ��ʾ��Ա��õĽ���
	 * @return ҳ��ת����Ϣ
	 */
	public String showAward(){
		int userId = Integer.parseInt(session.get("userId").toString());
		awards = awardService.findAwardByUser(userId);
		jsonString = JsonUtil.jsonForList(awards);
		return SUCCESS;
	}
	
	/**
	 * ��ʾ��Ա���ר��
	 * @return ҳ��ת����Ϣ
	 */
	public String showPatent(){
		int userId = Integer.parseInt(session.get("userId").toString());
		patents = patentService.findPatentByUser(userId);
		jsonString = JsonUtil.jsonForList(patents);
		return SUCCESS;
	}
	
	/**
	 * ��ʾ��Ա�������Ŀ
	 * @return
	 */
	public String showProject(){
		int userId = Integer.parseInt(session.get("userId").toString());
		projects = projectService.findProjectByUser(userId);
		jsonString = JsonUtil.jsonForList(projects);
		return SUCCESS;
	}
	
	/**
	 * ��ʾ��Ա���������
	 * @return
	 */
	public String showThesis(){
		int userId = Integer.parseInt(session.get("userId").toString());
		thesises = thesisService.findThesisByUser(userId);
		jsonString = JsonUtil.jsonForList(thesises);
		return SUCCESS;
	}
	
	/**
	 * ��ӽ�����Ϣ
	 * @return
	 */
	public String addAward(){
		int userId = Integer.parseInt(session.get("userId").toString());
		award.setUser(new User());
		award.getUser().setId(userId);
		awardService.addAward(award);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * ���ר����Ϣ
	 * @return
	 */
	public String addPatent(){
		int userId = Integer.parseInt(session.get("userId").toString());
		patent.setUser(new User());
		patent.getUser().setId(userId);
		patentService.addPatent(patent);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * �����Ŀ��Ϣ
	 * @return
	 */
	public String addProject(){
		int userId = Integer.parseInt(session.get("userId").toString());
		project.setUser(new User());
		project.getUser().setId(userId);
		projectService.addProject(project);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * ���������Ϣ
	 * @return
	 */
	public String addThesis(){
		int userId = Integer.parseInt(session.get("userId").toString());
		thesis.setUser(new User());
		thesis.getUser().setId(userId);
		thesisService.addThesis(thesis);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * ɾ��������Ϣ
	 * @return
	 */
	public String deleteAwards(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			awardService.deleteAwardById(Integer.parseInt(ids[i]));
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * ɾ��ר����Ϣ
	 * @return
	 */
	public String deletePatents(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			patentService.deletePatentById(Integer.parseInt(ids[i]));
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * ɾ����Ŀ��Ϣ
	 * @return
	 */
	public String deleteProjects(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			projectService.deleteProjectById(Integer.parseInt(ids[i]));
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * ɾ��������Ϣ
	 * @return
	 */
	public String deleteThesises(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			thesisService.deleteThesisById(Integer.parseInt(ids[i]));
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Thesis getThesis() {
		return thesis;
	}

	public void setThesis(Thesis thesis) {
		this.thesis = thesis;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Patent getPatent() {
		return patent;
	}

	public void setPatent(Patent patent) {
		this.patent = patent;
	}

	public Award getAward() {
		return award;
	}

	public void setAward(Award award) {
		this.award = award;
	}

	public void setThesisService(ThesisService thesisService) {
		this.thesisService = thesisService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setPatentService(PatentService patentService) {
		this.patentService = patentService;
	}

	public void setAwardService(AwardService awardService) {
		this.awardService = awardService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setSelectIds(String selectIds) {
		this.selectIds = selectIds;
	}

}
