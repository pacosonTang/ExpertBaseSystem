package com.cdkx.test;

import java.util.List;
import org.junit.Test;

import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.domain.Patent;
import com.cdkx.expertbasesystem.domain.Project;
import com.cdkx.expertbasesystem.domain.Thesis;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.service.AwardService;
import com.cdkx.expertbasesystem.service.DatacountService;
import com.cdkx.expertbasesystem.service.PatentService;
import com.cdkx.expertbasesystem.service.ProjectService;
import com.cdkx.expertbasesystem.service.ThesisService;
import com.cdkx.expertbasesystem.service.UserService;
import com.cdkx.util.BaseTest;

public class UserSpecificationTest  extends BaseTest{
	
	private List list;
	
	@Test
	public void findUserTest(){//���Բ�ѯ�û���Ϣ
		
		User user;
		String name = "�����";
		UserService userService = (UserService) this.ctx.getBean("userService");
		List<User> list = userService.findUsers(name);
		if(list.size()> 0){
			user = (User)list.get(0);
			System.out.println(user.getAddress());
		}
	}
	
	@Test
	public void findPatentTest(){//���Բ�ѯר����Ϣ
		
		int id = 6;
		PatentService patentService = (PatentService) this.ctx.getBean("patentService");
		List<Patent> list = patentService.findPatentByUser(id);
		
		for (Patent patent : list) {
			System.out.println(patent.getName());
		}
	}
	
	@Test
	public void findThesisTest(){//���Բ�ѯ������Ϣ
		
		int id = 6;
		ThesisService thesisService = (ThesisService) this.ctx.getBean("thesisService");
		List<Thesis> list = thesisService.findThesisByUser(id);
		
		for (Thesis thesis: list) {
			System.out.println(thesis.getName());
		}
	}
	
	@Test
	public void findProjectTest(){//���Բ�ѯ��Ŀ��Ϣ
		
		int id = 6;
		ProjectService projectService = (ProjectService) this.ctx.getBean("projectService");
		List<Project> list = projectService.findProjectByUser(id);
		
		for (Project project: list) {
			System.out.println(project.getName());
		}
	}
	
	@Test
	public void findAwardTest(){//���Բ�ѯ������Ϣ
		
		int id = 6;
		AwardService awardService = (AwardService) this.ctx.getBean("awardService");
		List<Award> list = awardService.findAwardByUser(id);
		
		for (Award award: list) {
			System.out.println(award.getName());
		}
	}
	
}
