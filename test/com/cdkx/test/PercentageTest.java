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
	 * ����ͨ����Ŀ���鿴�û���;
	 */
	
	@Test
	public void memberCountTest(){//����ͨ����Ŀ���鿴�û���;
		
		User user;
		String keyword = "projectNum";
		DatacountService datacountService = (DatacountService) this.ctx.getBean("datacountService");
		List<BiPropertyDTO> list = datacountService.member_ratio(keyword);
		
		for (BiPropertyDTO o : list)  
			System.out.print(o.getFirst_p() + "  " + o.getSecond_p());
	}
}
