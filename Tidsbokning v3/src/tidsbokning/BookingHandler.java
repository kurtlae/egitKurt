package tidsbokning;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class BookingHandler {
	static BookingHandler bh = new BookingHandler();

	private static ArrayList<Time> bookingArray;

	public BookingHandler() {
		bookingArray = new ArrayList<Time>();
	}

	public Time createTime(String name, LocalDateTime start, LocalDateTime end) {
		return new Time(name, start, end);
	}

	public void addTime(Time t) {
		bookingArray.add(t);
	}

	public ArrayList<Time> getTime() {
		return BookingHandler.bookingArray;
	}

	public static void checkAvailability(Barber chosenBarber, Time ct) {

		// Ett antal test av variabler för att få check av arbetstid 08:00 - 18:00 att funka
		// Enligt tips från coachen är det lämpligt att använda .compareTo >= som returnerar true/false i stället för .isBefore
		// 
				
		String bookingName;
		LocalDateTime checkStart;
		LocalDateTime checkEnd;
		LocalDateTime formattedMorning;
		LocalDateTime formattedEvening;
		LocalDateTime formattedCheckStart;
		LocalDateTime formattedCheckEnd;
		String morning = "08:00"; // Hårdkodat
		String evening = "18:00";

		bookingName = ct.getBookingName();
		checkStart = ct.getStartTime();
		checkEnd = ct.getEndTime();
		String checkStartDay = ct.getStartTime().toString();
		String checkEndDay = ct.getEndTime().toString();
		String morningStartTime = Constants.MORNING_START; // Plockas från konstanterna
		String eveningEndTime = Constants.EVENING_END;

		// For your eyes only: Försök att formattera datum så att man kan kolla HH:mm för angiven tid (ursprungligen yy-MM-dd HH:mm)
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
//		formattedMorning = LocalDateTime.parse(morning, formatter);
//		formattedEvening = LocalDateTime.parse(evening, formatter);
//
//		LocalDateTime formattedStartTime = LocalDateTime.parse(morningStartTime, formatter);
//		LocalDateTime formattedEndTime = LocalDateTime.parse(eveningEndTime, formatter);
//		formattedCheckStart = LocalDateTime.parse(checkStartDay, formatter);
//		formattedCheckEnd = LocalDateTime.parse(checkEndDay, formatter);
//

//		boolean OKBusinessHours = true;
//		if (formattedCheckStart.isBefore(formattedMorning) || formattedCheckEnd.isAfter(formattedEvening)) {
//			System.out.println("Arbetstiderna är 08:00 till 18:00");
//			OKBusinessHours = false;
//		} else {
		
		// kolla föreslagen tid mot de befintliga i bookingArray
		boolean OK = true;
			for (Time checkArray : chosenBarber.getBookings()) { 
				if (checkEnd.isBefore(checkArray.getStartTime()) || (checkStart.isAfter(checkArray.getEndTime()))) {
				} else {
					System.out.println("Angiven söktid: " + ct.getStartTime());
					System.out.println(
							"Tyvärr är din föreslagna tid inte tillgänglig\nVälj 2 för att ange ny tid eller 1 för att se bokade tider");
					OK = false; // om tiden ej är tillgänglig ska den inte lagras i arrayen
				}
			}

		// lagring i arrayen om de nya tiderna är OK	
		if (OK) { 
			
			chosenBarber.getBookings().add(ct);
			System.out.println(ct.getBookingName() + " är bokad: " + ct.getStartTime());
		}
	}
}
