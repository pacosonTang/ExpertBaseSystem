package com.cdkx.expertbasesystem.actions;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.domain.Patent;
import com.cdkx.expertbasesystem.domain.Project;
import com.cdkx.expertbasesystem.domain.Thesis;
import com.cdkx.expertbasesystem.domain.Userfour;
import com.cdkx.expertbasesystem.dto.BiPropertyDTO;
import com.cdkx.expertbasesystem.dto.UserTotalDTO;
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
	
	private String keyword;
	
	private String result;
	
	private String specific_type;
	
	private UserAction userAction;
	
	private String someoneKey;
	
	private String curpage;
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
		if(str.equals("undefined"))
			str = String.valueOf(this.getSession().get("cur_sub"));
		try {
			List<Project> temp = projectService.countProNum(str,Integer.parseInt(curpage));
			this.getRequest().put("list_total", temp);
			this.getSession().put("cur_sub", str);
			this.getRequest().put("curpage", curpage);// ��ǰҳ���Ƕ���
			this.getSession().put("item_total", awardService.countFiveNum(str, "proNum"));
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
		if(str.equals("undefined"))
			str = String.valueOf(this.getSession().get("cur_sub"));
		try {
			List<Award> temp = awardService.countAwardNum(str,Integer.parseInt(curpage));
			this.getRequest().put("list_total", temp);
			this.getSession().put("cur_sub", str);
			this.getRequest().put("curpage", curpage);// ��ǰҳ���Ƕ���
			this.getSession().put("item_total", awardService.countFiveNum(str, "aNum"));
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
		if(str.equals("undefined"))
			str = String.valueOf(this.getSession().get("cur_sub"));
		try {
			List<Thesis> temp = thesisService.countThesisNum(str,Integer.parseInt(curpage));
			this.getRequest().put("list_total", temp);
			this.getSession().put("cur_sub", str);
			this.getRequest().put("curpage", curpage);// ��ǰҳ���Ƕ���
			this.getSession().put("item_total", awardService.countFiveNum(str, "tNum"));
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
		if(str.equals("undefined"))
			str = String.valueOf(this.getSession().get("cur_sub"));
		try {
			List<Patent> temp = patentService.countPatentNum(str,Integer.parseInt(curpage));
			this.getRequest().put("list_total", temp);
			this.getSession().put("cur_sub", str);
			this.getRequest().put("curpage", curpage);// ��ǰҳ���Ƕ���
			this.getSession().put("item_total", awardService.countFiveNum(str, "patNum"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ  ר��  ��Ϣʧ��");
		}
		return "success";
	}
	
	//��ҳ��ѯ4 items ,project��patent�� award , thesis;
	public String page_four() throws UnsupportedEncodingException{
		
		List list = null;
		String str = String.valueOf(this.getSession().get("cur_sub"));
		String access = String.valueOf(this.getSession().get("access"));
		try {
			if(access.equals("project")){
				list = projectService.countProNum(str, Integer.parseInt(curpage));
				this.getSession().put("item_total", awardService.countFiveNum(str, "proSum")); 
			}
			else if(access.equals("award")){
				list = awardService.countAwardNum(str, Integer.parseInt(curpage));
				this.getSession().put("item_total", awardService.countFiveNum(str, "aSum")) ; 
			}
			else if(access.equals("patent")){
				list = patentService.countPatentNum(str, Integer.parseInt(curpage));
				this.getSession().put("item_total", awardService.countFiveNum(str, "patSum")); 
			}
			else{//thesis
				list = thesisService.countThesisNum(str, Integer.parseInt(curpage));
				this.getSession().put("item_total", awardService.countFiveNum(str, "tSum")); 
			}
			this.getRequest().put("curpage", curpage);// ��ǰҳ���Ƕ���
			this.getRequest().put("list_total", list);//
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ�û��ۺ���Ϣʧ��");
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
		 
		System.out.println("�ؼ��� :  " + someoneKey);
		try {
			switch(Integer.parseInt(specific_type)){
				case 2: result = JsonUtil.jsonForList(projectService.findProjectByUser(Integer.parseInt(someoneKey)));break;//��List����Ϊjson�ַ�������
				case 3: result = JsonUtil.jsonForList(awardService.findAwardByUser(Integer.parseInt(someoneKey)));break;
				case 4: result = JsonUtil.jsonForList(thesisService.findThesisByUser(Integer.parseInt(someoneKey)));break;
				case 5: result = JsonUtil.jsonForList(patentService.findPatentByUser(Integer.parseInt(someoneKey)));break;
				default:result = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ ��Ŀ  ��Ϣʧ��");
		}
		System.out.println(result);
		return "success";
	}
	
	/**
	 * ��������תҳ��ķ���
	 * @return success
	 * @throws UnsupportedEncodingException 
	 */
	public String skip_patent() throws UnsupportedEncodingException{
		
		String str;
		this.getSession().put("access", "patent");
		if(this.getSession().get("cur_sub") != null){
			str = String.valueOf(this.getSession().get("cur_sub"));
			List<Patent> temp = patentService.countPatentNum(str,1);
			this.getRequest().put("curpage", 1);// ��ǰҳ���Ƕ���
			this.getRequest().put("list_total", temp);
			this.getSession().put("item_total", this.awardService.countFiveNum(str, "patSum"));//����Ŀ��
		}  
		return SUCCESS;
	}
	
	public String skip_award() throws UnsupportedEncodingException{
		
		String str;
		this.getSession().put("access", "award");
		if(this.getSession().get("cur_sub") != null){
			str = String.valueOf(this.getSession().get("cur_sub"));
			List<Award> temp = awardService.countAwardNum(str,1);
			this.getRequest().put("curpage", 1);// ��ǰҳ���Ƕ���
			this.getRequest().put("list_total", temp); 
			this.getSession().put("item_total", this.awardService.countFiveNum(str, "aSum"));//����Ŀ��
		} 
		return SUCCESS;
	}
	
	public String skip_project() throws UnsupportedEncodingException{
		
		String str;
		this.getSession().put("access", "project");
		if(this.getSession().get("cur_sub") != null){
			str = String.valueOf(this.getSession().get("cur_sub"));
			List<Project> temp = projectService.countProNum(str,1);
			this.getRequest().put("curpage", 1);// ��ǰҳ���Ƕ���
			this.getRequest().put("list_total", temp); 
			this.getSession().put("item_total", this.awardService.countFiveNum(str, "proSum"));//����Ŀ��
		}
		return SUCCESS;
	}
	public String skip_thesis() throws UnsupportedEncodingException{
		
		String str;
		this.getSession().put("access", "thesis");
		if(this.getSession().get("cur_sub") != null){
			str = String.valueOf(this.getSession().get("cur_sub"));
			List<Thesis> temp = thesisService.countThesisNum(str,1);
			this.getRequest().put("curpage", 1);// ��ǰҳ���Ƕ���
			this.getRequest().put("list_total", temp); 
			this.getSession().put("item_total", this.awardService.countFiveNum(str, "tSum"));//����Ŀ��
		} 
		return SUCCESS;
	}
	
	public String skip_member() throws UnsupportedEncodingException{
		
		String str;
		this.getSession().put("access", "member");
		if(this.getSession().get("cur_sub") != null){
			str = String.valueOf(this.getSession().get("cur_sub"));
			List<Userfour> list_total = this.getUserAction().getUserService().countnum(str,1);
			this.getRequest().put("curpage", 1);// ��ǰҳ���Ƕ���
			this.getRequest().put("list_total", list_total);	
			this.getSession().put("item_total", this.awardService.countFiveNum(str, "mSum"));//����Ŀ��
		}
		return SUCCESS;
	}
	
	public String skip_chart(){
		
		this.getSession().put("access", "chart");
		return SUCCESS;
	}
	
	public String skip_someone() throws UnsupportedEncodingException{
		
		String str;
		this.getSession().put("access", "someone");
		if(this.getSession().get("cur_sub") != null){
			str = String.valueOf(this.getSession().get("cur_sub"));
			this.setSomeoneKey(str);
			this.getUserAction().setKeyword(str);
			List<BiPropertyDTO> temp = this.getUserAction().getUserService().findUserBySub_count(str);
			this.getRequest().put("list_total", temp);
		}
		return SUCCESS;
	}
	//[over]ҳ����ת����
	
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

	public UserAction getUserAction() {
		return userAction;
	}

	public void setUserAction(UserAction userAction) {
		this.userAction = userAction;
	}

	public String getSomeoneKey() {
		return someoneKey;
	}

	public void setSomeoneKey(String someoneKey) {
		this.someoneKey = someoneKey;
	}

	public String getCurpage() {
		return curpage;
	}

	public void setCurpage(String curpage) {
		this.curpage = curpage;
	}
	
	
}
