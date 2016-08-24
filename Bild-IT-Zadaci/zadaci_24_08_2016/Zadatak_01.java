
package zadaci_24_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/**Program finds first ten numbers with 50 digits divisible by 2 and 3*/
	public static void main(String[] args) {
		// create counter and starting number for division
		int counter = 0;
		int number = 1;
		// find numbers until 10 is found
		while (counter < 10) {
			// if number is divisible by 3 and 2 print it and count it
			if (number % 2 == 0 || number %3 == 0) {
				System.out.printf("0.%050d\n", number);
				counter++;
			}
			// go to next number
			number++;
		}
	}
}

