package com.cdkx.expertbasesystem.actions;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.domain.Patent;
import com.cdkx.expertbasesystem.domain.Project;
import com.cdkx.expertbasesystem.domain.Thesis;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.domain.UserDTO;
import com.cdkx.expertbasesystem.dto.BiPropertyDTO;
import com.cdkx.expertbasesystem.dto.UserTotalDTO;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.DatacountService;
import com.cdkx.expertbasesystem.service.UserService;
import com.cdkx.expertbasesystem.utils.BaseAction;
import com.cdkx.expertbasesystem.utils.JsonUtil;
import com.cdkx.expertbasesystem.utils.MD5Util;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �����û���Ϣ�����в������ڴ˽�����Ӧ�ͷַ�<br>
 * 1.��Ա���Լ���Ϣִ�еĲ���������ע�ᡢ��ѯ�޸��Լ�����Ϣ<br>
 * 2.�쵼���Լ���Ϣ���޸ģ���ѯ<br>
 * 3.�г���������Ա���Լ���Ϣ���޸Ĳ�ѯ<br>
 * 4.����Ա���Լ���Ϣ�Ĳ�ѯ�޸�<br>
 * @author Guojun
 *
 */

public class DatacountAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private DatacountService datacountService;
	private String keyword;
	private String result;
	
	/**
	 * ͳ�ƻ�ԱmemberNum,��ĿprojectNum������awardNum�� ����thesisNum�� ר��patentNum,ռ��,��ajax����
	 * @return chart_list;
	 */
	public String member_percentage(){
		
		try {
			List<BiPropertyDTO> list = datacountService.member_ratio(keyword);
			result = JsonUtil.jsonForList(list);	
	    } catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ  ��Ա����  ��Ϣʧ��");
		}
		System.out.println(result);
		return SUCCESS;
	}
	
	
	public String execute(){//Ĭ�Ϸ��ʷ���
		return SUCCESS;
	}

	public DatacountService getDatacountService() {
		return datacountService;	
	}

	public void setDatacountService(DatacountService datacountService) {
		this.datacountService = datacountService;
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
	
}
