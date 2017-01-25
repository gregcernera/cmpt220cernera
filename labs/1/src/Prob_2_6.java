import java.util.Scanner;

public class Prob_2_6 {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    System.out.print("Enter a number between 0 and 1000: ");
	    int user = input.nextInt();
	    int total = 0;
	    int a = user % 10;
	    int b = (user / 10) % 10;
	    int c = (user / 100) % 100;
		
	    total = a + b + c;
	    System.out.println("The sum of the digits is " + total);
		
	}

}
