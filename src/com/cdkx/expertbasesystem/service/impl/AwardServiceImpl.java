package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.AwardDao;
import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.AwardService;

/**
 * 对奖励实体服务的实现，提供对科研奖励实体的增删查服务
 * @author Guojun
 * 2014-8-24
 */
public class AwardServiceImpl implements AwardService {

	private AwardDao awardDao;
	
	@Override
	public void addAward(Award award) {
		try {
			awardDao.addAward(award);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("添加科研奖励信息失败！");
		}
	}

	@Override
	public void deleteAward(Award award) {
		try {
			awardDao.deleteAward(award);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("删除ID=【" + award.getId() + "】的科研奖励信息失败！");
		}
	}

	@Override
	public void deleteAwardById(int id) {
		try {
			Award award = awardDao.findAward(id);
			if(award != null)
				awardDao.deleteAward(award);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("删除ID=【" + id + "】的科研成果奖励信息失败！");
		}
	}

	@Override
	public Award findAward(int id) {
		try {
			return awardDao.findAward(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找ID=【" + id + "】的科研成果奖励信息失败！");
		}
	}

	@Override
	public List<Award> findAwardByUser(int userId) {
		try {
			return awardDao.findAwardByUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找用户【" + userId + "】拥有的科研成果奖励失败！");
		}
	}

	public void setAwardDao(AwardDao awardDao) {
		this.awardDao = awardDao;
	}
	
	@Override
	public int findAwardNum(String userId) {
		
		String sql = "select count(*) from Award where a.user.realname = '" + userId + "'";
		try {
			List list = awardDao.findkey(sql); 
			
			return Integer.parseInt(list.get(0).toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("统计该用户的论文数量失败");
		}
	}

	@Override
	public List<Award> countAwardNum(String sub) {
		
		String sql = "from Award p where p.user.major.name = '" + sub + "'";
		try {
			return  awardDao.findkey(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("统计该用户的 奖励  数量失败");
		}
	}

}
