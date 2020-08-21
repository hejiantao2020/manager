package com.athjt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/3/14.
 */
public class DateUtil {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String dateFormat(Date date) {
        return new SimpleDateFormat(DATE_FORMAT).format(date);
    }

    /**
     * 根据传入的时间字符串，把它转换成"yyyy-MM-dd HH:mm:ss"格式或者"yyyy-MM-dd"的字符串 <br>
     * 先把该时间字符串按照"yyyy-MM-dd HH:mm:ss"格式转换，如果为空；再按照"yyyy-MM-dd"格式进行转换
     * @param dateStr 时间字符串
     * @return 日期对象
     */
    public static Date parseDateOrNull(String dateStr) {
        Date date = null;
        try {
            date = new SimpleDateFormat(STANDARD_FORMAT).parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (date == null) {
            try {
                date = new SimpleDateFormat(DATE_FORMAT).parse(dateStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    /**
     * 获取现在时间
     * @param format 详见DateUtils的静态常量[诸如FORMAT_*]
     * @return 返回format字符串格式
     */
    public static String getStringNowDate(String format) {
        return getStringDate(new Date(), format);
    }

    /**
     * 获取时间的字符串表现形式
     * @param format 详见DateUtils的静态常量[诸如FORMAT_*]
     * @return 返回format字符串格式
     */
    public static String getStringDate(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    //1、获取当月第一天

    public static String firstForDateMon(){
    //规定返回日期格式
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        Date theDate=calendar.getTime();
        GregorianCalendar gcLast=(GregorianCalendar)Calendar.getInstance();
        gcLast.setTime(theDate);
    //设置为第一天
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first=sf.format(gcLast.getTime());
    //打印本月第一天
        return day_first;
    }
    //2、获取当月最后一天

    public static String lastForDateMon(){
    //获取Calendar
        Calendar calendar=Calendar.getInstance();
    //设置日期为本月最大日期
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
    //设置日期格式
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        String ss=sf.format(calendar.getTime());
        return ss;
    }
    //3、非常简单和实用的获取本月第一天和最后一天

    public static String testt(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(ca.getTime());
       return last;
    }
    //4、获取上个月的第一天

    public static String getBeforeFirstMonthdate()throws Exception{
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(calendar.getTime());
    }
    //5、获取上个月的最后一天

    public static String getBeforeLastMonthdate()throws Exception{
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return sf.format(calendar.getTime());
    }



    public static String getFirstDate(){
        SimpleDateFormat  sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cl = Calendar.getInstance();
    // cl.setTime(dateNow);
    // cl.add(Calendar.DAY_OF_YEAR, -1);
    //一天
    // cl.add(Calendar.WEEK_OF_YEAR, -1);
    //一周
        cl.add(Calendar.MONTH, -1);
    //从现在算，之前一个月,如果是2个月，那么-1-----》改为-2
        Date dateFrom = cl.getTime();
        return sdf.format(dateFrom);
    }
    
    public static Date getDayStart(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
   }
   
   public static Date getDayEnd(Date date) {
   	Calendar calendar = new GregorianCalendar();
       calendar.setTime(date);
       calendar.set(Calendar.HOUR_OF_DAY, 23);
       calendar.set(Calendar.MINUTE, 59);
       calendar.set(Calendar.SECOND, 59);
       calendar.set(Calendar.MILLISECOND, 999);
       return calendar.getTime();
   }
    
    public static Date addHour(Date before, int num) {
    	Calendar ca = Calendar.getInstance();
    	ca.setTime(before);
    	ca.add(Calendar.HOUR_OF_DAY, num);
    	return ca.getTime();
    }
    
    public static int differentDays(Date date1,Date date2){
        int days = (int) ((getDayStart(date2).getTime() - getDayStart(date1).getTime()) / (1000*3600*24));
        return days;
    }
    
    public static int differentHours(Date date1,Date date2){
        int days = (int) ((getDayStart(date2).getTime() - getDayStart(date1).getTime()) / (1000*3600));
        return days;
    }
    
    public static int differentDays(String startTime, String endTime) throws ParseException{
    	Date start = parse(startTime, "yyyy-MM-dd");
    	Date end = parse(endTime, "yyyy-MM-dd");
        int days = (int) ((getDayStart(end).getTime() - getDayStart(start).getTime()) / (1000*3600*24));
        return days;
    }
    
    public static void main(String[] args) {
		System.out.println(addDay(new Date(), -4));
	}
    
    public static Date addDay(Date before, int num) {
    	Calendar ca = Calendar.getInstance();
    	ca.setTime(before);
    	ca.add(Calendar.DAY_OF_YEAR, num);
    	return ca.getTime();
    }
    
    public static Date addMinus(Date before, int num) {
    	Calendar ca = Calendar.getInstance();
    	ca.setTime(before);
    	ca.add(Calendar.MINUTE, num);
    	return ca.getTime();
    }
    
    public static Date addSecond(Date before, int num) {
    	Calendar ca = Calendar.getInstance();
    	ca.setTime(before);
    	ca.add(Calendar.SECOND, num);
    	return ca.getTime();
    }

    public void testStartDate(){
        System.out.println("当前日期往前推一个月是：" + getFirstDate());

        //如果当前日期是2015.11.08,那么打印日期是:20151008
    }

    public static Date getDate(Integer hour,Integer minute,Integer second){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        Date date = calendar.getTime();
        return date;
    }

    /**
     * 获取当前时间之前或之后几小时 hour
     * @param hour
     * @return
     */
    public static Date getTimeByHour(int hour) {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);

        Date time = calendar.getTime();

        return time;

    }

    /**
     * 获取某月第一天与最后一天
     * @param dateStr yyyy-MM
     * @return
     */
    public static List<Date> getThisMonthFirstAndLastDay(String dateStr){
        List<Date> list = new ArrayList<>();

        try {
            if(dateStr == null || "".equals(dateStr)){
                list.add(null);
                list.add(null);
                return list;
            }

            String[] split = dateStr.split("-");
            list.add(getFirstDayOfMonth(Integer.valueOf(split[0]), Integer.valueOf(split[1])));
            list.add(getLastDayOfMonth(Integer.valueOf(split[0]), Integer.valueOf(split[1])));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    /**
     * 获得该月第一天
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(int year,int month){
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        return cal.getTime();
    }


    /**
     * 获得该月最后一天
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(int year,int month){
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        return cal.getTime();
    }

    /**
     * 获取今天之前某几天零点的集合
     * @param day
     * @return
     */

    public static List<Date> getDateRange(int day){

        Date date = getToday();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,day);//把日期往后增加一天.整数往后推,负数往前移动
        Date date2=calendar.getTime(); //这个时间就是日期往后推一天的结果
        List<Date> list = new ArrayList<>();
        list.add(date2);
        list.add(date);

        return list;

    }

    /**
     * 获取今日零点的Date对象
     * @return
     */
    private static Date getToday(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        return zero;
    }

    /**
     * 获取今天的时间字符串格式为：yyyyMMdd
     */
    public static String getDateStr(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-1);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }
    /**
     * 获取今天的前N天的字符串格式为：yyyyMMdd
     */
    public static String getDateStr(int day){
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }
    
    public static String formatDate(Date date, String format){
    	if (date == null) {
    		return null;
    	}
        SimpleDateFormat sdf= new SimpleDateFormat(format);
        return sdf.format(date);

    }

    /*
    获取当前时间之前或之后几分钟 minute

    */
    public static Date getTimeByMinute(int minute) {

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.MINUTE, minute);

        Date time = calendar.getTime();

        return time;

    }

    /**
     * 判断一个字符串是否为手机号字符串
     */
    public static boolean checkMobile(String mobiles){
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    public static Date getTimeByHour2(int min) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,min);
        Date time = calendar.getTime();
        return time;
    }
    
    public static Date parse(String dateStr, String format) throws ParseException {
    	SimpleDateFormat sf = new SimpleDateFormat(format);
    	return sf.parse(dateStr);
    }
    
    public static Date parse(String dateStr) throws ParseException {
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    	return sf.parse(dateStr);
    }
    
    /**
     * 获取一个月之前的现在时间
     * @param nowTime
     * @return
     */
    public static Date getBeforeMonth(Date nowTime){
        Calendar c = Calendar.getInstance();
        //过去一月
        c.setTime(nowTime);
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
    	return m;
    }
    
    /**
     * 获取当前月的第一天的开始时间
     * @param nowTime
     * @return
     */
    public static Date getCurrtMonthFirstDayTime(Date nowTime){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Calendar c = Calendar.getInstance();
        c.setTime(nowTime);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String start = sdf.format(c.getTime());
        try {
			return sdf.parse(start);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    
    /**
     * 获得该月最早一天的开始一秒时间
     * @param month
     * @return
     * @throws ParseException 
     */
    public static Date getStartDayOfMonthByTime(String month) throws ParseException{
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String monthStr=month+"-01 00:00:00";		
        return sdf.parse(monthStr);
    }
    
    /**
     * 获得该月最后一天的最后一秒时间
     * @param time
     * @return
     * @throws ParseException 
     */
    public static Date getLastDayOfMonthByTime(Date time) throws ParseException{
    	   	
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        // 时
        cal.set(Calendar.HOUR_OF_DAY, 23);
    	// 分
        cal.set(Calendar.MINUTE, 59);
    	// 秒
        cal.set(Calendar.SECOND, 59);
    	// 毫秒
        cal.set(Calendar.MILLISECOND, 999);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String endMonthStr=sdf2.format(cal.getTime());
        return sdf2.parse(endMonthStr);
    }
    
    /**
     * 得到这天的开始时间
     * @param day
     * @return
     * @throws ParseException
     */
    public static Date getDayStart(String day) throws ParseException{    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String time=day+" 00:00:00";		
    	return sdf.parse(time);
    	
    }
    
    /**
     * 得到这天的结束时间
     * @param day
     * @return
     * @throws ParseException
     */
    public static Date getDayEnd(String day) throws ParseException{    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String time=day+" 23:59:59";		
    	return sdf.parse(time);
    	
    }
    
    public static int passSeconds(Date date) {
		if (date == null) {
			return 0;
		}
		return (int) (new Date().getTime() - date.getTime()) / (1000);
	}
    
    public static String getDateFilePath() {
    	Date date = new Date();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Chongqing"));
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return String.format("%s/%s/%s", year, month, day);
    }

}
