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
 * �ṩ��������Ϣ�Ĺ��������Ի�Ա���г���������Ա���쵼��Ϣ�Ĺ������ݿ�ı�����ָ��Ĺ����ҵ���߼�
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
	 * �쵼ͳһ��Ϊû��������Ϣ��ֻ�б�Ҫ��Ϣ
	 * �쵼��Ϣ�ɹ���Ա���
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
	 * ����г���������Ա
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
	 * ��ӻ�Ա
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
	 * ɾ���г���������Ա<br>
	 * �����Ҫɾ�������г�������Ա����ôֻ��Ҫ����Ҫɾ���ı�ű�����selectIds������̨����<br>
	 * ���Ҫɾ������г���������Ա����ô�轫ѡ���idȫ���ռ�������Ȼ���á�,����������selectIds��<br>
	 * �����ֱ�ӽ���ѡ��ȡ��ͬ���ִ��䣬��ô���䵽��̨��������Ҫ�޸�Ϊint�͵����飬�Ի�Ա���쵼�Ĳ�����Ȼ
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
	 * ɾ����Ա��Ϣ
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
	 * ����ɾ���쵼��Ϣ
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
	 * ��ʾ���е��쵼��Ϣ
	 * @return
	 */
	public String showLeaders(){
		leaders = userService.findLeaders();
		jsonString = JsonUtil.jsonForList(leaders);
		return SUCCESS;
	}
	
	/**
	 * ��ʾ���еĻ�Ա��Ϣ
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
