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
		LocalDateTime startTime = null;
		LocalDateTime endTime = null;

		
		do {
			System.out.println("\n1. Se bokningar\n2. Lägg till ny bokning\n0. Avsluta");
				svar = inputReader.readLine();

			switch (svar) {
			case "1": // visa bokade tider
				ArrayList<Time> lista = bh.getTime();
				for (Time snurra : lista)
					System.out.println("Bokad tid: " + snurra.getStartTime().toString() + " " + snurra.getEndTime().toString());
				break;

			case "2": // ta emot förslag på tid och kolla om den är tillgänglig via BookingHandler
				System.out.println("Ange ett datum och tid för bokning enligt formatet\nyy-MM-dd HH:mm");
				String inputTime = inputReader.readLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
				LocalDateTime formattedInput = LocalDateTime.parse(inputTime, formatter);  //  Snyggare formattering
				System.out.println("Angiven söktid: " + formattedInput.format(formatter));
				
				Time myTime = bh.createTime(startTime, endTime);
				myTime.setStartTime(formattedInput);
//				Duration CUT_DURATION = Duration.ofMinutes(60);   // tester för att använda en konstant så att man kan ange olika tider för herrar, damer, färgning etc
//				myTime.endTime = formatDateTime + CUT_DURATION;
				myTime.setEndTime(formattedInput.plusMinutes(43));   //  .plusMinutes(CUT_DURATION);
				
				bh.checkAvailability(myTime);
//				bh.addTime(myTime);  /flyttad till checkAvailability för att inte få krockande tider inlagda i arrayen
				
				break;
			case "0":
			default:
				break;
			}
		} while (!svar.equals("0"));
		System.out.println("Avslut!");
	}
}
