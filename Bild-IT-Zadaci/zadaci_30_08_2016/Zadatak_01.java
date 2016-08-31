
package zadaci_30_08_2016;

import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	public static int binToDec(String binary) {
		for (char ch : binary.toCharArray()) {
			if (ch != '0' && ch != '1') {
				throw new NumberFormatException("Number passed to binToDec() cant be parsed.");
			}
		}
		int num = Integer.parseInt(binary, 2);
		return num;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String userInput;
		int binary;
		while (true) {
			try {
				System.out.print("Enter binary string: ");
				userInput = input.nextLine();
				binary = binToDec(userInput);
				System.out.println("Binary representation is: " + binary);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				break;
			}
		}
		input.close();
	}

}

