package week8;

public class PolymorphismDemo2 {

	public static void main(String[] args) {
		m(new GraduateStudent());
		m(new Student());
		m(new Person2());
		m(new Object());

	}
	
	public static void m(Object x) {
		System.out.println(x.toString());
	}

}

class GraduateStudent extends Student {	
}

class Student extends Person2 {
	public String toString() {
		return "student";
	}
}

class Person2 extends Object {
	public String toString() {
		return "person";
	}
}
