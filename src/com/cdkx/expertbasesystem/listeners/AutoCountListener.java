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
		System.out.println("自动统计表生成任务已注册...");
	}
	
	public Date getStartTime(){
		Calendar calendar = Calendar.getInstance();
		//设置第一次启动执行任务时间为凌晨4点
		calendar.set(Calendar.HOUR_OF_DAY, 4);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(calendar.SECOND, 0);
		
		Date date = calendar.getTime();
		
		//第一次执行时，如果当前时间已经过了起始时间，那么就该第二天在执行
		if(date.before(new Date())){
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			date = calendar.getTime();
		}
		return date;
	}

}
