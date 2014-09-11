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
 * 提供会员对自己论文、科研项目、科研成果奖励、专利信息的增删查<br>
 * 1.用户在注册时可以不填写这些信息，等审核通过了，登录系统再填写<br>
 * 2.对论文科研项目科研成果奖励专利信息等不提供修改操作，如果用户填写错误，需删除重填<br>
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
	 * 显示会员获得的奖励
	 * @return 页面转向信息
	 */
	public String showAward(){
		getUser();
		awards = user.getAwards();
		return SUCCESS;
	}
	
	/**
	 * 显示会员获得专利
	 * @return 页面转向信息
	 */
	public String showPatent(){
		getUser();
		patents = user.getPatents();
		return SUCCESS;
	}
	
	/**
	 * 显示会员参与的项目
	 * @return
	 */
	public String showProject(){
		getUser();
		projects = user.getProjects();
		return SUCCESS;
	}
	
	/**
	 * 显示会员发表的论文
	 * @return
	 */
	public String showThesis(){
		getUser();
		thesises = user.getThesises();
		return SUCCESS;
	}
	
	/**
	 * 添加奖励信息
	 * @return
	 */
	public String addAward(){
		getUser();
		award.setUser(user);
		awardService.addAward(award);
		return SUCCESS;
	}
	
	/**
	 * 添加专利信息
	 * @return
	 */
	public String addPatent(){
		getUser();
		patent.setUser(user);
		patentService.addPatent(patent);
		return SUCCESS;
	}
	
	/**
	 * 添加项目信息
	 * @return
	 */
	public String addProject(){
		getUser();
		project.setUser(user);
		projectService.addProject(project);
		return SUCCESS;
	}
	
	/**
	 * 添加论文信息
	 * @return
	 */
	public String addThesis(){
		getUser();
		thesis.setUser(user);
		thesisService.addThesis(thesis);
		return SUCCESS;
	}
	
	/**
	 * 删除奖励信息
	 * @return
	 */
	public String deleteAward(){
		awardService.deleteAwardById(award.getId());
		return SUCCESS;
	}
	
	/**
	 * 删除专利信息
	 * @return
	 */
	public String deletePatent(){
		patentService.deletePatentById(patent.getId());
		return SUCCESS;
	}
	
	/**
	 * 删除项目信息
	 * @return
	 */
	public String deleteProject(){
		projectService.deleteProjectById(project.getId());
		return SUCCESS;
	}
	
	/**
	 * 删除论文信息
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
			throw new AppException("用户没有登录！请先登录...");
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
