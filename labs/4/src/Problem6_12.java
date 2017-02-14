
public class Problem6_12 {

	// DONE
	// (Display characters)
	public static void main(String[] args) {
		printChars('1', 'Z', 10);

	}
	
	public static void printChars(char ch1, char ch2, int numberPerLine) {
		for (int i = 1; ch1 <= ch2; i++) {
			System.out.print(ch1 + " ");
			if (i % numberPerLine == 0)
				System.out.println();
			ch1++;
		}
	}

}
