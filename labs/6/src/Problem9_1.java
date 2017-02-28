
public class Problem9_1 {

	// FINISHED
	// (The Rectangle Class)
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(4, 40);
		Rectangle r2 = new Rectangle(3.5, 35.9);
		
		display(r1);
		display(r2);
	}
	
	public static void display(Rectangle r) {
		System.out.println("For this rectangle:");
		System.out.println("The width is " + r.width);
		System.out.println("The height is " + r.height);
		System.out.printf("%s %.2f %s", "The area is ", r.getArea(), "\n");
		System.out.printf("%s %.2f %s", "The perimeter is ", r.getPerimeter(), "\n\n");
	}

}

class Rectangle {
	double width, height;
	
	// a no-arg constructor that creates a default rectangle
	Rectangle() {
		width = 1;
		height = 1;
	}
	
	// a constructor that creates a rectangle with the specified
	// width and height
	Rectangle(double newWidth, double newHeight) {
		width = newWidth;
		height = newHeight;
	}
	
	// a method that returns the area of this rectangle
	public double getArea() {
		return width * height;
	}
	
	// a method that returns the perimeter
	public double getPerimeter() {
		return (2 * width) + (2 * height);
	}
}
