
package zadaci_27_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/**Use for printing list on to console.*/
	public static void print(int[] list) {
		for (int i : list) {
			System.out.println(i + " ");
		}
		System.out.println();
	}
	/**Use for printing 2D list on to console.*/
	public static void print(int[][] list) {
		for (int[] is : list) {
			print(is);
		}
	}
	/**Method returns sum of all items inside list*/
	public static int sum(int[] list) {
		int sum = 0;
		for (int i : list) {
			sum += i;
		}
		return sum;
	}
	/**Method fills whole matrix with 0 and 1.*/
	public static void fillMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = (int)(Math.random() * 2);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] matrix;
		int size = 0;
		do {
			try {
				System.out.print("Enter size of matrix: ");
				size = input.nextInt();
				if (size < 0) size = 0;
			} catch (InputMismatchException e) {
				System.out.println("Please enter number.");
				input.nextLine();
			}
		} while (size == 0);
		
		matrix = new int[size][size];
		
		
		input.close();
	}

}

