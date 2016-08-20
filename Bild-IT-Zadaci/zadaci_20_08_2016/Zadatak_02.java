
package zadaci_20_08_2016;

import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/**
	 * Method checks if lists are strictly equal.
	 * @param m1
	 * @param m2
	 * @return
	 */
	public static boolean equals(int[][] m1, int[][] m2) {
		// not equal length, not identical
		if (m1.length != m2.length) {
			return false;
		}
		// loop over on of the list
		for (int i = 0; i < m2.length; i++) {
			for (int j = 0; j < m2.length; j++) {
				// if element at same index from both list is nos same value
				if (m1[i][j] != m2[i][j]) {
					// return false, not identical
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * Program asks from user two matrix and checks if they are strictly identical.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create two new 2D list and get values from user
		int[][] matrix1 = new int[3][3];
		int[][] matrix2 = new int[3][3];
		// read values for first matrix
		while (true) {
			try {
				System.out.print("Enter first list: ");
				for (int i = 0; i < matrix1.length; i++) {
					for (int j = 0; j < matrix1.length; j++) {
						matrix1[i][j] = input.nextInt();
					}
				}
			} catch (Exception e) {
				System.out.println("Please provide correct values.");
				continue;
			}
			break;
		}
		// read values for second matrix
		while (true) {
			try {
				System.out.print("Enter second list: ");
				for (int i = 0; i < matrix2.length; i++) {
					for (int j = 0; j < matrix2.length; j++) {
						matrix2[i][j] = input.nextInt();
					}
				}
			} catch (Exception e) {
				System.out.println("Please provide correct values.");
				continue;
			}
			break;
		}
		// print status message 
		System.out.printf("Lists are%s strictly identical.\n",
				equals(matrix1, matrix2) ? "" : "n't");
		input.close();
	}

}

