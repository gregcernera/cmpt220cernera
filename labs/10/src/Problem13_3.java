import java.util.ArrayList;
import java.util.Random;

public class Problem13_3 {

	// FINISHED
	// (Sort ArrayList)
	public static void main(String[] args) {
		Random random = new Random();
		ArrayList<Number> numbers = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			numbers.add(random.nextInt(100));
		}
		
		System.out.println("Numbers before sorting...");
		System.out.println(numbers);
		System.out.println();
		System.out.println("Numbers after sorting...");
		sort(numbers);
		System.out.println(numbers);
		

	}
	
	public static void sort(ArrayList<Number> list) {
		
		for (int i = 0; i < list.size(); i++) {
			Number min = list.get(i);
			int index = i;
			
			for (int j = i+1; j < list.size(); j++) {
				if (list.get(j).doubleValue() < min.doubleValue()) {
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
