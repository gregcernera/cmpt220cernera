
public class Problem6_16 {

	// DONE
	// (Number of days in a year)
	public static void main(String[] args) {
		for (int i = 2000; i <= 2020; i++) {
			System.out.println("The year " + i + " has " + numberOfDaysInAYear(i) + " days in a year.");
		}

	}
	
	// find out if it's a leap year
	public static int numberOfDaysInAYear(int year) {
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			return 366;
		} else {
			return 365;
		}
	}

}
