import java.util.Scanner;

public class Problem4_13 {

    // FINISHED
    // (Vowel or consonant?)
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char [] vowel = "aeiou".toCharArray();
        char [] consonant = "bcdfghjklmnpqrstvwxyz".toCharArray();
        System.out.print("Enter a letter: ");
        char user = input.next().charAt(0);
        char temp = Character.toLowerCase(user);
        boolean cons = false; // flag booleans
        boolean vow = false;
        
        // check if it's a vowel
        for (int i = 0; i < vowel.length; i++) {
            if (vowel[i] == temp) {
                vow = true;
                break;
            }
        }
        
        // check if it's a consonant
        for (int i = 0; i < consonant.length; i++) {
            if (consonant[i] == temp) {
                cons = true;
                break;
            }
        }
	    
        if (vow == true) {
            System.out.println(user + " is a vowel.");
        } else if (cons == true) {
            System.out.println(user + " is a consonant.");
        } else {
            System.out.println(user + " is an invalid input.");
        }

    }

}
