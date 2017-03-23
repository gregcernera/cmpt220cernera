package week8;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListToArray {

	public static void main(String[] args) {
		String [] array = {"red", "green", "blue"};
		
		System.out.println(java.util.Collections.max(new ArrayList<>(Arrays.asList(array))));
		System.out.println(java.util.Collections.min(new ArrayList<>(Arrays.asList(array))));
		
		ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
		
		String [] array1 = new String[list.size()];
		list.toArray(array1);
		
		Integer [] array2 = {3, 4, 95, 4, 15, 34, 3, 6, 5};
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(array2));
		

	}

}
