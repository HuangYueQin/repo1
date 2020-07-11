package com.maternalBabyManage.util;

public class StringUtil {
	
	private StringUtil() {
		
	};
	public static boolean  equals(String from ,String to) {
		
		return from.equalsIgnoreCase(to);
	}
	public static boolean isEmpty(String str) {
		if("".equalsIgnoreCase(str)) {
			return true;
		}else {
			return false;
		}
	}
	public static int toInt(String str) {
		
		return Integer.parseInt(str);
	}
}
