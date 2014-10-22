package com.cdkx.expertbasesystem.listeners;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

public class AutoBackUpListener extends HttpServlet implements
		ServletContextListener {

	Timer timer = new Timer();
	
	private static final long serialVersionUID = 1L;

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		timer.cancel();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//执行周期为30天
		//延迟10天启动，加快启动速度
		timer.schedule(new AutoBackUpTask(), 864000000L, 2592000000L);
		System.out.println("自动备份任务已注册...");
	}

}
