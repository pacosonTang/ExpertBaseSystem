package com.cdkx.expertbasesystem.actions;

import java.util.List;

import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Ϊ�쵼�ṩ��Աͳ�ƣ���Ա��ѯ��ҵ���߼�
 * @author Guojun
 *
 */
public class LeaderAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private List<User> members;
	
	private UserService userService;
	
	private String countCondition;
	
	private List<Object[]> count;
	
	/**
	 * ��ʾ���еĻ�Ա��Ϣ
	 * @return
	 */
	public String showMembers(){
		members = userService.findMembers();
		return SUCCESS;
	}
	
	/**
	 * �Ի�Ա��Ϣ����ͳ��<br>
	 * ���ص���һ��Object���������list���ϣ���jsp�н��з��ʵ�ʱ����Ҫ����iterator��ǩ����ѭ��<br>
	 * �������е�Object������Ҫ��id�����з��ʣ���#{id}[0]����ȡ<br>
	 * json��ʾ��ʱû�в���<br>
	 * ��Ҫ�û�ѡ���������������簴ѧλ��������ѧ����������ְ�������ȣ�������������Щ������Ӣ�ı�ʾ
	 * degree-ѧλ
	 * education-ѧ��
	 * title-ְ�ƣ���Ҫ���ۣ�
	 * institution-Э�ᣨ�����ۣ�
	 * @return
	 */
	public String countMember(){
		count = (List<Object[]>) userService.statisticMembers(countCondition);
		return SUCCESS;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setCountCondition(String countCondition) {
		this.countCondition = countCondition;
	}

	public Object getCount() {
		return count;
	}

}
