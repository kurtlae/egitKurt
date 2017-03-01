package tidsbokning;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SchemaHandler {
	static SchemaHandler sch = new SchemaHandler();

	private static ArrayList<Time> bookingArray;

	public SchemaHandler() {
		bookingArray = new ArrayList<Time>();
	}

	public Time createTime(String hairdresser, LocalDateTime start, LocalDateTime end) {
		return new Time(hairdresser, start, end);
	}
	public void addTime(Time t) {
		bookingArray.add(t);
	}
}
