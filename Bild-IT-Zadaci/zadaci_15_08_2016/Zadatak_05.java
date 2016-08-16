
package zadaci_15_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/**
	 * Method for printing matrix of n size.
	 * @param n
	 */
	public static void printMatrix(int n) {
		//for every row
		for (int i = 0; i < n; i++) {
			// for every column in row
			for (int j = 0; j < n; j++) {
				// print 0 or 1
				System.out.print((int)(Math.random() * 2) + " ");
			}
			// and get to the new line
			System.out.println();
		}
	}
	/**
	 * Program asks user for size of a matrix and then prints size x size matrix.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// prompt user for matrix size
		System.out.println("Input number of matrix(bigger than 0).");
		int matrixSize = 0;
		while (matrixSize == 0) {
			// try to get matrix size
			try {
				// if matrix size is still on default get new value
				if (matrixSize == 0) {
					System.out.print("Enter size of the matrix: ");
					matrixSize = input.nextInt();
					// if user enters 0 or negative reset to default and start again
					if (matrixSize <= 0) {
						matrixSize = 0;
						continue;
					}
				}
				break;
			// if user makes mistake ask to enter correct and clear console
			} catch (InputMismatchException e) {
				System.out.println("Please enter number.");
				input.nextLine();
			// something goes wrong exit
			} catch (Exception e) {
				System.out.println("Unknown erroe. Exit.");
				System.exit(0);
			}
		}
		// print matrix
		System.out.println("Printing matrix of " + matrixSize + " size: ");
		printMatrix(matrixSize);
		input.close();
	}

}

