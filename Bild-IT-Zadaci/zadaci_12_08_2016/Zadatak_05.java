/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_12_08_2016;
import java.util.Scanner;

public class Zadatak_05 {
	/**
	 * Program reads unlimited amount of numbers in range 1 - 100 and counts how many times each is entered.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create list for counting numbers and user number
		int[] numbers = new int[100];
		int userNumber = -1;
		// prompt user to enter numbers and take until 0 is entered
		System.out.println("Enter numbers: ");
		while (userNumber != 0) {
			userNumber = input.nextInt();
			if (userNumber > 0) {
				// count number as list index
				numbers[userNumber - 1]++;
			}
		}
		// loop over list and print those indexes that are greater than 0
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > 0) {
				System.out.printf("Number %d occured %d time%s.\n",
						i + 1,
						numbers[i],
						numbers[i] > 1 ? "'s" : "");
			}
		}
		input.close();
	}

}
