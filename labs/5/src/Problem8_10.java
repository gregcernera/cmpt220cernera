
public class Problem8_10 {

	// FINISHED
	// (Largest row and column)
	public static void main(String[] args) {
		int [][] matrix = new int[4][4];
		for (int r = 0; r< matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				matrix[r][c] = (int)(Math.random() + 0.5);
			}
		}
		
		for (int r = 0; r< matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				System.out.print(matrix[r][c] + " ");
				if (c == 3) {
					System.out.println();
				}
			}
		}
		
		System.out.println("The largest row index: " + largestRow(matrix));
		System.out.println("The largest column index: " + largestColumn(matrix));
	}

	public static int largestRow(int [][] array) {
		int largestRow = 0;
		int maxOnes = 0;
		int numberOfOnes = 0;
		
		for (int r = 0; r < array.length; r++) {
			for (int c = 0; c < array[0].length; c++) {
				
				if (array[r][c] == 1) {
					numberOfOnes++;
				}
				
				if (c == 3) {
					if (numberOfOnes > maxOnes) {
						maxOnes = numberOfOnes;
						largestRow = r;
					}
					numberOfOnes = 0;
				}
			}
		}
		return largestRow;
	}
	
	public static int largestColumn(int [][] array) {
		int largestColumn = 0;
		int maxOnes = 0;
		int numberOfOnes = 0;
		
		for (int c = 0; c < array[0].length; c++) {
			for (int r = 0; r < array.length; r++) {
				
				if (array[r][c] == 1) numberOfOnes++;
				if (r == 3) {
					if (numberOfOnes > maxOnes) {
						maxOnes = numberOfOnes;
						largestColumn = c;
					}
					numberOfOnes = 0;
				}
			}
		}
		return largestColumn;
	}
}
