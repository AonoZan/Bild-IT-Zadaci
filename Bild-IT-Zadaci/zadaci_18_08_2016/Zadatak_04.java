
package zadaci_18_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/**
	 * Method that sums specific column in a list. 
	 * @param m
	 * @param columnIndex
	 * @return
	 */
	public static double sumColumn(double[][] m, int columnIndex) {
		double sum = 0;
		// go trough list rows and sum values on columnIndex
		for (int i = 0; i < m.length; i++) {
			sum += m[i][columnIndex];
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[][] matrix = new double[3][4];
		System.out.println("Enter a 3-by-4 matrix row by row: ");
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("Enter " + i + " row: ");
			try {
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] = input.nextDouble();
				}
			// in case wrong input, reset, ask again
			} catch (InputMismatchException e) {
				System.out.println("Please enter decimal value.");
				input.nextLine();
				i--;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		// print sum of columns
		for (int i = 0; i < matrix[0].length; i++) {
			System.out.printf("Sum of %d column is %.2f.\n",
					i,
					sumColumn(matrix, i));
		}
		input.close();
	}

}

