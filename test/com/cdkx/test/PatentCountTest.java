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

public class PatentCountTest  extends BaseTest{
	
	private List list;
	
	/**
	 * ����ͨ���û����鿴��Ŀ;
	 */
	@Test
	public void patentCountTest(){//����ͨ����Ŀ���鿴�û���;
		
		Patent patent;
		
		PatentService patentService = (PatentService) this.ctx.getBean("patentService");
		List<Patent> list = patentService.findPatentByUser(12);
		
		for (Patent patent2 : list)  
			System.out.print(patent2.getName() + "  ");
	}
	
	/**
	 * ����ͨ����Ŀ�鿴ר��;
	 */
	@Test
	public void countPatentNumTest(){//����ͨ����Ŀ���鿴�û���;
		
		Patent patent;
		
		PatentService patentService = (PatentService) this.ctx.getBean("patentService");
		List<Patent> list = patentService.findPatentByUser(12);
		
		for (Patent patent2 : list)  
			System.out.print(patent2.getName() + "  ");
	}
	
	/**
	 * ����ͨ�����û� id  �鿴ר��;
	 */
	@Test
	public void findPatent_id_Test(){
		
		Patent patent;
		
		PatentService patentService = (PatentService) this.ctx.getBean("patentService");
		List<Patent> list = patentService.findPatentByUser(12);
		
		for (Patent patent2 : list)  
			System.out.print(patent2.getName() + "  ");
	}
	
	
	
}
