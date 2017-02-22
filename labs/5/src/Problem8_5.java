import java.util.Scanner;

public class Problem8_5 {

	// FINISHED
	// (Algebra: add two matrices)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double [][] matrix1 = new double[3][3];
		double [][] matrix2 = new double[3][3];
		double [][] matrix3 = new double[3][3];
		
		System.out.print("Enter matrix1: ");
		for (int r = 0; r < matrix1.length; r++) {
			for (int c = 0; c < matrix1[0].length; c++) {
				matrix1[r][c] = input.nextDouble();
			}
		}

		System.out.print("Enter matrix2: ");
		for (int r = 0; r < matrix2.length; r++) {
			for (int c = 0; c < matrix2[0].length; c++) {
				matrix2[r][c] = input.nextDouble();
			}
		}
		input.close();
		matrix3 = addMatrix(matrix1, matrix2);
		
		// print out the equation of matrices
		System.out.println("The matrices are added as follows");
		for (int r = 0; r < matrix1.length; r++) {
			
			//display matrix1
			for (int c = 0; c < matrix1[0].length; c++) {
				if (c == 0) System.out.printf("%s", "|");
				System.out.printf("%2.1f", matrix1[r][c]);
				if (c == 2) System.out.printf("%s", "|");
				
				if (r == 1 && c == 2) {
					System.out.printf("%2s", " + ");
				} else {
					System.out.printf("%3s", "  ");
				}
			}
			
			//display matrix2
			for (int c = 0; c < matrix2[0].length; c++) {
				if (c == 0) System.out.printf("%s", "|");
				System.out.printf("%2.1f", matrix2[r][c]);
				if (c == 2) System.out.printf("%s", "|");
				
				if (r == 1 && c == 2) {
					System.out.printf("%2s", " = ");
				} else {
					System.out.printf("%3s", "  ");
				}
			}
			
			//display matrix3
			for (int c = 0; c < matrix3[0].length; c++) {
				if (c == 0) System.out.printf("%s", "|");
				System.out.printf("%2.1f", matrix3[r][c]);
				if (c == 2) System.out.printf("%s", "|");
				System.out.printf("%2s", "  ");
			}
			
			System.out.println();
		}
		
	}
	
	// add the matrices
	public static double[][] addMatrix(double [][] a, double [][] b) {
		double [][] array = new double[3][3];
		
		for (int r = 0; r < array.length; r++) {
			for (int c = 0; c < array[0].length; c++) {
				array[r][c] = a[r][c] + b[r][c];
			}
		}
		
		return array;
	}

}
