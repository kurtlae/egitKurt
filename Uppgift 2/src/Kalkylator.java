import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Kalkylator {

	public static void main(String[] args) throws IOException {

		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		KalkylatorHandler kh = new KalkylatorHandler();
		String svar = null;
		
		do {
			System.out.println("\n1. Lägg till tal att bearbeta\n2. Addera\n9. Se inmatade tal\n0. Avsluta");
				svar  = inputReader.readLine();
			switch (svar) {
			case "1":
				double tal = 0;
				System.out.println("Ange ett tal\n");
				String inputTal = inputReader.readLine();
				Tal talet = kh.createTal(inputTal);
				kh.addTal(talet);
				break;
			case "2":

				kh.addition(null);
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
