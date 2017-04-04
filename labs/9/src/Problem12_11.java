import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Problem12_11 {

	// FINISHED
	// (Remove text)
	// used ReplaceText java file for reference
	public static void main(String[] args) {
		 
		if (args.length != 2) {
            System.out.println("Error: invalid arguments. The arguments entered do not exist.");
            System.out.println("Usage: java Problem12_11 word ''file''");
            System.exit(1);
        }

        
        File file = new File(args[1]);
        if (!file.exists()) 
            System.out.println(args[1] + " could not be found.");
        

        // read all text from the file
        String string  = "";
        try {
            Scanner input = new Scanner(file);
            
            while (input.hasNext()) {
                string += input.nextLine();
            }
            input.close();
            
        } catch (FileNotFoundException e) {
        	System.out.println("File unidentified. Could not be found.");
        }
        
        // remove word from text
        string = string.replaceAll(args[0], "");
        
        // write the text back in the file
        try {
            PrintWriter output = new PrintWriter(file);
            System.out.println(string);
            output.write(string);
            output.close();
        } catch (FileNotFoundException e) {
        	System.out.println("File unidentified. Could not be found.");
        }

        System.out.println("Done.");

	}

}
