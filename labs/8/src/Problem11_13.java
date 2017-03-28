import java.util.ArrayList;
import java.util.Scanner;

public class Problem11_13 {

	// FINISHED
	// (Remove duplicates)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<>();
		
		System.out.print("Enter ten integers: ");
		for (int i = 0; i < 10; i++) {
			numbers.add(input.nextInt());
		}
		input.close();
		
		removeDuplicate(numbers);
		
		System.out.println("The distinct integers are " + numbers);

	}
	
	public static void removeDuplicate(ArrayList<Integer> list) {
		
		ArrayList<Integer> num = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			if (num.contains(list.get(i)) == false) {
				num.add(list.get(i));
			}
		}
		list.clear();
		list.addAll(num);
		
	}

}
