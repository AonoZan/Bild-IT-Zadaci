
package zadaci_26_08_2016;

import java.util.ArrayList;
import java.util.Date;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/**
	 * Program creates several object and adds them to list
	 * so that it could print each object toString() output.
	 */
	public static void main(String[] args) {
		// create few object
		Loan loan = new Loan();
		Date date = new Date();
		String string = new String("String");
		Circle circle = new Circle();
		// create list and add all objects to list
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(loan);
		list.add(date);
		list.add(string);
		list.add(circle);
		// loop trough whole list and print output using toString() of objects
		for (Object object : list) {
			System.out.println(object);
		}
	}
}
/**Simple generic loan class*/
class Loan {
	Loan() {
	}
	@Override
	public String toString() {
		return "Simple Loan class...";
	}
}
/**Simple circle class*/
class Circle {
	Circle() {
	}
	@Override
	public String toString() {
		return "Simple Circle class...";
	}
}