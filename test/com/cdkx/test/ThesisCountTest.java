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
	 * 测试通过科目名查看用户名;
	 */
	@Test
	public void memberCountTest(){//测试通过科目名查看用户名;
		
		User user;
		String keyword = "计算机应用技术";
		UserService userService = (UserService) this.ctx.getBean("userService");
		List<String> list = userService.findUserBySub(keyword);
		
		for (String user2 : list)  
			System.out.print(user2 + "  ");
	}
	
	/**
	 * 测试通过用户名查看专利;
	 */
	@Test
	public void patentCountTest(){//测试通过科目名查看用户名;
		
		Patent patent;
		String keyword = "郭刚";
		PatentService patentService = (PatentService) this.ctx.getBean("patentService");
		List<String> list = null;
		
		for (String patent2 : list)  
			System.out.print(patent2 + "  ");
	}
	
	/**
	 * 依据科目 查看所有 论文
	 */
	
	@Test
	public void countThesisTest(){//测试通过科目名查看用户名;
		
		Thesis thesis;
		String keyword = "计算机应用技术";
		ThesisService thesisService = (ThesisService) this.ctx.getBean("thesisService");
		List<Thesis> list = thesisService.countThesisNum(keyword,1);
		
		for (Thesis thesis2 : list)  
			System.out.println(thesis2.getName() + "  ");
	}
	
	/**
	 * 依据用户id  查看所有 论文
	 */
	
	@Test
	public void findThesis_id_Test(){//测试通过科目名查看用户名;
		
		Thesis thesis;
		String keyword = "计算机应用技术";
		ThesisService thesisService = (ThesisService) this.ctx.getBean("thesisService");
		List<Thesis> list = thesisService.findThesisByUser(12);
		
		for (Thesis thesis2 : list)  
			System.out.println(thesis2.getName() + "  ");
	}
	
}
