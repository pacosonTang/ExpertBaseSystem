package com.cdkx.expertbasesystem.listeners;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

public class AutoCountListener extends HttpServlet implements
		ServletContextListener {

	private final long PERIOD = 24 * 60 * 60 * 1000;
	
	Timer timer = new Timer();
	
	private static final long serialVersionUID = 1L;

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		timer.cancel();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		timer.scheduleAtFixedRate(new AutoCountTask(), this.getStartTime(), this.PERIOD);
		System.out.println("�Զ�ͳ�Ʊ�����������ע��...");
	}
	
	public Date getStartTime(){
		Calendar calendar = Calendar.getInstance();
		//���õ�һ������ִ������ʱ��Ϊ�賿4��
		calendar.set(Calendar.HOUR_OF_DAY, 4);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(calendar.SECOND, 0);
		
		Date date = calendar.getTime();
		
		//��һ��ִ��ʱ�������ǰʱ���Ѿ�������ʼʱ�䣬��ô�͸õڶ�����ִ��
		if(date.before(new Date())){
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			date = calendar.getTime();
		}
		return date;
	}

}
