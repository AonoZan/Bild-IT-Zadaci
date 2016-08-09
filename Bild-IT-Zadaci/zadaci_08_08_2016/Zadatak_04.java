/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_08_08_2016;

public class Zadatak_04 {
	/**
	 * Method for checking if number is perfect.
	 * Number can be perfect if it's positive and equal to sum of all its dividers excluding itself.
	 * <p><b>Example:</b>
	 * <br> 6 =  3 + 2 + 1
	 * <br>28 = 14 + 7 + 4 + 2 + 1
	 * @param number
	 * @return
	 */
	public static boolean isPerfect(int number) {
		if (number < 6) return false;			// if number less than first perfect number return false 
		else if (number == 6) return true;		// if first perfect return true
		int sum = 0;
		for (int i = 1; i <= number/2; i++) {	// loop for all dividers and add them to sum
			if (number % i == 0) sum += i;
		}
		if (sum == number) return true;			// if number is equal to sum then it's perfect
		return false;
	}
	/**
	 * Program prints all perfect numbers in range from 1 to 10.000.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Perfect numbers in range 1 - 10000:");
		for (int i = 0; i < 10000; i++) {
			if (isPerfect(i)) System.out.print(i + " ");
		}
	}
}
