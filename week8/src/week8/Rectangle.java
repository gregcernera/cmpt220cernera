package week8;

public class Rectangle extends GeometricObject {
	private double width, height;
	
	public Rectangle(){
		
	}
	
	public Rectangle(double width, double height) {
		this.setWidth(width);
		this.setHeight(height);
	}
	
	public Rectangle(double width, double height, String color, boolean filled) {
		this.setWidth(width);
		this.setHeight(height);
		setColor(color);
		setFilled(filled);
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getArea() {
		return height * width;
	}
	
	public double getPerimeter() {
		return width + width + height + height;
	}

	
	
	

}
