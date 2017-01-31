import java.util.Scanner;

public class Problem4_9 {

	// FINISHED
	// (Find the Unicode of a character)
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    System.out.print("Enter a character: ");
	    char user = input.next().charAt(0);
	    System.out.println("The Unicode for the character " + user + " is " + (int)user);
	    
	}

}
