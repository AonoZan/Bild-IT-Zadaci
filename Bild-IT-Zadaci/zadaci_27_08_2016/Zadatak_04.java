
package zadaci_27_08_2016;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/**Method checks if an item with same value is inside list.*/
	public static boolean contains(ArrayList<Integer> list, int i) {
		// if null or empty list return false
		if (list == null || list.size() == 0) return false;
		// loop over items and check if any same as argument
		for (Integer integer : list) {
			// return true if yes
			if (integer == i) return true;
		}
		return false;
	}
	//  0 0 0 1 1 2 2 3 0
	// .001122300 -0 +0
	// .01122300  -0
	// .1122300   -0
	// .1223001   -1 +1
	// .223001    -1
	// .230012    -2 +2
	// .30012     -2
	// .00123     -3 +3
	// .
	// 5 0 0 0 0 4 2 1 5 
	/**Method removes all duplicated items from list.*/
	public static void removeDuplicate(ArrayList<Integer> list) {
		// create list to store all unique numbers
		ArrayList<Integer> unique = new ArrayList<>();
		// loop over list until both lists dont match up in length
		while (unique.size() < list.size()) {
			// get item first item
			int item = list.get(0);
			// if item is unique
			if (!contains(unique, item)) {
				// add to both lists
				unique.add(item);
				list.add(item);
			}
			// remove first item from list
			list.remove(0);
		}
	}
	/**Program asks user for 10 numbers, stores them in array and prints unique.*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create list and set length variable
		ArrayList<Integer> list = new ArrayList<>();
		final int LENGTH = 10;
		// prompt user for values
		System.out.println("Enter " + LENGTH + " integer values.");
		for (int i = 0; i < LENGTH; i++) {
			try {
				// get values from user
				System.out.printf("Enter %d value: ", i);
				list.add(input.nextInt());
			} catch (InputMismatchException e) {
				// in case of error print message, clear console and loop back
				System.out.println("Please enter number.");
				input.nextLine();
				i--;
			}
		}
		System.out.println();
		// sterilize from duplicates and print list
		System.out.print("The distinct integers are: ");
		removeDuplicate(list);
		Zadatak_02.print(list);
		
		input.close();
	}

}

