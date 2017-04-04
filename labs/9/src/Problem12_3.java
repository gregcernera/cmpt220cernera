import java.util.Random;
import java.util.Scanner;

public class Problem12_3 {

	// FINISHED
	// (ArrayIndexOutOfBoundsException)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		int [] numbers = new int[100];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(100) + 1;
		}
		
		System.out.print("Enter an index number: ");
		int user = input.nextInt();
		input.close();
		
		try {
			System.out.println("The corresponding number for index [" + user + 
					"] is " + numbers[user]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR: The index you entered is Out of Bounds.");
			System.exit(1);
		}
	}

}
