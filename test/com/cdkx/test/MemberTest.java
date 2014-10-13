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

public class MemberTest  extends BaseTest{
	
	private List list;
	
	@Test
	public void memberTest(){//测试查询用户信息
		
		Subject subject;
		String name = "周锐锋";
		SubjectService subjectService = (SubjectService) this.ctx.getBean("subjectService");
		List<Subject> list = subjectService.findFirstSubjects();
		
		for (Subject subject2 : list)  
			System.out.print(subject2.getName() + "  ");
	}
	 
}
