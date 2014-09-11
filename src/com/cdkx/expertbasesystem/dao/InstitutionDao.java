package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Institution;

/**
 * ��Э����Ϣ���в���
 * @author Guojun
 * 2014-8-21
 */
public interface InstitutionDao {
	
	/**
	 * ���һ��Э��
	 * @param institution
	 */
	public void addInstitution(Institution institution);
	
	/**
	 * ����Э��Ķ���ɾ��һ��Э��
	 * @param institution
	 */
	public void deleteInstitution(Institution institution);
	
	/**
	 * �������е�Э����Ϣ
	 * @return List ��������Э����Ϣ
	 */
	public List<Institution> findInstitutions();
	
	/**
	 * 
	 * @param id Ҫ����Э���ID
	 * @return Institution ����ID���ҵ���Э�����
	 */
	public Institution findInstitutionId(int id);
}
