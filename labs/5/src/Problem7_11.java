import java.util.Scanner;

public class Problem7_11 {

	// FINISHED
	// (Statistics: compute deviation)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double [] numbers = new double[10];
		System.out.print("Enter ten numbers (separated by spaces): ");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextDouble();
		}
		input.close();
		
		System.out.println("The mean of the following numbers is " + mean(numbers));
		System.out.println("The standard deviation of the following numbers is " + deviation(numbers));

	}

	// compute the deviation of double values
	private static double deviation(double [] x) {
		double numerator = 0;
		double deviation = 0;
		for (int i = 0; i < x.length; i++) {
			numerator += Math.pow((x[i] - mean(x)), 2);
		}
		
		deviation = Math.pow((numerator / (x.length - 1)), .5);
		return deviation;
	}

	// compute the mean of an array of double values
	private static double mean(double [] x) {
		double total = 0;
		for (int i = 0; i < x.length; i++) {
			total += x[i];
		}
		return total / x.length;
	}
	
}
