/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_06_08_2016;

import java.util.ArrayList;

public class Zadatak_02 {
	public static void main(String[] args) {
		int startingYear = 0, endingYear = 0;
		System.out.println("Enter two numbers representing two years\nfor listing all leap ones in between.");
		while(true) {
			try {
				if (startingYear == 0) {
					System.out.print("Enter starting year: ");
					startingYear = zadaci_01_08_2016.Zadatak_05.readFromConsole(startingYear);
					if (startingYear < 1) {
						System.out.printf("Wrong value for year(%d).", startingYear);
						startingYear = 0;
						throw new Exception("Enter new value.");
					}
				}
				if (endingYear == 0) {
					System.out.print("Enter starting year: ");
					endingYear = zadaci_01_08_2016.Zadatak_05.readFromConsole(startingYear);
					if (endingYear < 1) {
						System.out.printf("Wrong value for year(%d).", startingYear);
						endingYear = 0;
						throw new Exception("Enter new value.");
					} else if (endingYear < startingYear) {
						System.out.println("Ending year must be bigger than starting year.");
						endingYear = 0;
						throw new Exception("Enter new value.");
					}
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.printf("All leap years in range %d - %d:\n", startingYear, endingYear);
		ArrayList<Integer> yearList = new ArrayList<>();
		for (int i = startingYear; i <= endingYear; i++) {
			if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) yearList.add(i);
		}
		// try to print all years
		try {
			zadaci_02_08_2016.Zadatak_01.printList(yearList, new String[]{" ", "\n"}, 4, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
