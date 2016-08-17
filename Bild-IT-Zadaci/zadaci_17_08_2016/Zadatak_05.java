
package zadaci_17_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	public static int[] sort(int[] list) {
		return list;
	}
	/**
	 * Program reads 10 numbers and prints all unique ones.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] numberList = new int[4];
		System.out.println("Enter 10 numbers.");
		for (int i = 0; i < numberList.length; i++) {
			try {
				System.out.printf("Enter number %d:", i + 1);
				numberList[i] = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please enter number.");
				input.nextLine();
				i--;
			}
		}
		System.out.print("Number list: ");
		for (int i : numberList) {
			System.out.print(i + " ");
		}
	}

}

