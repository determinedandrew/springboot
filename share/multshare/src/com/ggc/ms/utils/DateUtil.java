package com.ggc.ms.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	//工具类的构造方法私用的
	private DateUtil() {
	}
	
	public static String getSystemTime(){
		return sdf.format(new Date());
	}
}
