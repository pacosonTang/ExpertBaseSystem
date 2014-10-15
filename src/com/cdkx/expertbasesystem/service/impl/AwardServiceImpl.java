package com.cdkx.expertbasesystem.service.impl;

import java.util.List;

import com.cdkx.expertbasesystem.dao.AwardDao;
import com.cdkx.expertbasesystem.domain.Award;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.AwardService;

/**
 * �Խ���ʵ������ʵ�֣��ṩ�Կ��н���ʵ�����ɾ�����
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
			throw new AppException("��ӿ��н�����Ϣʧ�ܣ�");
		}
	}

	@Override
	public void deleteAward(Award award) {
		try {
			awardDao.deleteAward(award);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ɾ��ID=��" + award.getId() + "���Ŀ��н�����Ϣʧ�ܣ�");
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
			throw new AppException("ɾ��ID=��" + id + "���Ŀ��гɹ�������Ϣʧ�ܣ�");
		}
	}

	@Override
	public Award findAward(int id) {
		try {
			return awardDao.findAward(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("����ID=��" + id + "���Ŀ��гɹ�������Ϣʧ�ܣ�");
		}
	}

	@Override
	public List<Award> findAwardByUser(int userId) {
		try {
			return awardDao.findAwardByUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("�����û���" + userId + "��ӵ�еĿ��гɹ�����ʧ�ܣ�");
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
			throw new AppException("ͳ�Ƹ��û�����������ʧ��");
		}
	}

	@Override
	public List<Award> countAwardNum(String sub) {
		
		String sql = "from Award p where p.user.major.name = '" + sub + "'";
		try {
			return  awardDao.findkey(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ͳ�Ƹ��û��� ����  ����ʧ��");
		}
	}

}
