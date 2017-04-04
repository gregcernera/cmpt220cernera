
public class Problem12_7 {

	// FINISHED
	// (NumberFormatException)
	 public static void main(String[] args) {

        System.out.println(bin2Dec("011010010"));
        System.out.println(bin2Dec("10001gsjd10"));
    }
 
	 public static int bin2Dec(String binary) throws NumberFormatException {

		 // check if string is binary
        if (!isBinary(binary)) {
            throw new NumberFormatException(binary + " is not a binary number.");
        }
        
        int pow = 0;
        int number = 0;
        
        // right to left
        for (int i = binary.length() - 1; i >= 0; i--) {

            if (binary.charAt(i) == '1')
                number += Math.pow(2, pow);
            
            pow++;
        }
        return number;
    }

    public static boolean isBinary(String binary) {

        for (char c : binary.toCharArray()) {
            if (c != '1' && c != '0') return false;
        }
        return true;
    }
}
