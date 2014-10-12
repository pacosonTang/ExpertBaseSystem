package com.cdkx.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest{
	
	protected  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-*.xml");

	public ApplicationContext getCtx() {
		return ctx;
	}
}
