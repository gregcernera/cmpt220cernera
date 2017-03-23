package week8;

public class CastingDemo {

	public static void main(String[] args) {
		Object object1 = new Circle(1);
		Object object2 = new Rectangle(1,1);
		
		displayObject(object1);
		displayObject(object2);

	}
	
	public static void displayObject(Object o) {
		if (o instanceof Circle) {
			System.out.println("The circle area is " +
				((Circle)o).getArea());
			System.out.println("The circle diameter is " +
				((Circle)o).getDiameter()); 
		} else if (o instanceof Rectangle) {
			System.out.println("The rectangle area is " + 
				((Rectangle)o).getArea());
			
		}
	}

}
