import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.lang.NumberFormatException;

public class Kalkylator {

	public static void main(String[] args){

		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		KalkylatorHandler kh = new KalkylatorHandler();
		String svar = null;
		
		do {
			System.out.println("1. Lägg till tal att bearbeta\n2. Addera\n3. Subtrahera\n4. Multiplicera\n5. Dividera\n9. Se inmatade tal\n0. Avsluta");
				try {
					svar  = inputReader.readLine();
				} catch (IOException ioe) {
					ioe.printStackTrace();
					System.out.println(ioe.getClass().getSimpleName() + " in Input " + ioe.getMessage());
				}
			switch (svar) {
			case "1":
				double tal = 0;
				System.out.println("Ange ett tal\n");
				String inputTal = null;
				
				try {
					inputTal = inputReader.readLine();
					Tal talet = kh.createTal(inputTal);
					kh.addTal(talet);
				} catch (NumberFormatException nfe1) {
					nfe1.printStackTrace();
					System.out.println(nfe1.getClass().getSimpleName() + " in Case 1 " + nfe1.getMessage());
				} catch (IOException ioe1) {
					ioe1.printStackTrace();
					System.out.println(ioe1.getClass().getSimpleName() + " in Case 1 " + ioe1.getMessage());
				}


				break;
			case "2":
				kh.add(null);
				break;
			case "3":
				kh.subtract(null);
				break;
			case "4":
				kh.multiply(null);
				break;
			case "5":
				kh.divide(null);
				break;
			case "9": 
				ArrayList<Tal> lista = kh.getTal();
				for (Tal snurra : lista)
					System.out.println("Inmatade tal: " + snurra.getTal());
				break;
			case "0":
			default:
				break;
			}
		} while (!svar.equals("0"));
		System.out.println("Avslut!");
		
	}

}
