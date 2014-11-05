package com.cdkx.expertbasesystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cdkx.expertbasesystem.dao.UserDao;
import com.cdkx.expertbasesystem.dto.BiPropertyDTO;
import com.cdkx.expertbasesystem.dto.TriPropertyDTO;
import com.cdkx.expertbasesystem.service.DatacountService;

public class DatacountServiceImpl implements DatacountService {

	private UserDao userDao;

	public DatacountServiceImpl() {
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<BiPropertyDTO> member_ratio(String keyword) {
		
		List<BiPropertyDTO> b_list = new ArrayList<BiPropertyDTO>(); 
		BiPropertyDTO bpd;
		String sql = "select subName," + keyword + " from Datacount dc order by " + keyword;
		Object temp_o[][] = new Object[1][2];
		List list = this.userDao.findKeyword(sql);

		if(list!=null)
			for (int i = 0; i < list.size(); i++) {
				temp_o[0] = (Object[])list.get(i);
				bpd = new BiPropertyDTO(String.valueOf(temp_o[0][0]),String.valueOf(temp_o[0][1]));//封装数据
				b_list.add(bpd);
			}
		return b_list;
	}
	
	@Override
	public int findItemSum(String subname, String itemType) {
		
//		int start = (curpage-1) * persum;
//		String sql = "select "+ itemType + " from Subject su where su.name = '" + subname + "' limit " + start + " , " + persum;
		String sql = "select "+ itemType + " from Subject su where su.name = '" + subname + "'";
		try {
			return Integer.parseInt(String.valueOf(convertData(this.userDao.findKeyword(sql))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Object convertData(List list){//将list类型转换为object类型。当通过传入sql取到的list需要转换为Object的时候使用
		
		if(list!=null)
			return list.get(0);
		return null;
	}
}
