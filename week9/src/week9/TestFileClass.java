package week9;

import java.util.Date;

public class TestFileClass {

	public static void main(String[] args) {
		java.io.File file = new java.io.File("image/die1.png");
		System.out.println("Does it exist? " + file.exists());
		System.out.println("The file is " + file.length() + " bytes");
		System.out.println("Can it be read? " + file.canRead());
		System.out.println("Can it be written? " + file.canWrite());
		System.out.println("Is it a directory? " + file.isDirectory());
		System.out.println("Is it a file? " + file.isFile());
		System.out.println("Is it absolute>? " + file.isAbsolute());
		System.out.println("Is it hidden? " + file.isHidden());
		System.out.println("Absolute path is " + file.getAbsolutePath());
		System.out.println("Last modified on " + new Date(file.lastModified()));

	}

}
