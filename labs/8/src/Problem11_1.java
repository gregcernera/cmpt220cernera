import java.util.Scanner;

public class Problem11_1 {

	// FINISHED
	// (The Triangle Class)
	// UML
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the three sides of the triangle (separated by spaces): ");
		double s1 = input.nextDouble();
		double s2 = input.nextDouble();
		double s3 = input.nextDouble();
		
		System.out.print("Enter a color for the triangle: ");
		String color = input.next();
		
		System.out.print("Is the triangle filled (true or false)?");
		String stringFilled = input.next();
		boolean filled = false;
		if (stringFilled.equals("true")) 
			filled = true;
		else if (stringFilled.equals("false"))
			filled = false;
		
		input.close();
		
		Triangle triangle = new Triangle(s1, s2, s3);
		triangle.setColor(color);
		triangle.setFilled(filled);
		
		System.out.println("Area = " + triangle.getArea());
		System.out.println("Perimeter = " +  triangle.getPerimeter());
		System.out.println("Color = " + triangle.getColor());
		System.out.println("Is filled = " + triangle.isFilled());

	}

}

class Triangle extends GeometricObject {
	private double side1, side2, side3;
	
	public Triangle () {
		this.side1 = 1;
		this.side2 = 1;
		this.side3 = 1;
	}
	
	public Triangle(double side1, double side2, double side3) {
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
	
	public void setSide1(double side) {
		this.side1 = side;
	}
	
	public void setSide2(double side) {
		this.side2 = side;
	}
	
	public void setSide3(double side) {
		this.side3 = side;
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
