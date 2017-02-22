import java.util.Scanner;

public class Problem7_19 {

	// FINISHED
	// (Sorted?)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter list: ");
		final int SIZE = input.nextInt();
		int [] numbers = new int[SIZE];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextInt();
		}
		input.close();

		if (isSorted(numbers) == true) {
			System.out.println("The list is already sorted.");
		} else {
			System.out.println("The list is not sorted.");
		}
	}
	
	public static boolean isSorted(int [] list) {
		for (int i = 0; i < list.length - 1; i++) {
			if (list[i + 1] < list[i]) {
				return false;
			}
			
		}
		return true;
	}
	
}
