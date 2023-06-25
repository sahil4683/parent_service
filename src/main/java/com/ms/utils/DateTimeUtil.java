package com.ms.utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
	
	 public static void main(String[] args) {
	        LocalDate date = LocalDate.now();
	        String formattedDate = DateTimeUtil.formatDate(date);
	        System.out.println("Formatted date: " + formattedDate);

	        LocalTime time = LocalTime.now();
	        String formattedTime = DateTimeUtil.formatTime(time);
	        System.out.println("Formatted time: " + formattedTime);

	        LocalDateTime dateTime = LocalDateTime.now();
	        String formattedDateTime = DateTimeUtil.formatDateTime(dateTime);
	        System.out.println("Formatted date-time: " + formattedDateTime);

	        String dateStr = "2023-06-23";
	        LocalDate parsedDate = DateTimeUtil.parseDate(dateStr);
	        System.out.println("Parsed date: " + parsedDate);

	        String timeStr = "12:34:56";
	        LocalTime parsedTime = DateTimeUtil.parseTime(timeStr);
	        System.out.println("Parsed time: " + parsedTime);

	        String dateTimeStr = "2023-06-23 12:34:56";
	        LocalDateTime parsedDateTime = DateTimeUtil.parseDateTime(dateTimeStr);
	        System.out.println("Parsed date-time: " + parsedDateTime);

        	String dateString = "2023-06-23";
            Date strTodate = DateTimeUtil.convertStringToDate(dateString);
            System.out.println("Parsed Date: " + strTodate);

            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            try {
                // Convert strings to java.util.Date objects
                Date date1 = dateFormat.parse("2023-06-23");
                Date date2 = dateFormat.parse("2023-06-24");

                // Compare dates
                int comparison = DateTimeUtil.compareDates(date1, date2);
                System.out.println("Comparison: " + comparison);

                // Subtract days
                Date subtractedDate = DateTimeUtil.subtractDays(date1, 7);
                System.out.println("Subtracted Date: " + dateFormat.format(subtractedDate));

                // Add days
                Date addedDate = DateTimeUtil.addDays(date2, 3);
                System.out.println("Added Date: " + dateFormat.format(addedDate));
            } catch (ParseException e) {
                System.out.println("Error occurred while parsing the date: " + e.getMessage());
            }
            
	    }
    
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    public static String formatDate(LocalDate date) {
        return formatDate(date, DATE_FORMAT);
    }
    
    public static String formatDate(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }
    
    public static String formatTime(LocalTime time) {
        return formatTime(time, TIME_FORMAT);
    }
    
    public static String formatTime(LocalTime time, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return time.format(formatter);
    }
    
    public static String formatDateTime(LocalDateTime dateTime) {
        return formatDateTime(dateTime, DATE_TIME_FORMAT);
    }
    
    public static String formatDateTime(LocalDateTime dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }
    
    public static LocalDate parseDate(String dateStr) {
        return parseDate(dateStr, DATE_FORMAT);
    }
    
    public static LocalDate parseDate(String dateStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(dateStr, formatter);
    }
    
    public static LocalTime parseTime(String timeStr) {
        return parseTime(timeStr, TIME_FORMAT);
    }
    
    public static LocalTime parseTime(String timeStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalTime.parse(timeStr, formatter);
    }
    
    public static LocalDateTime parseDateTime(String dateTimeStr) {
        return parseDateTime(dateTimeStr, DATE_TIME_FORMAT);
    }
    
    public static LocalDateTime parseDateTime(String dateTimeStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(dateTimeStr, formatter);
    }
    
    public static Date convertStringToDate(String dateString) {
        return convertStringToDate(dateString, DATE_FORMAT);
    }
    
    public static Date convertStringToDate(String dateString, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public static int compareDates(Date date1, Date date2) {
        return date1.compareTo(date2);
    }

    public static Date subtractDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        return calendar.getTime();
    }

    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }
}
