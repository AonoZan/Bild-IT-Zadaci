
package zadaci_18_08_2016;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/**
	 * Method checks list and recognizes pattern of 4 equal numbers
	 * in a row, if pattern is found true is returned.
	 * @param values
	 * @return
	 */
	public static boolean isConsecutiveFour(int[] values) {
		// in case argument is null
		if (values == null) {
			System.out.println("Can't find consecutive 4. (null args)");
			return false;
		}
		// loop over numbers 
		for (int i = 0; i < values.length - 3; i++) {
			// if 4 in a row same return true
			if (values[i] == values[i + 1]
					&& values[i] == values[i + 2]
					&& values[i] == values[i + 3]) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Program asks from user length of list and then fills list with user
	 * input. If list contains consecutive fours true is printed else false
	 * is printed on the console.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int listLen = 0;
		int[] list;
		System.out.println("Enter size of the list and numbers for the list.");
		while (true) {
			try {
				// if length is not provided get it from user
				if (listLen == 0) {
					System.out.print("Enter list length: ");
					listLen = input.nextInt();
					// if user makes mistake loop again
					if (listLen <= 0) {
						listLen = 0;
						continue;
					}
				}
			// in case of mistake
			} catch (InputMismatchException e) {
				System.out.println("Please enter number.");
				input.nextLine();
			// any other mistake
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
			// create list with numbers and loop over that list
			list = new int[listLen];
			for (int i = 0; i < list.length; i++) {
				// try to fill that list with user values
				try {
					System.out.printf("Fill index %d:", i);
					list[i] = input.nextInt();
				// in case mistake clean console and reset counter
				} catch (InputMismatchException e) {
					System.out.println("Please enter number.");
					input.nextLine();
					i--;
				// exit for other mistakes
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.exit(0);
				}
			}
			break;
		}
		// print message
		System.out.printf("Consecutive four found: %b",
				isConsecutiveFour(list));
		input.close();
	}

}

