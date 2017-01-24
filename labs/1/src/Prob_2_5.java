import java.util.Scanner;

public class Prob_2_5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the subtotal and a gratuity rate: ");
		double subTotal = input.nextDouble();
		double rate = input.nextDouble();
		rate *= .01;
		
		double gratuity = subTotal * rate;
		double total = subTotal + gratuity;
		System.out.println("The gratuity is " + gratuity + " and total is " + total);

	}

}
