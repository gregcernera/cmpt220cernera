import java.util.Scanner;

public class Problem7_2 {

	// DONE
	// (Reverse the numbers entered)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int [] numbers = new int[10];
		System.out.print("Enter integer (separate by spaces): ");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextInt();
		}
		input.close();
		
		for (int i = numbers.length - 1; i >= 0; i--) {
			System.out.print(numbers[i] + " ");
		}
	}

}
