
public class Problem10_23 {

	// 
	// (Implement the String class)
	public static void main(String[] args) {
		
		MyString2 s1 = new MyString2("hello");
		MyString2 s2 = new MyString2("softwaredevelopment");
		
		// keep getting null exceptions
		System.out.println("(compare method): s1.compare(''helloworld'') = " + s1.compare("hello"));

		System.out.println("(substring method): s2.substring(10) = ");
		output(s2.substring(10));

		System.out.println("(toUpperCase method): s1.toUpperCase() = ");
		output(s1.toUpperCase());

		System.out.println("(valueOf method): MyString2.valueOf(true) = ");
		output(MyString2.valueOf(true));
		
	}
	
	
	public static void output(MyString2 s) {
		output(s.toChars());
		System.out.println();
	}
	
	public static void output(char [] c) {
		for (int i = 0; i < c.length; i ++) {
			System.out.print(c[i]);
		}
	}
	
}

class MyString2 {
	
	private String s;
	
	public MyString2(String s) {
		for (int i = 0; i < s.length(); i++) {
			this.s += s.charAt(i);
		}
		
	}
	
	public int compare(String s) {
		int x = 0;
		if (this.s.length() < s.length()) x = -1; 
		if (this.s.length() > s.length()) x = 1;

		for (int i = 0; i < this.s.length(); i++) {
			if (this.s.charAt(i) < s.charAt(i)) x = -(i + 1); // JA: This can give you an out of bounds error
			if (this.s.charAt(i) > s.charAt(i)) x = i + 1;
		}
		return x;

	}
	
	public MyString2 substring(int begin) {
		String str = "";
		
		for (int i = begin; i < s.length(); i++) {
			str += s.charAt(i) + "";
		}
		return new MyString2(str);
	}

	public MyString2 toUpperCase() {
		String str = "";
		
		for (int i = 0; i < s.length(); i++) {
			
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
				str += String.valueOf((char)(s.charAt(i) - 32));
			else
				str += String.valueOf(s.charAt(i));
		}
		
		return new MyString2(str);
	}

	
	public char[] toChars() {
		char [] c = new char[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			c[i] = s.charAt(i);
		}
		return c;
	}

	public static MyString2 valueOf(boolean b) {
		
		if (b) return new MyString2("true");
		else return new MyString2("false");
	}
}
