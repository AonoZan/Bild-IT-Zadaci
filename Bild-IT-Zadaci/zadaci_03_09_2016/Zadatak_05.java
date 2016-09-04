
package zadaci_03_09_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	public static void main(String[] args) {
	}
}

class Course {
	private String courseName;
	private String[] students = new String[100];
	private int numberOfStudents;

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public void addStudent(String student) {
		students[numberOfStudents] = student;
		numberOfStudents++;
	}

	public String[] getStudents() {
		return students;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public String getCourseName() {
		return courseName;
	}

	public void dropStudent(String student) {
		// Left as an exercise in Programming Exercise 10.9
	}
}