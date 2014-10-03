package com.cdkx.expertbasesystem.actions;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Subject;
import com.cdkx.expertbasesystem.service.SubjectService;
import com.cdkx.expertbasesystem.utils.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class SubjectAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Subject> subjects;
	
	private Subject subject;
	
	private SubjectService subjectService;
	
	private int subjectId;
	
	private String selectIds;
	
	private String jsonString;
	
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
	
	public String deleteSubject(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			subjectService.deleteSubjectById(Integer.parseInt(ids[i]));
		jsonString = "{success:true}";
		return SUCCESS;
	}

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
}
