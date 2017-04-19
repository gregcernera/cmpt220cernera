
public class Problem13_9 {

	// FINISHED
	// (Enable Circle Comparable)
	// UML
	public static void main(String[] args) {
		
		Circle2D [] list = new Circle2D[3];
		list[0] = new Circle2D(0,0,3);
		list[1] = new Circle2D(0,0,3);
		list[2] = new Circle2D(0,0,7);

		for (int i = 0; i < list.length; i++) {
			System.out.println("Circle #" + (i+1) + "'s area is " + list[i].getArea());
		}
		
		System.out.println("Circle1.equals(Circle2)? " + list[0].equals(list[1]));
		System.out.println("Circle2.equals(Circle3)? " + list[1].equals(list[2]));
	}
	
}
