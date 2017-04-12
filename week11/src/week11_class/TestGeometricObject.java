package week11_class;

import week11_class.Circle;
import week11_class.GeometricObject;
import week11_class.Rectangle;

public class TestGeometricObject {
	
	public static void main(String[] args) {
		GeometricObject geoObject1 = new Circle(5);
		GeometricObject geoObject2 = new Rectangle(5, 3);
		
		System.out.println("The two objects have the same area? " + 
				equalArea(geoObject1, geoObject2));
	}

	private static boolean equalArea(GeometricObject geoObject1, GeometricObject geoObject2) {
		if (geoObject1.getArea() == geoObject2.getArea()) {
			return true;
		}
		return false;
	}
	

}
