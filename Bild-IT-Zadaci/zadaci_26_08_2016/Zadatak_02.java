
package zadaci_26_08_2016;

import java.util.Date;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {

	public static void main(String[] args) {
		Person zdravko = new Person("Zdravko Mrèina", "Tunguziæi donji", "zm_ladysman15@mail.com", "053/789-987");
		System.out.println("Person:\n" + zdravko.toString());
		
		Student cvetko = new Student("Cvetko Brat", "Pribiniæi", "bukva_i_rast789@hotmail.com", "+38766/787-887");
		cvetko.setStatus(Student.CLASS_0);
		System.out.println("Student:\n" + cvetko.toString());
		
		Employee boris = new Employee("Boris Vajiæ", "Derventa", "boris_vajic331@gmail.com", "066785453");
		boris.setOffice("Derventa");
		boris.setSalary(840);
		System.out.println("Employee:\n" + boris.toString());
		
		Facility ratko = new Facility("Ratko Bošnjak", "Maglaj", "ratkoratkoko14@gmail.com", "064-789-654");
		ratko.setOffice("Doboj");
		ratko.setSalary(1200);
		ratko.setOfficeHours(8);
		ratko.setRank("šef stanice");
		System.out.println("Facility:\n" + ratko.toString());
		
		Facility slavica = new Facility("Slavica Kokuziæ", "Pridjel", "slavica_slava96@gmail.com", "066/365-065");
		slavica.setOffice("Bivši modeks");
		slavica.setSalary(600);
		slavica.setOfficeHours(12);
		slavica.setRank("Rukovodilac šivaæih mašinama");
		System.out.println("Staff:\n" + slavica.toString());
	}
}

class Person {
	private String name, adress, email, phone;
	public Person() {
		this("N/A");
	}
	public Person(String name) {
		this(name, "N/A");
	}
	public Person(String name, String phone) {
		this(name, "N/A", "N/A", phone);
	}
	public Person(String name, String adress, String email, String phone) {
		super();
		this.name = name;
		this.adress = adress;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
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
				, this.adress
				);
	}
}
class Student extends Person {
	final static String CLASS_0 = "Freshman";
	final static String CLASS_1 = "Sophomore";
	final static String CLASS_2 = "Junior";
	final static String CLASS_3 = "Senior";
	
	private String status;
	
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
	private String office;
	private int salary;
	private Date dateHired = new Date();;
	
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
class Facility extends Employee {
	private int officeHours;
	private String rank;
	
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