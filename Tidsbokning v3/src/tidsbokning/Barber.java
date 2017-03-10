package tidsbokning;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Barber {
	
	private String barberName;

	private ArrayList<Time> barberBook; 
	
	public ArrayList<Time> getBookings(){
		return this.barberBook;
	}
	
		public Barber(String barber) {
		this.barberName = barber;
		this.barberBook = new ArrayList<Time>();
	}

	public String getBarberName() {
		return barberName;
	}
	public void setBarberName(String barberName) {
		this.barberName = barberName;
	}


	public void setStartTime(LocalDateTime formattedInput) {
		// TODO Auto-generated method stub
	}


	public void setEndTime(LocalDateTime plusMinutes) {
		// TODO Auto-generated method stub
	}

}
