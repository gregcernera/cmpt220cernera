
public class Problem10_9 {

	// FINISHED
	// (The Course class)
	public static void main(String[] args) {
		
		Course course = new Course("Comp Sci");
		String [] students = course.getStudents();
		
		course.addStudent("Greg");
		course.addStudent("Tom");
		course.addStudent("Bob");
		
		course.dropStudent("Greg");
		
		System.out.println("The students in the course are: ");
		for (int i = 0; i < course.getNumberOfStudents(); i++) {
			System.out.println(students[i]);
		}
	}
}

class Course {
	private String courseName;
	private String [] students = new String[100];
	private int numberOfStudents;
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	public void addStudent(String student) {
		if (numberOfStudents >= students.length) {
			String [] x = new String[students.length + 1];
			students = x;
		}
		students[numberOfStudents++] = student;
	}
	
	public String [] getStudents() {
		return students;
	}
	
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void dropStudent(String student) {
		
		for (int i = 0; i < students.length; i++) {
			if (student.equals(students[i])) {
				
				students[i] = "";
				numberOfStudents--;
				
				while (i < numberOfStudents) {
					students[i] = students[i + 1];
					i++;
				}
				break;
			}
		}
		
	}
	
	public void clear() {
		students = new String[1];
		numberOfStudents = 0;
	}
}
