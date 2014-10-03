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
	 * �����û�ѡ��ѧ�Ʊ����ʾ��ѧ���µ���ѧ��
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
	 * ��Ӷ���ѧ��<br>
	 * ����ѧ���£�ʼ�����һ����������������ǰ�˱���ѡ������ѧ�Ƶ�����
	 * @return
	 */
	public String addSecondSubject(){
		subjectService.addSubject(subject);
		Subject other = new Subject();
		other.setParent(subject);
		other.setName("����");
		subjectService.addSubject(other);
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	/**
	 * ���һ��������ѧ�ƣ����һ��ѧ��ʱ��parent�ֶ��ǿյ�<br>
	 * �������ѧ��ʱ����Ҫ����ѡ��Ķ���ѧ������ӣ�parent��ֵ<br>
	 * �Դ���������ӵ���һ��ѧ�ƻ�������ѧ��
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
