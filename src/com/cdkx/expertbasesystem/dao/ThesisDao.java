package com.cdkx.expertbasesystem.dao;

import java.util.List;

import com.cdkx.expertbasesystem.domain.Thesis;

/**
 * 对用户发表的论文进行操作
 * @author Guojun
 * 2014-8-21
 */
public interface ThesisDao {

	/**
	 * 添加一个论文类
	 * @param thesis 需要添加的论文类
	 */
	public void addThesis(Thesis thesis);
	
	/**
	 * 删除一个论文类
	 * @param thesis 需要删除的论文类
	 */
	public void deleteThesis(Thesis thesis);
	
	/**
	 * 修改论文信息
	 * @param thesis 已修改的论文类
	 */
	public void modifyThesis(Thesis thesis);
	
	/**
	 * 根据会员的编号查找该会员所拥有的论文
	 * @param userid 会员编号
	 * @return List 包含对应会员所有的论文
	 */
	public List<Thesis> findThesisByUser(int userid);
	
	/**
	 * 查找对应编号的论文
	 * @param id
	 * @return Thesis 对应编号的论文
	 */
	public Thesis findThesis(int id);
}
