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
	 * 测试通过用户名查看项目;
	 */
	@Test
	public void patentCountTest(){//测试通过科目名查看用户名;
		
		Patent patent;
		
		PatentService patentService = (PatentService) this.ctx.getBean("patentService");
		List<Patent> list = patentService.findPatentByUser(12);
		
		for (Patent patent2 : list)  
			System.out.print(patent2.getName() + "  ");
	}
	
	/**
	 * 测试通过科目查看专利;
	 */
	@Test
	public void countPatentNumTest(){//测试通过科目名查看用户名;
		
		Patent patent;
		
		PatentService patentService = (PatentService) this.ctx.getBean("patentService");
		List<Patent> list = patentService.findPatentByUser(12);
		
		for (Patent patent2 : list)  
			System.out.print(patent2.getName() + "  ");
	}
	
	/**
	 * 测试通过科用户 id  查看专利;
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
