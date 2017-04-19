
public class Problem13_11 {

	// FINISHED
	// (The Octagon class)
	// UML
	public static void main(String[] args) {
		Octagon octagon1 = new Octagon(5);
		System.out.println("octagon1 area = " + octagon1.getArea());
		System.out.println("octagon1 perimeter = " + octagon1.getPerimeter());
		System.out.println("Cloning...");
		
		
		Octagon octagon2 = (Octagon)octagon1.clone();
		
		System.out.println("compareTo method: " + (octagon1.compareTo(octagon2) == 0));
		System.out.println("equals method: " + octagon1.equals(octagon2));
		
	}

}

class Octagon extends GeometricObject implements Cloneable {
	
	private double side;
	
	public Octagon() {
		this(2);
	}
	
	public Octagon(double side) {
		this.side = side;
	}
	
	@Override
	public double getArea() {
		return ( (2 + (4 / Math.sqrt(2))) * side * side);
	}
	
	@Override
	public double getPerimeter() {
		return side * 8;
	}
	
	public Object clone() {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return object;
	}
	
	public boolean equals(Object object) {
		return object instanceof Octagon && getArea() == ((Octagon) object).getArea();
	}
}


