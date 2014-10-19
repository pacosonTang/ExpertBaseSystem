package com.cdkx.expertbasesystem.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cdkx.expertbasesystem.dao.UserDao;
import com.cdkx.expertbasesystem.domain.ConditionDTO;
import com.cdkx.expertbasesystem.domain.User;
import com.cdkx.expertbasesystem.dto.UserChartDTO;
import com.cdkx.expertbasesystem.dto.UserTotalDTO;
import com.cdkx.expertbasesystem.exception.AppException;
import com.cdkx.expertbasesystem.service.UserService;

/**
 * ���û�����ӿڵ�ʵ�֣��ṩ���û�ʵ�����ɾ�Ĳ�
 * @author Guojun
 * 2014-8-23
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Override
	public List<User> login(User user) {
		try {
			return userDao.login(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ�û���Ϊ��" + user.getUsername() +"��ʧ�ܣ�");
		}
	}

	@Override
	public User findUser(int id) {
		try {
			return userDao.findUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException();
		}
	}

	@Override
	public void addUser(User user) {
		try {
			userDao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException();
		}
	}

	@Override
	public void modifyUser(User user) {
		try {
			userDao.modifyUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException();
		}
	}

	@Override
	public void deleteUser(User user) {
		try {
			userDao.deleteUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException();
		}
	}

	@Override
	public void deleteUser(int id) {
		try {
			User user = userDao.findUserById(id);
			if(user != null)
				userDao.deleteUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException();
		}
	}

	public void setUserDao(UserDao userDao) {
		try {
			this.userDao = userDao;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException();
		}
	}

	@Override
	public List<User> findMembers() {
		try {
			return userDao.findMembers();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("�������л�Ա��Ϣʧ�ܣ�");
		}
	}

	@Override
	public List<User> findLeaders() {
		try {
			return userDao.findLeaders();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("���������쵼��Ϣʧ�ܣ�");
		}
	}

	@Override
	public List<User> findServers() {
		try {
			return userDao.findServers();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("���������г���������Ա��Ϣʧ�ܣ�");
		}
	}

	@Override
	public List<Object[]> statisticMembers(String countCondition) {
		//if(countCondition.equals(""))
		try {
			return userDao.statisticMembers(countCondition);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ͳ���û�ʧ�ܣ�");
		}
	}

	@Override
	public List<User> findUsersByUsername(String username) {
		try {
			return userDao.findUsersByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ�û���=��" + username + "�����û�ʧ�ܣ�");
		}
	}

	@Override
	public List<User> searchMember(ConditionDTO conditionDTO) {
		String hql = "from User u left join fetch u.institution left join fetch u.degree left join fetch u.education where u.level=3";
		if(conditionDTO.getDegree() != 0){
			hql += "and u.degree.id=" + conditionDTO.getDegree();
		}
		if(conditionDTO.getEducation() != 0){
			hql += "and u.education.id=" + conditionDTO.getEducation();
		}
		if(conditionDTO.getInstitution() != 0){
			hql += "and u.institution.id=" + conditionDTO.getInstitution();
		}
		if(conditionDTO.getCurrentMajor() !=null && !"".equals(conditionDTO.getCurrentMajor())){
			hql += "and u.currentMajor like '%" + conditionDTO.getCurrentMajor() + "%'";
		}
		if(conditionDTO.getAdept() != null && !"".equals(conditionDTO.getAdept())){
			hql += "and u.adept like '%" + conditionDTO.getAdept() + "%'";
		}
		if(conditionDTO.getTitle() != null && !"".equals(conditionDTO.getTitle())){
			hql += "and u.title like '%" + conditionDTO.getTitle() + "%'";
		}
		return userDao.searchMember(hql);
	}

	@Override
	public List<User> findUsers(String username) {

		String sql = "from User u where u.realname = '" + username + "'";
		return userDao.findKeyword(sql);
	}

	@Override
	public List<String> findUserBySub(String sub) {
		
		String sql = "select u.realname from User u where u.major.name = '" + sub + "'";
		return userDao.findKeyword(sql);
	}

	@Override
	public List<UserTotalDTO> countnum(String sub) {

		UserTotalDTO userTotal;
		List<UserTotalDTO> userCountList = new ArrayList<UserTotalDTO>();
		List list = null;
		String name;
		String sql = "select u.id , u.realname from User u where u.major.name = '" + sub +"'";
		 
		Object temp_object[][] = new Object[1][2];
		list = userDao.findKeyword(sql);
		if(list != null)
			for (int i = 0; i < list.size(); i++) {
				userTotal = new UserTotalDTO();
				temp_object[0] = (Object[]) list.get(i);
				sql = "select count(*) from Award a where a.user.id = '" + String.valueOf(temp_object[0][0]) + "'";
				userTotal.setAward(String.valueOf(userDao.findKeyword(sql).get(0)));
				sql = "select count(*) from Project p where p.user.id = '" + String.valueOf(temp_object[0][0]) + "'";
				userTotal.setProject(String.valueOf(userDao.findKeyword(sql).get(0)));
				sql = "select count(*) from Thesis t where t.user.id = '" + String.valueOf(temp_object[0][0]) + "'";
				userTotal.setThesis(String.valueOf(userDao.findKeyword(sql).get(0)));
				sql = "select count(*) from Patent p where p.user.id = '" + String.valueOf(temp_object[0][0]) + "'";
				userTotal.setPatent(String.valueOf(userDao.findKeyword(sql).get(0)));
				userTotal.setUsername(String.valueOf(temp_object[0][1]));
				userCountList.add(userTotal);
			}
		return userCountList;
	}

	@Override
	public List<UserChartDTO> user_chart_dto() {
		
		
		String sql = "select s.name from Subject s where s.parent=null";
		List<String> firstsub = this.userDao.findKeyword(sql);
		UserChartDTO ucd;
		List<UserChartDTO> ucd_list = new ArrayList<UserChartDTO>();
		
		for(String s:firstsub){
			
			int usernum,phd;
			ucd = new UserChartDTO();
			sql = "select count(*) from User u where u.major.parent.parent.name = '" + s + "'";
			usernum = user_chart_dto_1(sql);//ͳ��ĳѧ���µĻ�Ա����
			
			sql = "select count(*) from User u where u.major.parent.parent.name = '" + s + "' and u.degree.name = '��ʿ'";//��ѯ���в�ʿѧλ���û�����
			phd = user_chart_dto_1(sql);// ͳ��ĳѧ���µĲ�ʿ��Ա����
			ucd = new UserChartDTO(s, phd, usernum);
			ucd_list.add(ucd);
		}
		 return ucd_list;
	}
	
	public int user_chart_dto_1(String sql){//��user_chart_dto()�г�ȡ����
		
		List temp = this.userDao.findKeyword(sql);//ͳ��ĳһ��ѧ���µ��û�����
		try {
			if(temp!=null)
				return Integer.valueOf(String.valueOf(temp.get(0)));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯʧ��  user_chart_dto");
		}
		return 0;
	}

	@Override
	public List findUserBySub_count(String sub) {
		
		String sql = "select u.id , u.realname from User u where u.major.name = '" + sub + "'";
		return userDao.findKeyword(sql);
	}
}
