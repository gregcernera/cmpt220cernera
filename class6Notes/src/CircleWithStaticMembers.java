
public class CircleWithStaticMembers {

	/** the radius of the cirlce */
	double radius;
	
	/** the number of objects created */
	static int numberOfObjects = 0;
	
	/** construct a cricle with radius 1*/
	CircleWithStaticMembers() {
		radius = 1.0;
		numberOfObjects++;
	}
	
	/** Construct a circle with a specified radius */
	CircleWithStaticMembers(double newRadius) {
		radius = newRadius;
		numberOfObjects++;
	}
	
	/** Return numberOfObjects */
	int getNumberOfObjects() {
		return numberOfObjects;
	}
}
