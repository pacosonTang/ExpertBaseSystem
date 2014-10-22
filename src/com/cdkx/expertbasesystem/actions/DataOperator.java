package com.cdkx.expertbasesystem.actions;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Subject;
import com.cdkx.expertbasesystem.service.SubjectService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 用于在每个二级学科下添加一个名称为“其它”的三级学科
 * @author Guojun
 *
 */
public class DataOperator extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private SubjectService subjectService;
	
	public String modifySecondSubject(){
		List<Subject> firstSubjects = subjectService.findFirstSubjects();
		for(int i = 0; i < firstSubjects.size(); i++)
			for(Subject subject : firstSubjects.get(i).getChildren()){
				Subject other = new Subject();
				other.setName("其它");
				other.setParent(subject);
				subjectService.addSubject(other);
			}
		return SUCCESS;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
}
