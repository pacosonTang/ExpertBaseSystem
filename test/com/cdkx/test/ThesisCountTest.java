package com.cdkx.test;

import java.util.List;
import org.junit.Test;

import com.cdkx.expertbasesystem.actions.SubjectAction;
import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.domain.Patent;
import com.cdkx.expertbasesystem.domain.Project;
import com.cdkx.expertbasesystem.domain.Subject;
import com.cdkx.expertbasesystem.domain.Thesis;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.service.AwardService;
import com.cdkx.expertbasesystem.service.PatentService;
import com.cdkx.expertbasesystem.service.ProjectService;
import com.cdkx.expertbasesystem.service.SubjectService;
import com.cdkx.expertbasesystem.service.ThesisService;
import com.cdkx.expertbasesystem.service.UserService;
import com.cdkx.util.BaseTest;

public class ThesisCountTest  extends BaseTest{
	
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
	 * ����ͨ���û����鿴ר��;
	 */
	@Test
	public void patentCountTest(){//����ͨ����Ŀ���鿴�û���;
		
		Patent patent;
		String keyword = "����";
		PatentService patentService = (PatentService) this.ctx.getBean("patentService");
		List<String> list = null;
		
		for (String patent2 : list)  
			System.out.print(patent2 + "  ");
	}
	
	/**
	 * ���ݿ�Ŀ �鿴���� ����
	 */
	
	@Test
	public void countThesisTest(){//����ͨ����Ŀ���鿴�û���;
		
		Thesis thesis;
		String keyword = "�����Ӧ�ü���";
		ThesisService thesisService = (ThesisService) this.ctx.getBean("thesisService");
		List<Thesis> list = thesisService.countThesisNum(keyword,1);
		
		for (Thesis thesis2 : list)  
			System.out.println(thesis2.getName() + "  ");
	}
	
	/**
	 * �����û�id  �鿴���� ����
	 */
	
	@Test
	public void findThesis_id_Test(){//����ͨ����Ŀ���鿴�û���;
		
		Thesis thesis;
		String keyword = "�����Ӧ�ü���";
		ThesisService thesisService = (ThesisService) this.ctx.getBean("thesisService");
		List<Thesis> list = thesisService.findThesisByUser(12);
		
		for (Thesis thesis2 : list)  
			System.out.println(thesis2.getName() + "  ");
	}
	
}
