package com.tribal.utils;

import java.util.Calendar;
import java.util.Date;

public class TribalScripts {
    /* Function to get a object of Calendar type from the current date */
    public static Calendar getCalendarFromToday(){
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        return calendar;
    }
    /* Function to get a date with 30 seconds less */
    public static Date  getThirtySecondsFromCurrentDate(Calendar calendar){
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) - 3);
        return calendar.getTime();
    }
    /* Function to get a date with 2 minutes less */
    public static Date  getTwoMinutesFromCurrentDate(Calendar calendar){
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - 2);
        return calendar.getTime();
    }
}
