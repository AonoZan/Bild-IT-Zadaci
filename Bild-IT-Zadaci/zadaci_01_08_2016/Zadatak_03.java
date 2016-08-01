/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_01_08_2016;
import java.util.InputMismatchException;

public class Zadatak_03 {
	// Create variable that holds Scanner and method that closes it
	private static java.util.Scanner userInput = new java.util.Scanner(System.in);
	private static void closeUserInput() {userInput.close();}
	/**
	 * Method that returns greatest common divisor for two numbers. If there is no possible solution 1 is returned.
	 * It is possible to misplace numbers in arguments(set biggest and then lowest), metod handles this.
	 * @param numberOne
	 * @param numberTwo
	 * @return Greatest common divisor
	 */
	public static int greatestCommonDivisor(int numberOne, int numberTwo){
		// default common divisor is 1
		int maxCommonDivisor = 1;
		// loop from 2 to whicever number from parameters is greatest
		for (int i = 2; i <= Integer.min(numberOne, numberTwo); i++) {
			// if both numbers are divisable with current counter update maxCommonDivisor
			if (numberOne % i == 0 && numberTwo % i == 0) maxCommonDivisor = i;
		}
		return maxCommonDivisor;
	}
	/**
	 * Main method that asks for two integers and then finds
	 * lowest possible divisor for those numbers using lowestDivisor() method
	 * @param args
	 */
	public static void main(String[] args) {
		int numberOne, numberTwo;
		// ask for input until valid one is provided
		while (true) {
			// prompt user to enter two integers
			System.out.print("Enter two integers: ");
			// try to get two integers and then break from while loop
			try {
				numberOne = userInput.nextInt();
				numberTwo = userInput.nextInt();
				break;
			// catch InputMismatchException print error and clean console
			} catch (InputMismatchException e) {
				System.out.printf("Wrong input try again.\n\n");
				userInput.nextLine();
			// if something unknown and wierd happen bail!
			} catch (Exception e) {
				System.out.println("Unknown error. Program terminates...");
			} 
		}
		// try to print/clean if something is left inside console
		try {
			System.out.printf("Unnecesary input garbage:\n%s\n\n", userInput.nextLine());
		// no garbage in console, pass...
		} catch (Exception e) {}
		
		// print greatest common divisor for two numbers
		System.out.printf("Greatest common divisor for %d and %d is %d.",
				numberOne, numberTwo, greatestCommonDivisor(numberOne, numberTwo));
		// close Scanner
		closeUserInput();
	}
}
