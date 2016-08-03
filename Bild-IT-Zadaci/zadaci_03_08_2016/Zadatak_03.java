/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_03_08_2016;

import zadaci_01_08_2016.Zadatak_05;

public class Zadatak_03 {
	/**
	 * Method taht checks two integer array list. Integer list's are equal if values at the same positions are same.
	 * List that are passed as arguments could be different size and still be the same. 
	 * @param niz1 list of integers any size
	 * @param niz2 list of integers any size
	 * @return false if any argument is null or incorect or lists are not equal, true if items at the same position's are the same value.
	 */
	public static boolean equals(int[] niz1, int[]niz2) {
		// if first or second argument are incorrect rerurn false
		if (niz1 == null) {
			System.out.println("Cant compare lists. First argument is null.");
			return false;
		} else if (niz2 == null) {
			System.out.println("Cant compare lists. Second argument is null.");
			return false;
		}
		// loop trough whichever list has less elements
		for (int i = 0; i < Math.min(niz1.length, niz2.length); i++) {
			// if elements on the same position are not the same value return false
			if (niz1[i] != niz2[i]) return false;
		}
		// if no diferent value is found then return true
		return true;
	}
	/**
	 * Simple main method that asks user for two integer arrays and compare them to see if they are equal.
	 * @param args
	 */
	public static void main(String[] args) {
		// ask user for two arrays
		System.out.println("Enter first array: ");
		int[] niz1 = Zadatak_05.fillListFromConsoleInput(new int[1]);
		System.out.println("Enter second array: ");
		int[] niz2 = Zadatak_05.fillListFromConsoleInput(new int[1]);
		// print status message if two arrays are equal
		System.out.printf("Two arrays entered are %sequal.", equals(niz1, niz2) ? "" : "not ");
	}
}
