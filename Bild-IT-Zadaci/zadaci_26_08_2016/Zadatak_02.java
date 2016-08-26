
package zadaci_26_08_2016;

import java.util.Date;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/**Program tests several classes: Person, Student, Employee, Facility and Staff*/
	public static void main(String[] args) {
		// create person with all attributes and print it
		Person zdravko = new Person("Zdravko Mrèina", "Tunguziæi donji", "zm_ladysman15@mail.com", "053/789-987");
		System.out.println("Person:\n" + zdravko.toString());
		// create student assign status and print
		Student cvetko = new Student("Cvetko Brat", "Pribiniæi", "bukva_i_rast789@hotmail.com", "+38766/787-887");
		cvetko.setStatus(Student.CLASS_0);
		System.out.println("Student:\n" + cvetko.toString());
		// create employee set office and salary
		Employee boris = new Employee("Boris Vajiæ", "Derventa", "boris_vajic331@gmail.com", "066785453");
		boris.setOffice("Derventa");
		boris.setSalary(840);
		System.out.println("Employee:\n" + boris.toString());
		// create facility, set office, salary, hours and rank
		Facility ratko = new Facility("Ratko Bošnjak", "Maglaj", "ratkoratkoko14@gmail.com", "064-789-654");
		ratko.setOffice("Doboj");
		ratko.setSalary(1200);
		ratko.setOfficeHours(8);
		ratko.setRank("šef stanice");
		System.out.println("Facility:\n" + ratko.toString());
		// create staff add office, salary and title
		Staff slavica = new Staff("Slavica Kokuziæ", "Pridjel", "slavica_slava96@gmail.com", "066/365-065");
		slavica.setOffice("Art studio Galebra");
		slavica.setSalary(2500);
		slavica.setTitle("Muza");
		System.out.println("Staff:\n" + slavica.toString());
	}
}
/**Simple person class.*/
class Person {
	// create attributes
	private String name, address, email, phone;
	// default person has name set to N/A
	public Person() {
		this("N/A");
	}
	// Person with name has phone set to N/A
	public Person(String name) {
		this(name, "N/A");
	}
	// Person with name and phone has email and address set to N/A
	public Person(String name, String phone) {
		this(name, "N/A", "N/A", phone);
	}
	// create person with all atributes
	public Person(String name, String adress, String email, String phone) {
		super();
		this.name = name;
		this.address = adress;
		this.email = email;
		this.phone = phone;
	}
	// accessors and mutators
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAdress(String adress) {
		this.address = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return String.format
				( "\tName: %s\n"
				+ "\tEmail: %s\n"
				+ "\tPhone: %s\n"
				+ "\tAdress: %s\n"
				, this.name
				, this.email
				, this.phone
				, this.address
				);
	}
}
/**Simple student class.*/
class Student extends Person {
	// student class have classes
	final static String CLASS_0 = "Freshman";
	final static String CLASS_1 = "Sophomore";
	final static String CLASS_2 = "Junior";
	final static String CLASS_3 = "Senior";
	// variable to store class as status
	private String status;
	// constructors that call super constructor to create person
	// other attributes can be set with mutators
	public Student() {
		super();
	}
	public Student(String name) {
		super(name);
	}
	public Student(String name, String phone) {
		super(name, phone);
	}
	public Student(String name, String addres, String email, String phone) {
		super(name, addres, email, phone);
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return String.format
				( "%s"
				+ "\tStudent status: %s\n"
				, super.toString()
				, this.status
				);
	}
}
class Employee extends Person {
	// employee have office and salary
	private String office;
	private int salary;
	// date when employee is hired is created automatically
	private Date dateHired = new Date();;
	// constructors that call super constructor to create person
	// other attributes can be set with mutators
	public Employee() {
		super();
	}
	public Employee(String name) {
		super(name);
	}
	public Employee(String name, String phone) {
		super(name, phone);
	}
	public Employee(String name, String addres, String email, String phone) {
		super(name, addres, email, phone);
	}
	// accessors and mutators
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return String.format
				( "%s"
				+ "\tOffice: %s\n"
				+ "\tSalary: %s\n"
				+ "\tDate hired: %s\n"
				, super.toString()
				, this.office
				, this.salary
				, this.dateHired.toString()
				);
	}
}
/**Simple facility class.*/
class Facility extends Employee {
	// facility have office hours and rank
	private int officeHours;
	private String rank;
	// constructors that call super constructor to create person
	// other attributes can be set with mutators
	public Facility() {
		super();
	}
	public Facility(String name) {
		super(name);
	}
	public Facility(String name, String phone) {
		super(name, phone);
	}
	public Facility(String name, String addres, String email, String phone) {
		super(name, addres, email, phone);
	}
	// accessors and mutators
	public int getOfficeHours() {
		return officeHours;
	}
	public void setOfficeHours(int officeHours) {
		this.officeHours = officeHours;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return String.format
				( "%s"
				+ "\tOffice hours: %d\n"
				+ "\tRank: %s\n"
				, super.toString()
				, this.officeHours
				, this.rank
				);
	}
}
/**Simple staff class.*/
class Staff extends Employee {
	// facility have title
	private String title;
	// constructors that call super constructor to create person
	// other attributes can be set with mutators
	public Staff() {
		super();
	}
	public Staff(String name) {
		super(name);
	}
	public Staff(String name, String phone) {
		super(name, phone);
	}
	public Staff(String name, String addres, String email, String phone) {
		super(name, addres, email, phone);
	}
	// accessors and mutators
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return String.format
				( "%s"
				+ "\tTitle: %s\n"
				, super.toString()
				, this.title
				);
	}
}