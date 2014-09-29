package com.cdkx.expertbasesystem.actions;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Degree;
import com.cdkx.expertbasesystem.service.DegreeService;
import com.cdkx.expertbasesystem.utils.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �ṩ��ѧ��ѧλ��ҵ���߼�
 * @author Guojun
 *
 */
public class DegreeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private List<Degree> educations;
	
	private List<Degree> degrees;
	
	private DegreeService degreeService;
	
	private String jsonString;
	
	/**
	 * ��ʾ����ѧλ��Ϣ<br>
	 * ʹ����������ĵط�������������һ���ǹ���Ա��ӻ�Ա��ʱ����һ���ǻ�Ա�޸��Լ���Ϣ���߹���Ա�޸Ļ�Ա��Ϣ��ʱ��<br>
	 * ����������Ajax�ķ������е��ã�����֮����Ҫ�ܻص���ǰҳ��ֲ�ˢ�������б����ڹ���Ҫ��json����װ����<br>
	 * ʹ�÷�������ǰ̨����showDegrees.action���ɣ�����Ҫ�������
	 * @return
	 */
	public String showDegrees(){
		degrees = degreeService.findDegrees();
		jsonString = JsonUtil.jsonForList(degrees);
		return SUCCESS;
	}
	
	/**
	 * ��ʾ����ѧ����Ϣ<br>
	 * ʹ����������ĵط�������������һ���ǹ���Ա��ӻ�Ա��ʱ����һ���ǻ�Ա�޸��Լ���Ϣ���߹���Ա�޸Ļ�Ա��Ϣ��ʱ��<br>
	 * ����������Ajax�ķ������е��ã�����֮����Ҫ�ܻص���ǰҳ��ֲ�ˢ�������б����ڹ���Ҫ��json����װ����<br>
	 * ʹ�÷�������ǰ̨����showDegrees.action���ɣ�����Ҫ�������
	 * @return
	 */
	public String showEducations(){
		educations = degreeService.findEducations();
		jsonString = JsonUtil.jsonForList(educations);
		return SUCCESS;
	}

	public void setDegreeService(DegreeService degreeService) {
		this.degreeService = degreeService;
	}

	public String getJsonString() {
		return jsonString;
	}

}
