package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Patent;

/**
 * 对专利实体提供服务
 * @author Guojun
 * 2014-8-23
 */
public interface PatentService {

	/**
	 * 添加专利实体
	 * @param patent 待添加的专利实体
	 */
	public void addPatent(Patent patent);
	
	/**
	 * 删除指定的专利实体
	 * @param patent 待删除的专利实体
	 */
	public void deletePatent(Patent patent);
	
	/**
	 * 删除指定编号的专利实体
	 * @param id 待删除专利实体的编号
	 */
	public void deletePatentById(int id);
	
	/**
	 * 查找专利实体
	 * @param id 待查找的专利编号
	 * @return List 相应的专利实体
	 */
	public Patent findPatent(int id);
	
	/**
	 * 根据用户编号查找该用户的所有专利
	 * @param userId 用户编号
	 * @return List 相应用户所有的专利
	 */
	public List<Patent> findPatentByUser(int userId);
	
	//以下为统计方法
	/**
	 * 根据用户名(id)统计 专利  数量
	 * @param userId 用户编号
	 * @return List 对应用户的 专利 数量
	 */
	public int findPatentNum(String userId);
	
	/**
	 * 根据 学科科目 统计 专利  数量
	 * @param sub 学科名称　
	 * @return List 对应用户的 专利 数量
	 */
	public List<Patent> countPatentNum(String sub,int pageindex);
	
	
}
