import java.util.Scanner;

public class Problem7_8 {

	// DONE
	// (Average an array)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 10 numbers (doubles): ");
		double [] numbers = new double[10];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextDouble();
		}
		input.close();
		System.out.println("The average of these numbers is " + average(numbers));
	}
	
	public static int average(int [] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum / array.length;
	}
	
	public static double average(double [] array) {
	    double sum = 0.;
	    for (int i = 0; i < array.length; i++) {
	    	sum += array[i];
	    }
	    return sum / array.length;
	}

}
