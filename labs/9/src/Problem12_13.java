import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem12_13 {

	// FINISHED
	// (Count characters, words, and lines in a file)
	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.out.println("Error: invalid arguments. The arguments entered do not exist.");
            System.out.println("Usage: java Problem12_31 file");
            System.exit(1);
		}
		
		File file = new File(args[0]);
		if (!file.exists()) 
            System.out.println(args[0] + " could not be found.");
		
		String string  = "";
		int lineCount = 0;
        try {
            Scanner input = new Scanner(file);
            
            while (input.hasNext()) {
                string += input.nextLine();
                lineCount++;
            }
            input.close();
            
        } catch (FileNotFoundException e) {
        	System.out.println("File unidentified. Could not be found.");
        }
        
        int charCount = 0;
        int wordCount = 1;
        
        
    	for (char c : string.toCharArray()) {
        	charCount++;
        	if (c == ' ') {
        		wordCount++;
        	}
        }
        
        System.out.println("File " + args[0] + " has");
        System.out.println(charCount + " characters");
        System.out.println(wordCount + " words");
        System.out.println(lineCount + " lines");
  
        
        

	}

}
