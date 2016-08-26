
package zadaci_26_08_2016;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/**Method returns max element from list.*/
	public static Integer max(ArrayList<Integer> list) {
		// for wrong argument return null
		if (list == null || list.size() == 0) {
			System.out.println("Can't retrieve max from list.(wrong argument)");
			return null;
		}
		// create number and search list for greatest value
		Integer number = new Integer(list.get(0));
		for (Integer integer : list) {
			if (integer > number) {
				number = integer;
			}
		}
		return number;
	}
	/**Program asks user for unlimited list of numbers and prints greatest.*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create list and number to store values
		ArrayList<Integer> list = new ArrayList<>();
		int number;
		// prompt user for input
		System.out.println("Enter unlimited amount of numbers. (0 stops input)");
		while (true) {
			try {
				// get number
				System.out.print("Enter number: ");
				number = input.nextInt();
				// if number is 0 break
				if (number == 0) {
					break;
				}
				// add to the list
				list.add(number);
			} catch (InputMismatchException e) {
				// if user enters wrong value clear console
				System.out.println("Please enter number.");
				input.nextLine();
			}
		}
		// print max value
		System.out.println("Max number is: " + max(list));
		input.close();
	}

}

