package tidsbokning;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BookingHandler {
	static BookingHandler bh = new BookingHandler();

	private static ArrayList<Time> bookingArray;

	public BookingHandler() {
		bookingArray = new ArrayList<Time>();
	}

	public Time createTime(String name, LocalDateTime start, LocalDateTime end, int price) {
		return new Time(name, start, end, price);
	}

	// public Hour createHour(String name, LocalTime start, LocalTime end, int
	// price) {
	// return new Hour(name, start, end, price);
	// }

	public void addTime(Time t) {
		bookingArray.add(t);
	}

	public ArrayList<Time> getTime() {
		return BookingHandler.bookingArray;
	}

	// public static boolean openTime(Time ot) {
	// LocalDateTime checkOpenStart;
	// LocalDateTime checkOpenEnd;
	// checkOpenStart = ot.getStartTime();
	// checkOpenEnd = ot.getEndTime();
	// String morningStartTime = Constants.MORNING_START;
	// String eveningEndTime = Constants.EVENING_END;
	// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	// LocalDateTime open = LocalDateTime.parse(morningStartTime, formatter);
	// LocalDateTime close = LocalDateTime.parse(eveningEndTime, formatter);

	// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	// LocalDateTime open = LocalDateTime.parse(morningStartTime, formatter);
	// LocalDateTime close = LocalDateTime.parse(eveningEndTime, formatter);
	// LocalDateTime openCheck = LocalDateTime.parse(checkOpenStart, formatter);
	// LocalDateTime closeCheck = LocalDateTime.parse(checkOpenEnd, formatter);

	// boolean openTime = true;
	// if (((checkOpenStart.compareTo(open) >= 0) &&
	// (checkOpenStart.compareTo(close) <= 0)) && ((checkOpenEnd.compareTo(open)
	// >= 0) && (checkOpenEnd.compareTo(close) <= 0))){
	// } else {
	// System.out.println("Vi har öppet mellan " + Constants.MORNING_START + "
	// och " + Constants.EVENING_END);
	// openTime = false;
	// }
	// return openTime;
	//
	//// return (checkOpenStart.compareTo(open) >= 0 &&
	// checkOpenStart.compareTo(close) <= 0)
	//// && (checkOpenEnd.compareTo(open) >= 0 && checkOpenEnd.compareTo(close)
	// <= 0);
	//
	//// boolean openTime = true;
	//// return (checkOpenStart.compareTo(open) >= 0 &&
	// checkOpenStart.compareTo(close) <= 0)
	//// && (checkOpenEnd.compareTo(open) >= 0 && checkOpenEnd.compareTo(close)
	// <= 0);
	//
	// }

	public static boolean checkAvailability(Barber chosenBarber, Time ct) {

		String bookingName;
		LocalDateTime checkStart;
		LocalDateTime checkEnd;

		bookingName = ct.getBookingName();
		checkStart = ct.getStartTime();
		checkEnd = ct.getEndTime();

		String checkStartDay = ct.getStartTime().toString();
		String checkEndDay = ct.getEndTime().toString();

		// kolla föreslagen tid mot de befintliga i bookingArray
		boolean OK = true;
		for (Time checkArray : chosenBarber.getBookings()) {
			if (checkEnd.isBefore(checkArray.getStartTime()) || (checkStart.isAfter(checkArray.getEndTime()))) {
			} else {
				System.out.println("Angiven söktid: " + ct.getStartTime());
				System.out.println(
						"Tyvärr är din föreslagna tid inte tillgänglig\nVälj 2 för att ange ny tid eller 1 för att se bokade tider");
				OK = false; // om tiden ej är tillgänglig ska den inte lagras i
							// arrayen
			}
		}

		// lagring i arrayen om de nya tiderna är OK
		if (OK) {
			chosenBarber.getBookings().add(ct);
			System.out.println(ct.getBookingName() + " är bokad: " + ct.getStartTime() + " ta med "
					+ ct.getCuttingPrice() + "kr i cash");
		}
		return OK;
	}

	
	// Spara bokningar i en fil
	public void saveBookings(Barber chosenBarber){
		ArrayList<Time> saveList = chosenBarber.getBookings();

		// To write your list to a file do the following:
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(chosenBarber.getBarberName());
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			System.out.println("File Not Found in saveBookings");
		}
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(fos);
			oos.writeObject(saveList);
			oos.close();
		} catch (IOException ioes) {
			ioes.printStackTrace();
			System.out.println("IOE in saveBookings");
		}

		// To read the list from a file, do the following:
		//
		// FileInputStream fis = new
		// FileInputStream(chosenBarber.getBarberName());
		// ObjectInputStream ois = new ObjectInputStream(fis);
		// ArrayList<Time> saveList = (ArrayList<Time>) ois.readObject();
		// ois.close();

		// BufferedWriter writer = Files.newBufferedWriter(Paths.get("Bookings",
		// saveList), StandardCharsets.UTF_8, StandardOpenOption.CREATE,
		// StandardOpenOption.APPEND);
		// {
		// for (Time loop : saveList) {
		// System.out.println(loop);
		// writer.write(loop.toFileFormat());
		// writer.newLine();
		// }
		//
		// }
	}

}
