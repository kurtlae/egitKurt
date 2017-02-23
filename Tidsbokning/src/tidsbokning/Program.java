package tidsbokning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.time.*;

public class Program {

	
	
	public static void main(String[] args) throws IOException, ParseException {

		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Ange ett datum för bokning: ");
		String inputDate = inputReader.readLine();
		System.out.println("Ange tid: ");
		String inputTime = inputReader.readLine();
		
		
	//	Date[] bookingCalendar = new Date[2];
	//	getDateFromString("2017-02-22");
		LocalDate today = LocalDate.now();
		LocalTime now = LocalTime.now();
		LocalDateTime nu = LocalDateTime.now();
		
		
		ZonedDateTime dateAndTimeHere = ZonedDateTime.now();

		System.out.println(dateAndTimeHere);
		
		DateFormat format = new SimpleDateFormat("yy.MM.dd HH.mm");
		Date date = (Date)format.parse("bookStartPunkt");
		Duration CUT_DURATION = Duration.ofMinutes(60);
		
		System.out.println(format);
		System.out.println(date);
		System.out.println(CUT_DURATION);
		
		
		
	//	datetime[] booking = new datetime[];

		String name;
		
		

	}

}
