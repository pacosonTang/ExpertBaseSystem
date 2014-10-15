package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Thesis;

/**
 * 对论文实体提供服务
 * @author Guojun
 * 2014-8-23
 */
public interface ThesisService {

	/**
	 * 添加论文实体
	 * @param thesis 待添加的论文实体
	 */
	public void addThesis(Thesis thesis);
	
	/**
	 * 删除指定的论文实体
	 * @param thesis 待删除的论文实体
	 */
	public void deleteThesis(Thesis thesis);
	
	/**
	 * 删除用论文编号指定的论文实体
	 * @param id 论文编号
	 */
	public void deleteThesisById(int id);
	
	/**
	 * 查找论文
	 * @param id 待查找的论文实体的编号
	 * @return
	 */
	public Thesis findThesis(int id);
	
	/**
	 * 通过用户编号来查找该用户所拥有的论文实体
	 * @param userId 用户编号
	 * @return List 对应用户所拥有的论文实体
	 */
	public List<Thesis> findThesisByUser(int userId);
	
	//【以下方法用于统计】
	/**
	 * 通过用户编号来查找该用户所拥有的论文实体
	 * @param userId 用户编号
	 * @return List 对应用户所拥有的论文实体
	 */
	public List<Thesis> countThesis(int userId);
	
	/**
	 * 根据用户名(id)统计 论文  数量
	 * @param userId 用户编号
	 * @return List 对应用户的论文数量
	 */
	public int findThesisNum(String userId);
	
	/**
	 * 查询所有论文
	 * @param sub 学科科目
	 * @return List 对应用户的论文数量
	 */
	public List<Thesis> countThesisNum(String sub);
	
}
