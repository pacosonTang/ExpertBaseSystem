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
		//path��Ҫ�޸�
		String path = "d:\\";
		String name = "expertinfobase(" + time +").sql";
		try{
			//���е����ݿ�������Ҫ�޸�
			String execString = "mysqldump -u root -p911022 expertinfobase>" + path + name;
			Runtime.getRuntime().exec("cmd /c" + execString);
			System.out.println("�Զ���������ִ����..." + new Date());
		}catch(Exception e){
			System.out.println("�Զ���������ִ��ʧ�ܣ�����");
			e.printStackTrace();
		}
	}

}
