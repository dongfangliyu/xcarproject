package com.fintecher.sims.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Author: jwdstef
 * @Description: 日期工具类
 * @Date 2017/6/2
 */
public class ZWDateUtil {

    /**
     * 获取当前日期
     * @return
     */
    public static LocalDate getNowLocalDate(){
        return LocalDate.now();
    }

    /**
     * 获取当前时间
     * @return
     */
    public static LocalDateTime getNowLocalDateTime(){
        return LocalDateTime.now();
    }

    /**
     * 获取指定的日期
     * @param year
     * @param month
     * @param dayOfMonth
     * @return
     */
    public static LocalDate getDefinedLocalDate(int year,int month,int dayOfMonth){
       return LocalDate.of(year,month,dayOfMonth);
    }

    /**
     * 获取当前日期 Date 类型
     * @return
     */
    public static Date getNowDate(){
        LocalDate nowLocalDate=getNowLocalDate();
        ZoneId zone=ZoneId.systemDefault();
        Instant instant = nowLocalDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取当前时间 Date类型
     * @return
     */
    public static Date getNowDateTime(){
        LocalDateTime nowLocalDateTime=getNowLocalDateTime();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = nowLocalDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 日期格式化
     * @param date
     * @param format
     * @return
     */
    public static String fomratterDate(Date date,String format){
        if (date == null)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format == null ? "yyyy-MM-dd HH:mm:ss" : format);
        return sdf.format(date);
    }

    /**
     * 获取当前日期和时间
     * @return
     */
    public static String getDateTime(){
        return fomratterDate(new Date(),"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当前日期
     * @return
     */
    public static String getDate(){
        return fomratterDate(new Date(),"yyyy-MM-dd");
    }

    /**
     * 获取当前年月
     * @return
     */
    public static String getYMDate(){return fomratterDate(new Date(),"yyyyMM");}


    /**
     * 获取当前年月日
     * @return
     */
    public static String getYMDDate(){return fomratterDate(new Date(),"yyyyMMdd");}

    /**
     * 转换日期 20080101 -> Date
     * @param dateStr 日期字符串
     * @param format 日期的字符串格式如yyyyMMdd
     * @return Date 日期
     * @throws ParseException 日期解析异常
     */
    public static Date getUtilDate(String dateStr, String format) throws ParseException {
        if (dateStr==null || dateStr.length()==0)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format == null ? "yyyy-MM-dd HH:mm:ss" : format);
        return sdf.parse(dateStr);
    }

    /**
     * 转换日期 20080101 -> Date
     * @param dateStr 日期字符串
     * @return Date 日期
     * @throws ParseException 日期解析异常
     */
    public static Date getFormatDate(String dateStr) throws ParseException {
        if (dateStr==null || dateStr.length()==0)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(dateStr);
    }

    /**
     * 转换日期 20080101111111 -> DateTime
     * @param dateStr 日期字符串
     * @return Date 日期
     * @throws ParseException 日期解析异常
     */
    public static Date getFormatDateTime(String dateStr) throws ParseException {
        if (dateStr==null || dateStr.length()==0)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(dateStr);
    }

    public static void main(String[] args) {
        System.out.println(getYMDate());
    }

}
