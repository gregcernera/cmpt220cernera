package week11_class;

import week11_class.GeometricObject;

public class Circle extends GeometricObject {
	private double radius;
	
	public Circle() {
		
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	
	@Override
	public double getArea() {
		return radius * radius * Math.PI;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double getPerimeter() {
		return 0.;
	}
}
