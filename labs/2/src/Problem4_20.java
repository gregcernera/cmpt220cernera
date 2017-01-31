import java.util.Scanner;

public class Problem4_20 {

	// FINISHED
	// (Process a string)
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String user = input.nextLine();
        System.out.println("The length of this string is " + user.length());
        System.out.println("The first character of this string is " + user.substring(0, 1));
        
	}

}
