import java.util.Scanner;

public class Problem5_16 {

	// FINISHED
	// (Find the factors of an integer)
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    System.out.print("Enter an integer: ");
	    int n = input.nextInt();
	    String output = "";
	    
	    // check for the factor and only increase if it hasn't worked
	    for (int i = 2; i <= n; ) {
	    	if (n % i == 0) {
	    		output += i + " ";
	    		n = n / i;
	    	} else {
	    		i++;
	    	}
	    }
	    
	    System.out.println(output);

	}

}
