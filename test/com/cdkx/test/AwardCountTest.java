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
	 * 测试通过科目名  查看  奖励;
	 */
	@Test
	public void countAwardNumTest(){//测试通过科目名查看用户名;
		
		Award award;
		String keyword = "计算机应用技术";
		AwardService awardService = (AwardService) this.ctx.getBean("awardService");
		List<Award> list = awardService.countAwardNum(keyword);
		
		for (Award a : list)  
			System.out.print(a.getName() + "  ");
	}
	
	 
}
