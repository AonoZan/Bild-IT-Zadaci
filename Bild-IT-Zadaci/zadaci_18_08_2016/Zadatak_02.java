
package zadaci_18_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/**
	 * Method generates random number in range 1 to 54
	 * filtering those passed in argument.
	 * 
	 * @param numbers
	 * @return
	 */
	public static int getRandom(int... numbers) {
		// constant for range
		final int RANGE_MIN = 1;
		final int RANGE_MAX = 54;
		// variable for random number and
		// for loop until right random is found
		int number = 0;
		boolean genAnother = true;
		// loop until another number needs to be generated
		while(genAnother) {
			// generate random number in range
			number = RANGE_MIN +(int)(Math.random() * RANGE_MAX);
			try {
				// see if it's not found in list
				for (int i : numbers) {
					if (i == number) {
						throw new Exception();
					}
				}
				// if it's not found exit loop
				genAnother = false;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return number;
	}
	public static void main(String[] args) {
		// loop over numbers and filter bad ones
		for (int i = 0; i < 72; i++) {
			System.out.println(getRandom(8, 9, 10, 11, 12, 13, 14,
					15, 16, 17, 18, 19, 20, 21,
					22, 23, 24));
		}
	}

}

