
package zadaci_29_08_2016;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/**Program creates list of integer and lets user search indexes.*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create list with 100 random numbers
		final int RANGE = 100;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < RANGE; i++) {
			list.add((int)(Math.random() * 100));
		}
		// create boolean for exit and variable for user input
		boolean searchIndex = true;
		int index;
		// search indexes
		while (searchIndex) {
			try {
				// prompt for index
				System.out.println("Search which index inside list: ");
				index = input.nextInt();
				// print number on that index
				System.out.printf("Number on %d index is %d.\n", index, list.get(index));
			} catch (IndexOutOfBoundsException e) {
				// index is out of range
				System.out.println("That's wrong index. Try again.");
			} catch (InputMismatchException e) {
				// if wrong input stop search
				System.out.println("Wrong input system exits.");
				searchIndex = false;
			}
		}
		input.close();
	}

}

