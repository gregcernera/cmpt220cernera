
public class Problem5_5 {

	// FINISHED
	//(Conversion from kilograms to pounds and pounds to kilograms)
	public static void main(String[] args) {
		System.out.println("Kilograms\tPounds\t\t |\tPounds\t\tKilograms");
		
		// convert kilograms to pounds and display
		// convert pounds to kilograms and display
		for (int i = 1, j = 20; i <= 199; i += 2, j += 5) {
			System.out.printf("%d\t\t %.1f\t\t |\t %d\t\t %.2f\n", i, i * 2.2, j, j / 2.2);
		}
		

	}

}
