package com.cdkx.test;

import java.util.List;
import org.junit.Test;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.dto.BiPropertyDTO;
import com.cdkx.expertbasesystem.service.DatacountService;
import com.cdkx.util.BaseTest;

public class PercentageTest  extends BaseTest{
	
	private List list;
	
	/**
	 * 测试通过科目名查看用户名;
	 */
	
	@Test
	public void memberCountTest(){//测试通过科目名查看用户名;
		
		User user;
		String keyword = "projectNum";
		DatacountService datacountService = (DatacountService) this.ctx.getBean("datacountService");
		List<BiPropertyDTO> list = datacountService.member_ratio(keyword);
		
		for (BiPropertyDTO o : list)  
			System.out.print(o.getFirst_p() + "  " + o.getSecond_p());
	}
}
