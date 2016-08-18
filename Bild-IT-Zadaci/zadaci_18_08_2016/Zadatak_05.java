
package zadaci_18_08_2016;

import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	public static double[][] addMatrix(double[][] a, double[][] b) {
		// if wrong arguments
		if (a == null || b == null) {
			System.out.println("Cant't sum lists. (null arg)");
		}
		double[][] sumedList = new double[a.length][];
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null || b[i] == null) {
				if (a[i] == b[i]) {
					System.out.println("null");
					sumedList[i] = null;
					continue;
				} else {
					System.out.println("Can't sum lists. (not equal)");
					return null;
				}
			} else {
				if (a[i].length == b[i].length) {
					sumedList[i] = new double[a[i].length];
					for (int j = 0; j < sumedList[i].length; j++) {
						sumedList[i][j] = a[i][j] + b[i][j];
					}
				} else {
					System.out.println("Can't sum lists. "
							+ "(wrong size on " + i + " row)");
					return null;
				}
			}
		}
		return sumedList;
		
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		input.close();
	}

}

