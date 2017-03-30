package week9;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceText {

	public static void main(String[] args) throws Exception {
		// check command line parameters
		if (args.length != 4) {
			System.out.println("Usage: java ReplaceText sourceFile targetFile oldStr newstr");
			System.exit(1);
		}
		
		// Check if source file exists
		File sourceFile = new File(args[0]);
		if (!sourceFile.exists()) {
			System.out.println("Source file " + args[0] + " does not exist");
			System.exit(2);
		}
		
		// check if target file exists
		File targetFile = new File(args[1]);
		if (targetFile.exists()) {
			System.out.println("target file " + args[1] + " already exists");
			System.exit(3);
		}
		
		try (
			// create input and output files
			Scanner input = new Scanner(sourceFile);
			PrintWriter output = new PrintWriter(targetFile);
			
		) {
			while (input.hasNext()) {
				String s1 = input.nextLine();
				String s2 = s1.replaceAll(args[2], args[3]);
				output.println(s2);
			}
		}

	}

}
