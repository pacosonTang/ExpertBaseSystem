package com.cdkx.expertbasesystem.service;

import java.util.List;

import com.cdkx.expertbasesystem.dto.BiPropertyDTO;
import com.cdkx.expertbasesystem.dto.TriPropertyDTO;

/**
 * 按学科对博士，会员，项目，国家级项目，省级项目， 市级项目， 专利，论文，奖励，一等奖，二等奖，三等奖进行统计
 * @author pacoson
 */
public interface DatacountService {
	
	/**传入kwyword 参数 统计会员，项目，专利，成果， 论文的 百分比。(int类型)
	 * @return 
	 */
	public List<BiPropertyDTO> member_ratio(String keyword);
	 
	/**
	 * 通过 查询各个科目 subname 的会员记录条目数量
	 * @param 一级科目名称， 项目集类型，itemType 如会员，项目， 奖励， 论文，专利。
	 * @return 项目集数量
	 */
	public int findItemSum(String subname,String itemType);
	
	/**
	 * 通过 查询各个科目 subname 的会员记录条目数量 【分页查询】
	 * @param 一级科目名称， 项目集类型，itemType 如会员，项目， 奖励， 论文，专利。
	 * @return 项目集数量
	 */
	
}
