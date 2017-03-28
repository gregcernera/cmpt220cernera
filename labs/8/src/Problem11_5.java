import java.util.ArrayList;

public class Problem11_5 {

	// FINISHED
	// (The Course class)
	// UML
	public static void main(String[] args) {
		
		Course course = new Course("Software Development");
		course.addStudent("Greg");
		course.addStudent("Bob");
		course.addStudent("Tom");
		course.dropStudent("Greg");
		
		course.clear();

	}

}

class Course {
	private String courseName;
	ArrayList<String> students = new ArrayList<>();
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	public void addStudent(String student) {
		students.add(student);
	}
	
	public String [] getStudents() {
		return students.toArray(new String[students.size()]);
	}
	
	public int getNumberOfStudents() {
		return students.size();
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void dropStudent(String student) {
		students.remove(student);
	}
	
	public void clear() {
		students.clear();
	}
}