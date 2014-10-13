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
	
	private String accessType;//�������ͣ� ��Ŀ�� ר�ң�����....
	
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
	 * ��ʾ���е�ѧ��רҵ
	 * @return
	 */
	public String showAllSubjects(){
		subjects = subjectService.findAllSubjects();
		for(int i = 0; i < subjects.size(); i ++)
			if(subjects.get(i).getName().equals("����")){
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
	
	public String deleteSubjects(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++)
			subjectService.deleteSubjectById(Integer.parseInt(ids[i]));
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	//������ͳ�Ʒ���,������ͳ�Ʒ���,������ͳ�Ʒ���,������ͳ�Ʒ���,������ͳ�Ʒ���,������ͳ�Ʒ���,������ͳ�Ʒ���
	
	/**
	 * �������ͣ���ת����ͬҳ��
	 * @return success
	 */
	public String skip_access(){
		String[] types = {"member","patent","project","thesis","award","someone"};
		this.setAccessType("");
		return SUCCESS;
	}
	
	/**
	 * ��װ һ��,����,���� Ŀ¼
	 * @return success
	 */
	
	public String findSubject(){
		
		List<FirstDTO> firstdto = new ArrayList<FirstDTO>();//һ��Ŀ¼����
		List<String> firstsub = subjectService.findFirstSub();//һ��Ŀ¼
		
		for (String temp : firstsub) {
			
			List<SecondDTO> seconddto = new ArrayList<SecondDTO>();// ����Ŀ¼����
			FirstDTO singleFirstdto = new FirstDTO();
			singleFirstdto.setFirst(temp);//��װһ��Ŀ¼
			List<String> secondsub = subjectService.subjectByParent(temp);//����Ŀ¼
			
			for (String subject2 : secondsub) {
				SecondDTO singleSeconddto = new SecondDTO();
				singleSeconddto.setSecondsingle(subject2);//��װ����Ŀ¼
				List<String> list2 = new ArrayList<String>();
				list2 = subjectService.subjectByParent(subject2);//����Ŀ¼
				if(list2.size() < 1) continue;
				singleSeconddto.setThird(list2);//��װ ����Ŀ¼
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
	
	
	//���� json������ʽ���ڼ��ص�ʱ�� ��ֹhibernate�� ����������
	public JSONArray configJson(List list){
		  JsonConfig jsonConfig = new JsonConfig();  //���������ļ�
		  jsonConfig.setIgnoreDefaultExcludes(false);  //����Ĭ�Ϻ���
		  jsonConfig.setExcludes(new String[]{""});  
		  //�˴������㣬ֻҪ����������ֶμӵ������м��ɣ������������У���Ҫ���Ե��ǡ�libs������ô�����������м��ɣ�
		  //��ʵ�ʲ����У��ҷ����������������У����ڴ����������ԣ��硰multipartRequestHandler������servletWrapper����
		  //��ôҲ���Խ��������ӵ�����������.
		  JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);  //���������ļ�
		  return jsonArray;
	}

	//������get��set����
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
