package tidsbokning;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Admin {

	
	
	String inputHairdresser = null;
	int Hairdresser = 0;

	System.out.println("Ange frisör: ");
	do {
		if (Hairdresser > 0) {
			System.out.println("Du glömde att ange namn...");
		}
		Hairdresser++;
		try {
			inputHairdresser = inputReader.readLine();
		} catch (NullPointerException npe) {
			// npe.printStackTrace();
			System.out.println("Du glömde att ange namn...");
		}

	} while (inputHairdresser.equals(""));

	int errordateH = 0;
	System.out.println("Ange datum och tid för ej arbetstid:\nyy-MM-dd HH:mm");
	boolean OKDateH = true;

	// if (OKName){
	do {
		try {
			String inputTime = inputReader.readLine();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
			LocalDateTime formattedInput = LocalDateTime.parse(inputTime, formatter); // Snyggare
																						// formattering
			// System.out.println("Angiven söktid: " +
			// formattedInput.format(formatter));

			Time myTime = sch.createTime(inputHairdresser, startTime, endTime);
			myTime.setStartTime(formattedInput);

			System.out.println("Ange datum och sluttid för ej arbetstid:\nyy-MM-dd HH:mm");
			String inputTime2 = inputReader.readLine();
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
			LocalDateTime formattedInput2 = LocalDateTime.parse(inputTime2, formatter2);

			// Time myTime2 = sch.createTime(inputHairdresser,
			// startTime, endTime);
			myTime.setEndTime(formattedInput2);

			// myTime.setEndTime(formattedInput.plusMinutes(43)); //
			// .plusMinutes(CUT_DURATION);

			// För upprepning lägg till plusMinutes.(variabel från
			// nån adminstrations timehandler)

			bh.checkAvailability(myTime);

		} catch (NumberFormatException nfe) {
			// nfe.printStackTrace();
			System.out.println("Fel NFE i Case 2");
		} catch (IOException ioe2) {
			// ioe2.printStackTrace();
			System.out.println("Fel IO i Case 2");
		} catch (DateTimeParseException dtpe2) {
			// dtpe2.printStackTrace();
			OKDate = false;
			errorcounter++;
			if (errorcounter < 2) {
				System.out.println(
						"Ooops, tyvärr blev det nåt fel i formatet på angiven tid\nAnge datum och tid enligt formatet:\nyy-MM-dd HH:mm");
			} else if (errorcounter < 3) {
				System.out.println(
						"Aj då, det blev fel igen\nAnge datum och tid enligt formatet:\nyy-MM-dd HH:mm");
			} else if (errorcounter < 4) {
				System.out.println(
						"Logiken är så här:\nyy är år\nMM är månad i siffror\ndd är datum\nHH är timme enligt 24-timmarsregeln\nmm är minuter\nAntal bokstäver visar antal siffror du ska ange");
				System.out.println("yy-MM-dd HH:mm");
			} else
				System.out.println("Skärpning !!!");

		}
		break;

	} while (!OKDate);

	
}
