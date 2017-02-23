
public class TestSimpleCircle {

	public static void main(String[] args) {
		// create a circle with radius 1
		SimpleCircle circle1 = new SimpleCircle();
		System.out.println("The area of the circle of raidus " + circle1.radius + " is " + circle1.getArea());
		
		// create a circle with the radius of 25
		SimpleCircle circle2 = new SimpleCircle(25);
		System.out.println("The area of the circle of raidus " + circle2.radius + " is " + circle2.getArea());

		circle2.radius = 100;
		System.out.println("The area of the circle of raidus " + circle2.radius + " is " + circle2.getArea());
	}
	
}
	
class SimpleCircle {
	double radius;
	
	// construct a circle with radius 1
	SimpleCircle() {
		radius = 1;
	}
	
	// construct a circle with a specified radius
	SimpleCircle(double newRadius) {
		radius = newRadius;
	}
	
	// return the are for this circle
	double getArea() {
		return radius * radius * Math.PI;
	}
	
	//set the radius for this circle 
	void setRadius(double newRadius) {
		radius = newRadius;
	}
}


