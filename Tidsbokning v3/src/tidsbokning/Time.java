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

	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String bookingName;
	private int price;
	
	public Time (String name, LocalDateTime start, LocalDateTime end){
		try {
			this.bookingName = name;
			this.startTime = start;
			this.endTime = end;
		} catch (DateTimeException dte) {
//			dte.printStackTrace();
			System.out.println("Aj då, fel i datumhanteringen (i Time) ");	}
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
		
		
		
		

	
	
	
	
	

