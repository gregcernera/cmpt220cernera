import java.util.Scanner;

public class Problem12_1 {

	// FINISHED
	// (NumberFormatException)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an expression using (+,-,*, or /): ");
		
		String [] x = new String[3];
		for (int i = 0; i < x.length; i++) {
			x[i] = input.next();
		}
		
		input.close();
		double output = 0;
		
		
		try {
			switch(x[1]) {
			case "+":
				output = Double.parseDouble(x[0]) + Double.parseDouble(x[2]);
				break;
			case "-":
				output = Double.parseDouble(x[0]) - Double.parseDouble(x[2]);
				break;
			case "*":
				output = Double.parseDouble(x[0]) * Double.parseDouble(x[2]);
				break;
			case "/":
				output = Double.parseDouble(x[0]) / Double.parseDouble(x[2]);
				break;
			}
		} catch (NumberFormatException e) {
			System.out.println("Error: The values entered are not numbers.");
			System.exit(1);
		}
		
		
		/*
		if ( isNumeric(x[0]) && isNumeric(x[2]) ) {
			switch(x[1]) {
			case "+":
				output = Double.parseDouble(x[0]) + Double.parseDouble(x[2]);
				break;
			case "-":
				output = Double.parseDouble(x[0]) - Double.parseDouble(x[2]);
				break;
			case "*":
				output = Double.parseDouble(x[0]) * Double.parseDouble(x[2]);
				break;
			case "/":
				output = Double.parseDouble(x[0]) / Double.parseDouble(x[2]);
				break;
			}
		} else {
			if (!isNumeric(x[0])) {
				System.out.println("Error: " + x[0] + " is not numeric");
				System.exit(2);
			} else if (!isNumeric(x[2])) {
				System.out.println("Error: " + x[3] + " is not numeric");
				System.exit(4);
			}
		}
		*/
		
		
		System.out.println(x[0] + " " + x[1] + " " + x[2] + " " + "=" + " " + output);
		
		

	}
	
	public static boolean isNumeric(String string) {
		for (char c : string.toCharArray()) {
			if (c < '0' || c > '9') return false;
		}
		return true;
	}

}
