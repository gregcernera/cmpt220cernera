import java.util.Scanner;

public class Problem9_11 {

	// FINISHED
	// (Algebra: 2x2 linear equations)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter numbers for a,b,c,d,e,f (separated by spaces): ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double d = input.nextDouble();
		double e = input.nextDouble();
		double f = input.nextDouble();
		input.close();
		
		LinearEquation equation = new LinearEquation(a,b,c,d,e,f);
		
		if (equation.isSolvable() == true) {
			System.out.println("x = " + equation.getX());
			System.out.println("y = " + equation.getY());
		} else {
			System.out.println("The equation has no solution");
		}

	}

}

class LinearEquation {
	double a,b,c,d,e,f;
	
	LinearEquation(double newA, double newB, double newC, 
			       double newD, double newE, double newF) {
		a = newA;
		b = newB;
		c = newC;
		d = newD;
		e = newE;
		f = newF;
		
	}
	
	double getA(){
		return a;
	}
	
	double getB() {
		return b;
	}
	
	double getC() {
		return c;
	}
	
	double getD() {
		return d;
	}
	
	double getE() {
		return e;
	}
	
	double getF() {
		return f;
	}
	
	boolean isSolvable() {
		if ( ( (a*d) - (b*c) ) == 0 ) {
			return false;
		} else {
			return true;
		}
	}
	
	double getX() {
		return ( (e*d) - (b*f) ) / ( (a*d) - (b*c) );
	}
	
	double getY() {
		return ( (a*f) - (e*c) ) / ( (a*d) - (b*c) );
	}
	
	
}