package com.cdkx.expertbasesystem.actions;

import java.util.List;

import sun.security.provider.MD5;

import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.domain.Patent;
import com.cdkx.expertbasesystem.domain.Project;
import com.cdkx.expertbasesystem.domain.Thesis;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.service.AwardService;
import com.cdkx.expertbasesystem.service.PatentService;
import com.cdkx.expertbasesystem.service.ProjectService;
import com.cdkx.expertbasesystem.service.ThesisService;
import com.cdkx.expertbasesystem.service.UserService;
import com.cdkx.expertbasesystem.utils.JsonUtil;
import com.cdkx.expertbasesystem.utils.MD5Util;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 提供对所有信息的管理，包括对会员、市场化服务人员、领导信息的管理，数据库的备份与恢复的管理等业务逻辑
 * @author Guojun
 *
 */
public class ManagerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private List<User> leaders;
	
	private List<User> members;
	
	private List<User> servers;
	
	private String jsonString;
	
	private String selectIds;
	
	private int userId;
	
	private List<Thesis> thesises;
	
	private List<Patent> patents;
	
	private List<Project> projects;
	
	private List<Award> awards;
	
	private Thesis thesis;
	
	private Award award;
	
	private Patent patent;
	
	private Project project;
	
	private UserService userService;
	
	private ThesisService thesisService;
	
	private PatentService patentService;
	
	private ProjectService projectService;
	
	private AwardService awardService;
	
	/**
	 * 领导统一视为没有详情信息，只有必要信息
	 * 领导信息由管理员添加
	 * @return
	 */
	public String addLeader(){
		user.setLevel(1);
		user.setUsername(user.getTelephone());
		user.setPassword(MD5Util.encode("123456"));
		userService.addUser(user);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * 添加市场化服务人员
	 * @return
	 */
	public String addServer(){
		user.setLevel(2);
		user.setUsername(user.getTelephone());
		user.setPassword(MD5Util.encode("123456"));
		userService.addUser(user);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * 添加会员
	 * @return
	 */
	public String addMember(){
		user.setUsername(user.getTelephone());
		user.setPassword(MD5Util.encode("123456"));
		user.setLevel(3);
		userService.addUser(user);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String showThesises(){
		thesises = thesisService.findThesisByUser(userId);
		jsonString = JsonUtil.jsonForList(thesises);
		return SUCCESS;
	}
	
	public String showPatents(){
		patents = patentService.findPatentByUser(userId);
		jsonString = JsonUtil.jsonForList(patents);
		return SUCCESS;
	}
	
	public String showProjects(){
		projects = projectService.findProjectByUser(userId);
		jsonString = JsonUtil.jsonForList(projects);
		return SUCCESS;
	}
	
	public String showAwards(){
		awards = awardService.findAwardByUser(userId);
		jsonString = JsonUtil.jsonForList(awards);
		return SUCCESS;
	}
	
	public String addThesis(){
		user = new User();
		user.setId(userId);
		thesis.setUser(user);
		thesisService.addThesis(thesis);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String addPatent(){
		user = new User();
		user.setId(userId);
		patent.setUser(user);
		patentService.addPatent(patent);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String addProject(){
		user = new User();
		user.setId(userId);
		project.setUser(user);
		projectService.addProject(project);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String addAward(){
		user = new User();
		user.setId(userId);
		award.setUser(user);
		awardService.addAward(award);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * 删除市场化服务人员<br>
	 * 如果需要删除单个市场服务人员，那么只需要将需要删除的编号保存在selectIds传到后台即可<br>
	 * 如果要删除多个市场化服务人员，那么需将选择的id全部收集起来，然后用“,”隔开存入selectIds中<br>
	 * 如果是直接将复选框取相同名字传输，那么传输到后台的数据需要修改为int型的数组，对会员、领导的操作亦然
	 * @return
	 */
	public String deleteServers(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			userService.deleteUser(Integer.parseInt(ids[i]));
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * 删除会员信息
	 * @return
	 */
	public String deleteMembers(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			userService.deleteUser(Integer.parseInt(ids[i]));
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * 批量删除领导信息
	 * @return
	 */
	public String deleteLeaders(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			userService.deleteUser(Integer.parseInt(ids[i]));
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * 显示所有的领导信息
	 * @return
	 */
	public String showLeaders(){
		leaders = userService.findLeaders();
		jsonString = JsonUtil.jsonForList(leaders);
		return SUCCESS;
	}
	
	/**
	 * 显示所有的会员信息
	 * @return
	 */
	public String showMembers(){
		members = userService.findMembers();
		jsonString = JsonUtil.jsonForList(members);
		return SUCCESS;
	}
	
	public String showServers(){
		servers = userService.findServers();
		jsonString = JsonUtil.jsonForList(servers);
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Thesis getThesis() {
		return thesis;
	}

	public void setThesis(Thesis thesis) {
		this.thesis = thesis;
	}

	public Award getAward() {
		return award;
	}

	public void setAward(Award award) {
		this.award = award;
	}

	public Patent getPatent() {
		return patent;
	}

	public void setPatent(Patent patent) {
		this.patent = patent;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public void setAwardService(AwardService awardService) {
		this.awardService = awardService;
	}

	public void setSelectIds(String selectIds) {
		this.selectIds = selectIds;
	}
}
