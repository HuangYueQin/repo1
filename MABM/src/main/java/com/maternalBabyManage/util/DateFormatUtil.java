package com.maternalBabyManage.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	
	private DateFormatUtil() {
		
	}
	public static String getFormatDate(Date date) throws Exception{
		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		String currentTime =  formatDate.format(date);       //��ʱ��ת��Ϊ��׼�ַ�����ʽ
		
		return currentTime;                
	}
	
	public static Date toDate(String Date) throws Exception{
		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		return formatDate.parse(Date);
		
	}

}
