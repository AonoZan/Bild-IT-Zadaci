
package zadaci_20_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/**
	 * Method creates new Location class, searches maximum value in list
	 * and fills values of Location class.
	 * @param a
	 * @return
	 */
	public static Location locateLargest(double[][] a) {
		// avoid error return null
		if (a == null) {
			System.out.println("Can't find max value argument is null");
			return null;
		}
		// new class
		Location loc = new Location();
		// set first value
		loc.maxValue = a[0][0];
		// search list
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				// if value is bigger than current update
				if (a[i][j] > loc.maxValue) {
					loc.maxValue = a[i][j];
					loc.row = i;
					loc.column = j;
				}
			}
		}
		return loc;
	}
	/**
	 * Program asks from user size of the list and then prompts for values.
	 * List is searched and maximum value location inside list is printed.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// values for size of the list
		int row = 0, col = 0;
		System.out.println("Enter size of the matrix.");
		// try to get values for the size
		while (true) {
			try {
				// ask for values until valid ones are provided
				if (row == 0) {
					System.out.print("Enter value for row: ");
					row = input.nextInt();
					if (row <= 0) continue;
				}
				if (col == 0) {
					System.out.print("Enter value for column: ");
					col = input.nextInt();
					if (col <= 0) continue;
				}
				break;
			// for wrong input clear console
			} catch (InputMismatchException e) {
				System.out.println("Please enter number.");
				input.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// create new list
		double[][] matrix = new double[row][col];
		System.out.print("Enter array: ");
		// fill list with values
		while (true) {
			try {
				for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix[i].length; j++) {
						matrix[i][j] = input.nextDouble();
					}
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Please enter only decimal values.");
				input.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// reference to the largest from list
		Location loc = locateLargest(matrix);
		System.out.printf("The location of the largest"
				+ "element is %.2f at (%d, %d)\n",
				loc.maxValue,
				loc.row,
				loc.column);
		
		input.close();
	}

}
/**
 * Simple class to store largest value of the list.
 * @author AonoZan
 *
 */
class Location {
	// max value from the list
	public double maxValue;
	// row and column indexes of max value
	public int row;
	public int column;
}
