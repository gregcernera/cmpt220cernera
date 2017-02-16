import java.util.Arrays;

public class ArraysDemo {

	// week 5
	public static void main(String[] args) {
		double [] numbers = {6.0, 4.4, 1.9, 2.9, 3.4, 3.5};
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		
		char [] chars = {'a', 'A', '4', 'F', 'D', 'P'};
		Arrays.sort(chars, 1, 3);
		System.out.println(Arrays.toString(chars));

		int [] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 70, 79};
		System.out.println(Arrays.binarySearch(list, 11));
		
		int [] list1 = {2, 4, 7, 10};
		int [] list2 = {2, 4, 7, 10};
		int [] list3 = {4, 2, 7, 10};
		System.out.println(Arrays.equals(list1, list2));
		System.out.println(Arrays.equals(list2, list3));
		
		Arrays.fill(list1, 5);
		System.out.println(Arrays.toString(list1));
		

	}

}
