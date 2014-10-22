package com.cdkx.expertbasesystem.listeners;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimerTask;

public class AutoBackUpTask extends TimerTask {

	@Override
	public void run() {
		Date backupDate = new Date();
		DateFormat dft = DateFormat.getDateInstance();
		String time = dft.format(backupDate);
		//path需要修改
		String path = "d:\\";
		String name = "expertinfobase(" + time +").sql";
		try{
			//其中的数据库密码需要修改
			String execString = "mysqldump -u root -p911022 expertinfobase>" + path + name;
			Runtime.getRuntime().exec("cmd /c" + execString);
			System.out.println("自动备份任务执行中..." + new Date());
		}catch(Exception e){
			System.out.println("自动备份任务执行失败！！！");
			e.printStackTrace();
		}
	}

}
