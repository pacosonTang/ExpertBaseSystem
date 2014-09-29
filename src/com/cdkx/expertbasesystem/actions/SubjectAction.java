package com.cdkx.expertbasesystem.actions;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Subject;
import com.cdkx.expertbasesystem.service.SubjectService;
import com.cdkx.expertbasesystem.utils.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class SubjectAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Subject> subjects;
	
	private SubjectService subjectService;
	
	private int subjectId;
	
	private String jsonString;
	
	public String showSubjects(){
		if(subjectId == 0)
			subjects = subjectService.findFirstSubjects();
		else
			subjects = subjectService.findSubjectsByParent(subjectId);
		jsonString = JsonUtil.jsonForList(subjects);
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
}
