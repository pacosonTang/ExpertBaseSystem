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
			//�˴���Ҫ�޸�Ϊ��Ҫִ�е��߼�
			List<Subject> subjects = subjectService.findAllSubjects();
			System.out.println("�Զ�����ͳ�Ʊ�����ִ������..." + new Date());
		}catch(Exception e){
			System.out.println("����ͳ�Ʊ�����ִ��ʧ��!!!");
			e.printStackTrace();
		}
	}

}
