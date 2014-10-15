package com.cdkx.test;

import java.util.Date;
import java.util.List;
import org.junit.Test;

import com.cdkx.expertbasesystem.actions.SubjectAction;
import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.domain.Patent;
import com.cdkx.expertbasesystem.domain.Project;
import com.cdkx.expertbasesystem.domain.Subject;
import com.cdkx.expertbasesystem.domain.Thesis;
import com.cdkx.expertbasesystem.domain.User;
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
	 * 测试通过科目名查看用户的全部信息
	 */
	
	@Test
	public void totalCountTest(){//测试通过科目名查看用户名;
		
		User user;
		String keyword = "计算机应用技术";
		UserService userService = (UserService) this.ctx.getBean("userService");
		Date before = new Date();
		List<UserTotalDTO> list = userService.countnum(keyword);
		Date after = new Date();
		System.out.println("运行时间为:  " + (after.getTime() - before.getTime() ));
		for (UserTotalDTO u : list) {
			System.out.println("[名称为：] " + u.getUsername() + " 【奖励为】 " + u.getAward() + " 【专利数量为 】 " + u.getPatent() + " 【项目数量为 】 " + u.getProject() + " 【论文数量为 】 " + u.getThesis());
		}
	}
	
}
