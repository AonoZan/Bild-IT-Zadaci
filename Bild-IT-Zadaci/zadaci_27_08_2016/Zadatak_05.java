
package zadaci_27_08_2016;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/**Method that unifies two array lists.*/
	public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		// create new array list
		ArrayList<Integer> union = new ArrayList<>();
		// add both lists to new array and return it
		for (Integer integer : list1) {
			union.add(integer);
		}
		for (Integer integer : list2) {
			union.add(integer);
		}
		return union;
	}
	/**Program asks for two lists, unifies them and prints result.*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create two lists
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		// set default length of lists
		final int LENGTH = 5;
		// prompt user for values
		System.out.println("Enter " + LENGTH + " integer values for first list.");
		for (int i = 0; i < LENGTH; i++) {
			try {
				// get values from user
				System.out.printf("Enter %d value: ", i);
				list1.add(input.nextInt());
			} catch (InputMismatchException e) {
				// in case of error print message, clear console and loop back
				System.out.println("Please enter number.");
				input.nextLine();
				i--;
			}
		}
		System.out.println("Enter " + LENGTH + " integer values for second list.");
		for (int i = 0; i < LENGTH; i++) {
			try {
				// get values from user
				System.out.printf("Enter %d value: ", i);
				list2.add(input.nextInt());
			} catch (InputMismatchException e) {
				// in case of error print message, clear console and loop back
				System.out.println("Please enter number.");
				input.nextLine();
				i--;
			}
		}
		System.out.println();
		// unify list and print it
		ArrayList<Integer> union = union(list1, list2);
		System.out.print("Unified list is: ");
		Zadatak_02.print(union);
		
		input.close();
		
	}
}

