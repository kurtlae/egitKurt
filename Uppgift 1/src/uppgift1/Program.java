package uppgift1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Program {

	public static void main(String[] args) throws IOException {

		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Ange en text att jobba med: ");
		String input = inputReader.readLine();

		char[] anArray = new char[input.length()];
		
		input = input.toLowerCase();
		input.getChars(0, anArray.length, anArray, 0);
		int bokst = 0;
		int siffror = 0;
		int tecken = 0;
		int space = 0;

		for (int i = 0; i < anArray.length; i++) {
			if (anArray[i] >= 'a' && anArray[i] <= 'ö')
				bokst++;
		}


		for (int i = 0; i < anArray.length; i++) {
			if (anArray[i] >= '0' && anArray[i] <= '9')
				siffror++;
		}


		for (int i = 0; i < anArray.length; i++)
			if (anArray[i] == ' ')
				space++;


		tecken = anArray.length - (bokst + siffror + space);


		String text = input;
		int countOfTokens = new StringTokenizer(text).countTokens();
		String svar = "";

		do {
			System.out.println("\nTexten är: \n" + text);
			System.out.println("\nAnge\n1 för att räkna ord\n2 för att räkna bokstäver\n3 för att visa båda\n4 för att räkna siffror\n5 för att räkna tecken\n6 för att räkna mellanslag\n7 för att räkna total längd\n8 Ange ny text\n9 för att avsluta");
			svar = inputReader.readLine();

			switch (svar) {
			case "1":
				System.out.println("Antal ord: " + countOfTokens);
				break;
			case "2":
				System.out.println("Antal bokstäver: " + bokst);
				break;
			case "3":
				System.out.println("Texten har " + bokst + " bokstäver och består av " + countOfTokens + " ord");
				break;
			case "4":
				System.out.println("Antal siffror: " + siffror);
				break;
			case "5":
				System.out.println("Antal tecken: " + tecken);
				break;
			case "6":
				System.out.println("Antal mellanslag: " + space);
				break;
			case "7":
				System.out.println("Total längd: " + anArray.length);
				break;
			case "8":
				System.out.println("" );
				break;
			case "9":
				System.out.println("Avslut");
	//			System.exit(0);
				break;
			default:
				System.out.println("Oops");
				break;
			}
		} while (svar.compareTo("9") != 0);

	}

}
