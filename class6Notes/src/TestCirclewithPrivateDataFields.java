
public class TestCirclewithPrivateDataFields {

	public static void main(String[] args) {
		CircleWithPrivateDataFields myCircle = new CircleWithPrivateDataFields(5.0);
		System.out.println("The area of the cirlce of radius " + myCircle.getRadius() + " is " + myCircle.getArea());
		
		// increase myCirlce's radius by 10%
		myCircle.setRadius(myCircle.getRadius() * 1.1);
		System.out.println("The area of the cirlce of radius " + myCircle.getRadius() + " is " + myCircle.getArea());

	}

}
