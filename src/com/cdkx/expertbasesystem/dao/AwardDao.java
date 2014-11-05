package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Award;

/**
 * 对会员科技成果奖励表的操作
 * @author Guojun
 * 2014-8-21
 */
public interface AwardDao {

	/**
	 * 根据用户id查询该用户的奖励
	 * @param userid
	 * @return List
	 */
	public List<Award> findAwardByUser(int userid);
	
	/**
	 * 根据id查询奖励信息
	 * @param id
	 * @return Award
	 */
	public Award findAward(int awardid);
	
	/**
	 * 添加奖励信息
	 * @param award
	 */
	public void addAward(Award award);
	
	/**
	 * 删除会员的奖励信息
	 * @param award Award对象，表示会员的一个科技成果奖励
	 */
	public void deleteAward(Award award);
	
	/**
	 * 修改科研奖励信息
	 * @param award 修改好的奖励信息
	 */
	public void modifyAward(Award award);
	
	public List findkey(String sql);
	
	/**
	 * 分页查询出项目
	 * @param t_sql , 传入的sql语句，
	 * @param pageindex， 当前页面
	 * @return
	 */
	public List<Award> loaditempage(String t_sql, int pageindex);
	
}
