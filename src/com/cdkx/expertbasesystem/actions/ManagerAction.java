package com.cdkx.expertbasesystem.actions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.domain.ConditionDTO;
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
	
	private File img;
	
	private String imgFileName;
	
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
	
	private ConditionDTO conditionDTO;
	
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
	
	public String modifyMember(){
		if(user.getMajor() != null && user.getMajor().getName() != null){
			user.getMajor().setId(Integer.parseInt(user.getMajor().getName().substring(0, user.getMajor().getName().indexOf("-"))));
			user.getMajor().setName(null);
		}
		user.setLevel(3);
		userService.modifyUser(user);
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
		user.getMajor().setId(Integer.parseInt(user.getMajor().getName().substring(0, user.getMajor().getName().indexOf("-"))));
		user.getMajor().setName(null);
		userService.addUser(user);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * ��ʾָ���û����е�����
	 * @return
	 */
	public String showThesises(){
		thesises = thesisService.findThesisByUser(userId);
		jsonString = JsonUtil.jsonForList(thesises);
		return SUCCESS;
	}
	
	/**
	 * ��ʾָ���û����е�ר��
	 * @return
	 */
	public String showPatents(){
		patents = patentService.findPatentByUser(userId);
		jsonString = JsonUtil.jsonForList(patents);
		return SUCCESS;
	}
	
	/**
	 * ��ʾָ���û����е���Ŀ
	 * @return
	 */
	public String showProjects(){
		projects = projectService.findProjectByUser(userId);
		jsonString = JsonUtil.jsonForList(projects);
		return SUCCESS;
	}
	
	/**
	 * ��ʾָ���û����еĽ���
	 * @return
	 */
	public String showAwards(){
		awards = awardService.findAwardByUser(userId);
		jsonString = JsonUtil.jsonForList(awards);
		return SUCCESS;
	}
	
	/**
	 * Ϊָ���û��������
	 * @return
	 */
	public String addThesis(){
		user = new User();
		user.setId(userId);
		thesis.setUser(user);
		thesisService.addThesis(thesis);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * Ϊָ���û����ר��
	 * @return
	 */
	public String addPatent(){
		user = new User();
		user.setId(userId);
		patent.setUser(user);
		patentService.addPatent(patent);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * Ϊָ���û������Ŀ
	 * @return
	 */
	public String addProject(){
		user = new User();
		user.setId(userId);
		project.setUser(user);
		projectService.addProject(project);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * Ϊָ���û���ӽ���
	 * @return
	 */
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
		if(conditionDTO != null){
			members = userService.searchMember(conditionDTO);
		} else {
			members = userService.findMembers();
		}
		jsonString = JsonUtil.jsonForList(members);
		conditionDTO = null;
		return SUCCESS;
	}
	
	/**
	 * ��ʾ�����г���������Ա
	 * @return
	 */
	public String showServers(){
		servers = userService.findServers();
		jsonString = JsonUtil.jsonForList(servers);
		return SUCCESS;
	}
	
	public String upload(){
		String realPath = ServletActionContext.getServletContext().getRealPath("/uploads");
		if(img != null && !"".equals(imgFileName)){
			if(img.length() < 204800){
				String imgName = UUID.randomUUID().toString() + imgFileName.substring(imgFileName.indexOf("."));
				File imgDist = new File(new File(realPath), imgName);
				if(!imgDist.getParentFile().exists()){
					imgDist.getParentFile().mkdirs();
				}
				try {
					FileUtils.copyFile(img, imgDist);
					jsonString = "{success:true, imgName:'" + imgName + "'}";
				} catch (IOException e) {
					e.printStackTrace();
					jsonString = "{success:false,errorMessage:'ͼƬ�ϴ�ʧ�ܣ�'}";
					throw new AppException("ͼƬ�ϴ�ʧ�ܣ�");
				}
			} else {
				jsonString = "{success : false, errorMessage:'ͼƬ���ֻ��Ϊ200K��������ѡ��...'}";
			}
		}else{
			jsonString = "{success:false, errorMessage:'ͼƬ�ϴ�ʧ�ܣ�'}";
		}
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

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public ConditionDTO getConditionDTO() {
		return conditionDTO;
	}

	public void setConditionDTO(ConditionDTO conditionDTO) {
		this.conditionDTO = conditionDTO;
	}
}
