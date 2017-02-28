import java.util.GregorianCalendar;
import java.util.Date;

public class Problem9_5 {

	// FINISHED
	// (Use the GregorianCalender class)
	public static void main(String[] args) {
		
		// display the current year, month, and day
		Date date = new Date();
		System.out.println(date.toString());
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(1234567898765L);
		
		System.out.println("Year: " + calendar.get(GregorianCalendar.YEAR) + " Month: " + 
		                   calendar.get(GregorianCalendar.MONTH) + " Day: " + calendar.get(GregorianCalendar.DAY_OF_MONTH));

	}

}
