/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_04_08_2016;

public class Zadatak_04 {
	/**
	 * Simple main method that generates list 100 random numbers and prints them on console 10 on each line.
	 * List is then used to print character values on the console 10 on each line
	 * @param args
	 */
	public static void main(String[] args) {
		// try to generate random numbers or print error message and exit
		try {
			// create list with 100 random numbers using A and Z character values
			int[] list = zadaci_01_08_2016.Zadatak_04.generateRandom('A', 'Z', 100);
			// print list values separated with space 10 on each line and enter new line
			zadaci_02_08_2016.Zadatak_01.printList(list, new String[]{" ", ""},  2, 10);
			System.out.println();
			// go trough list and print characters using list values
			for (int i = 0; i < list.length; i++) {
				if (i % 10 == 0 && i != 0) System.out.println();
				System.out.printf("%c ", list[i]);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
