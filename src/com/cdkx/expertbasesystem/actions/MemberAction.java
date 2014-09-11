package com.cdkx.expertbasesystem.actions;

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
	
	private int userId;
	
	private UserService userService;
	
	private User user;
	
	private Set<Award> awards;
	
	private Set<Patent> patents;
	
	private Set<Project> projects;
	
	private Set<Thesis> thesises;
	
	private Map<String, Object> session;

	/**
	 * ��ʾ��Ա��õĽ���
	 * @return ҳ��ת����Ϣ
	 */
	public String showAward(){
		getUser();
		awards = user.getAwards();
		return SUCCESS;
	}
	
	/**
	 * ��ʾ��Ա���ר��
	 * @return ҳ��ת����Ϣ
	 */
	public String showPatent(){
		getUser();
		patents = user.getPatents();
		return SUCCESS;
	}
	
	/**
	 * ��ʾ��Ա�������Ŀ
	 * @return
	 */
	public String showProject(){
		getUser();
		projects = user.getProjects();
		return SUCCESS;
	}
	
	/**
	 * ��ʾ��Ա���������
	 * @return
	 */
	public String showThesis(){
		getUser();
		thesises = user.getThesises();
		return SUCCESS;
	}
	
	/**
	 * ��ӽ�����Ϣ
	 * @return
	 */
	public String addAward(){
		getUser();
		award.setUser(user);
		awardService.addAward(award);
		return SUCCESS;
	}
	
	/**
	 * ���ר����Ϣ
	 * @return
	 */
	public String addPatent(){
		getUser();
		patent.setUser(user);
		patentService.addPatent(patent);
		return SUCCESS;
	}
	
	/**
	 * �����Ŀ��Ϣ
	 * @return
	 */
	public String addProject(){
		getUser();
		project.setUser(user);
		projectService.addProject(project);
		return SUCCESS;
	}
	
	/**
	 * ���������Ϣ
	 * @return
	 */
	public String addThesis(){
		getUser();
		thesis.setUser(user);
		thesisService.addThesis(thesis);
		return SUCCESS;
	}
	
	/**
	 * ɾ��������Ϣ
	 * @return
	 */
	public String deleteAward(){
		awardService.deleteAwardById(award.getId());
		return SUCCESS;
	}
	
	/**
	 * ɾ��ר����Ϣ
	 * @return
	 */
	public String deletePatent(){
		patentService.deletePatentById(patent.getId());
		return SUCCESS;
	}
	
	/**
	 * ɾ����Ŀ��Ϣ
	 * @return
	 */
	public String deleteProject(){
		projectService.deleteProjectById(project.getId());
		return SUCCESS;
	}
	
	/**
	 * ɾ��������Ϣ
	 * @return
	 */
	public String deleteThesis(){
		thesisService.deleteThesisById(thesis.getId());
		return SUCCESS;
	}
	
	private void getUser(){
		if(session.get("userId") != null){
			userId = Integer.parseInt(session.get("userId").toString());
			user = userService.findUser(userId);
		} else
			throw new AppException("�û�û�е�¼�����ȵ�¼...");
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

	public Set<Award> getAwards() {
		return awards;
	}

	public Set<Patent> getPatents() {
		return patents;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public Set<Thesis> getThesises() {
		return thesises;
	}

}
