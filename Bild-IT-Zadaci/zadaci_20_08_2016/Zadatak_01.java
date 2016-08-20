
package zadaci_20_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	// Method for sorting list of double values
	// values are sorted in increasing order
	public static double[] sort(double[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - 1 - i; j++) {
				if (list[j] > list[j + 1]) {
					list[j] += list[j + 1];
					list[j + 1] = list[j] - list[j + 1];
					list[j] -= list[j + 1];
				}
			}
		}
		return list;
	}
	// Method that sorts each row in 2D list
	public static double[][] sortRows(double[][] list) {
		for (int i = 0; i < list.length; i++) {
			list[i] = sort(list[i]);
		}
		return list;
	}
	// method for printing 2D list on console
	public static void printList(double[][] list) {
		for (double[] ds : list) {
			for (double d : ds) {
				System.out.print(d + " ");
			}
			System.out.println();
		}
	}
	/**
	 * Program asks user to enter 3x3 matrix of double elements and then sorts
	 * and prints sorted matrix.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create new 2D list and get values from user
		double[][] matrix = new double[3][3];
		while (true) {
			// for each row
			for (int i = 0; i < matrix.length; i++) {
				// try to get row
				try {
					// prompt for row values and collect them
					System.out.printf("Enter %d row: ", i);
					for (int j = 0; j < matrix[i].length; j++) {
						matrix[i][j] = input.nextDouble();
					}
				// if user makes mistake reset counter ask again
				} catch (InputMismatchException e) {
					System.out.println("Please enter decimal number.\n");
					input.nextLine();
					i--;
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			break;
		}
		// sort list and print it
		sortRows(matrix);
		printList(matrix);
		
		input.close();
	}

}

