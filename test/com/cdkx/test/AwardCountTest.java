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

public class AwardCountTest  extends BaseTest{
	
	private List list;
	
	/**
	 * ����ͨ����Ŀ��  �鿴  ����;
	 */
	@Test
	public void countAwardNumTest(){//����ͨ����Ŀ���鿴�û���;
		
		Award award;
		String keyword = "�����Ӧ�ü���";
		AwardService awardService = (AwardService) this.ctx.getBean("awardService");
		List<Award> list = awardService.countAwardNum(keyword);
		
		for (Award a : list)  
			System.out.print(a.getName() + "  ");
	}
	
	 
}
