package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Patent;

/**
 * 对会员专利表进行操作
 * @author Guojun
 * 2014-8-21
 */
public interface PatentDao {

	/**
	 * 添加专利对象
	 * @param patent 需要添加的专利对象
	 */
	public void addPatent(Patent patent);
	
	/**
	 * 删除专利对象
	 * @param patent 需要删除的专利对象
	 */
	public void deletePatent(Patent patent);
	
	/**
	 * 根据编号查找专利对象
	 * @param id
	 * @return Patent 对应编号的专利对象
	 */
	public Patent findPatent(int id);
	
	/**
	 * 根据会员的编号查找出该会员所拥有的所有专利对象
	 * @param userId 会员的编号
	 * @return List 包含对应会员的所有专利对象
	 */
	public List<Patent> findPatentByUser(int userId);
}
