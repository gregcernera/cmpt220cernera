
public class Problem12_5 {

	// FINISHED
	// (IllegalTriangleException)
	public static void main(String[] args) {
		
		Triangle triangle;
		try {
			triangle = new Triangle(4, 3, 200);
		} catch (IllegalTriangleException e) {
			System.out.println("The numbers entered to not create a valid triangle.");
			e.printStackTrace();
		}

	}

}

class IllegalTriangleException extends IllegalArgumentException {
	private double side1;
	private double side2;
	private double side3;
	
	public IllegalTriangleException(double side1, double side2, double side3) {
		super(side1 + " " + side2 + " & " + side3 + " do not make a real triangle.");
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}
}

class Triangle extends GeometricObject {
	private double side1, side2, side3;
	
	public Triangle () {
		this.side1 = 1;
		this.side2 = 1;
		this.side3 = 1;
	}
	
	public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		checkTriangle();
	}
	
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}
	
	public void setSide1(double side) throws IllegalTriangleException {
		this.side1 = side;
		checkTriangle();
	}
	
	public void setSide2(double side) throws IllegalTriangleException {
		this.side2 = side;
		checkTriangle();
	}
	
	public void setSide3(double side) throws IllegalTriangleException {
		this.side3 = side;
		checkTriangle();
	}
	
	public double getArea() {
		double s = (side1 + side2 + side3) / 2;
		return Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
	}
	
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	@Override
	public String toString() {
		return "Triangle: side1 = " + side1 + " side2 = " + side2 +
				" side3 = " + side3;
	}
	
	public static boolean isTriangle(double side1, double side2, double side3) throws IllegalTriangleException {
		if ( (side1 + side2 > side3) &&
			 (side2 + side3 > side1) &&
			 (side1 + side3 > side2)) {
			return true;
		}
		return false;
	}
	
	private void checkTriangle() {
		if (!isTriangle(side1,side2,side3)) {
			throw new IllegalTriangleException(side1,side2,side3);
		}
	}
}

class GeometricObject {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	public GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	public GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.setColor(color);
		this.setFilled(filled);
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	public String toString() {
		return "created on" + dateCreated + "\ncolor: " + color + " and filled: " + filled;
	}

}
