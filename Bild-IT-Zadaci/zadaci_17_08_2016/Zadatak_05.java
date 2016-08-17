
package zadaci_17_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/**
	 * Method for sorting list of numbers.
	 * @param list
	 * @return
	 */
	public static int[] sort(int[] list) {
		// go trough all numbers
		for (int i = 0; i < list.length-1; i++) {
			// go from current number
			for (int j = 0; j < list.length-1-i; j++) {
				// if current is bigger switch with next one
				if (list[j] > list[j + 1]) {
					list[j] += list[j+1];
					list[j+1] = list[j] - list[j+1];
					list[j] -= list[j+1];
				}
			}
		}
		return list;
	}
	/**
	 * Program reads 10 numbers and prints all unique ones.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create list and fill it with user input
		int[] numberList = new int[10];
		System.out.println("Enter 10 numbers.");
		for (int i = 0; i < numberList.length; i++) {
			// try to get integer value
			try {
				System.out.printf("Enter number %d:", i + 1);
				numberList[i] = input.nextInt();
			// if wrong value clear console and reset counter
			} catch (InputMismatchException e) {
				System.out.println("Please enter number.");
				input.nextLine();
				i--;
			}
		}
		// sort list
		numberList = sort(numberList);
		int tempNumber = numberList[0] - 1, numberCount = 0;
		// print all unique numbers and count them
		System.out.print("Number list: ");
		for (int i : numberList) {
			if (tempNumber != i) {
				System.out.print(i + " ");
				tempNumber = i;
				numberCount++;
			}
		}
		// print count of unique numbers
		System.out.println("\nNumber count: " + numberCount);
		input.close();
	}

}

