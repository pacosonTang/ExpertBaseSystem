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
				bpd = new BiPropertyDTO(String.valueOf(temp_o[0][0]),String.valueOf(temp_o[0][1]));//·â×°Êý¾Ý
				b_list.add(bpd);
			}
		return b_list;
	}
}
