package tidsbokning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.ZonedDateTime;
import java.time.*;

public class Program {

	public static void main(String[] args) throws IOException {

		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Ange ett datum för bokning: ");
		String date = inputReader.readLine();

	//	Date[] bookingCalendar = new Date[2];
	//	getDateFromString("2017-02-22");
		LocalDate today = LocalDate.now();
		LocalTime now = LocalTime.now();
		ZonedDateTime dateAndTimeHere = ZonedDateTime.now();
//		datatyp date ?
		System.out.println(dateAndTimeHere);
		
	//	datetime[] booking = new datetime[];

		String name;
		
		

	}

}
