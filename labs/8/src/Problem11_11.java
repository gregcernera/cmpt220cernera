import java.util.ArrayList;
import java.util.Scanner;

public class Problem11_11 {

	// FINISHED
	// (Sort ArrayList)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<>();
		
		System.out.print("Enter 5 integers (separated by spaces): ");
		numbers.add(input.nextInt());
		numbers.add(input.nextInt());
		numbers.add(input.nextInt());
		numbers.add(input.nextInt());
		numbers.add(input.nextInt());
		input.close();
		
		sort(numbers);
		
		System.out.println("The sorted array list is " + numbers);
		

	}
	
	public static void sort(ArrayList<Integer> list) {
		int min, index;
		
		for (int i = 0; i < list.size() - 1; i++) {
            
			min = list.get(i);
            index = i;

            for (int j = i + 1; j < list.size(); j++) {
            	
                if (list.get(j) < min) {
                    min = list.get(j);
                    index = j;
                }
            }

            if (index != i) {
                list.set(index, list.get(i));
                list.set(i, min);
            }
        }
	}

}
