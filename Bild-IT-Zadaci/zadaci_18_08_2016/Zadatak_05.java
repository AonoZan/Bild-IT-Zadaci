
package zadaci_18_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/**
	 * Method sums elements of two list into new list.
	 * <p>For example for 3x3 lists:
	 * <br>1 2 3 + 1 3 3 = 2 5 6
	 * <br>4 5 6 + 1 2 3 = 5 7 9
	 * <br>7 8 9 + 1 1 0 = 8 9 9
	 * @param a
	 * @param b
	 * @return
	 */
	public static double[][] addMatrix(double[][] a, double[][] b) {
		// if wrong arguments
		if (a == null || b == null) {
			System.out.println("Cant't sum lists. (null arg)");
		}
		// create new list
		double[][] sumedList = new double[a.length][];
		// go trough list rows
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null || b[i] == null) {// if any list null
				if (a[i] == b[i]) {// if both null
					// set new list row  to null and skip iteration
					sumedList[i] = null;
					continue;
				} else {
					// wrong list rows return null
					System.out.println("Can't sum lists. (not equal)");
					return null;
				}
			} else { // if rows are filled with values
				if (a[i].length == b[i].length) { // check if equal size
					// create row list
					sumedList[i] = new double[a[i].length];
					// fill values with sum of a and b lists
					for (int j = 0; j < sumedList[i].length; j++) {
						sumedList[i][j] = a[i][j] + b[i][j];
					}
				} else { // not equal size return null
					System.out.println("Can't sum lists. "
							+ "(wrong size on " + i + " row)");
					return null;
				}
			}
		}
		return sumedList;
		
	}
	/**
	 * Program asks from user for two 3x3 matrixes and then prints both
	 * matrixes and sum of those two.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create matrixes
		double[][] matrix1 = new double[3][3];
		double[][] matrix2 = new double[3][3];
		// prompt user for matrixes
		System.out.println("Enter two 3x3 matrixs.");
		while (true) {
			try {
				// fill first matrix
				System.out.print("Enter matrix1: ");
				for (int i = 0; i < matrix1.length; i++) {
					for (int j = 0; j < matrix1[i].length; j++) {
						matrix1[i][j] = input.nextDouble();
					}
				}
				break;
			// if user makes mistake clear console
			} catch (InputMismatchException e) {
				System.out.println("Please enter decimal values.");
				input.nextLine();
				continue;
			} catch (Exception e) {
				System.exit(0);
			}
		}
		while (true) {
			try {
				// fill second matrix
				System.out.print("Enter matrix2: ");
				for (int i = 0; i < matrix2.length; i++) {
					for (int j = 0; j < matrix2[i].length; j++) {
						matrix2[i][j] = input.nextDouble();
					}
				}
				break;
			// if error clear console
			} catch (InputMismatchException e) {
				System.out.println("Please enter decimal values.");
				input.nextLine();
				continue;
			} catch (Exception e) {
				System.exit(0);
			}
		}
		// sum both matrixes into new one
		double[][] matrixSum = addMatrix(matrix1, matrix2);
		for (int i = 0; i < matrixSum.length; i++) {
			// print row of first matrix
			for (double dn : matrix1[i]) {
				System.out.print(dn + " ");
			}
			// plus sign on second row else space characters
			System.out.print(i == 1 ? "+ " : "  ");
			// row of second matrix
			for (double dn : matrix2[i]) {
				System.out.print(dn + " ");
			}
			// equal sign on second row else spaces
			System.out.print(i == 1 ? "= " : "  ");
			// row of new matrix
			for (double dn : matrixSum[i]) {
				System.out.print(dn + " ");
			}
			// new row
			System.out.println();
		}
		input.close();
	}

}

