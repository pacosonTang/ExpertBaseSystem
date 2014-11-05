package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Award;

/**
 * 对用户科研奖励实体提供服务
 * @author Guojun
 * 2014-8-23
 */
public interface AwardService {

	/**
	 * 添加奖励实体
	 * @param award 待添加的奖励实体
	 */
	public void addAward(Award award);
	
	/**
	 * 删除指定的科研奖励
	 * @param award 待删除的科研奖励实体 
	 */
	public void deleteAward(Award award);
	
	/**
	 * 通过指定的奖励编号删除奖励实体
	 * @param id 待删除的科研奖励实体的编号
	 */
	public void deleteAwardById(int id);
	
	/**
	 * 查找指定编号的科研奖励实体
	 * @param id 需找到的科研奖励实体的编号
	 * @return Award 对应的科研奖励实体
	 */
	public Award findAward(int id);
	
	/**
	 * 通过用户的编号找到该用户的所有奖励科研奖励实体
	 * @param userId 用户编号
	 * @return List 该用户的所有奖励实体集合
	 */
	public List<Award> findAwardByUser(int userId);
	
	/**
	 * 根据用户名(id)统计 奖励  数量
	 * @param userId 用户编号
	 * @return List 对应用户的 奖励  数量
	 */
	public int findAwardNum(String userId);
	
	/**
	 * 根据  学科科目  统计 奖励  
	 * @param sub 学科科目
	 * @return List 对应用户的 奖励  数量
	 */
	public List<Award> countAwardNum(String sub,int pageindex);
	
	/**
	 * 根据  学科科目  统计 条目数量，包括 five: member, award , project ,patent ,thesis.[为了方便，我写在了awardService 里面]
	 * @param sub 学科科目, numtype,mNum, aNum,proNum, patNum, tNum.
	 * @return    数量
	 */
	public int countFiveNum(String sub, String datatype);
	
	
}
