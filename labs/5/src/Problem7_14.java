import java.util.Arrays;
import java.util.Scanner;

public class Problem7_14 {

	// FINISHED
	// (computing gcd)
	// used GreatestCommonDivisor project from class notes as reference //
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int [] num = new int[5];
		System.out.print("Enter five numbers (separated by spaces): ");
		for (int i = 0; i < num.length; i++) {
			num[i] = input.nextInt();
		}
		input.close();
		System.out.println("The greatest common denominator is " + gcd(num));

	}
	
	public static int gcd(int... numbers) {
		int gcd = 1;
		int k = 2;
		Arrays.sort(numbers);
		int min = numbers[0];
		while (k <= min) {
			if (numbers[0] % k == 0 && numbers[1] % k == 0 && numbers[2] % k == 0 &&
					numbers[3] % k == 0 && numbers[4] % k == 0) {
				gcd = k;
			}
			k++;
		}
		return gcd;
	}
	
}
