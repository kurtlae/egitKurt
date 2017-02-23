package tidsbokning;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingHandler {

	private ArrayList<Time> bookingArray;

	public BookingHandler() {
		bookingArray = new ArrayList<Time>();
	}

	public Time createTime(LocalDateTime start, LocalDateTime end) {
		return new Time(start, end);
	}

	public void addTime(Time t) {
		
		
		bookingArray.add(t);
	}
	
//	public Time getTime(LocalDateTime start, LocalDateTime end) {
//		for (int i=0; i<bookingArray.size(); i++)
//			
//			
//		//	for (Time t : bookingArray)
//		//		if (t.getStartTime().equals(start)) 
//				 bookingArray[i];
//	//	return null;
//
//		}
	
	public ArrayList<Time> getTime() {
		return this.bookingArray;
	}
	
	public Time checkAvailability(Time myTime){

		LocalDateTime ny;
		ny.isAfter(formatDateTime);
		
		
		return null;
		
	}
	
}
