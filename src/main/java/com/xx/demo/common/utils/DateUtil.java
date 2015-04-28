package com.xx.demo.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtil {

	private static final Log LOG = LogFactory.getLog(DateUtil.class);

	public static final String PATTERN_STANDARD = "yyyy-MM-dd HH:mm:ss";

	public static final String PATTERN_STANDARDP_NOSS = "yyyy-MM-dd HH:mm";

	public static final String PATTERN_DATE = "yyyy-MM-dd";

	public static final String PATTERN_DATE_NUM = "yyyyMMdd";
	
	public static final long ONE_MINUTE_IN_MILLI_SECOND = 60 * 1000;

	public static final long ONE_HOUR_IN_MILLI_SECOND = 3600 * 1000;

	public static final long ONE_DAY_IN_MILLI_SECOND = ONE_HOUR_IN_MILLI_SECOND * 24;

	public static String date2String(Date date) {
		return date2String(date, PATTERN_STANDARD);
	}

	public static String date2String(Date date, String pattern) {
		String result = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			result = sdf.format(date);
		} catch (Exception e) {
			LOG.info("date=[" + date + "] to pattern=[" + pattern + "] error,msg=[" + e.getMessage() + "]");
		}
		return result;
	}

	public static Date string2Date(String dateStr, String formatPattern) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(formatPattern);
			return format.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date addDay(Date date, int days) {
		return addHour(date, 24 * days);
	}

	public static Date addHour(Date date, int hours) {
		Date resultDate = new Date();
		if (date == null) {
			return resultDate;
		}
		long interval = ONE_HOUR_IN_MILLI_SECOND * hours;
		resultDate.setTime(date.getTime() + interval);

		return resultDate;
	}

	/**
	 * 五分钟取整
	 * 
	 * @param date
	 * @return
	 */
	public static Date truncate5Minute(Date date) {
		return new Date(date.getTime() / 300000 * 300000);
	}

	/**
	 * 一天取整
	 * 
	 * @param date
	 * @return
	 */
	public static Date truncate1Day(Date date) {
		return org.apache.commons.lang.time.DateUtils.truncate(date, Calendar.DATE);
	}

	 /**
	   * 取得某天相加(减)後的那一天
	   * 
	   * @param date
	   * @param num(可正可负)
	   * @return
	   */
	  public static Date getAnotherDate(Date date, int num) {
	      Calendar c = Calendar.getInstance();
	      c.setTime(date);
	      c.add(Calendar.DAY_OF_YEAR, num);
	      return c.getTime();
	  }

	  /**
	   * 取得某月的的最后一天
	   * 
	   * @param year
	   * @param month
	   * @return
	   */
	  public static Date getLastDayOfMonth(int year, int month) {
	      Calendar cal = Calendar.getInstance();
	      cal.set(Calendar.YEAR, year);// 年
	      cal.set(Calendar.MONTH, month - 1);// 月，因为Calendar里的月是从0开始，所以要减1
	      cal.set(Calendar.DATE, 1);// 日，设为一号
	      cal.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一号
	      cal.add(Calendar.DATE, -1);// 下一个月减一为本月最后一天
	      return cal.getTime();// 获得月末是几号
	  }

	  /**
	   * 取得某天是一年中的多少周
	   * 
	   * @param date
	   * @return
	   */
	  public static int getWeekOfYear(Date date) {
	      Calendar c = new GregorianCalendar();
	      c.setFirstDayOfWeek(Calendar.MONDAY);
	      c.setMinimalDaysInFirstWeek(7);
	      c.setTime(date);
	      return c.get(Calendar.WEEK_OF_YEAR);
	  }

	  /**
	   * 取得某天所在周的第一天
	   * 
	   * @param date
	   * @return
	   */
	  public static Date getFirstDayOfWeek(Date date) {
	      Calendar c = new GregorianCalendar();
	      c.setFirstDayOfWeek(Calendar.MONDAY);
	      c.setTime(date);
	      c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
	      return c.getTime();
	  }

	  /**
	   * 取得某天所在周的最后一天
	   * 
	   * @param date
	   * @return
	   */
	  public static Date getLastDayOfWeek(Date date) {
	      Calendar c = new GregorianCalendar();
	      c.setFirstDayOfWeek(Calendar.MONDAY);
	      c.setTime(date);
	      c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
	      return c.getTime();
	  }

	  /**
	   * 取得某一年共有多少周
	   * 
	   * @param year
	   * @return
	   */
	  public static int getMaxWeekNumOfYear(int year) {
	      Calendar c = new GregorianCalendar();
	      c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
	      return getWeekOfYear(c.getTime());
	  }
	  
	  /**
	   * 取得某年某周的第一天
	   * 对于交叉:2008-12-29到2009-01-04属于2008年的最后一周,2009-01-05为2009年第一周的第一天
	   * @param year
	   * @param week
	   * @return
	   */
	  public static Date getFirstDayOfWeek(int year, int week) {
	      Calendar calFirst = Calendar.getInstance();
	      calFirst.set(year, 0, 7);
	      Date firstDate = getFirstDayOfWeek(calFirst.getTime());

	      Calendar firstDateCal = Calendar.getInstance();
	      firstDateCal.setTime(firstDate);

	      Calendar c = new GregorianCalendar();
	      c.set(Calendar.YEAR, year);
	      c.set(Calendar.MONTH, Calendar.JANUARY);
	      c.set(Calendar.DATE, firstDateCal.get(Calendar.DATE));

	      Calendar cal = (GregorianCalendar) c.clone();
	      cal.add(Calendar.DATE, (week - 1) * 7);
	      firstDate = getFirstDayOfWeek(cal.getTime());

	      return firstDate;
	  }

	  /**
	   * 取得某年某周的最后一天
	   * 对于交叉:2008-12-29到2009-01-04属于2008年的最后一周,2009-01-04为2008年最后一周的最后一天
	   * @param year
	   * @param week
	   * @return
	   */
	  public static Date getLastDayOfWeek(int year, int week) {
	      Calendar calLast = Calendar.getInstance();
	      calLast.set(year, 0, 7);
	      Date firstDate = getLastDayOfWeek(calLast.getTime());

	      Calendar firstDateCal = Calendar.getInstance();
	      firstDateCal.setTime(firstDate);

	      Calendar c = new GregorianCalendar();
	      c.set(Calendar.YEAR, year);
	      c.set(Calendar.MONTH, Calendar.JANUARY);
	      c.set(Calendar.DATE, firstDateCal.get(Calendar.DATE));

	      Calendar cal = (GregorianCalendar) c.clone();
	      cal.add(Calendar.DATE, (week - 1) * 7);
	      Date lastDate = getLastDayOfWeek(cal.getTime());
	      
	      return lastDate;
	  }
	  
	public static String getFullTimeStamp() {
		return new SimpleDateFormat(PATTERN_STANDARD).format(new Date());
	}
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(DateUtil.getFullTimeStamp());
	}
}
