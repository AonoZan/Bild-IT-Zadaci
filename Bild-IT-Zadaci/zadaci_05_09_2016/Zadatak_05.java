
package zadaci_05_09_2016;

import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/** Program converts decimal to fractions. */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// prompt user for decimal number
		System.out.print("Enter a decimal number: ");
		String decimal = input.nextLine();
		// parse in to ratiaonal and print it
		BigRational rat = new BigRational(decimal);
		System.out.println("The fraction number is "
				+ rat.getNumerator().toString()
				+ "/"
				+ rat.getDenominator().toString());
		input.close();
	}
}

