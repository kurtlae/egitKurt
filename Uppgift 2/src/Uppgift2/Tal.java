

public class Tal {

	private double tal;

	public Tal(String t) {

		
		try {
			this.tal = Double.parseDouble(t);
		} catch (NumberFormatException nfe) {
//			nfe.printStackTrace();
			System.out.println(
					nfe.getClass().getSimpleName() + " in Tal " + nfe.getMessage());
		}
	}

	public double getTal() {
		return tal;
	}

	public void setTal(double tal) {
		this.tal = tal;
	}

}
