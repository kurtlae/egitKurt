package tidsbokning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Time implements Serializable {

	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private LocalTime startHour;
	private LocalTime endHour;
	private String bookingName;
	private int cuttingPrice;
	
	public Time (String name, LocalDateTime start, LocalDateTime end, int price){
		try {
			this.bookingName = name;
			this.startTime = start;
			this.endTime = end;
			this.cuttingPrice = price;
		} catch (DateTimeException dte) {
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
	
	
	
	public LocalTime getStartHour() {
		return startHour;
	}
	public void setStartHour(LocalTime startHour) {
		this.startHour = startHour;
	}
	public LocalTime getEndHour() {
		return endHour;
	}
	public void setEndHour(LocalTime endHour) {
		this.endHour = endHour;
	}

	public String getBookingName() {
		return bookingName;
	}

	
	
	public void setBookingName(String bookingName) {
		this.bookingName = bookingName;
	}
	public int getCuttingPrice() {
		return cuttingPrice;
	}

	public void setCuttingPrice(int price) {
		this.cuttingPrice = price;
	}

	public char[] toFileFormat() {
		// TODO Auto-generated method stub
		return null;
	}

}
		
		
		
		

	
	
	
	
	

