import java.util.ArrayList;

public class KalkylatorHandler {

	static KalkylatorHandler kh = new KalkylatorHandler();

	private static ArrayList<Tal> talArray;

	public KalkylatorHandler() {
		talArray = new ArrayList<Tal>();
	}

	public Tal createTal(String inputTal) {
		return new Tal(inputTal);
	}

	public void addTal(Tal t) {
		talArray.add(t);
	}
	
	public ArrayList<Tal> getTal() {
		return KalkylatorHandler.talArray;
	}
	
	public void addition(Tal t) {
		double tal = t.getTal();
		double sum = 0.0;
		
		for (Tal talAdd : talArray) {  
			sum = sum + talAdd.getTal();
		}

	}	
}
