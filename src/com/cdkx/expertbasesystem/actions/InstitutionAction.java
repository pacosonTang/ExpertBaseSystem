package com.cdkx.expertbasesystem.actions;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Institution;
import com.cdkx.expertbasesystem.service.InstitutionService;
import com.cdkx.expertbasesystem.utils.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �ṩ��Э����Ϣ��ҵ���߼�
 * @author Guojun
 *
 */
public class InstitutionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Institution institution;
	
	private List<Institution> institutions;
	
	private InstitutionService institutionService;
	
	private String jsonString;
	
	/**
	 * ��ʾ���е�Э����Ϣ<br>
	 * ʹ�÷�������ǰ��ֱ��ʹ��showInstitutions.action���ɣ�����Ҫ���ݲ���<br>
	 * ʹ�ø÷����ĵط���������һ���ǻ�Ա�޸��Լ���Ϣ��һ���ǹ���Ա��Ӻ��޸Ļ�Ա��Ϣ<br>
	 * �˷������ص������е�Э����Ϣ�����û�ѡ����ҪAjax��֧�֣�һ���ǵ�������б�Ȼ�󽫷��ص�institutionsѭ����ʾ�������б���<br>
	 * ���������Ҫ���ص��������������ҳ��ȥ����Ҫ�ֲ�ˢ�£��ʷ��ص����ݿ�����Ҫ��json��װ
	 * @return
	 */
	public String showInstitutions(){
		institutions = institutionService.findInstitutions();
		jsonString = JsonUtil.jsonForList(institutions);
		return SUCCESS;
	}
	
	/**
	 * ���Э����Ϣ<br>
	 * ʹ�÷�����ֱ����ǰ��form�е�aciton����addInstitution.action���ɡ�<br>
	 * ���룺��Ҫ����Э����Ϣ��������name��ҪΪinstitution.name���ɣ�id���Զ����ɡ�<br>
	 * ����������Ҫ�˹��ܣ���ô��Ҫ����һ����ʾ����Э���б��ҳ�棬�˷��������󣬻���ת��showInstitutions.action������ʾ�����е�Э����Ϣ��
	 * ����������һ��ajax�����ڹ���Ա��ӻ�Աѡ��Э���ʱ����Э�����ݲ��㣬ֱ����һ����ӹ��ܣ�
	 * �γɼ򵥵���ӣ���ӽ�����ֱ�Ӱ���ӽ������ˢ�¼��ɣ�Ҳ��Ҫ����showInstitutions.action���¾ֲ�ˢ��<br>
	 * @return
	 */
	public String addInstitution(){
		institutionService.addInstitution(institution);
		return SUCCESS;
	}

	public List<Institution> getInstitutions() {
		return institutions;
	}

	public void setInstitutionService(InstitutionService institutionService) {
		this.institutionService = institutionService;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public String getJsonString() {
		return jsonString;
	}

}
