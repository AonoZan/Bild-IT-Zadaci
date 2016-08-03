/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_03_08_2016;

import zadaci_01_08_2016.Zadatak_05;

public class Zadatak_03 {
	public static boolean equals(int[] niz1, int[]niz2) {
		if (niz1 == null) {
			System.out.println("Cant compare lists. First argument is null.");
			return false;
		} else if (niz2 == null) {
			System.out.println("Cant compare lists. Second argument is null.");
			return false;
		} else if (niz1.length < 1) {
			System.out.println("Cant compare lists. First argument has no values.");
			return false;
		} else if (niz2.length < 1) {
			System.out.println("Cant compare lists. Second argument has no values.");
			return false;
		}
		
		for (int i = 0; i < Math.min(niz1.length, niz2.length); i++) {
			if (niz1[i] != niz2[i]) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println("Enter first array: ");
		int[] niz1 = Zadatak_05.fillListFromConsoleInput(new int[1]);
		System.out.println("Enter second array: ");
		int[] niz2 = Zadatak_05.fillListFromConsoleInput(new int[1]);
		
		System.out.printf("Two arrays entered are %sequal.", equals(niz1, niz2) ? "" : "not ");
	}
}
