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
		//ִ������Ϊ30��
		//�ӳ�10���������ӿ������ٶ�
		timer.schedule(new AutoBackUpTask(), 864000000L, 2592000000L);
		System.out.println("�Զ�����������ע��...");
	}

}
