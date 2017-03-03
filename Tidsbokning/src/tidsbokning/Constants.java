package tidsbokning;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Constants {

	public static final long cutMale = 26;
	public static final long cutFemale = 55;
	public static final long inBetween = 5;
	public static final long cutType = 0;
	
	
	public static final String morningStart = "08:00";
	public static final String eveningEnd = "18:00";

		public static long getCuttype() {
		return cutType;
	}
	
	// Används ej 
//	private int LENGTH;
//	private int CUT_MALE;
//	private int CUT_FEMALE = 53;
//	private int NEW_CUSTOMER = 5;
//	
//	public int getCUT_MALE() {
//		return CUT_MALE;
//	}
//	public void setCUT_MALE(int cUT_MALE) {
//		this.CUT_MALE = cUT_MALE;
//	}
//	public int getCUT_FEMALE() {
//		return CUT_FEMALE;
//	}
//	public void setCUT_FEMALE(int cUT_FEMALE) {
//		CUT_FEMALE = cUT_FEMALE;
//	}
//	public int getNEW_CUSTOMER() {
//		return NEW_CUSTOMER;
//	}
//	public void setNEW_CUSTOMER(int nEW_CUSTOMER) {
//		NEW_CUSTOMER = nEW_CUSTOMER;
//	}
	
}
