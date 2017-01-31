import java.util.Scanner;

public class Problem3_5 {

	// FINISHED
	// (Find future dates)
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    String [] names = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	    
	    System.out.print("Enter today's day: ");
	    int today = input.nextInt();
	    System.out.print("Enter the number of days elapsed since today: ");
	    int xDays = input.nextInt();
	    int newDay = (today + xDays) % 7;

	    System.out.println("Today is " + names[today] + " and the future day is " + names[newDay]);
	    
	}

}
