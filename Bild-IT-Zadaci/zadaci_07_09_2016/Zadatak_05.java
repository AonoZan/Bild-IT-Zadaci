
package zadaci_07_09_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/** Program finds largest integer in list using recursion. */
	public static int largest(int[] list, int index) {
		// if index is equal length return last item
		// else check which one is largest current or one in front
		// and return largest
		if (index == list.length) return list[list.length - 1];
		else {
			int n = list[index];
			int largest = largest(list, index + 1);
			return n > largest ? n : largest;
		}
	}
	/** Program prompts user for 8 numbers, strore them in list and prints largest. */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// prompt user for 8 values
		int[] list = new int[8];
		System.out.print("Enter 8 values: ");
		for (int i = 0; i < list.length; i++) {
			try {
				// take value
				list[i] = input.nextInt();
			} catch (InputMismatchException e) {
				// in case of a mistake reset iteration and prompt user to enter again
				System.out.println("Please enter only numbers.");
				input.nextLine();
				i = 0;
			}
		}
		// print largest
		System.out.println("Largest is: " + largest(list, 0));
		
		input.close();
	}
}

