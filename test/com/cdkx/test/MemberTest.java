package com.cdkx.test;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import org.junit.Test;

import com.cdkx.expertbasesystem.actions.SubjectAction;
import com.cdkx.expertbasesystem.actions.UserAction;
import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.domain.Patent;
import com.cdkx.expertbasesystem.domain.Project;
import com.cdkx.expertbasesystem.domain.Subject;
import com.cdkx.expertbasesystem.domain.Thesis;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.dto.UserChartDTO;
import com.cdkx.expertbasesystem.dto.UserTotalDTO;
import com.cdkx.expertbasesystem.service.AwardService;
import com.cdkx.expertbasesystem.service.PatentService;
import com.cdkx.expertbasesystem.service.ProjectService;
import com.cdkx.expertbasesystem.service.SubjectService;
import com.cdkx.expertbasesystem.service.ThesisService;
import com.cdkx.expertbasesystem.service.UserService;
import com.cdkx.util.BaseTest;

public class MemberTest  extends BaseTest{
	
	private List list;
	
	/**
	 * ����ͨ����Ŀ���鿴�û���;
	 */
	@Test
	public void memberCountTest(){//����ͨ����Ŀ���鿴�û���;
		
		User user;
		String keyword = "�����Ӧ�ü���";
		UserService userService = (UserService) this.ctx.getBean("userService");
		List<String> list = userService.findUserBySub(keyword);
		
		for (String user2 : list)  
			System.out.print(user2 + "  ");
	}
	
	/**
	 * ����ͨ����Ŀ���鿴�û���ȫ����Ϣ
	 */
	
	@Test
	public void totalCountTest(){//����ͨ����Ŀ���鿴�û���;
		
		User user;
		String keyword = "�����Ӧ�ü���";
		UserService userService = (UserService) this.ctx.getBean("userService");
		Date before = new Date();
		List<UserTotalDTO> list = userService.countnum(keyword);
		Date after = new Date();
		System.out.println("����ʱ��Ϊ:  " + (after.getTime() - before.getTime() ));
		for (UserTotalDTO u : list) {
			System.out.println("[����Ϊ��] " + u.getUsername() + " ������Ϊ�� " + u.getAward() + " ��ר������Ϊ �� " + u.getPatent() + " ����Ŀ����Ϊ �� " + u.getProject() + " ����������Ϊ �� " + u.getThesis());
		}
	}
	
	/**
	 * ����ͨ����Ŀ���鿴�û���ȫ����Ϣ
	 */
	
	 
	@Test
	public void findUserBySub_Test(){//����ͨ�� ��Ŀ�� ����������Ա
		
		User user;
		String keyword = "�����Ӧ�ü���";
		Object[] o;
		
		UserService userService = (UserService) this.ctx.getBean("userService");
		List list = userService.findUserBySub_count(keyword);
		
		for (int i = 0; i < list.size(); i++) {
			o = (Object[])list.get(i);
			System.out.println("��Ա���� :  " + String.valueOf(o[1]) + "  ���" + String.valueOf(o[0]));
		} 
	}
	
	@Test//ͨ��userid ��ѯuser��ȫ����Ϣ.
	public void findUser_id() throws UnsupportedEncodingException{//����ͨ�� ��Ŀ�� ����������Ա
		
		/*UserService userService = (UserService) this.ctx.getBean("userService");
		User u = userService.findUserById("6"); 
		System.out.println(u.getAddress()); */
		
		UserAction userAction = (UserAction) this.ctx.getBean("userAction");
		userAction.setKeyword("6");
		String s = userAction.find_someone_id(); 
	}
}
