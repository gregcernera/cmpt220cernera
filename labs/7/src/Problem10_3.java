
public class Problem10_3 {

	// FINISHED
	// (The MyInteger class)
	// UML
	public static void main(String[] args) {
		MyInteger m1 = new MyInteger(3);
		MyInteger m2 = new MyInteger(16);
		MyInteger m3 = new MyInteger(3);
		
		System.out.printf("Num 1 = %d isEven = %b, isOdd = %b, isPrime = %b \n", m1.getValue(),
				m1.isEven(), m1.isOdd(), m1.isPrime());
		System.out.printf("Num 2 = %d isEven = %b, isOdd = %b, isPrime = %b \n", m2.getValue(),
				m2.isEven(), m2.isOdd(), m2.isPrime());
		System.out.printf("Num 3 = %d isEven = %b, isOdd = %b, isPrime = %b \n", m3.getValue(),
				m3.isEven(), m3.isOdd(), m3.isPrime());
		
		System.out.println("Num 1 = Num 2 is " + m1.equals(m2));
		System.out.println("Num 1 = Num 3 is " + m1.equals(m3));
		
		System.out.println("Parse int 10 string = " + MyInteger.parseInt("10"));
		System.out.println("Parse int 30 char array = " + MyInteger.parseInt("30".toCharArray()));
	}

}

class MyInteger {
	private int value;
	
	MyInteger(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isEven() {
		if (value % 2 == 0) return true;
		return false;
	}
	
	public boolean isOdd() {
		if (value % 2 == 0) return false;
		return true;
	}
	
	public boolean isPrime() {
		for (int i = 2; i < value; i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isEven(int value) {
		if (value % 2 == 0) return true;
		return false;
	}
	
	public static boolean isOdd(int value) {
		if (value % 2 == 0) return false;
		return true;
	}
	
	public static boolean isPrime(int value) {
		for (int i = 2; i < value; i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isEven(MyInteger myinteger) {
		return myinteger.isEven();
	}
	
	public static boolean isOdd(MyInteger myinteger) {
		return myinteger.isOdd();
	}
	
	public static boolean isPrume(MyInteger myinteger) {
		return myinteger.isPrime();
	}
	
	public boolean equals(int value) {
		if (this.value == value) return true;
		return false;
	}
	
	public boolean equals(MyInteger myinteger) {
		if (this.value == myinteger.value) return true;
		return false;
	}
	
	public static int parseInt(char[] value) {
		
		double newValue = 0;
		int pow = value.length - 1;
		
		for (char val: value) {
			newValue = newValue + Math.pow(10, pow--) * (val - '0');
		}
		
		return (int)newValue;
	}
	
	public static int parseInt(String value) {
		return MyInteger.parseInt(value.toCharArray());
	}
	
	
	
}
