package com.cdkx.test;

import java.util.List;
import org.junit.Test;

import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.domain.Patent;
import com.cdkx.expertbasesystem.domain.Project;
import com.cdkx.expertbasesystem.domain.Thesis;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.domain.Userfour;
import com.cdkx.expertbasesystem.service.AwardService;
import com.cdkx.expertbasesystem.service.DatacountService;
import com.cdkx.expertbasesystem.service.PatentService;
import com.cdkx.expertbasesystem.service.ProjectService;
import com.cdkx.expertbasesystem.service.ThesisService;
import com.cdkx.expertbasesystem.service.UserService;
import com.cdkx.util.BaseTest;

public class DataCountTest  extends BaseTest{
	
	private List list;
	
	@Test
	public void findMemSumTest(){//测试查询奖励信息
		
		int id = 6;
		String s1 = "计算机应用技术",s2 = "mSum";
		DatacountService awardService = (DatacountService) this.ctx.getBean("datacountService");
		int sum = awardService.findItemSum(s1, s2);
		System.out.println(sum +  "sum");
	}
	
	@Test
	public void loadMemSumPage(){//分页查看用户
		
		int id = 6;
		String s1 = "计算机应用技术";
		UserService userService = (UserService) this.ctx.getBean("userService");
		List<Userfour> list = userService.countnum(s1, 1);
		for (Userfour o : list) {
			System.out.println(o.getaNum());
		}
	}
	
}
