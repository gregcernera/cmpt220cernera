import java.util.Scanner;

public class Problem8_1 {

	// FINISHED
	// (Sum elements column by column)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double [][] numbers = new double[3][4];
		System.out.println("Enter a 3-by-4 matrix row by row: ");
		
		for (int r = 0; r < numbers.length; r++) {
			for (int c = 0; c < numbers[0].length; c++) {
				numbers[r][c] = input.nextDouble();
			}
		}
		input.close();
		
		for (int i = 0; i < numbers[0].length; i++) {
			System.out.println("Sum of the elements at column " + i + " is " + sumColumn(numbers, i));
		}
	}
	
	public static double sumColumn(double [][] m, int columnIndex) {
		double sum = 0.;
		for (int i = 0; i < m.length; i++) {
			sum += m[i][columnIndex];
		}
		return sum;
	}
	
}
