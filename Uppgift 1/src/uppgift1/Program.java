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
			if (anArray[i] >= 'a' && anArray[i] <= '�')
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
			System.out.println("\nTexten �r: \n" + text);
			System.out.println("\nAnge\n1 f�r att r�kna ord\n2 f�r att r�kna bokst�ver\n3 f�r att visa b�da\n4 f�r att r�kna siffror\n5 f�r att r�kna tecken\n6 f�r att r�kna mellanslag\n7 f�r att r�kna total l�ngd\n8 Ange ny text\n9 f�r att avsluta");
			svar = inputReader.readLine();

			switch (svar) {
			case "1":
				System.out.println("Antal ord: " + countOfTokens);
				break;
			case "2":
				System.out.println("Antal bokst�ver: " + bokst);
				break;
			case "3":
				System.out.println("Texten har " + bokst + " bokst�ver och best�r av " + countOfTokens + " ord");
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
				System.out.println("Total l�ngd: " + anArray.length);
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
