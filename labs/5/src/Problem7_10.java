import java.util.Scanner;

public class Problem7_10 {

	// FINISHED
	// (Find the index of the smallest element)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double [] numbers = new double[10];
		System.out.print("Enter ten integers (separated by spaces): ");
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextInt();
		}
		
		input.close();
		System.out.println("The index of the smallest element is " + indexOfSmallestElement(numbers));

	}
	
	public static int indexOfSmallestElement(double [] array) {
		int index = 0;
		double smallest = array[0];
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] < smallest) {
				array[i] = smallest;
				index = i;
			}
		}
		return index;
	}
	
}
