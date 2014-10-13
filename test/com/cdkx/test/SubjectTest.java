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

public class SubjectTest  extends BaseTest{
	
	private List list;
	
	@Test
	public void findFirstSubjectTest(){//���Բ�ѯ�û���Ϣ
		
		Subject subject;
		String name = "�����";
		SubjectService subjectService = (SubjectService) this.ctx.getBean("subjectService");
		List<Subject> list = subjectService.findFirstSubjects();
		
		for (Subject subject2 : list)  
			System.out.print(subject2.getName() + "  ");
	}
	
	@Test
	public void findSubjectByParentTest(){//���Բ�ѯ�û���Ϣ
		
		Subject subject;
		String name = "��ѧ";
		SubjectService subjectService = (SubjectService) this.ctx.getBean("subjectService");
		List<String> list = subjectService.subjectByParent(name);
		
		System.out.println("size = " + list.size());
		for (String subject2 : list) { 
			System.out.println("["+ list.indexOf(subject2) + "] = " + subject2 + "  ");
			subjectService = (SubjectService) this.ctx.getBean("subjectService");
			List<String> list2 = subjectService.subjectByParent(subject2);
			for (String subject3 : list2)  
				System.out.print("[" + subject3 + " ] ");	
			System.out.println();		
		}
	}
	
	@Test
	public void findSubListTest(){//���Բ�ѯ�û���Ϣ
		
		Subject subject;
		String name = "�����";
		SubjectAction subjectAction = (SubjectAction) 
		this.ctx.getBean("subjectAction");
		String string = subjectAction.findSubject();
	}
}