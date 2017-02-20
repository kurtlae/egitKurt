package uppgift1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Program {

	public static String getUserInputFromDialogue(String dialogue) throws IOException {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(dialogue);
		return inputReader.readLine();
	}

	public static void main(String[] args) {

		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

		String test = " Detta  är ett test av ordräknare";
		int countOfTokens = new StringTokenizer(test).countTokens();
		System.out.println(countOfTokens);

		int countWords = 0;
		String input = "  333 4 && # alive   is  awesome   ";
		String[] anArray = input.split("\\s+");
		
		int length = input.length();
		for (int i = 0; i < anArray.length; i++) {
			countWords++;
		}
		System.out.println(countWords);
		System.out.println(length);
		
/*		\w - Matches any word character. 
		\W - Matches any nonword character. 
		\s - Matches any white-space character. 
		\S - Matches anything but white-space characters. 
		\d - Matches any digit. 
		\D - Matches anything except digits.
*/
		
		int countChar = 0;
		String inputC = "333 44 && #& /# alive  is  awesome   ";
		String[] anArrayC = inputC.split("\\s+");
		
		for (int i = 0; i < anArrayC.length; i++) {
			countChar++;
		}
		System.out.println(countChar);
		
		
		
		
	}

}
