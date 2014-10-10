package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Subject;

/**
 * ��ѧ��רҵʵ���ṩ����
 * @author Guojun
 * 2014-8-23
 */
public interface SubjectService {

	/**
	 * ���ѧ��רҵ��Ϣ
	 * @param subject ����ӵ�ѧ��רҵʵ��
	 */
	public void addSubject(Subject subject);
	
	/**
	 * ɾ��ָ����ѧ��רҵʵ��
	 * @param subject ��ɾ����ѧ��רҵʵ��
	 */
	public void deleteSubject(Subject subject);
	
	/**
	 * ɾ���ɱ��ָ����ѧ��רҵʵ��
	 * @param id ��ɾ����ѧ��רҵʵ��ı��
	 */
	public void deleteSubjectById(int id);
	
	/**
	 * �޸�ѧ��רҵ
	 * @param subject ���޸ĵ�ѧ��רҵʵ��
	 */
	public void modifySubject(Subject subject);
	
	/**
	 * ����ָ����ѧ��רҵʵ��
	 * @param id �����ҵ�ѧ��רҵ���
	 * @return Subject ��Ӧ��ѧ��רҵʵ��
	 */
	public Subject findSubject(int id);
	
	/**
	 * �ҵ�parent�����е���רҵ
	 * @return List ��רҵ��������רҵ
	 */
	public List<Subject> findSubjectsByParent(int id);
	
	/**
	 * ����һ��ѧ��ʵ��
	 * @return List ����һ��ѧ��ʵ��
	 */
	public List<Subject> findFirstSubjects();
	
	/**
	 * ��ѯ����ѧ��רҵ
	 * @return List ����ѧ��רҵ����
	 */
	public List<Subject> findAllSubjects();
}
