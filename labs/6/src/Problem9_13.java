import java.util.Scanner;

public class Problem9_13 {

	// FINISHED
	// (The Location class)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of rows and columns in the array: ");
		int rows = input.nextInt();
		int columns = input.nextInt();
		double [][] numbers = new double[rows][columns];
		Location location;
		System.out.println("Enter the array: ");
		
		for (int r = 0; r < numbers.length; r++) {
			for (int c = 0; c < numbers[0].length; c++) {
				numbers[r][c] = input.nextDouble();
			}
		}
		input.close();

		location = locateLargest(numbers);
		location.display();
		
	}
	
	public static Location locateLargest(double [][] a) {
		double max = a[0][0];
		int row = 0;
		int col = 0;
		
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[0].length; c++) {
				if (a[r][c] > max) {
					max = a[r][c];
					row = r;
					col = c;
				}
			}
		}
		return new Location(row, col, max);
	}

}

class Location {
	int row, column;
	double maxValue;
	
	Location(int newRow, int newColumn, double newMaxValue) {
		row = newRow;
		column = newColumn;
		maxValue = newMaxValue;
	}
	
	void display() {
		System.out.println("The location of the largest element is " + maxValue + " at (" +
	                       row + ", " + column + ")");
	}
}
