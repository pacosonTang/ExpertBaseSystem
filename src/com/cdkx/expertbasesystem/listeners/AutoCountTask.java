package com.cdkx.expertbasesystem.listeners;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import com.cdkx.expertbasesystem.domain.Subject;
import com.cdkx.expertbasesystem.service.SubjectService;
import com.cdkx.util.BaseTest;

public class AutoCountTask extends TimerTask {
	
	private BaseTest baseTest = new BaseTest();
	private SubjectService subjectService = (SubjectService)baseTest.getCtx().getBean("subjectService");
	
	@Override
	public void run() {
		try{
			//此处需要修改为需要执行的逻辑
			List<Subject> subjects = subjectService.findAllSubjects();
			System.out.println("自动生成统计表任务执行正常..." + new Date());
		}catch(Exception e){
			System.out.println("生成统计表任务执行失败!!!");
			e.printStackTrace();
		}
	}

}
