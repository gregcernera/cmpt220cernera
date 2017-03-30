package week9;

public class TestException {

	static Double refVar;
	
	public static void main(String[] args) {
		// Bad
		try {
			System.out.println(refVar.toString());
		} catch (NullPointerException ex) {
			System.out.println("refVar is null");
		}
		
		// Good
		if (refVar != null) {
			System.out.println(refVar.toString());
		} else {
			System.out.println("refVar is null");
		}

	}

}
