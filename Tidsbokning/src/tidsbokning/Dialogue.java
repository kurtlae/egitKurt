package tidsbokning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Dialogue {

	public static void main(String[] args) throws IOException {

		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		BookingHandler bh = new BookingHandler();
		SchemaHandler sch = new SchemaHandler();
		String svar = "";
		LocalDateTime startTime = null;
		LocalDateTime endTime = null;
		int errorcounter = 0;

		do {
			System.out.println("\n1. Se bokningar\n2. Lägg till ny bokning\n9. Underhåll av arbetstider\n0. Avsluta");

			try {
				svar = inputReader.readLine();
			} catch (IOException ioem) {
				ioem.printStackTrace();
				System.out.println("Ooops, tyvärr ... vid Val ");
			}

			switch (svar) {
			case "1": // visa bokade tider
				ArrayList<Time> lista = bh.getTime();
				for (Time snurra : lista)
					System.out.println("Bokad tid: " + snurra.getBookingName() + " " + snurra.getStartTime().toString()
							+ " " + snurra.getEndTime().toString());
				break;

			case "2": // ta emot förslag på tid och kolla om den är tillgänglig
						// via BookingHandler

				String inputName = null;
				int errorname = 0;

				System.out.println("Ange namn: ");
				do {
					if (errorname > 0) {
						System.out.println("Du glömde att ange namn...");
					}
					errorname++;
					try {
						inputName = inputReader.readLine();
					} catch (NullPointerException npe) {
						// npe.printStackTrace();
						System.out.println("Du glömde att ange namn...");
					}

				} while (inputName.equals(""));

				String inputType = null;
				int errortype = 0;

				System.out.println("Ange typ av klippning\n1. Kvinnlig\n3. Manlig");
				String cutType = null;
				String Type = inputReader.readLine();

				switch (Type) {
				case "1":
					String cutType = "Female";
					break;

				case "3":
					String cutType = "Male";
					break;
				default:
					break;
				}

				int errordate = 0;
				System.out.println("Ange ett datum och tid för bokning enligt formatet:\nyy-MM-dd HH:mm");
				boolean OKDate = true;

				do {
					try {
						String inputTime = inputReader.readLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
						LocalDateTime formattedInput = LocalDateTime.parse(inputTime, formatter);

//						String inputName;
						Time myTime = bh.createTime(inputName, startTime, endTime);
						myTime.setStartTime(formattedInput);

						myTime.setEndTime(formattedInput.plusMinutes(Constants.cutMale));

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

				// Time myTime = bh.createTime(inputName, startTime, endTime);
				// myTime.setStartTime(formattedInput);
				//
				// myTime.setEndTime(formattedInput.plusMinutes(Constants.cutMale));
				//
				// bh.checkAvailability(myTime);

			case "9":
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

				// break;
			case "0":
			default:
				break;
			}
		} while (!svar.equals("0"));
		System.out.println("Avslut!");
	}
}
