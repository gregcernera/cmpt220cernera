import java.util.Scanner;

public class Problem7_4 {

	// DONE
	// (Analyze scores)
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    int [] scores = new int[100];
	    int count = -1;
	    System.out.print("Enter scores: ");
	    
	    do {
	    	count++;
	    	scores[count] = input.nextInt();
	    } while (scores[count] >= 0);
	    input.close();
	    
	    System.out.println("The number of scores above or equal to the average is " + numbersAboveOrEqual(scores, count, findAverage(scores, count)));
	    System.out.println("The number of scores below the average is " + numbersBelow(scores, count, findAverage(scores, count)));
	}
	
	// find the average
	public static double findAverage(int [] numbers, int x) {
		int sum = 0;
		double average = 0.;
		
		for (int i = 0; i < x; i++) {
			sum += numbers[i];
		}
		average = sum / x;
		return average;
	}
	
	// find if a number is above or equal to the average
	public static int numbersAboveOrEqual(int [] numbers, int x, double average) {
		int count = 0;
		for (int i = 0; i < x; i++) {
			if (numbers[i] >= average) {
				count++;
			}
		}
		return count;
	}
	
	// find if a number is below the average
	public static int numbersBelow(int [] numbers, int x, double average) {
		int count = 0;
		for (int i = 0; i < x; i++) {
			if (numbers[i] < average) {
				count++;
			}
		}
		return count;
	}

}
