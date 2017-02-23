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
	
	public Time (LocalDateTime start, LocalDateTime end){
		this.startTime = start;
		this.endTime = end;
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

	
////	public void main(String[] args) throws IOException, ParseException {
//		Time myTime = new Time(startTime, endTime);
//		
//		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
//		
//		System.out.println("Ange ett datum och tid för bokning\nyy-MM-dd HH:mm");
//		String inputDate = inputReader.readLine();
////		System.out.println("Ange tid: ");
////		String inputTime = inputReader.readLine();
//		
////		DateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm");
////		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
//		LocalDateTime formatDateTime = LocalDateTime.parse(inputDate, formatter);
//		System.out.println("Angiven söktid: " + formatDateTime.format(formatter));
//	
//		Duration CUT_DURATION = Duration.ofMinutes(60);
//		
////		myTime.setStartTime(formatDateTime);
//
//		myTime.startTime = formatDateTime;
////		myTime.endTime = formatDateTime + CUT_DURATION;
//		myTime.endTime = formatDateTime.plusMinutes(60);   //  .plusMinutes(CUT_DURATION);
//		
//		System.out.println("Starttid: " + myTime.startTime.format(formatter));
//		System.out.println("Sluttid: " + myTime.endTime.format(formatter));
//		
//		
//		
//		Date[] bookingArray = new Date[]{
//		for (int i=0; i<bookingArray.length; i++)
//			bookingArray[i] = myTime.startTime
//			
//		};
//	
//
//
////		Date date = (Date)formatter.parse(inputDate);
////		System.out.println(CUT_DURATION);
////		LocalDateTime now = LocalDateTime.now();
//		

		
}
		
		
		
		

	
	
	
	
	

