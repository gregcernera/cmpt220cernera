
public class Problem13_7 {

	// FINISHED	
	// (The Colorable Interface)
	// UML
	public static void main(String[] args) {
		
		GeometricObject [] list = new GeometricObject[5];
		list[0] = new Square();
		list[1] = new Circle2D();
		list[2] = new Rectangle();
		list[3] = new Square(0, 0, 5);
		list[4] = new Rectangle(3,6);
		
		for (int i = 0; i < list.length; i++) {
			System.out.println("Geo shape " + (i+1) + ": area = " + list[i].getArea());
			if (list[i] instanceof Colorable) {
				System.out.println(((Colorable)list[i]).howToColor());
			}
		}

	}

}

interface Colorable {
	String howToColor();
}

class Square extends GeometricObject implements Colorable {
	
	private double x;
	private double y;
	private double side;
	
	public Square() {
		this(0,0,10);
	}
	
	public Square(double x, double y, double side) {
		this.x = x;
		this.y = y;
		this.side = side;
	}
	
	@Override
	public double getArea() {
		return side * side;
	}
	
	@Override
	public double getPerimeter() {
		return 4 * side;
	}
	
	@Override
	public String howToColor() {
		return "Color all four sides";
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getSide() {
		return side;
	}
	
	public void setSide(double side) {
		this.side = side;
	}
}
