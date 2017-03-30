package week9;

import java.util.Scanner;

public class QuotientWithException {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// prompt the user to enter two integers
		System.out.println("Enter two integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		
		try {
			System.out.println(number1 + " / " + number2 + " is " + quotient(number1,number2));
		} catch (ArithmeticException ex) {
			System.out.println("Exception: an integer " + "cannot be divided by zero");
		}
		
		System.out.println("Execution continues...");

	}
	
	public static int quotient(int number1, int number2) {
		if (number2 == 0) {
			throw new ArithmeticException("Divisor cannot be zero");
		}
		
		return number1/number2;
	}

}
