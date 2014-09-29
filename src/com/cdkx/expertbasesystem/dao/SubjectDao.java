package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Subject;

/**
 * ��ѧ��רҵ�Ĳ���
 * @author Guojun
 * 2014-8-21
 */
public interface SubjectDao {

	/**
	 * ���һ��ѧ��רҵ
	 * @param subject Ҫ��ӵ�ѧ�Ʒ���
	 */
	public void addSubject(Subject subject);
	
	/**
	 * ɾ��һ��ѧ�Ʒ���
	 * @param subject Ҫɾ����ѧ�Ʒ���
	 */
	public void deleteSubject(Subject subject);
	
	/**
	 * �޸�һ��ѧ�Ʒ���
	 * @param subject ���޸ĵ�ѧ�Ʒ�����Ϣ
	 */
	public void modifySubject(Subject subject);
	
	/**
	 * �ҵ�idרҵ��������רҵ
	 * @return List ��רҵ��������רҵ
	 */
	public List<Subject> findSubjectsByParent(int id);
	
	/**
	 * ����ָ��ѧ�Ʒ���
	 * @param id ѧ�Ʒ���ı��
	 * @return Suject ��Ӧ��ѧ�Ʒ���
	 */
	public Subject findSubject(int id);
	
	/**
	 * �������е�һ��ѧ�Ʒ���
	 * @return List ���е�һ��ѧ��
	 */
	public List<Subject> findFirstSubjects();
}
