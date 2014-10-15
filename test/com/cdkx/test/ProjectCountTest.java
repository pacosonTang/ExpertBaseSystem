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

public class ProjectCountTest  extends BaseTest{
	
	private List list;
	
	
	/**
	 * 测试通过用户名查看项目;
	 */
	@Test
	public void projectCountTest(){//测试通过科目名查看用户名;
		
		Project project;
		String keyword = "郭刚";
		ProjectService projectService = (ProjectService) this.ctx.getBean("projectService");
		List<Project> list = projectService.findProjectByUser(12);
		
		for (Project project2 : list)  
			System.out.print(project2.getName() + "  ");
	}
	
	/**
	 * 统计某科目下，项目数量
	 */
	@Test
	public void countProMember(){
		
		Project project;
		String keyword = "唐荣2";
		ProjectService projectService = (ProjectService) this.ctx.getBean("projectService");
		int num = projectService.findProNum(keyword);
		
		System.out.println(num);
		
	}
	
	/**
	 * 依据 科目 查询所有科研项目
	 * 
	 */
	@Test
	public void countProjectNum(){
		
		Project project;
		String keyword = "计算机应用技术";
		ProjectService projectService = (ProjectService) this.ctx.getBean("projectService");
		List<Project> temp = projectService.countProNum(keyword);
		
		for (Project p : temp) {
			System.out.println(p.getName());
		}
		
	}
}
