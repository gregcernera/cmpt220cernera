import java.util.Scanner;

public class Problem6_18 {

	// DONE
	// (check password)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("A password must have at lease eight characters");
		System.out.println("A password consists of only letters and digits");
		System.out.println("A password must contain at least two digits");
		System.out.print("Enter a password: ");
		String password = input.nextLine();
		input.close();
		
		if (isValid(password) == true) {
			System.out.println(password + " is a valid password.");
		} else {
			System.out.println(password + " is not a valid passoword");
		}
	}
	
	public static boolean isValid(String pwd) {
	    if (checkLength(pwd) == true && checkLettersAndDigits(pwd) == true && checkNumberOfDigits(pwd) == true) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	
	// password must contain eight characters
	public static boolean checkLength(String pwd) {
		if (pwd.length() >= 8)
			return true;
		return false;
	}
	
	// password must contain only letters and digits
	public static boolean checkLettersAndDigits(String pwd) {
		pwd = pwd.toLowerCase();
		for (int i = 0; i < pwd.length(); i++) {
			char x = pwd.charAt(i);
			if ( (x >= 'a' && x <= 'z') || (x >= '0' && x <= '9') ) {
				;
			} else {
				return false;
			}
		}
		return true;
	}
	
	// password must contain at least two digits
	public static boolean checkNumberOfDigits(String pwd) {
		int count = 0;
		for (int i = 0; i < pwd.length(); i++) {
			char x = pwd.charAt(i);
			if (x >= '0' && x <= '9') {
				count++;
			}
		}
		
		if (count >= 2) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
