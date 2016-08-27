
package zadaci_27_08_2016;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/**Method for printing whole list.*/
	public static void print(ArrayList<Integer> list) {
		// for each integer print it with space
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		// go to next line
		System.out.println();
	}
	/**Method for sorting an array list.*/
	public static void sort(ArrayList<Integer> list) {
		// constant for offset
		final int OFFSET = 1;
		// loop for each element minus offset
		for (int i = 0; i < list.size() - OFFSET; i++) {
			// create boolean in case sort ends early
			boolean finished = true;
			// loop for each element minus sorted and offset
			for (int j = 0; j < list.size() - i - OFFSET; j++) {
				// if element is greater switch them and set finished to false
				if (list.get(j) > list.get(j + OFFSET)) {
					Integer tmp = list.get(j);
					list.set(j, list.get(j + OFFSET));
					list.set(j + OFFSET, tmp);
					finished = false;
				}
			}
			// if nothing happened in this itteration break
			if (finished) return;
		}
	}
	/**Program asks user for 5 numbers and prints them sorted.*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create list and set length variable
		ArrayList<Integer> list = new ArrayList<>();
		final int LENGTH = 5;
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
		// sort and print list
		System.out.print("Sorted list: ");
		sort(list);
		print(list);
		
		input.close();
	}
}

