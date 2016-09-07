
package zadaci_06_09_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/** Program calculates series of i / i + 1 using recursion. */
	public static double recurSum(int i) {
		// return i/i+1 if index is 1 or less
		// else return sum of lower index plus i/i+1
		if (i <= 1) {
			return (i / (i + 1.0));
		} else {
			return recurSum(i - 1) + (i / (i + 1.0));
		}
	}

	/** Program prints series of number for index 10 using formula i/i+1. */
	public static void main(String[] args) {
		System.out.println("For formula i / i + 1:");
		for (int i = 1; i < 10; i++) {
			System.out.printf("If i is %d then result is: %.4f\n", i, recurSum(i));
		}
	}
}

