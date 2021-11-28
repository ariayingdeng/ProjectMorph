package com.csis3275.morphModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



public class DateSystem {
	private String day;
	private int date;
	private int month;
	private int year;
	private Date today;
	private int dayNumber;
	private int emptyDayNumber;
	
	
	public DateSystem() {
		
	}
	
	
	public DateSystem(int date, int month, int year) {
		super();		
		this.date = date;
		this.month = month;
		this.year = year;
		getDate(date, month, year);
		
		
	}
	
	public void getDate(int date, int month, int year) {				
		Calendar myCalendar = Calendar.getInstance();
		dayNumber = myCalendar.get(Calendar.DAY_OF_WEEK);
		switch (dayNumber) {
			case 0: 
				day = "Sunday";
				break;
			case 1: 
				day = "Monday";
				break;
			case 2: 
				day = "Tuesday";
				break;
			case 3: 
				day = "Wednesday";
				break;
			case 4: 
				day = "Thursday";
				break;
			case 5: 
				day = "Friday";
				break;
			case 6: 
				day = "Saturday";
				break;
		}
		
		
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public int getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}
	
	public int getEmptyDaynumber() {
		Calendar myCalendar = Calendar.getInstance();
		myCalendar.set(year, month - 1, 1);
		emptyDayNumber = myCalendar.get(Calendar.DAY_OF_WEEK);
		return emptyDayNumber;
	}
	
	
	
	
}
