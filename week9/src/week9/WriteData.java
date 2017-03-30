package week9;

public class WriteData {

	public static void main(String[] args) throws java.io.IOException {
		java.io.File file = new java.io.File("scores.txt");
		if (file.exists()) {
			System.out.println("file already exists");
			System.exit(0);
		}
		
		// Create a File
		try (java.io.PrintWriter output = new java.io.PrintWriter(file);) {
			// write formatted output to the file 
			output.print("John T Smith ");
			output.println(90);
			output.print("Eric K Jones ");
			output.print(85);
		}
		
		
		
		
		// Close the file
		//output.close();

	}

}
