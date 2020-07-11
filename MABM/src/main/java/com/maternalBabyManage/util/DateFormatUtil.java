package com.maternalBabyManage.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	
	private DateFormatUtil() {
		
	}
	public static String getFormatDate(Date date) throws Exception{
		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		String currentTime =  formatDate.format(date);       //将时间转换为标准字符串格式
		
		return currentTime;                
	}
	
	public static Date toDate(String Date) throws Exception{
		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		return formatDate.parse(Date);
		
	}

}
