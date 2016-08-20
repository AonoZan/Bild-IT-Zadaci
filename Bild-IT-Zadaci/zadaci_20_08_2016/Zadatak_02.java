
package zadaci_20_08_2016;

import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	public static boolean equals(int[][] m1, int[][] m2) {
		for (int i = 0; i < m2.length; i++) {
			for (int j = 0; j < m2.length; j++) {
				if (m1[i][j] != m2[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create new 2D list and get values from user
		int[][] matrix1 = new int[3][3];
		int[][] matrix2 = new int[3][3];
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
		System.out.printf("Lists are%s strictly identical.\n",
				equals(matrix1, matrix2) ? "" : "n't");
		input.close();
	}

}

