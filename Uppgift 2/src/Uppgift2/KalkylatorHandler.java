
import java.util.ArrayList;

public class KalkylatorHandler {

	static KalkylatorHandler kh = new KalkylatorHandler();

	private static ArrayList<Tal> talArray;

	public KalkylatorHandler() {
		talArray = new ArrayList<Tal>();
	}

	public Tal createTal(String inputTal) throws NumberFormatException {
//		try {
			return new Tal(inputTal);
//		} catch (NumberFormatException nfe) {
//			nfe.printStackTrace();
//			System.out.println(nfe.getClass().getSimpleName() + " in createTal " + nfe.getMessage());
//		}
//		return null;
	}

	public void addTal(Tal t) throws NumberFormatException {
			talArray.add(t);
	}
	public ArrayList<Tal> getTal() {
		return KalkylatorHandler.talArray;
	}

	public void add(Tal t) {
		try {
			// double tal = t.getTal();
			double sum = 0.0;

			for (Tal talAdd : talArray) {
				sum = sum + talAdd.getTal();
			}
			System.out.println("Summan �r: " + sum);

		} catch (NullPointerException npe) {
			npe.printStackTrace();
			System.out.println(npe.getClass().getSimpleName() + " in AddTal " + npe.getMessage());
		}
	}

	public void subtract(Tal t) {
		try {
			// double tal = t.getTal();
			Tal rest = talArray.get(0);

			for (int i = 1; i < talArray.size(); i++) {
				rest.setTal(rest.getTal() - talArray.get(i).getTal());
			}
			System.out.println("Resten �r: " + rest.getTal());
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			System.out.println(npe.getClass().getSimpleName() + " in SubtractTal " + npe.getMessage());
		}
	}

	public void multiply(Tal t) {
		try {
			// double tal = t.getTal();
			double prod = 1.0;

			for (Tal talMul : talArray) {
				prod = prod * talMul.getTal();
			}
			System.out.println("Produkten �r: " + prod);
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			System.out.println(npe.getClass().getSimpleName() + " in MultiplyTal " + npe.getMessage());
		}
	}

	public void divide(Tal t) {
		try {
			// double tal = t.getTal();
			Tal div = talArray.get(0);

			for (int i = 1; i < talArray.size(); i++) {
				div.setTal(div.getTal() / talArray.get(i).getTal());
			}
			System.out.println("Divisorn �r: " + div.getTal());
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			System.out.println(npe.getClass().getSimpleName() + " in DivideTal " + npe.getMessage());
		}
	}
}
