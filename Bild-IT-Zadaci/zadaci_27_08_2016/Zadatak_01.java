
package zadaci_27_08_2016;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/**Use for printing list on to console.*/
	public static void print(int[] list) {
		// for each element print that element
		for (int i : list) {
			System.out.print(i + " ");
		}
		// go to new line
		System.out.println();
	}
	/**Use for printing 2D list on to console.*/
	public static void print(int[][] list) {
		// for each row print row as list
		for (int[] is : list) {
			print(is);
		}
	}
	/**Method returns sum of all items inside list*/
	public static int sum(int[] list) {
		// create sum and
		// add all elements from list to it
		int sum = 0;
		for (int i : list) {
			sum += i;
		}
		return sum;
	}
	/**Method fills whole matrix with 0 and 1.*/
	public static void fillMatrix(int[][] matrix) {
		// for each row
		for (int i = 0; i < matrix.length; i++) {
			// for each item in row
			for (int j = 0; j < matrix.length; j++) {
				// set item to raandom int 1 or 0
				matrix[i][j] = (int)(Math.random() * 2);
			}
		}
	}
	/**Method for finding row with max sum of elements.*/
	public static void maxRow(int[][] list, ArrayList<Integer> row) {
		// create max sum and set to first row by default
		int max = sum(list[0]);
		// loop for each row
		for (int i = 0; i < list.length; i++) {
			// get row sum 
			int sum = sum(list[i]);
			// update max and list if other row in list is greater
			if (sum > max) {
				max = sum;
				row.clear();
				row.add(i);
			} else if (sum == max) {
				// if it's equal just add to list
				row.add(i);
			}
		}
	}
	/**Method for finding column with max sum of elements.*/
	public static void maxCol(int[][] list, ArrayList<Integer> col) {
		// create list for storing column as list
		int[] column = new int[list.length];
		// create max and boolean indicating that max is not yet set
		int max = 0;
		boolean notSet = true;
		// loop for each row
		for (int i = 0; i < list[0].length; i++) {
			// create column list
			for (int j = 0; j < list.length; j++) {
				column[j] = list[j][i];
			}
			// get sum of column
			int sum = sum(column);
			// if max is not yet set and set it
			// else check if sum is greater and update sum if yes
			// or just add column indices 
			if (notSet) {
				max = sum;
				notSet = false;
				col.add(i);
			}else if (sum > max) {
				max = sum;
				col.clear();
				col.add(i);
			} else if (sum == max) {
				col.add(i);
			}
		}
	}
	/**Program asks user for size of matrix and prints greatest row and column found.*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create matrix and size variable
		int[][] matrix;
		int size = 0;
		// loop as long as size is on default (0)
		do {
			try {
				// prompt for size
				System.out.print("Enter size of matrix: ");
				size = input.nextInt();
				// if size is negative reset it
				if (size < 0) size = 0;
			} catch (InputMismatchException e) {
				// if user makes mistake clear console, ask again
				System.out.println("Please enter number.");
				input.nextLine();
			}
		} while (size == 0);
		// create matrix, fill it and print
		matrix = new int[size][size];
		fillMatrix(matrix);
		print(matrix);
		// create row and column lists
		ArrayList<Integer> row = new ArrayList<>();
		ArrayList<Integer> col = new ArrayList<>();
		// get max indices
		maxRow(matrix, row);
		maxCol(matrix, col);
		// print greatest row and column indices
		System.out.println("Max rows is: " + row);
		System.out.println("Max columns is: " + col);
		
		input.close();
	}

}

