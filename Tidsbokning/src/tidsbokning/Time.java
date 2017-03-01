package tidsbokning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Time {

	private String date;
	private String time;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String bookingName;
	
	public Time (String name, LocalDateTime start, LocalDateTime end){
		try {
			this.setBookingName(name);
			this.startTime = start;
			this.endTime = end;
		} catch (DateTimeException dte) {
//			dte.printStackTrace();
			System.out.println("Aj då, fel i datumhanteringen (i Time) ");	}
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getBookingName() {
		return bookingName;
	}

	public void setBookingName(String bookingName) {
		this.bookingName = bookingName;
	}
	
}
		
		
		
		

	
	
	
	
	

