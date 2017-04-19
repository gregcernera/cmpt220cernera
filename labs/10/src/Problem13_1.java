import java.util.Scanner;

public class Problem13_1 {

	// FINISHED
	// (The Triangle class)
	// UML
	// the Rectangle/Triangle/GO classes used in the other problems refer back to this problem
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 3 sides for a triangle (separated by spaces): ");
		int s1 = input.nextInt();
		int s2 = input.nextInt();
		int s3 = input.nextInt();
		
		System.out.print("Enter a color: ");
		String color = input.next();
		System.out.print("Triangle is filled? (true or false): ");
		
		String filled = input.next();
		boolean flag = false;
		
		if (filled.equals("true"))
			flag = true;
		
		input.close();
		GeometricObject triangle = new Triangle(s1,s2,s3);
		triangle.setColor(color);
		triangle.setFilled(flag);
		
		System.out.println("The area is " + triangle.getArea());
		System.out.println("The perimeter is " + triangle.getPerimeter());
		System.out.println("The color is " + triangle.getColor());
		System.out.println("isFilled? " + triangle.isFilled());

	}

}

abstract class GeometricObject implements Comparable<GeometricObject> {
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
	
	public double getArea() {
		return 0;
	}
	
	public double getPerimeter() {
		return 0;
	}
	
	@Override
    public int compareTo(GeometricObject o) {
        if (this.getArea() > o.getArea())
            return 1;
        else if (this.getArea() < o.getArea())
            return -1;
        else
            return 0;
	}
	
	public static GeometricObject max(GeometricObject go1, GeometricObject go2) {
		//return (go1.compareTo(go2) >= 0) ? go1 : go2;
		
		if (go1.compareTo(go2) >= 0) {
			return go1;
		} else {
			return go2;
		}
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
	
	@Override
	public double getArea() {
		double s = (side1 + side2 + side3) / 2;
		return Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
	}
	
	@Override
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