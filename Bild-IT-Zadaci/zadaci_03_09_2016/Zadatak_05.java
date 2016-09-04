
package zadaci_03_09_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/** Method generates random name. */
	public static String randName() {
		// create new string
		String name = new String();
		// all vowels in list
		char[] vowel = new char[] {'a', 'e', 'i', 'o', 'u'};
		// length of the name between 4 and 10 characters
		int len = 2 + (int)(Math.random() * 3);
		// add first letter as upper-case
		name += Character.toUpperCase((char)('a' + Math.random() * ('z' - 'a')));
		for (int i = 0; i < len; i++) {
			// add one non vowel and one vowel character
			name += (char)('a' + Math.random() * ('z' - 'a'));
			name += vowel[(int)(Math.random() * vowel.length)];
		}
		return name;
	}
	public static void main(String[] args) {
		System.out.println("Creating english course and adding students: ");
		// create English course
		Course engCourse = new Course("English Class");
		// add couple of students
		for (int i = 0; i < 10; i++) {
			// get random name and add it to the course
			String name = randName();
			engCourse.addStudent(name);
			System.out.println("\tAdded student: " + name);
		}
		System.out.println("Cloned course and students names are:");
		// clone course and print all students names
		Course clone = (Course)(engCourse).clone();
		for (String name : clone.getStudents()) {
			// print only if neme is not null
			if (name != null) {
				System.out.println("\tName: " + name);
			}
		}
		
		
	}
}

class Course implements Cloneable {
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
	// implement comparable method
	@Override
    protected Object clone()  {
		// create brand new stack
        Course newCourse = null;
        // cry to clone
        try {
            newCourse = (Course) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // set list to the new stack and retrieve it
        newCourse.students = this.students.clone();
        newCourse.courseName = new String(this.courseName);
        return newCourse;
    }
}