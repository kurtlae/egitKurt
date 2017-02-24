package tidsbokning;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BookingHandler {
	static BookingHandler bh = new BookingHandler();

	private static ArrayList<Time> bookingArray;

	public BookingHandler() {
		bookingArray = new ArrayList<Time>();
	}

	public Time createTime(LocalDateTime start, LocalDateTime end) {
		return new Time(start, end);
	}

	public void addTime(Time t) {
		bookingArray.add(t);
	}

	public ArrayList<Time> getTime() {
		return BookingHandler.bookingArray;
	}

	public static void checkAvailability(Time ct) {
		LocalDateTime checkStart = ct.getStartTime();
		LocalDateTime checkEnd = ct.getEndTime();
//		Time checkTime = bh.createTime(checkStart, checkEnd);  // ej använd
		boolean OK = true;

		for (Time checkArray : bookingArray) {  // kolla ny tid mot de befintliga i bookingArray
			if (checkEnd.isBefore(checkArray.getStartTime()) || (checkStart.isAfter(checkArray.getEndTime()))) {
			} else {
				System.out.println("Tyvärr är din föreslagna tid inte tillgänglig\nVälj 2 för att ange ny tid eller 1 för att se bokade tider");
          		OK = false; // om tiden ej är tillgänglig ska den inte lagras i arrayen
			}
		}
		if (OK){ // lagring i arrayen om de nya är OK
		Time time = bh.createTime(checkStart, checkEnd);
		bh.addTime(time);
		System.out.println("Du är bokad: " + time.getStartTime());
		}
	}
}
