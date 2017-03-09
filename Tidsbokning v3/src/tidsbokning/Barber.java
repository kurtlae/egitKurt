package tidsbokning;

import java.util.ArrayList;

public class Barber {
	
	private String barberName;

	private ArrayList<Time> book = new ArrayList<Time>();
	
	public ArrayList<Time> getBookings(){
		
		return book;
		
	}
	
		
	public Barber(String barber) {
		this.barberName = barber;
	}

	public String getBarberName() {
		return barberName;
	}
	public void setBarberName(String barberName) {
		this.barberName = barberName;
	}


	
	
	
	
	
	
	
	

}
// array per frisör
// bokningar som property i barber   bokningar = ArrayList<Time>
// eventuellt i barber 				bokningar = ListHandler<Time>
// i huvudprogrammet   			ArrayList<barber>