package com.newweb.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";

    /**
     * 获取距当前日期上一个月的日期
     * 返回格式：yyyy-MM-dd
     *
     * @return
     */
    public static String getLastMonthDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);    // 得到前一天
        calendar.add(Calendar.MONTH, -1);   // 得到前一个月
        return formatDate(calendar.getTime());
    }

    /**
     * 进行日期的减法计算
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int dateSub(String startDate, String endDate) {
        Date sd = getDate(startDate);
        Date ed = getDate(endDate);
        long time = ed.getTime() - sd.getTime();
        return (int) (time / 1000 / 60 / 60 / 24);
    }

    /**
     * 将‘yyyy-MM-dd’的字符串日期转化为Date对象
     *
     * @param date
     * @return
     */
    public static Date getDate(String date) {
        String[] dateParts = date.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);
        return new Date(year - 1900, month - 1, day);
    }

    /**
     * 返回当前日期的yyyy-MM-dd的日期字符串格式
     *
     * @return
     */
    public static String getLocationCurrentDate() {
        return new SimpleDateFormat(DATE_FORMAT).format(new Date());
    }

    /**
     * 返回当前日期的HH:mm:ss的时间字符串格式
     *
     * @return
     */
    public static String getLocationCurrentTime() {
        return new SimpleDateFormat(TIME_FORMAT).format(new Date());
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    private static String formatDate(Date date) {
        return new SimpleDateFormat(DATE_FORMAT).format(date);
    }
}
