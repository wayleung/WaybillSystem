package com.way.waybillsystem.util;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	
	
	/**
	 * 根据格式返回一个现在的时间
	 * @param format
	 * @return
	 */
	public static String getNow(String format){
		if (format == null || "".equals(format))
			format = "yyyy-MM-dd HH:mm:ss";
		Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String now_string  = simpleDateFormat.format(now);
		return now_string;
	}
	
	
	
	
	public static Date dateFormat(Date date,String pattern){
		if (date == null)
			return null;

		if (pattern == null || "".equals(pattern))
			pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat  = new SimpleDateFormat(pattern);
		String format = simpleDateFormat.format(date);
		Date newdate=null;
		try {
			newdate = simpleDateFormat.parse(format);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newdate;
	}
	
	
	
	public static String dateToString(Date date,String pattern){
		if (date == null)
			return "";

		if (pattern == null || "".equals(pattern))
			pattern = "yyyy-MM-dd HH:mm:ss";

		return new SimpleDateFormat(pattern).format(date);
	}
	
	
	public static Date stringToDate(String date_string,String pattern){
		if (date_string == null||date_string.equals(""))
			return null;

		if (pattern == null || "".equals(pattern))
			pattern = "yyyy-MM-dd HH:mm:ss";

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	        Date date = null;
	        try {
	            date = simpleDateFormat.parse(date_string);
	        } catch (Exception e) {
	        }
	        return date;
	}
	
	
	
	/**
	 * 时间转时间戳方法 yyyy-MM-dd HH:mm:ss.SSS
	 * @param time
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	  public static String dateToStamp(String time,String format) throws ParseException{
			if (format == null || "".equals(format))
				format = "yyyy-MM-dd HH:mm:ss";
		  	String res;
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
	        Date date = simpleDateFormat.parse(time);
	        long ts = date.getTime();
	        res = String.valueOf(ts);
	        return res;
	    }
	
	  /**
	   * 将时间戳转换为时间 yyyy-MM-dd HH:mm:ss.SSS
	   * @param timestamp
	   * @param format
	   * @return
	   */
	  public static String stampToDate(String timestamp,String format){
			if (format == null || "".equals(format))
				format = "yyyy-MM-dd HH:mm:ss";
		  	String res;
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
	        try {
	        	long lt = new Long(timestamp);
		        Date date = new Date(lt);
		        res = simpleDateFormat.format(date);
		        return res;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				res = timestamp;
				return res;
			}
	        

	    }
}
