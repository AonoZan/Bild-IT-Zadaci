
package zadaci_27_08_2016;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/**Method that retrieves sum of an array.*/
	public static double sum(ArrayList<Double> list) {
		double sum = 0;
		// for each element in list add it to the sum
		for (Double d : list) {
			sum += d;
		}
		return sum;
	}
	/**Program asks user for 5 numbers, stores them in array and prints sum.*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create list and set length variable
		ArrayList<Double> list = new ArrayList<>();
		final int LENGTH = 5;
		// prompt user for values
		System.out.println("Enter " + LENGTH + " integer values.");
		for (int i = 0; i < LENGTH; i++) {
			try {
				// get values from user
				System.out.printf("Enter %d value: ", i);
				list.add(input.nextDouble());
			} catch (InputMismatchException e) {
				// in case of error print message, clear console and loop back
				System.out.println("Please enter decimal number.");
				input.nextLine();
				i--;
			}
		}
		// calculate sum and print it
		double sum = sum(list);
		System.out.printf("Sum of list is : %.2f\n", sum);
		
		input.close();
	}
}

