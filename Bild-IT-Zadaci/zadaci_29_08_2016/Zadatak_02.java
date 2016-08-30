
package zadaci_29_08_2016;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/** Method returns list of factors for a given number. */
	public static ArrayList<Integer> getFactors(int n) {
		// create list and starting divider
		ArrayList<Integer> factors = new ArrayList<>();
		int divider = 2;
		// loop as long as number is divisible
		while (n > 1) {
			// if divisible add factor(divider) and divide number
			if (n % divider == 0) {
				factors.add(divider);
				n /= divider;
			} else {
				// else try another divider
				divider++;
			}
		}
		return factors;
	}
	/** Method cleans list from every value that appears more then once. */
	public static void cleanDuplicates(ArrayList<Integer> list) {
		// loop trough whole list
		for (int i = 0; i < list.size() - 1;) {
			// get item at current index
			int n = list.get(i);
			// if item is same as next one remove all item with that value
			if (n == list.get(i + 1)) {
				while (i < list.size() && n == list.get(i)) {
					list.remove(i);
				}
			// else move to the next index
			} else {
				i++;
			}
		}
	}
	/** Method retrieves product of all values from the list */
	public static int product(ArrayList<Integer> list) {
		int product = 1;
		for (Integer integer : list) {
			product *= integer;
		}
		return product;
	}
	/** 
	 * Program asks user for one integer and then prints
	 * smallest integer n such that n * integer is perfect square.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int integer;
		while (true) {
			try {
				System.out.print("Enter one integer:");
				integer = input.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Please enter integer.");
				input.nextLine();
			}
		}
		// calculate factors, clean from duplicate
		// and get product of those values
		ArrayList<Integer> factors = getFactors(integer);
		cleanDuplicates(factors);
		int product = product(factors);
		// print result
		System.out.printf("The smallest number n for m * n "
				+ "to be a perfect square is %d\nm * n is %d",
				product, integer * product);
		input.close();
	}

}

