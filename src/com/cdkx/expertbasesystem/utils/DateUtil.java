package com.cdkx.expertbasesystem.utils;

import java.util.Date;

/**
 * 日期生成辅助类
 * @author GJ
 *
 */
public class DateUtil {

	/**
	 * 获取时间并格式化为本地显示方式
	 * @return String
	 */
	public static String dateFormat(){
		//获得系统时间
		Date date = new Date();
		//将时间本地化并转化为字符串
		String dateToString = date.toLocaleString();
		//返回下标从0~9的子字符串，只保留日期部分
		return dateToString.substring(0, 9);
	}
}
