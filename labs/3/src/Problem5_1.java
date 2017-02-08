import java.util.Scanner;

public class Problem5_1 {

	// FINISHED
	// (Count positive and negative numbers and compute the average of numbers)
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    System.out.print("Enter an integer, the input ends if it is 0: ");
	    int user = 0;
	    int positive = 0;
	    int negative = 0;
	    int total = 0;
	    double average = 0;
	    double count = 0;
		
	    // each time the loop executes the next number is given to the user variable
	    // it is then checked if the number is positive or negative, adds to the total
	    // and keeps track of how many numbers to get the average
	    do {
		user = input.nextInt();
		total += user;
		count++;
			
		if (user > 0) {
		    positive++;
		} else if (user < 0) {
		    negative++;
		}
	    } while (user != 0);
		
	    count--;
	    average = total / count;
		
	    if (total == 0) {
		System.out.println("No numbers are entered except 0.");
	    } else {
		System.out.println("The number of positives is " + positive);
		System.out.println("The number of negatives is " + negative);
		System.out.println("The total is " + total);
		System.out.println("The average is " + average);
	    }
		
	}

}
