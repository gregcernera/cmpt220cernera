
public class Problem10_11 {

	// FINISHED
	// (Geometry: the Circle2D class)
	// UML
	public static void main(String[] args) {
		
		Circle2D c1 = new Circle2D(2, 2, 5.5);
		System.out.println("Area = " + c1.getArea());
		System.out.println("Perimeter = " + c1.getPerimeter());
		System.out.println("c1.contains(3,3) is " + c1.contains(3, 3));
		System.out.println("c1.contains(new Circle2D(4, 5, 10.5) is " + 
				c1.contains(new Circle2D(4, 5, 10.5)));
		System.out.println("c1.overlaps(new Circle2D(3, 5, 2.3)) is " + 
				c1.overlaps(new Circle2D(3, 5, 2.3)));
		

	}

}

class Circle2D {
	private double x, y;
	private double radius;
	
	Circle2D() {
		x = 0;
		y = 0;
		radius = 1;
	}
	
	Circle2D(double x, double y, double radius) {
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
}
