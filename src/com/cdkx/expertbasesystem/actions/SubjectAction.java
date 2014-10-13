package com.cdkx.expertbasesystem.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.SessionAware;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.cdkx.expertbasesystem.domain.Subject;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.dto.SecondDTO;
import com.cdkx.expertbasesystem.dto.FirstDTO;
import com.cdkx.expertbasesystem.service.SubjectService;
import com.cdkx.expertbasesystem.utils.BaseAction;
import com.cdkx.expertbasesystem.utils.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class SubjectAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private List<Subject> subjects;
	
	private Subject subject;
	
	private SubjectService subjectService;
	
	private int subjectId;
	
	private String selectIds;
	
	private String jsonString;
	
	private JSONObject jo;
	
	private JSONArray ja;
	
	private String result;
	
	private String postid;
	
	private String accessType;//访问类型： 项目， 专家，找人....
	
	/**
	 * 根据用户选择学科编号显示该学科下的子学科
	 * @return
	 */
	public String showSubjects(){
		if(subjectId == 0)
			subjects = subjectService.findFirstSubjects();
		else
			subjects = subjectService.findSubjectsByParent(subjectId);
		jsonString = JsonUtil.jsonForList(subjects);
		return SUCCESS;
	}
	
	/**
	 * 显示所有的学科专业
	 * @return
	 */
	public String showAllSubjects(){
		subjects = subjectService.findAllSubjects();
		for(int i = 0; i < subjects.size(); i ++)
			if(subjects.get(i).getName().equals("其它")){
				subjects.remove(subjects.get(i));
			}
		for(int i = 0; i < subjects.size(); i ++)
			if(subjects.get(i).getParent() == null){
				Subject parent = new Subject();
				parent.setId(0);
				parent.setName("");
				subjects.get(i).setParent(parent);
			}
		jsonString = JsonUtil.jsonForSubject(subjects);
		return SUCCESS;
	}
	
	/**
	 * 添加二级学科<br>
	 * 二级学科下，始终添加一个其它，用以满足前端必须选择三级学科的需求
	 * @return
	 */
	public String addSecondSubject(){
		subjectService.addSubject(subject);
		Subject other = new Subject();
		other.setParent(subject);
		other.setName("其它");
		subjectService.addSubject(other);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * 添加一级与三级学科，添加一级学科时，parent字段是空的<br>
	 * 添加三级学科时，需要根据选择的二级学科来添加，parent有值<br>
	 * 以此来区分添加的是一级学科还是三级学科
	 * @return
	 */
	public String addSubject(){
		subjectService.addSubject(subject);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String deleteSubjects(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			subjectService.deleteSubjectById(Integer.parseInt(ids[i]));
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	//以下是统计方法,以下是统计方法,以下是统计方法,以下是统计方法,以下是统计方法,以下是统计方法,以下是统计方法
	
	/**
	 * 访问类型，跳转到不同页面
	 * @return success
	 */
	public String skip_access(){
		String[] types = {"member","patent","project","thesis","award","someone"};
		this.setAccessType("");
		return SUCCESS;
	}
	
	/**
	 * 封装 一级,二级,三级 目录
	 * @return success
	 */
	
	public String findSubject(){
		
		List<FirstDTO> firstdto = new ArrayList<FirstDTO>();//一级目录集合
		List<String> firstsub = subjectService.findFirstSub();//一级目录
		
		for (String temp : firstsub) {
			
			List<SecondDTO> seconddto = new ArrayList<SecondDTO>();// 二级目录集合
			FirstDTO singleFirstdto = new FirstDTO();
			singleFirstdto.setFirst(temp);//封装一级目录
			List<String> secondsub = subjectService.subjectByParent(temp);//二级目录
			
			for (String subject2 : secondsub) {
				SecondDTO singleSeconddto = new SecondDTO();
				singleSeconddto.setSecondsingle(subject2);//封装二级目录
				List<String> list2 = new ArrayList<String>();
				list2 = subjectService.subjectByParent(subject2);//三级目录
				if(list2.size() < 1) continue;
				singleSeconddto.setThird(list2);//封装 三级目录
				seconddto.add(singleSeconddto);
			}
			singleFirstdto.setSecondlist(seconddto);
			firstdto.add(singleFirstdto);
		}
		
		ja = configJson(firstdto);
		result = ja.toString();
		System.out.println(result);
		return SUCCESS;
	}
	
	
	//配置 json解析格式，在加载的时候 防止hibernate的 懒加载属性
	public JSONArray configJson(List list){
		  JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		  jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
		  jsonConfig.setExcludes(new String[]{""});  
		  //此处是亮点，只要将所需忽略字段加到数组中即可，在上述案例中，所要忽略的是“libs”，那么将其添到数组中即可，
		  //在实际测试中，我发现在所返回数组中，存在大量无用属性，如“multipartRequestHandler”，“servletWrapper”，
		  //那么也可以将这两个加到忽略数组中.
		  JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);  //加载配置文件
		  return jsonArray;
	}

	//以下是get，set方法
	public String getJsonString() {
		return jsonString;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public void setSelectIds(String selectIds) {
		this.selectIds = selectIds;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPostid() {
		return postid;
	}

	public void setPostid(String postid) {
		this.postid = postid;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
	
	
	
}
