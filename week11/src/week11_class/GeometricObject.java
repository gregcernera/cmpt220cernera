package week11_class;

public abstract class GeometricObject {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	protected GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	

}
