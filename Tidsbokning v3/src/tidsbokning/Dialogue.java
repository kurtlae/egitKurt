package tidsbokning;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Dialogue {

	public static void main(String[] args) throws IOException {

		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		BookingHandler bh = new BookingHandler();
		SchemaHandler sch = new SchemaHandler();
		String svar = "";
		String svarBarber = "";
		LocalDateTime startTime = null;
		LocalDateTime endTime = null;
		LocalDateTime startHour = null;
		LocalDateTime endHour = null;
		int errorcounter = 0;
		int barberIndex = 0;

		ArrayList<Barber> barberList;
		barberList = new ArrayList<Barber>();
		barberList.add(new Barber("Ulla-Märta"));
		barberList.add(new Barber("Valderama"));
		barberList.add(new Barber("Wilma"));
		barberList.add(new Barber("Xerxes"));
		barberList.add(new Barber("Ylva"));
		barberList.add(new Barber("Zeke"));

		do {
			System.out.println("Välj frisör genom att ange första bokstaven i hens namn");
			for (Barber loop : barberList)
				System.out.println(loop.getBarberName());
			System.out.println("0 - Avsluta");

			try {
				svarBarber = inputReader.readLine();
			} catch (IOException ioef) {
				ioef.printStackTrace();
				System.out.println("Ooops, tyvärr fel vid Val av frisör");
			}

			switch (svarBarber) {
			case "u":
				barberIndex = 0;
				break;
			case "v":
				barberIndex = 1;
				break;
			case "w":
				barberIndex = 2;
				break;
			case "x":
				barberIndex = 3;
				break;
			case "y":
				barberIndex = 4;
				break;
			case "z":
				barberIndex = 5;
				break;
			case "0":
			default:
				break;
			}
			// break;
			// } while (!svar.equals("0"));

			Barber chosenBarber = barberList.get(barberIndex);

			do {
				System.out.println("\nVald frisör: " + chosenBarber.getBarberName());
				System.out.println("1. Se bokningar\n2. Lägg till ny bokning\n3. Byt frisör\n4. Spara fil\n0. Avsluta");

				try {
					svar = inputReader.readLine();
				} catch (IOException ioem) {
					ioem.printStackTrace();
					System.out.println("Ooops, tyvärr fel vid Val av åtgärd");
				}

				switch (svar) {
				case "1": // visa bokade tider
					ArrayList<Time> lista = chosenBarber.getBookings();
					for (Time loop : lista)
						System.out.println("Bokad tid: " + loop.getBookingName() + " " + loop.getStartTime().toString()
								+ " " + loop.getEndTime().toString());
					break;

				// Ta emot tid och kolla om den är tillgänglig
				case "2":

					String inputName = null;
					int errorname = 0;

					// Namn på personen som vill boka tid för
					// koll på att man inte anger nåt (bara trycker ENTER)
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
					System.out.println("Ange ett datum och tid för bokning enligt formatet:\nyy-MM-dd HH:mm");
					boolean OKDate = true;

					// Loop för att tvinga användaren att ange datum i rätt
					// format
					do {
						try {
							int price = 0;
							
							String inputTime = inputReader.readLine();
							
							DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
							LocalDateTime formattedInputDate = LocalDateTime.parse(inputTime, formatterDate);
							Time myTime = bh.createTime(inputName, startTime, endTime, price);
							myTime.setStartTime(formattedInputDate);
							
//							DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH:mm");
//							LocalDateTime formattedInputHour = LocalDateTime.parse(inputTime, formatterHour);
//							Time myHour = bh.createTime(inputName, startHour, endHour, price);
//							myHour.setStartTime(formattedInputHour); 
//							System.out.println(myHour);

//							Hour myHour = bh.createHour(inputName, startHour, endHour, price);
//							myHour.setStartHour(startHour); 

							// Val av klipptyp
							System.out.println("Ange typ av klippning\n1. Kvinnlig\n2. Manlig");

							String Type = inputReader.readLine();

							// Plocka in tid och pris från Constants
							switch (Type) {
							case "1":
								myTime.setEndTime(formattedInputDate.plusMinutes(Constants.CUT_FEMALE));
								myTime.setCuttingPrice(Constants.PRICE_FEMALE);
//								myHour.setEndHour(startHour.plusMinutes(Constants.CUT_FEMALE));
//								myHour.setEndTime(formattedInputHour.plusMinutes(Constants.CUT_FEMALE));
//								myHour.setCuttingPrice(Constants.PRICE_FEMALE);
								break;

							case "2":
								myTime.setEndTime(formattedInputDate.plusMinutes(Constants.CUT_MALE));
								myTime.setCuttingPrice(Constants.PRICE_MALE);
//								myHour.setEndHour(startHour.plusMinutes(Constants.CUT_MALE));
//								myHour.setEndTime(formattedInputHour.plusMinutes(Constants.CUT_MALE));
//								myHour.setCuttingPrice(Constants.PRICE_MALE);
								break;
							default:
								break;
							}

							// Skicka tiden för kontroll om den är tillgänglig
							// eller ej
							
//							bh.openTime(myHour);
							
							bh.checkAvailability(chosenBarber, myTime);

						} catch (NumberFormatException nfe) {
							// nfe.printStackTrace();
							System.out.println("Fel NFE i Case 2");
						} catch (IOException ioe2) {
							// ioe2.printStackTrace();
							System.out.println("Fel IO i Case 2");
						} catch (DateTimeParseException dtpe2) {
							// dtpe2.printStackTrace();

							// Loop för att påpeka för användaren att hen gör
							// fel
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
								System.out.println(
										"Skärpning !!!" + " Nu har du gjort fel " + errorcounter + " gånger...");
						}
						break;
					} while (!OKDate);
					break;

				case "3":
					do {
						System.out.println("Välj frisör genom att ange första bokstaven i hens namn");
						for (Barber snurra : barberList)
							System.out.println(snurra.getBarberName());
						System.out.println("0 - Avsluta");

						try {
							svarBarber = inputReader.readLine();
						} catch (Exception ioef2) {
							ioef2.printStackTrace();
							System.out.println("Ooops, tyvärr fel vid byte av frisör");
						}

						switch (svarBarber) {
						case "u":
							barberIndex = 0;
							break;
						case "v":
							barberIndex = 1;
							break;
						case "w":
							barberIndex = 2;
							break;
						case "x":
							barberIndex = 3;
							break;
						case "y":
							barberIndex = 4;
							break;
						case "z":
							barberIndex = 5;
							break;
						case "0":
						default:
							break;
						}
						break;
					} while (!svar.equals("0"));

					chosenBarber = barberList.get(barberIndex);

					// Administratörsval som i grunden är densamma som den
					// vanliga
					// tidsbokningen dock med skillnaden att man här kan ange
					// sluttid
					// själv, t ex 08:00 dagen efter
					// Kan användas för att ange tid då frisören är hemma eller
					// sjuk

					// case "0":
					// default:
					// break;
					
				case "4":
					bh.saveBookings(chosenBarber);
				}
			} while (!svar.equals("0"));
		} while (!svar.equals("0"));
		System.out.println("Avslut!");
	}

}
