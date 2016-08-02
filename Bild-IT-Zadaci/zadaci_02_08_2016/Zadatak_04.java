/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_02_08_2016;

public class Zadatak_04 {
	/**
	 * Simple method that prints matrix of zero's and one's.
	 * @param n is argument that tells how big matrix should be in width and height
	 */
	public static void printMatrix(int n) {
		// make sure argument is valid
		if (n < 1) n = 1;
		// if argument is 1 then print only one number
		if (n == 1) System.out.println((int)(Math.random() * 2));
		// loop for rows and collumns, print random number and at the end of row enter new line
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%d ", (int)(Math.random() * 2));
			}
			System.out.println();
		}
	}
	/**
	 * Method that ask user for one number and based on that number prints matrix.
	 * It loops infinitely until user enters right value. Right value is any number bigger than 0.
	 * @param args
	 */
	public static void main(String[] args) {
		// create variable and ask user for value
		int sizeOfMatrix = 1;
		System.out.print("Enter number for the size of the matrix: ");
		// loop infinitely, right value will break out of loop
		while (true) {
			// try to get right value
			try {
				// try to get only number using method
				sizeOfMatrix = zadaci_01_08_2016.Zadatak_05.readFromConsole(sizeOfMatrix);
				// if value is number but negative or zero raise exception
				if (sizeOfMatrix < 1) throw new Exception("Invalid number. size can't be zero or negative.");
				break;
			// if value is not correct print message
			} catch (Exception e) {
				System.out.print(e.getMessage() + "\nTry again: ");
			}
		}
		// print matrix with method using right value
		printMatrix(sizeOfMatrix);
	}
}
