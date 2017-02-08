import java.util.Scanner;

public class Problem6_3 {

	// FINISHED
	// (Palindrome integer)
	
	// Return the reversal of an integer, i.e., reverse(456) returns 654
	public static int reverse(int number) {
		int newNumber = 0;
	    while (number > 0) {
	    	int digit = number % 10;
	    	newNumber = (newNumber * 10) + digit;
	    	number /= 10;
	    }
	    return newNumber;
	}
	
	// Return true if number is palindrome
	public static boolean isPalindrome(int number) {
		if (reverse(number) == number) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int n = input.nextInt();
		
		if (isPalindrome(n) == true) {
			System.out.println("The number " + n + " is a palindrome");
		} else {
			System.out.println("The number " + n + " is not a palindrome");
		}
		
	}

}
