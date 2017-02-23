package tidsbokning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Dialogue {

	public static void main(String[] args) throws IOException {

		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		BookingHandler bh = new BookingHandler();
		String svar = "";
		String nameToFind = "";
		LocalDateTime startTime = null;
		LocalDateTime endTime = null;

		
		do {
			System.out.println("1. Se bokningar\n2. Lägg till ny bokning\n0. Avsluta");
				svar = inputReader.readLine();

			switch (svar) {
			case "1":
				ArrayList<Time> lista = bh.getTime();
				for (Time snurra : lista)
					System.out.println("Bokad tid: " + snurra.getStartTime().toString() + " " + snurra.getEndTime().toString());
				break;

			case "2":
				System.out.println("Ange ett datum och tid för bokning enligt formatet\nyy-MM-dd HH:mm");
				String inputTime = inputReader.readLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
				LocalDateTime formattedInput = LocalDateTime.parse(inputTime, formatter);
				System.out.println("Angiven söktid: " + formattedInput.format(formatter));
				
				
				Time myTime = bh.createTime(startTime, endTime);
				myTime.setStartTime(formattedInput);
//				myTime.endTime = formatDateTime + CUT_DURATION;
				myTime.setEndTime(formattedInput.plusMinutes(43));   //  .plusMinutes(CUT_DURATION);
				
				bh.checkAvailability(myTime);
				
				bh.addTime(myTime);
			
				Duration CUT_DURATION = Duration.ofMinutes(60);
				
				System.out.println("Starttid: " + myTime.getStartTime().format(formatter));
				System.out.println("Sluttid: " + myTime.getEndTime().format(formatter));
				break;

			case "0":
			default:
				break;
			}
		} while (!svar.equals("0"));
		System.out.println("Avslut!");

		
//		Time myTime = new Time(startTime, endTime);

		

//		System.out.println("Ange tid: ");
//		String inputTime = inputReader.readLine();
		
//		DateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm");
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");



		//System.out.println();
					


		
	}

}
