package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Institution;

/**
 * ��Э��ʵ���ṩ����
 * @author Guojun
 * 2014-8-23
 */
public interface InstitutionService {

	/**
	 * ���һ��Э��ʵ��
	 * @param institution ����ӵ�Э��ʵ��
	 */
	public void addInstitution(Institution institution);
	
	/**
	 * ɾ��ָ����Э��ʵ��
	 * @param institution ��ɾ����Э��ʵ��
	 */
	public void deleteInstitution(Institution institution);
	
	/**
	 * ɾ��ָ��id��Э��ʵ��
	 * @param id ��ɾ��Э��ʵ��ı��
	 */
	public void deleteInstitutionById(int id);
	
	/**
	 * ����Э��ʵ��
	 * @param id ������Э��ʵ��ı��
	 * @return Institution ��Ӧ��Э��ʵ��
	 */
	public Institution findInstitutions(int id);
	
	/**
	 * �������е�Э��ʵ��
	 * @return List ��������Э��ʵ��ļ���
	 */
	public List<Institution> findInstitutions();
}
