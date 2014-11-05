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
	public List<Award> countAwardNum(String sub,int pageindex) {
		
		String sql = "from Award p where p.user.major.name = '" + sub + "'";
		return this.awardDao.loaditempage(sql, pageindex);
	}

	@Override
	public int countFiveNum(String sub, String datatype) {
		
		String sql = "select "+ datatype + " from Subject s where s.name = '" +  sub + "'";
		try {
			return Integer.parseInt(String.valueOf(convertData(this.awardDao.findkey(sql))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Object convertData(List list){//��list����ת��Ϊobject���͡���ͨ������sqlȡ����list��Ҫת��ΪSingle Object��ʱ��ʹ��
		
		if(list!=null)
			return list.get(0);
		return null;
	}

}
