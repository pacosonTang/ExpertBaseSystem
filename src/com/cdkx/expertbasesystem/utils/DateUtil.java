package com.cdkx.expertbasesystem.utils;

import java.util.Date;

/**
 * �������ɸ�����
 * @author GJ
 *
 */
public class DateUtil {

	/**
	 * ��ȡʱ�䲢��ʽ��Ϊ������ʾ��ʽ
	 * @return String
	 */
	public static String dateFormat(){
		//���ϵͳʱ��
		Date date = new Date();
		//��ʱ�䱾�ػ���ת��Ϊ�ַ���
		String dateToString = date.toLocaleString();
		//�����±��0~9�����ַ�����ֻ�������ڲ���
		return dateToString.substring(0, 9);
	}
}
