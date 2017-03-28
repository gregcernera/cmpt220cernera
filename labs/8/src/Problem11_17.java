import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem11_17 {

	// FINISHED
	// (Algebra: perfect square)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer m: ");
		int m = input.nextInt();
		input.close();
		
		ArrayList<Integer> factors = new ArrayList<>();
		findFactors(m, factors);
		
		removeDuplicate(m, factors);
		int smallestNumber = smallestNumber(factors);
		
		System.out.println("The smallest number n for n * m to be a perfect square is " + smallestNumber);
		System.out.println("m * n is " + (m * smallestNumber));
		
	}
	
	// used my code from Problem 11.13
    public static void removeDuplicate(int m, ArrayList<Integer> list) {
		
    	ArrayList<Integer> temp = new ArrayList<>();
    	
    	int frequency;
    	
    	for (int i = 0; i < list.size(); i ++) {
    		frequency = Collections.frequency(list, list.get(i));
    		
    		if (frequency % 2 != 0) {
    			if (!temp.contains(list.get(i)))
    				temp.add(list.get(i));
    			
    		}
    	}
    	
		list.clear();
		list.addAll(temp);
	}
    
    

    // used my code from Problem 5.16
	public static void findFactors(int m, ArrayList<Integer> list) {
		
		// check for the factor and only increase if it hasn't worked
		for (int i = 2; i <= m; ) {
	    	if (m % i == 0) {
	    		list.add(i);
	    		m = m / i;
	    	} else {
	    		i++;
	    	}
	    }
	}
	
	public static int smallestNumber(ArrayList<Integer> list) {
		int smallestNumber = 1;
		
		for (int i = 0; i < list.size(); i++) {
			smallestNumber *= list.get(i);
		}
		
		return smallestNumber;
	}

}
