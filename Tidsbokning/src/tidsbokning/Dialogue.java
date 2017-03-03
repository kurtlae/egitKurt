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

			Time repeatTime;
			switch (svar) {
			case "1": // visa bokade tider
				ArrayList<Time> lista = bh.getTime();
				for (Time snurra : lista)
					System.out.println("Bokad tid: " + snurra.getBookingName() + " " + snurra.getStartTime().toString()
							+ " " + snurra.getEndTime().toString());
				break;

			// Ta emot tid och kolla om den är tillgänglig
			case "2":

				String inputName = null;
				int errorname = 0;

				// Namn på personen som vill boka tid för med koll på att man inte anger nåt (bara trycker ENTER)
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

				// String inputType = null;
				// int errortype = 0;

				// Ta emot ett datum enligt specat format
				int errordate = 0;
				System.out.println("Ange ett datum och tid för bokning enligt formatet:\nyy-MM-dd HH:mm");
				boolean OKDate = true;

				// Loop för att tvinga användaren att ange datum i rätt format (OKDate)
				do {
					try {
						String inputTime = inputReader.readLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
						LocalDateTime formattedInput = LocalDateTime.parse(inputTime, formatter);

						Time myTime = bh.createTime(inputName, startTime, endTime);
						myTime.setStartTime(formattedInput);

						// Val av klipptyp
						System.out.println("Ange typ av klippning\n1. Kvinnlig\n2. Manlig");
						String cutType = null;
						String Type = inputReader.readLine();

						// Plocka in tid från Constants
						switch (Type) {
						case "1":
							myTime.setEndTime(formattedInput.plusMinutes(Constants.CUT_FEMALE));
							break;

						case "2":
							myTime.setEndTime(formattedInput.plusMinutes(Constants.CUT_MALE));
							break;
						default:
							break;
						}

						// Skicka tiden för kontroll om den är tillgänglig eller ej
						bh.checkAvailability(myTime);
						// så här föreslog Eclipse att det skulle se ut efter ett antal tillägg i koden
//						BookingHandler.checkAvailability(myTime);

					} catch (NumberFormatException nfe) {
						// nfe.printStackTrace();
						System.out.println("Fel NFE i Case 2");
					} catch (IOException ioe2) {
						// ioe2.printStackTrace();
						System.out.println("Fel IO i Case 2");
					} catch (DateTimeParseException dtpe2) {
						// dtpe2.printStackTrace();

						// Loop för att påpeka för användaren att hen gör fel
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
				break;

			// Administratörsval som i grunden är densamma som den vanliga
			// tidsbokningen dock med skillnaden att man här kan ange sluttid
			// själv, t ex 08:00 dagen efter
			// Kan användas för att ange tid då frisören är hemma eller sjuk
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
						LocalDateTime formattedInput2 = LocalDateTime.parse(inputTime, formatter);

						Time myTime = sch.createTime(inputHairdresser, startTime, endTime);
						myTime.setStartTime(formattedInput2);

						System.out.println("Ange datum och sluttid för ej arbetstid:\nyy-MM-dd HH:mm");
						String inputTime2 = inputReader.readLine();
						DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
						LocalDateTime formattedInput3 = LocalDateTime.parse(inputTime2, formatter2);

						myTime.setEndTime(formattedInput3);

						bh.checkAvailability(myTime);

					} catch (NumberFormatException nfe) {
						System.out.println("Fel NFE i Case 2");
					} catch (IOException ioe2) {
						System.out.println("Fel IO i Case 2");
					} catch (DateTimeParseException dtpe2) {
						OKDateH = false;
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

				} while (!OKDateH);

				// Här är tanken att lägga in ett val för frisörer så att dom
				// kan kopiera tid då dom är hemma till nästa vecka (plus 7
				// dagar) så att dom skapar ett schema
				// Det lär behövas en loop som stoppar efter ett antal
				// iterationer...
				// System.out.println("Vill du lägga upp tiden som stående varje dag ?");
				// String inputRepeatTime = null;

				// if (inputRepeatTime != null)
				// Time repeatTime = sch.createTime(inputHairdresser, startTime,
				// endTime);
				// repeatTime.setStartTime(formattedInput.plusDays(7));
				//
				// DateTimeFormatter formatter3 =
				// DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
				// LocalDateTime formattedInput3 =
				// LocalDateTime.parse(inputTime3, formatter3);
				//
				// repeatTime.setEndTime(formattedInput.plusDays(7));
				//
				// bh.checkAvailability(repeatTime);

				// lägg in ""LocalTime" för att kunna ange arbetstider
				// Tid arbtid = "08:00")

				// break;
			case "0":
			default:
				break;
			}
		} while (!svar.equals("0"));
		System.out.println("Avslut!");
	}
}
