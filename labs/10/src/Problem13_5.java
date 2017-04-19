
public class Problem13_5 {

	// FINISHED
	// (Enable GeometricObject comparable)
	// UML
	public static void main(String[] args) {
		
		Circle2D circle1 = new Circle2D(0, 0, 3);
		Circle2D circle2 = new Circle2D(0, 0, 10);
		Circle2D maxCircle = (Circle2D) GeometricObject.max(circle1, circle2);
		
		Rectangle rectangle1 = new Rectangle(1, 10);
		Rectangle rectangle2 = new Rectangle(5, 10);
		Rectangle maxRectangle = (Rectangle) GeometricObject.max(rectangle1, rectangle2);
		
		
		System.out.println("Circle 1 = " + circle1);
		System.out.println("Circle 2 = " + circle2);
		System.out.println("Max circle = " + maxCircle);
		System.out.println();
		System.out.println("Rectangle 1 = " + rectangle1);
		System.out.println("Rectangle 2 = " + rectangle2);
		System.out.println("Max rectangle = " + maxRectangle);
		

	}
	
}


class Rectangle extends GeometricObject implements Comparable<GeometricObject> {
	private double width, height;
	
	// a no-arg constructor that creates a default rectangle
	public Rectangle() {
		width = 1;
		height = 1;
	}
	
	// a constructor that creates a rectangle with the specified
	// width and height
	public Rectangle(double newWidth, double newHeight) {
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

	
	
	@Override
	public String toString() {
		return "[ width = " + width + ", height = " + height + "]";
	}
}


class Circle2D extends GeometricObject implements Comparable<GeometricObject> {
	private double x, y;
	private double radius;
	
	public Circle2D() {
		x = 0;
		y = 0;
		radius = 1;
	}
	
	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	public boolean contains(double x, double y) {
		boolean xFlag = false;
		boolean yFlag = false;
		
		if (x < (this.x + radius) && x > (this.x - radius)) xFlag = true;
		if (y < (this.y + radius) && y > (this.y - radius)) yFlag = true;
		
		if (xFlag && yFlag) return true;
		return false;
	}
	
	public boolean contains(Circle2D circle) {
		
		double distance = Math.sqrt( Math.pow((circle.x - this.x), 2) + Math.pow((circle.y - this.y), 2));
		
		if (distance <= (this.radius - circle.getRadius())) return true;
		else return false;
		
	}
	
	public boolean overlaps(Circle2D circle) {
		double distance = Math.sqrt( Math.pow((circle.x - this.x), 2) + Math.pow((circle.y - this.y), 2));	
		
		if (distance <= this.radius + circle.getRadius()) return true;
		else return false;
	}

	
	
	@Override
	public String toString() {
		return "[ x = " + x + ", y = " + y + ", radius = " + radius + "]";
	}
	
	
	public boolean equals(Circle2D circle) {
		return this.radius == circle.getRadius();
	}
}