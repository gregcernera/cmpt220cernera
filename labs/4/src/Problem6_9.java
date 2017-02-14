
public class Problem6_9 {

	// DONE
	// (Conversions between feet and meters)
	public static void main(String[] args) {
		System.out.println("Feet\tMeters\t\t |\tMeters\t\t  Feet");
		System.out.println("_________________________|______________________________");
		
		for (double i = 1., j = 20.; i <= 10; i++, j += 5) {
			System.out.printf("%.1f\t %.3f\t\t |\t %.1f\t\t %.3f\n", i, footToMeter(i), j, meterToFoot(j));
		}

	}
	
	// Convert from feet to meters
	public static double footToMeter(double foot) {
		return 0.305 * foot;
	}
	
	// Convert from meters to feet
	public static double meterToFoot(double meter) {
		return 3.279 * meter;
	}
	
	

}
